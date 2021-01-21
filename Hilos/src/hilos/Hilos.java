/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tabat
 */
public class Hilos {
    
    //20-01-21 MECANISMO DE SINCRONIZACIÓN
    public static void main (String args[]){
        /*//Instancia del hello thread 
        HelloThread h0 = new HelloThread(); 
        // Instancia de hello Runnable
        Thread h1 = new Thread(new HelloRunnable());
        
        // con start se llama a ejecutar
            // aqui si se genera el hilo y se ejecuta como hilo
            // con run se llaman los hilos pero no se generan los hilos llamada a un método cualquiera 
            
        h0.start(); 
        try {
            h0.join(); //sincronización via barrera
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        h1.start(); */
        
        Counter c = new Counter(0); 
        SynchronizedThread h0 = new SynchronizedThread(c); 
        SynchronizedThread h1 = new SynchronizedThread(c); 
        h0.start(); 
        h1.start(); 
        
    }
    
}
