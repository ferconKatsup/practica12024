/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO3;

/**
 *
 * @author fer
 */
class Tablero {

    private char[][] tablero;
    public int filas;
    public int columnas;

    
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        tablero = new char[filas][columnas];
         
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '-'; //agua
            }
        }
        
    }//fin constructor

    public int getFilas(){
        return filas;
    }
    
    public int getColumnas(){
    return columnas;
}
    
      //coloca el barco en el tablero
     public boolean colocar(int filaInicio, int columnaInicio, int filaFinal, int columnaFinal, char simbolo) {
        // Verifica si las coordenadas están dentro de los límites del tablero.
        if (filaInicio < 0 || filaFinal >= filas || columnaInicio < 0 || columnaFinal >= columnas) {
            return false;
        }

        // Coloca el barco (simbolizado por un carácter) en las casillas correspondientes.
        for (int i = filaInicio; i <= filaFinal; i++) {
            for (int j = columnaInicio; j <= columnaFinal; j++) {
                tablero[i][j] = simbolo;
            }
        }
        return true;
    }
     
     
     public boolean atacar(int fila, int columna) {
        if (tablero[fila][columna] != '-') {
            tablero[fila][columna] = 'X';  // Marcar como tocaso
            return true;
        } else {
            tablero[fila][columna] = '0';  // Marcar como agua
            return false;
        }
        }
        

    public void mostrarTablero() {
        System.out.println(" ");

        for (int i = 0; i < filas; i++) {
            System.out.print((i+1)+" ");//fila A-J
            }
System.out.println();
             for (int i = 0; i < filas; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

 
        public boolean barcosHundidos(){
         // Busca en el tablero si aún queda algún barco (no 'X', 'O' ni '~').
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] != 'X' ) {
                    return false; // Aún queda un barco flotando.
                }
            }
        }
        return true; // Todos los barcos han sido hundidos.
    }
  

 
}//fin clase
