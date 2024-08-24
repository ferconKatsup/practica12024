/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerapractica2dosemestre2024.JUEGO2;

/**
 *
 * @author fer
 */
public class Palabra {

public String palabraOriginal;
public String palabraRevuelta; 


// genera la palabra revuelta y recibe la original 
public Palabra(String palabraOriginal){
    
    this.palabraOriginal = palabraOriginal;
    this.palabraRevuelta = mezclar(palabraOriginal); 
    
 
}// fin constructor  
    


public String mezclar (String palabra){
    
    char [] letras = palabra.toCharArray(); // para convertir la palabra en caracteres 
    
    for (int i = 0; i < letras.length ; i++) {
        int randomIndex = (int)(Math.random()* letras.length);// deberia crear un indice aleatorio con las palabras 
        char intercambio = letras[i]; // mezcla las letras 
        letras[i] = letras [randomIndex];
        letras[randomIndex] = intercambio;
        
    }
    return new String(letras);// retorna palabra revuelta
}

public boolean palabraParecidaValida (String palabraParecida ){
    if(palabraParecida.length() < 3)
        return false; 
    
    return anagramaFinal(palabraParecida);
}

public boolean anagramaFinal(String palabraParecida){
    int[] letrasOriginales = contarLetras(palabraOriginal);
    int[] letrasPalabraParecida = contarLetras(palabraParecida);
    
    //verificar que la palabra nueva no use mas que solo las de la palabra original 
    
    for (int i = 0; i < letrasOriginales.length; i++) {
        if (letrasPalabraParecida[i] > letrasOriginales[i]) {
            return false;
               
            }
    }
    return true; 
}

public int[]contarLetras(String palabra){
    int[] conteo = new int[27]; // cuenta letras del abcedario 

    for (char c : palabra.toCharArray()) {
        if (Character.isLetter(c)){
            conteo[c-'A']++;
        }
    }
return conteo;
}

public String getPalabraRevuelta(){
    return palabraRevuelta;
}

        
        
        
}//fin clase 

