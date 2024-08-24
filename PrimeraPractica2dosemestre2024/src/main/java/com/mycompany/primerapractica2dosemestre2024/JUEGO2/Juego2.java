/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO2;

import com.mycompany.primerapractica2dosemestre2024.MenuInicial;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Juego2 {

    public void Anagrama() {

        String[] palabras = {"FRUTA", "LIBRO", "AMOR", "BOTELLA", "MESA", "CASA", "COMIDA", "GATO", "RADIO", "CARRO"};

        int intentos = 10;
        int palabrasAdivinadas = 0;
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        while (intentos > 0 && palabrasAdivinadas < palabras.length) {
            int palabrasAleatorias = random.nextInt(palabras.length);
            String seleccion = palabras[palabrasAleatorias]; //selecciona una palabra del arreglo 
            Palabra palabra = new Palabra(seleccion); //
            GestorDeInteraccion gestorDeInteraccion = new GestorDeInteraccion(palabra, intentos);
            System.out.println("La palabra mezclada es:" + palabra.getPalabraRevuelta());

            //mientras el juego no termine(ni se agoten los intentos)
            while (!gestorDeInteraccion.terminado()) {

                System.out.println("Intentos restantes" + gestorDeInteraccion.getIntentosRestantes());
                System.out.println("intenta de nuevo");
                String palabraJugador = scanner.nextLine().toUpperCase();

                //para validar si la palabra es correcta 
                if (gestorDeInteraccion.intentoPalabra(palabraJugador)) {
                    System.out.println("encontraste una palabra");
                } else {
                    System.out.println("Palabra invalida ");
                }

            }

            //verifica si se ha ganado el juego de la palabra actual 
            if (gestorDeInteraccion.Ganador()) {
                palabrasAdivinadas++;
                System.out.println("resolviste la palabra" + seleccion);
                intentos = gestorDeInteraccion.getIntentosRestantes();// actualiza los intentos
            } else {
                System.out.println("fallaste al divinar la palabra" + seleccion);
                break;//el juego termina si el  jugador falla
            }

            System.out.println("palabras acertadas " + palabrasAdivinadas);
        }

        if (palabrasAdivinadas == 10) {
            System.out.println("ganaste el juego");
        } else {
            System.out.println("agotaste tus intentos");
        }

        mostrarMenuAnagrama(scanner);

    }//fin metodo motor de juego  

    public boolean mostrarMenuAnagrama(Scanner scanner) {

        System.out.println("1. regresar al menu inicial \n 3. salir del juego");

        int eleccion = scanner.nextInt();

        switch (eleccion) {

            case 1:
                MenuInicial MenuDeJuegos = new MenuInicial();
                MenuDeJuegos.MenuDeJuegos();
                return false;

            case 2:
                System.out.println("fin del programa");
                System.exit(0);
            default:
                System.out.println("opcion invalida");

        }

        return false;

    }
}
