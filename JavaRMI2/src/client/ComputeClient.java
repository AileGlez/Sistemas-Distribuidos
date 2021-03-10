package client;
import interfaces.Compute;
import interfaces.Credential;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComputeClient {
    public static void main (String [] args) {
        System.setProperty("java.security.policy","D:/tabat/Documents/12/SistemasDistribuidos/JavaRMI2/src/client/client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String name = "Compute";

        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("localhost");
            Compute comp = (Compute)registry.lookup(name);

            Credential aCredential = new Credential(8, "Octavio");

            System.out.println(comp.power(3,3, aCredential));
            System.out.println(comp.square(2, aCredential));
        } catch (RemoteException ex) {
            Logger.getLogger(ComputeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }


    }
}
