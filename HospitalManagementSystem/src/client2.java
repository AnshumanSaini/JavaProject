

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

public class client2{

    public static void main(String [] args) throws Exception
    {
        try{
        Socket s = new Socket("localhost",8080);
        
        InputStream is = s.getInputStream();
        ObjectInputStream objis = new ObjectInputStream(is);
        
        String str = (String)objis.readObject();
        if(str.equals("on"))
        {
            
        }
        s.close();
        
        is.close();
        objis.close();
        }catch (Exception e)
        {
            System.out.println("here");
            System.out.println(e);
        }
        
      
        

    }
}   
