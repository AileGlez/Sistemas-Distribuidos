package javaserialization;
import java.io.Serializable;

/**
 *
 * @author tabat
 */

public class Person implements Serializable{
   private String name; 
   private String place; 
   private int year; 
   
   public Person(String name,String place, int year){
       name = this.name; 
       place = this.name; 
       year = this.year; 
   }

   @Override
    public String toString() {
        return "Person{" + "name=" + name + ", place=" + place + ", year=" + year + '}';
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
   
   
   
}
