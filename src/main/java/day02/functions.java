package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Salma
 */
public class functions {
    ArrayList<String> ronda = new ArrayList<>();
   
    public void leeArchivo(){
        String dato;
        
        try{
            /* apertura del archivo */
            FileReader archivo = new FileReader("C:\\Users\\Salma\\Documents\\GitHub\\AdventOfCode-2022\\src\\main\\java\\day02\\registro-juego.txt"); 
            BufferedReader lee = new BufferedReader(archivo);
            
            /* lectura del archivo */
            if(lee.ready()){
                while((dato = lee.readLine()) != null){
                    ronda.add(dato);
                }
                
                System.out.println("leerArchivo | Lectura completada. ");
                lee.close();
            }
        } catch(IOException | NumberFormatException e){
            System.err.println("leerArchivo | Error: " + e);
        }
    }
    
    public void calculaPuntosI(){
        String dato;
        int totalPuntos = 0;
        
        try{
            for (int i = 0; i < ronda.size(); i++) {
                dato = ronda.get(i);
                int puntosRonda = 0;
                    
                switch(dato){
                    case "A X": // Piedra = 1 punto || empate = 3 puntos
                        totalPuntos += 4;
                        puntosRonda = 4;
                    break;
                    case "A Y": // Papel = 2 puntos || ganar = 6 puntos
                        totalPuntos += 8;
                        puntosRonda = 8;
                    break;
                   case "A Z": // Tijera = 3 puntos || perder = 0 puntos
                        totalPuntos += 3;
                        puntosRonda = 3;
                    break;
                    case "B X":  // Piedra = 1 punto || perder = 0 puntos
                        totalPuntos += 1;
                        puntosRonda = 1;
                    break;
                    case "B Y": // Papel = 2 puntos ||  empate = 3 puntos
                        totalPuntos += 5;
                        puntosRonda = 5;
                    break;
                    case "B Z": // Tijera = 3 puntos || ganar = 6 puntos
                        totalPuntos += 9;
                        puntosRonda += 9;
                    break;
                    case "C X": //Piedra = 1 punto || ganar = 6 puntos
                        totalPuntos += 7;
                        puntosRonda = 7;
                    break;
                    case "C Y": // Papel = 2 puntos || perder = 2 puntos
                        totalPuntos += 2;
                        puntosRonda = 2;
                    break;
                    case "C Z": // Tijeras = 3 puntos || empate = 3 puntos
                        totalPuntos += 6;
                        puntosRonda = 6;
                    break;
                }
                    
                //System.out.println("Entrada: " + dato + " Puntos ronda: " + puntosRonda);
            }
                
            System.out.println("calculaPuntosI | Puntuación final: " + totalPuntos);
            
        } catch(Exception e){
            System.err.println("CalculaPuntosI | Error: " + e);
        }
    }
    
    public void calculaPuntosII(){
        String dato;
        int totalPuntos = 0;
        
        try{
            for (int i = 0; i < ronda.size(); i++) {
                dato = ronda.get(i);
                int puntosRonda = 0;
                    
                switch(dato){ // x perder | y empate | z ganar
                    case "A X": // perder = 0 puntos || tijeras = 3 puntos
                        totalPuntos += 3;
                        puntosRonda = 3;
                    break;
                    case "A Y": // empate = 3 puntos || piedra = 1 punto
                        totalPuntos += 4;
                        puntosRonda = 4;
                    break;
                   case "A Z": // ganar = 6 puntos || papel = 2 puntos
                        totalPuntos += 8;
                        puntosRonda = 8;
                    break;
                    case "B X":  // perder = 0 puntos || piedra = 1 punto
                        totalPuntos += 1;
                        puntosRonda = 1;
                    break;
                    case "B Y": // empate = 3 puntos || papel = 2 puntos
                        totalPuntos += 5;
                        puntosRonda = 5;
                    break;
                    case "B Z": // ganar = 6 puntos || tijera = 3 puntos
                        totalPuntos += 9;
                        puntosRonda += 9;
                    break;
                    case "C X": // perder = 0 puntos || papel = 2 puntos
                        totalPuntos += 2;
                        puntosRonda = 2;
                    break;
                    case "C Y": // empate = 3 puntos || tijeras = 3 puntos
                        totalPuntos += 6;
                        puntosRonda = 6;
                    break;
                    case "C Z": // ganar = 6 puntos || piedra = 1 punto
                        totalPuntos += 7;
                        puntosRonda = 7;
                    break;
                }
                    
                //System.out.println("Entrada: " + dato + " Puntos ronda: " + puntosRonda);
            }
                
            System.out.println("calculaPuntosII | Puntuación final: " + totalPuntos);
            
        } catch(Exception e){
            System.err.println("CalculaPuntosII | Error: " + e);
        }
    }
}
