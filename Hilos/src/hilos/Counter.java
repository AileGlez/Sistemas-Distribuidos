
package hilos;

public class Counter {
    
    private int count=0; //variable compartida 
    
    //constructor 
    public Counter(int count){
        this.count = count; 
    }
    
    // Este método es nuestra región crítica 
    public synchronized void increaseAndPrint(){
        for (int i = 0; i<10; i++){
            count++;
            System.out.println(count);
        }
    } 
}
