package hospitalmanagementsystem;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author SHIVANI SINGH
 */
//public class client2 {
//    
//}

import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class client2
{
    private static ExecutorService pool=Executors.newFixedThreadPool(10);
    public static void main(String [] args) throws Exception
    {
        Socket s = new Socket("localhost",8081);
        try
        {
            Login1 l1=new Login1(s);
            pool.execute(l1);
        }
        catch (Exception e)
        {
            System.out.println("here");
            System.out.println(e);
        }
    }
}   
