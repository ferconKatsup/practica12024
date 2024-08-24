/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO2;

/**
 *
 * @author fer
 */
public class GestorDeInteraccion {

    public Palabra palabra;
    public int intentosRestantes;
    public int palabrasEncontradas = 0;
    public String palabrasCorrectas = "";
    public validarPalabras validador = new validarPalabras();

    public GestorDeInteraccion(Palabra palabra, int intentosRestantes) {

        this.palabra = palabra;
        this.intentosRestantes = intentosRestantes;

    }//fin constructor 

    public boolean intentoPalabra(String palabraJugador) {

        if (palabra.palabraParecidaValida(palabraJugador) && validador.palabraValida(palabraJugador) && !palabrasCorrectas.contains(palabraJugador)) {
            palabrasCorrectas += palabraJugador + "  ";
            palabrasEncontradas++;
            return true;

        }
        intentosRestantes--;
        return false;

    }

    public boolean Ganador() {
        return palabrasEncontradas > 0;
    }

    // el juago termina si el jugador agota intentos o gana 
    public boolean terminado() {
        return intentosRestantes <= 0 || Ganador();
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }
}
