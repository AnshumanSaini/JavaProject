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
    PreparedStatement pst=null;
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
                
                StringTokenizer st = new StringTokenizer(sql,"#");
                
                String checkQuery=st.nextToken();
		String query = st.nextToken();
	        String operation = st.nextToken();
                
                
                System.out.println(checkQuery+"......"+query+"........"+operation);
                
                if(!checkQuery.equals("null"))
                {
                   System.out.println("checkquery mai kuch too hai!!!!!!!!");
                   pst=con.prepareStatement(checkQuery);
                   rs= pst.executeQuery();
                }
                System.out.println("checkquery too chal gayi...");
                
                if(operation.equals("login"))
                {
                    //   response#operation
                    System.out.println("aagiya login ke pass!!!!!");
                    pst=con.prepareStatement(query);
                    rs= pst.executeQuery();
                    if(rs.next())
                    {
                        String str="yes#";
                        str+=operation;
                        out.writeUTF(str);
                    }
                    else
                    {
                        String str="no#";
                        str+=operation;
                        out.writeUTF(str);
                    }
                }
                if(operation.equalsIgnoreCase("insert"))
                {
                    if(rs.next())
                    {
                        out.writeUTF("no#"+operation);
                    }
                    else
                    {
                        pst=con.prepareStatement(query);
                        rs= pst.executeQuery();
                        String str="yes#";
                        str+=operation;
                        out.writeUTF(str);
                    }
                }
                if(operation=="delete")
                {
                    
                }
                if(operation=="update")
                {
                    
                }
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
    
}
