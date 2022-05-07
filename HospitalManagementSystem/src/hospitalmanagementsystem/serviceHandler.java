/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;


import java.sql.*;
import java.io.BufferedReader;
import java.io.*;
import java.net.Socket;
import hospitalmanagementsystem.*;
import java.util.StringTokenizer;
/**
 *
 * @author SHIVANI SINGH
 */
public class serviceHandler implements Runnable
{
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    private Socket Client ;
    static DataInputStream in;
    static DataOutputStream out;
    
    serviceHandler(Socket ClientSocket) throws IOException
    {
         this.Client = ClientSocket;
         in = new DataInputStream(Client.getInputStream());
         out = new DataOutputStream(Client.getOutputStream());
    }

    @Override
    public void run()
    {
        System.out.println("ch  chal raha hai!!!!!!!!!");
        try
        {
            con=Connect.ConnectDB();
            while(true)
            {
                String sql = (String)in.readUTF();
                
                StringTokenizer sto = new StringTokenizer(sql,"#");
                
		String query = sto.nextToken();
	        String operation = sto.nextToken();
                
                
//                System.out.println(checkQuery+"......"+query+"........"+operation);
                System.out.println("Received the Query");
                st=con.createStatement();
                if(operation.equals("execute"))
                {
                    System.out.println("execute ch aa giya!!!!!!!!");
                    rs=st.executeQuery(query);
                    String responseSend="";
                    System.out.println("query execute ho gayi!!!!!!");
                    if(rs.next())
                    {
                        responseSend="yes";
                        System.out.println("sended the response!!!!!!!");
                        out.writeUTF(responseSend);
                    }
                    else out.writeUTF(responseSend);
                }
                if(operation.equals("update"))
                {
                    System.out.println("execute update ch aa giya!!!!!!!!");
                    st.executeUpdate(query);
                }
                
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
    
}
