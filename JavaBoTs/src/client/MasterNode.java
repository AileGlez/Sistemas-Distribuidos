package client;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MasterNode{

    public class Hilo extends Thread{

    }

    public static void main(String[] args){
        System.setProperty("java.security.policy","D:/tabat/Documents/12/SistemasDistribuidos/JavaBoTs/src/client/client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry registry = null; // server's ip address
        Task t = null;

        try {
            registry = LocateRegistry.getRegistry("localhost");
           // t = new Task(1,1,1,"Hola");
            if(t.getRequirement() =="DataMining"){

                registry.lookup("DataMining");
            }else{
                if(t.getRequirement() =="ImageProcessing"){
                    registry.lookup("ImageProcessing");
                }   else{
                    registry.lookup("Bioinformatics");
                }
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

}
