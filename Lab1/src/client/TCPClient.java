package client;
import java.net.*;
import java.io.*;
public class TCPClient {

    private int id = 0;
    private int nRequests= 0;
    private int nClients= 0;

    public TCPClient(int id, int nRequests, int nClientes){
        this.id = id;
        this.nRequests = nRequests;
        this.nClients = nClientes;
    }

    public void askServer(){
        Socket s = null;

        try {
            long totalElapsedTimeMilli = 0;
            long elapsedTime[]= new long[nRequests];
            int n= 0;

            int serverPort = 7896;

            s = new Socket("localhost", serverPort);
            //   s = new Socket("127.0.0.1", serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out =
                    new DataOutputStream( s.getOutputStream());

            while(n < nRequests){
                int key = (int) Math.round(Math.random()*4);
                long startTime = System.currentTimeMillis();

                out.writeInt(key);
                String record = in.readUTF();

                long elapsedTimeMilli =(System.currentTimeMillis() - startTime);
                totalElapsedTimeMilli = elapsedTimeMilli + totalElapsedTimeMilli;
                elapsedTime[n] = elapsedTimeMilli;
                n++;
            }
            out.writeInt(8);
            System.out.println(nClients + "," + nRequests + ",Avg. response  time (ms)," + (double) (totalElapsedTimeMilli) / nRequests + ",Std dev of response time," + stdDev(elapsedTime));
        }
        catch (UnknownHostException e) {
            System.out.println("Sock:"+e.getMessage());
        }
        catch (EOFException e) {
            System.out.println("EOF:"+e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO:"+e.getMessage());
        } finally {
            if(s!=null)
                try {
                    s.close();
                } catch (IOException e){
                    System.out.println("close:"+e.getMessage());}
        }
    }

    private double stdDev(long[] list) {
        double sum = 0.0;
        double num = 0.0;

        for (int i = 0; i < list.length; i++)
            sum += list[i];

        double mean = sum / list.length;

        for (int i = 0; i < list.length; i++)
            num += Math.pow((list[i] - mean), 2);

        return Math.sqrt(num / list.length);
    }

}
