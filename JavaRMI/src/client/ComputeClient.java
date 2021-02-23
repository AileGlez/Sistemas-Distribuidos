package client;

import interfaces.Compute;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tabat
 */
public class ComputeClient {
    
    public static void main (String [] args) throws NotBoundException {
        System.setProperty("java.security.policy","D:/tabat/Documents/12/SistemasDistribuidos/JavaRMI/src/client/client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        String name = "Compute"; 
    
        Registry registry = null; 
        try {
            registry = LocateRegistry.getRegistry("localhost");
            Compute comp = (Compute)registry.lookup(name); 
        } catch (RemoteException ex) {
            Logger.getLogger(ComputeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    
    
}
