package client;

public class Launcher {
    private static final int nClientes= 1;
    private static final int nRequests = 2000;

    public static void main (String args[]) throws InterruptedException{

        for (int i = 0; i < nClientes; i++){
            ClientThread clientThread = new ClientThread(i, nRequests, nClientes);
            clientThread.start();
        }
    }

}
