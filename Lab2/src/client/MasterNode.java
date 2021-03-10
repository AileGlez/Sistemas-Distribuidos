package client;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MasterNode {
    public static void main (String [] args) {
        System.setProperty("java.security.policy","D:/tabat/Documents/12/SistemasDistribuidos/Lab2/src/client/client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry registry = null;

        try {
            registry = LocateRegistry.getRegistry("localhost");

            Task[] BoTImageProcessing = {
                    new Task("T1", "ImageProcessing", (long)5000),
                    new Task("T2", "ImageProcessing", (long)10000),
                    new Task("T3", "ImageProcessing", (long)15000),
                    new Task("T4", "ImageProcessing", (long)20000),
                    new Task("T5", "ImageProcessing", (long)30000),
                    new Task("T6", "ImageProcessing", (long)5000),
                    new Task("T7", "ImageProcessing", (long)10000),
                    new Task("T8", "ImageProcessing", (long)15000),
                    new Task("T9", "ImageProcessing", (long)20000),
                    new Task("T10", "ImageProcessing", (long)30000),
            };

            Task[] BoTDataMining = {
                    new Task("T11", "DataMining", (long)5000),
                    new Task("T12", "DataMining", (long)10000),
                    new Task("T13", "DataMining", (long)15000),
                    new Task("T14", "DataMining", (long)20000),
                    new Task("T15", "DataMining", (long)30000),
                    new Task("T16", "DataMining", (long)5000),
                    new Task("T17", "DataMining", (long)10000),
                    new Task("T18", "DataMining", (long)15000),
                    new Task("T19", "DataMining", (long)20000),
                    new Task("T20", "DataMining", (long)30000),
                    new Task("T21", "DataMining", (long)5000),
                    new Task("T22", "DataMining", (long)10000),
                    new Task("T23", "DataMining", (long)15000),
                    new Task("T24", "DataMining", (long)20000),
                    new Task("T25", "DataMining", (long)30000),
                    new Task("T26", "DataMining", (long)5000),
                    new Task("T27", "DataMining", (long)10000),
                    new Task("T28", "DataMining", (long)15000),
                    new Task("T29", "DataMining", (long)20000),
                    new Task("T30", "DataMining", (long)30000),
            };

            Task[] BoTBioinformatics = {
                    new Task("T31", "Bioinformatics", (long)5000),
                    new Task("T32", "Bioinformatics", (long)10000),
                    new Task("T33", "Bioinformatics", (long)15000),
                    new Task("T34", "Bioinformatics", (long)20000),
                    new Task("T35", "Bioinformatics", (long)30000),
                    new Task("T36", "Bioinformatics", (long)5000),
                    new Task("T37", "Bioinformatics", (long)10000),
                    new Task("T38", "Bioinformatics", (long)15000),
                    new Task("T39", "Bioinformatics", (long)20000),
                    new Task("T40", "Bioinformatics", (long)30000),
                    new Task("T41", "Bioinformatics", (long)5000),
                    new Task("T42", "Bioinformatics", (long)10000),
                    new Task("T43", "Bioinformatics", (long)15000),
                    new Task("T44", "Bioinformatics", (long)20000),
                    new Task("T45", "Bioinformatics", (long)30000)
            };

            System.out.println("ImageProcessing ");
            BoTExecution ex1 = new BoTExecution(BoTImageProcessing, registry);
            ex1.start();

            System.out.println("Bioinformatics ");
            BoTExecution ex2 = new BoTExecution(BoTBioinformatics, registry);
            ex2.start();

            System.out.println("DataMining ");
            BoTExecution ex3 = new BoTExecution(BoTDataMining, registry);
            ex3.start();

        } catch (RemoteException ex) {
            System.err.println("ComputeEngine exception:");
            ex.printStackTrace();
        }

    }

    private static class BoTExecution extends Thread {
        Task[] aTask;
        Registry registry;

        public BoTExecution(Task[] aTask, Registry registry){
            this.aTask = aTask;
            this.registry = registry;
        }

        @Override
        public void run() {
            try {

                Task taskType = aTask[0];
                DataMining dm = null;
                ImageProcessing ip = null;
                Bioinformatics bi = null;

                if (taskType.getRequirementId().equals("DataMining")) {
                    dm = (DataMining) registry.lookup(taskType.getRequirementId());
                } else if (taskType.getRequirementId().equals("ImageProcessing")) {
                    ip = (ImageProcessing) registry.lookup(taskType.getRequirementId());
                } else if (taskType.getRequirementId().equals("Bioinformatics")) {
                    bi = (Bioinformatics) registry.lookup(taskType.getRequirementId());
                }

                for (int i=0; i< aTask.length; i++){

                    Task task = aTask[i];

                    System.out.println("Sending for execution task "+ task.getTaskId());

                    if (task.getRequirementId().equals("DataMining")) {
                        task = dm.executeDataMiningTask(task);
                        System.out.println("Data Mining task "+task.getTaskId()+ " was executed with output "+  task.getOutput());
                    } else if (task.getRequirementId().equals("ImageProcessing")) {
                        task = ip.executeImageProcessingTask(task);
                        System.out.println("Image Processing task " +task.getTaskId()+ " was executed with output "+ task.getOutput());
                    } else if (task.getRequirementId().equals("Bioinformatics")) {
                        task = bi.executeBioinformaticsTask(task);
                        System.out.println("Bioinformatics task "+task.getTaskId()+ " was executed with output "+ task.getOutput());
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
