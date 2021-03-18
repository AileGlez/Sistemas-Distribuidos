/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaipmulticast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JGUTIERRGARC
 */
public class MulticastSenderPeer{
    	public static void main(String args[]){ 
  	 
	MulticastSocket s =null;
        InetAddress group = null; 
        
   	 try {
                
                 group = InetAddress.getByName("228.5.6.7"); // destination multicast group
	    	s = new MulticastSocket(6789); // generamos (creamos)  nuestro socket 
                // nos unimos al grupo 
	   	s.joinGroup(group); // estoy escuchando 
                
                //s.setTimeToLive(10);
                //System.out.println("Messages' TTL (Time-To-Live): "+ s.getTimeToLive());
                while (true){
                    String myTime= (new Date()).toString(); 
                    byte [] m = myTime.getBytes(); 
                    DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
                    s.send(messageOut);
                    System.out.println("Heartbeat");
                     try {
                         Thread.sleep(2000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(MulticastSenderPeer.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                
 	    }
         catch (SocketException e){
             System.out.println("Socket: " + e.getMessage());
	 }
         catch (IOException e){
             System.out.println("IO: " + e.getMessage());
         }
	 finally {
            if(s != null){
                try {
                    s.leaveGroup(group); // salimos de escuchar
                } catch (IOException ex) {
                    Logger.getLogger(MulticastSenderPeer.class.getName()).log(Level.SEVERE, null, ex);
                }
                // dejamos el grupo 
                s.close();
            } // cerramos el socket
        }
    }		     
}
