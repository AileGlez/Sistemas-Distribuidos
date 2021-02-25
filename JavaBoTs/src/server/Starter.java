package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Starter {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            SlaveNode SlaveNode1 = null,SlaveNode2 = null,SlaveNode3 = null;
            SlaveNode1.despligue("Bioinformatics");
            SlaveNode2.despligue("DataMining");
            SlaveNode3.despligue("ImageProcessing");

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}
