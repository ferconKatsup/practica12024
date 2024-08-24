/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO1;

import com.mycompany.primerapractica2dosemestre2024.MenuInicial;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Juego1 {


    public void CarreraDeCaballos() {
        
    Scanner scanner = new Scanner(System.in);

        System.out.println("Carrera de caballos");

        
          String nombreDelJugador; 
        
        System.out.println("introduce el nombre de tu caballo");
        nombreDelJugador = scanner.next();
        
       
        // pregunta cantidad de caballos 
    

        System.out.println("ELIGE LA CANTIDAD DE CABALLOS PARA LA CARRERA");
        int cantCaballos = scanner.nextInt();
        
        if(cantCaballos < 3 || cantCaballos > 7){
            
            cantCaballos = 5 ; // el caballo del jugador cuenta, entonces seria 4 bots + el jugador
        }
    
        //pregunta la candidad de dados 
        
        System.out.println("cantidad de dados a usar ");
       int cantDados = scanner.nextInt();
        
       if (cantDados <= 1 ) {
            cantDados = 2 ;
        }
 
        System.out.println("incicia la carrera \n tienes" + cantDados + "dados");
         
        Carrera carrera = new Carrera(cantCaballos, 100, nombreDelJugador, cantDados);
        
        carrera.MotorCarrera();;
      
        
               
        
    }//fin metodo CarreraDeCaballos 
    
    
    
    
} //fin clase juego1
