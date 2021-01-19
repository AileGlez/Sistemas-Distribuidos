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
public class HelloRunnable implements Runnable  {

    @Override
    public void run() {
        for(int i =0; i<10000; i ++){
            System.out.println(i + " Hola soy el hilo runnable: " + Thread.currentThread().getName());
        }
       
    }
    
}
