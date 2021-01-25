
package hilos;

public class Counter {
    
    private int count=0; //variable compartida 
    
    //constructor 
    public Counter(int count){
        this.count = count; 
    }
    
    // Este método es nuestra región crítica
    //En esta region solo  quiero un hilo a la vez para que se ejecute de forma ordenada 
    public synchronized void increaseAndPrint(){
        for (int i = 0; i<10; i++){
            count++;
            System.out.println(count);
        }
    } 

    public void increaseAndPrint(String name) {
        for (int i = 0; i<10; i++){
            synchronized(this){
                count++;
                System.out.println(count + " " + name);
            }
        }
    }
}
