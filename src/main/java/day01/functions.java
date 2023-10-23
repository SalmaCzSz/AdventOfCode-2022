package day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Salma
 */
public class functions {
    ArrayList<Integer> elfo = new ArrayList<>();
    int caloriasMax = 0;
    
    public void leerArchivo(){
        String dato;
        int caloriasElfo = 0;
        int totalElfos = 0;
        
        try{
            /* apertura del archivo */
            FileReader archivo = new FileReader("C:\\Users\\Salma\\Documents\\GitHub\\AdventOfCode-2022\\src\\main\\java\\day01\\registro-calorias.txt"); 
            BufferedReader lee = new BufferedReader(archivo);
            
            /* lectura del archivo */
            if(lee.ready()){
                while((dato = lee.readLine()) != null){
                    // System.out.println("" + dato.toString());
                    if(!dato.isEmpty()){
                        caloriasElfo += Integer.parseInt(dato);
                    } else {
                        elfo.add(caloriasElfo);
                        caloriasElfo = 0; 
                        totalElfos += 1;
                    }
                }
                
                System.out.println("leerArchivo | Total elfos: " + totalElfos);
            }
        } catch(IOException | NumberFormatException e){
            System.err.println("leerArchivo | Error: " + e);
        }
    }
    
    public void calcularMayor(){
        caloriasMax = Collections.max(elfo);
        int numElfo = 0;
        
        for (int i = 0; i < elfo.size(); i++) {
            if(elfo.get(i) == caloriasMax ){
                numElfo = i + 1;
            }
        }
        
        System.out.println("El elfo que lleva más calorias es el " + numElfo + " (" + caloriasMax + " calorias)");
    }   
    
    public void calculaTresMayores(){
        int totalCalorias = 0;
        /* ordenamos la lista */
        elfo.sort((Integer o1, Integer o2) -> o2.compareTo(o1));
        
        /* sumamos calorias */
        for(int i = 0 ; i < 3; i++){
            totalCalorias += elfo.get(i);
        }
        
        System.out.println("Los tres elfos con más calorías suman " + totalCalorias + " calorias");
    }
}