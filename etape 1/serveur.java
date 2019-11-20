package tenta4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;


public class serveur {
	public static void main(String[] args) throws Exception {
		
		
		 
	 
	    
	    try{
	      ServerSocket server=new ServerSocket(5000);
	     // ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialis�");
			 
	      Socket serverClient=server.accept();
	      DataInputStream inStream=new DataInputStream(serverClient.getInputStream());
	      DataOutputStream outStream=new DataOutputStream(serverClient.getOutputStream());
	      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	      String clientMessage="", serverMessage="";
	      while(!clientMessage.equals("quit")){
	        clientMessage=inStream.readUTF();
	        System.out.println("From Client: "+clientMessage);
	        serverMessage=reader.readLine();
	        outStream.writeUTF(serverMessage);
	        outStream.flush();
	      }
	      inStream.close();
	      outStream.close();
	      serverClient.close();
	      server.close();
	    }catch(Exception e){
	      System.out.println(e);
	    }
	  }

}