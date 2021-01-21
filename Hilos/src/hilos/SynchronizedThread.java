
package hilos;
/*
SOY UN HILO 
*/
public class SynchronizedThread extends Thread{
    Counter counter; 
    
    //Constructor pq necesitamos ponerle parametros
    public SynchronizedThread(Counter counter){
        this.counter = counter; 
    }
    
    @Override
    public void run(){
        counter.increaseAndPrint();
    }
    
}
