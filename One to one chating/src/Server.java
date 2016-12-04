/**
 *
 * @author Ridwan
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    private ServerSocket ServSock;

    Server() {
        try {
            
            ServSock = new ServerSocket(33333);
            System.out.println("Server running at port 33333");
            while (true) {

                ServerThread m = new ServerThread(ServSock.accept());

            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public static void main(String args[]) throws UnknownHostException, IOException {
        Server objServer = new Server();
         
    }
}

class ServerThread implements Runnable {

    private Socket ClientSock;
    private Thread thr;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    int a;
    static ServerThread[] st = new ServerThread[10];
    static int client_count = 0;

    ServerThread(Socket client) {
        try {
            this.ClientSock = client;
            st[client_count] = this;
            a = client_count;
            client_count++;
            
            oos = new ObjectOutputStream(ClientSock.getOutputStream());
            
            ois = new ObjectInputStream(ClientSock.getInputStream());
            
            this.thr = new Thread(this);
            thr.start();
        } catch (Exception ex) {

        }
    }

    public void run() {

        while (true) {
            try {
                
                String t =(String) ois.readObject();
               
                int m=(int) t.charAt(6);
                t = t.substring(7, t.length());
                
                if (t != null) {
                    System.out.println("From Client "+t);
                }
                
                st[m-48].oos.writeObject("From Client"+this.a+" "+t);
           
                
            } catch (Exception ex) {

            }

        }

    }
}
