/**
 *
 * @author Ridwan
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;


public class Client {

    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    
      
    public static void main(String args[]) {
       
        try {
            
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            Socket client = new Socket(serverAddress, serverPort);
            Scanner input = new Scanner(System.in);
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
           
            
            
            
            new ReadThread(ois);
            
            System.out.println("Type destinated client name e.g. client0,client1,client2,...followed by a space and your message.");
            while (true) {
              
                String s = input.nextLine();
            
                oos.writeObject( s);
             
            }
                  
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}


 class ReadThread implements Runnable
{
 private Thread thr;
 ObjectInputStream ois;
 
 
 

 public ReadThread(ObjectInputStream ois) 
 {
    
  this.ois=ois;
  this.thr = new Thread(this);
  thr.start();
 }
 
 public void run() 
 {
  try
  {
      
   while(true)
   {
       
    String t=(String)ois.readObject();
    if(t != null) 
        System.out.println(t);
    
   }
  }catch(Exception e)
  {
   System.out.println (e);                        
  }   
                  
 }
}



