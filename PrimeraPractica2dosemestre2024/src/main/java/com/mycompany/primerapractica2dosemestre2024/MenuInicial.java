/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024;

import com.mycompany.primerapractica2dosemestre2024.JUEGO1.Juego1;
import com.mycompany.primerapractica2dosemestre2024.JUEGO2.Juego2;
import com.mycompany.primerapractica2dosemestre2024.JUEGO3.Juego3;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class MenuInicial {

    public void MenuDeJuegos() {

        Scanner scanner = new Scanner(System.in);

        int opcionInicial = 0;
        int salir = 0;
        System.out.println("Bienvenido a libreria de juegos"
                + "\nElija una opcion: "
                + " \n1. Carrera de Caballos \n2.Palindromo \n3.BattleShip \n4.Reportes \n5. Salir");

        opcionInicial = Integer.parseInt(scanner.nextLine());

        switch (opcionInicial) {

            case 1:
                Juego1 CarreaDeCaballos = new Juego1();
                CarreaDeCaballos.CarreraDeCaballos();

                break;
            case 2:
                 Juego2 Anagrama = new Juego2();
                Anagrama.Anagrama();
                break;
            case 3:
              Juego3 BattleShip = new Juego3();
                BattleShip.BattleShip();
                break;
            case 4:
                System.out.println("Reportes");
                break;
            case 5:
                scanner.close();
                salir = 5;
                break;

        }

    }//fin metodo menudejuegos

}//fin clase 
