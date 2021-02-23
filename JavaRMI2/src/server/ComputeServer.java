package server;
import interfaces.Compute;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComputeServer implements Compute {

    public static void main (String [] args){
        System.setProperty("java.security.policy","D:/tabat/Documents/12/SistemasDistribuidos/JavaRMI2/src/server/server.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            LocateRegistry.createRegistry(1099);

            String name = "Compute";

            ComputeServer engine = new ComputeServer();
            Compute stub = (Compute)UnicastRemoteObject.exportObject(engine,0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name,stub); //
            System.out.println("Servicio desplegado");
        } catch (RemoteException ex) {
            Logger.getLogger(ComputeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public double square(int number) throws RemoteException{
        return number*number;
    }

    @Override
    public double power(int num1, int num2) throws RemoteException{
        return java.lang.Math.pow(num1, num2);
    }
}
