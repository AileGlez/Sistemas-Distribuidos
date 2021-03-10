package server;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlaveNode implements Bioinformatics, DataMining, ImageProcessing {

    public void start (String service){
        System.setProperty("java.security.policy","D:/tabat/Documents/12/SistemasDistribuidos/JavaRMI2/src/server/server.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            SlaveNode engine = new SlaveNode();

            if (service.equals("Bioinformatics")) {
                DataMining stub = (DataMining) UnicastRemoteObject.exportObject(engine,0);
                Registry registry = LocateRegistry.getRegistry();
                registry.rebind(service,stub); //pblicacion
                System.out.println("Bioinformatics Engine bound");
            } else if (service.equals("DataMining")) {
                ImageProcessing stub = (ImageProcessing) UnicastRemoteObject.exportObject(engine,0);
                Registry registry = LocateRegistry.getRegistry();
                registry.rebind(service,stub); //pblicacion
                System.out.println("Data Mining Engine bound");
            } else if (service.equals("ImageProcessing")) {
                ImageProcessing stub = (ImageProcessing) UnicastRemoteObject.exportObject(engine,0);
                Registry registry = LocateRegistry.getRegistry();
                registry.rebind(service,stub); //pblicacion
                System.out.println("Image Processing Engine bound");
            }

        } catch (RemoteException ex) {
            System.err.println("ComputeEngine exception:");
            ex.printStackTrace();
        }


    }

    @Override
    public Task executeBioinformaticsTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getLength());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        aTask.setOutput("BioinformaticsOutput");
        return aTask;
    }

    @Override
    public Task executeDataMiningTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getLength());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        aTask.setOutput("DataMiningOutput");
        return aTask;
    }

    @Override
    public Task executeImageProcessingTask(Task aTask) throws RemoteException {
            try {
                Thread.sleep(aTask.getLength());
            } catch (InterruptedException ex) {
                Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
            }
            aTask.setOutput("ImageProcessingOutput");
            return aTask;
    }
}
