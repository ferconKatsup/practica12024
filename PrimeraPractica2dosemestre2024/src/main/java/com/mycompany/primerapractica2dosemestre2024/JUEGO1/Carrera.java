/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO1;

import com.mycompany.primerapractica2dosemestre2024.MenuInicial;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Carrera {

    Caballo[] caballos;
    int meta;
    int cantDados;

    public Carrera(int Caballos, int meta, String nombre, int dados) {

        this.meta = meta;
        this.cantDados = dados;
        caballos = new Caballo[Caballos]; // inicia arreglo de caballos 

        //iniciar caballo del jugador y bots, dios plis 
        caballos[0] = new Caballo(nombre, true);

        for (int i = 1; i < Caballos; i++) {
            caballos[i] = new Caballo("bot" + i, false);
        }

    } //fin carrera 
    //contiene el turno del caballo y la estrategia de dados 

    public void turnos(Caballo caballo, boolean estrategia2) {

        Random random1 = new Random();
        int dados = 0;

        //lanza los dados con un numero entre 1 y 6 
        for (int i = 0; i < cantDados; i++) {
            dados += random1.nextInt(6) + 1;
        }

        //si se eligio una estrategia 
        if (estrategia2 && numPrimo(dados)) {
            System.out.println(caballo.getNombre() + "¡Sacaste un numero primo!" + dados + "¡Avamzas el doble!");
            caballo.avanzar(dados * 2);
        } else if (!estrategia2) {

            System.out.println(caballo.getNombre() + "avanza" + dados + "posiciones");
            caballo.avanzar(dados);
        } else {
            System.out.println(caballo.getNombre() + "No ha salido un numero primo, no avanzas");
        }

    } // fin turnos 

    public void pista() {
        for (Caballo caballo : caballos) {
            System.out.println(caballo.getNombre() + ":");
            for (int i = 0; i < caballo.getPosicion(); i++) {
                System.out.print("-");
            }
            System.out.println("*");
        }
        System.out.println();
    }

    public void MotorCarrera() {
        Scanner scanner = new Scanner(System.in);
        Random random2 = new Random();
        

        while (!partidaGanada()) {

            System.out.println("¡Es tu turno! Elije una estrategia \n 1.Avanzar con precaucion: avanzas conforme el numero del dado \n 2.Avanzar con riesgo: si el dado queda en numero par avanzas el doble, si no, no avanzas ");

            int estrategia = scanner.nextInt();
            boolean estrategia2 = estrategia == 2;

            turnos(caballos[0], estrategia2);
            pista();
            //bots
            for (int i = 1; i < caballos.length; i++) {
                System.out.println("Es turno de " + caballos[i].getNombre() + ":");
                turnos(caballos[i], random2.nextBoolean());
                pista();
            }
        }

        //empate 
        boolean empate = false;
        Caballo ganador = null;

        for (Caballo caballo : caballos) {

            if (caballo.getPosicion() >= meta) {
                if (ganador == null) {
                    ganador = caballo;
                } else {
                    empate = true;
                    break;
                }
            }

        }

        if (empate) {
            System.out.println("es empate");
        } else {

            System.out.println("haz ganado:" + ganador.getNombre());
        }

        mostrarMenuCaballos(scanner);
          
    }//fin motor carrera

    //llegada a la meta 
    public boolean partidaGanada() {

        for (Caballo caballo : caballos) {
            if (caballo.getPosicion() >= meta) {
                return true;

            }
        }
        return false;
        
    }

    public boolean numPrimo(int numero) {
        if (numero < 2) {
            return false;
        }

        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
        
    }
    
    public boolean mostrarMenuCaballos(Scanner scanner){
        
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
