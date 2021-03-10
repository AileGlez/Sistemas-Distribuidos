package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Starter {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry(1099); //instanciar el servidor

        SlaveNode[] slaveNodes = {new SlaveNode(),new SlaveNode(), new SlaveNode() };

        String[] services = new String[3];

        slaveNodes[0].start("Bioinformatics");
        slaveNodes[1].start("DataMining");
        slaveNodes[2].start("ImageProcessing");

    }
}
