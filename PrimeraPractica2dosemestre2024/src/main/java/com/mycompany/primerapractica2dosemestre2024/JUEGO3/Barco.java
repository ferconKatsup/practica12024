/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO3;

import java.awt.image.VolatileImage;

/**
 *
 * @author fer
 */
abstract class Barco {
    
    protected int tamaño;
    protected String nombre; 
    protected char simbolo;
    
    
    public Barco(int tamaño, String nombre, char simbolo){
        
        this.tamaño = tamaño; 
        this.nombre = nombre; 
        this.simbolo = simbolo;
    }
    
    public boolean colocarBarco(int filaInicio, int columnaInicio, int filaFinal, int columnaFinal, Tablero tablero){
        
       // Valida que el barco esté colocado de manera horizontal o vertical.
        if ((filaInicio == filaFinal && Math.abs(columnaInicio - columnaFinal) == tamaño - 1) ||
            (columnaInicio == columnaFinal && Math.abs(filaInicio - filaFinal) == tamaño - 1)) {
            // Intenta colocar el barco con el símbolo del nombre.
            return tablero.colocar(filaInicio, columnaInicio, filaFinal, columnaFinal, nombre.charAt(0));
        }
        return false;
    }       
          
    
    
    
    
}//fin metodo 
