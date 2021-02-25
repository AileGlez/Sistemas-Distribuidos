package server;

import client.MasterNode;
import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SlaveNode implements Bioinformatics,DataMining,ImageProcessing {

    public static void main(String[] args){

        System.setProperty("java.security.policy","D:/tabat/Documents/12/SistemasDistribuidos/JavaBoTs/src/server/server.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            LocateRegistry.createRegistry(1099);

            String tipoServicio = "Bioinformatics";

            SlaveNode engine = new SlaveNode();
            Registry registry = LocateRegistry.getRegistry();

            if(tipoServicio =="DataMining"){
                DataMining stub = (DataMining) UnicastRemoteObject.exportObject(engine, 0);
                registry.rebind(tipoServicio, stub);
            }else if(tipoServicio =="ImageProcessing"){
                    ImageProcessing stub = (ImageProcessing) UnicastRemoteObject.exportObject(engine, 0);
                    registry.rebind(tipoServicio, stub);
            } else {
                    Bioinformatics stub = (Bioinformatics) UnicastRemoteObject.exportObject(engine, 0);
                    registry.rebind(tipoServicio, stub);
            }

            System.out.println("Servicio desplegado!");

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public Task executeBioTask(Task aTask) throws RemoteException{
        return aTask;
    }

    public Task executeDataTask(Task aTask) throws RemoteException{
        return aTask;
    }

    public Task executeImageTask(Task aTask) throws RemoteException{
        return aTask;
    }

    public String despligue(String string) {
        return string;
    }
}
