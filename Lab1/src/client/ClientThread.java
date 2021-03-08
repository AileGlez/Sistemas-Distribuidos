package client;

public class ClientThread extends Thread{

    private int id;
    private int nRequests;
    private int nClients;

    public ClientThread (int id, int nRequests, int nClientes){
        this.id = id;
        this.nRequests = nRequests;
        this.nClients = nClientes;
    }

    @Override
    public void run() {
        try{
            TCPClient client = new TCPClient(id,nRequests,nClients);
           client.askServer();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
