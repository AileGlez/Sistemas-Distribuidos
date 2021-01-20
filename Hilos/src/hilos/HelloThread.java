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
public class HelloThread extends Thread{
    
    public void run(){
       for(int i =0; i<10000; i ++){
            System.out.println(i + " Hola soy el hilo thread: " + Thread.currentThread().getName());
        }
    }
}
