package hospitalmanagementsystem;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author SHIVANI SINGH
 */
//public class server2 {
//    
//}
import java.net.*;
import java.io.*;

public class server2 extends Thread implements Runnable { 
    Socket s;
    static String str1="";
    public server2(Socket s){
        this.s = s;
    }
    
    synchronized public void startLogin(){
        try{
            OutputStream obj = s.getOutputStream();
            ObjectOutputStream obj1 = new ObjectOutputStream(obj);
            obj1.writeObject(str1);
        }
        catch (Exception e){
            
        }
    }
    
    public void run()
    {
        startLogin();
    }

    public static void main(String [] args) throws Exception
    {
        try{
            ServerSocket ss = new ServerSocket(8080);
            System.out.println("Server is running ");
            int i = 1;
            server2 server; 
            while(true)
            {
                Socket s = ss.accept();
                server = new server2(s);
                System.out.println("Client "+i +" is connected");
                str1="Client ";
                str1+=Integer.toString(i);
                i++;
                new Thread(server).start();
            }
        }catch(Exception e){
            
        }
    }
   
}