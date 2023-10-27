package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class functions {
    ArrayList<String> mochilas = new ArrayList<>();
    char [] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    public void leeArchivo(){
        String dato;
        
        try{
            /* apertura del archivo */
            FileReader archivo = new FileReader("C:\\Users\\Salma\\Documents\\GitHub\\AdventOfCode-2022\\src\\main\\java\\day03\\registro-mochilas.txt"); 
            BufferedReader lee = new BufferedReader(archivo);
            
            /* lectura del archivo */
            if(lee.ready()){
                while((dato = lee.readLine()) != null){
                    mochilas.add(dato);
                }
                
                System.out.println("leerArchivo | Lectura completada. ");
                lee.close();
            }
        } catch(IOException | NumberFormatException e){
            System.err.println("leerArchivo | Error: " + e);
        }
    }
    
    public void asignaPrioridadMochila(){
        String compartimentoUno;
        String compartimentoDos;
        char coincidencia = ' ';
        int prioridad = 0;
        
        for (String mochila : mochilas) {
            compartimentoUno = mochila.substring(0, (mochila.length()/2));
            compartimentoDos = mochila.substring((mochila.length()/2));
            
            //System.out.println("");
            //System.out.println("asignaPrioridad | Cadena original: " + mochila);
            //System.out.println("M1: " + compartimentoUno + " M2: " + compartimentoDos);
           
            for (char articulo : compartimentoUno.toCharArray()){
                if(compartimentoDos.indexOf(articulo) != -1){
                    coincidencia = articulo;
                }
            }
            
            //System.out.println("asignaPrioridad | Coincidencia: " + coincidencia);
            
            for(int i=1; i <=26; i++){
                if(letras[i-1] == coincidencia){
                    prioridad += (i+26); 
                    //System.out.println("Prioridad mayus: " + (i+26));
                }
                if(Character.toLowerCase(letras[i-1]) == coincidencia){
                    prioridad += (i);
                    //System.out.println("Prioridad minus: " + i);
                }
            }
            
            //System.out.println("asignaPrioridad | Prioridad Acum: " + prioridad);
        }
        
        //System.out.println("");
        System.out.println("asignaPrioridad | Prioridad Final: " + prioridad);
    }
    
    public void asignaPrioridadGrupo(){
        String mochilaUno;
        String mochilaDos;
        String mochilaTres;
        char coincidencia = ' ';
        int prioridad = 0;
        
        for (int i = 0; i < mochilas.size(); i+=3) {
            mochilaUno = mochilas.get(i);
            mochilaDos = mochilas.get(i+1);
            mochilaTres = mochilas.get(i+2);
            
            //System.out.println("M1: " + mochilaUno + " M2: " + mochilaDos + " M3: " + mochilaTres);
           
            for (char articulo : mochilaUno.toCharArray()){
                if(mochilaDos.indexOf(articulo) != -1 && mochilaTres.indexOf(articulo) != -1){
                    coincidencia = articulo;
                }
            }
            
            //System.out.println("asignaPrioridadGrupo | Coincidencia: " + coincidencia);
            
            for(int j=1; j <=26; j++){
                if(letras[j-1] == coincidencia){
                    prioridad += (j+26); 
                    //System.out.println("Prioridad mayus: " + (i+26));
                }
                if(Character.toLowerCase(letras[j-1]) == coincidencia){
                    prioridad += (j);
                    //System.out.println("Prioridad minus: " + i);
                }
            }
            
            //System.out.println("asignaPrioridadGrupo | Prioridad Acum: " + prioridad);
        }
        
        //System.out.println("");
        System.out.println("asignaPrioridadGrupo | Prioridad Final: " + prioridad);
    }
    
}
