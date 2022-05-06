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
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server2{ 
    private static ArrayList<serviceHandler> activeClient=new ArrayList<>();
    private static ExecutorService pool=Executors.newFixedThreadPool(10);

    public static void main(String [] args) throws Exception
    {
            
        try{
            ServerSocket ss = new ServerSocket(8081);
            System.out.println("Server is running ");
            int i = 1;
            while(true)
            {
                Socket s = ss.accept();
                serviceHandler ch=new serviceHandler(s);
                activeClient.add(ch);
                pool.execute(ch);
                System.out.println("Client "+i +" is connected");
            }
        }
        catch(Exception e){
            
        }
    }
   
}