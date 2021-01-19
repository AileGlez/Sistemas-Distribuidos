/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author tabat
 */
public class Hilos {
    
    public static void main (String args[]){
        //Instancia del hello thread 
        HelloThread h1 = new HelloThread(); 
        // Instancia de hello Runnable
        Thread h2 = new Thread(new HelloRunnable());
        
        // con start se llama a ejecutar
            // aqui si se genera el hilo y se ejecuta como hilo
            // con run se llaman los hilos pero no se generan los hilos llamada a un método cualquiera 
        h1.start(); 
        h2.start(); 
    }
    
}
