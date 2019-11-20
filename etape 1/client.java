package tenta4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class client {
	public static void main(String[] args) throws Exception {
		  try{
			  Socket socket=new Socket("127.0.0.1",5000);
			     System.out.println("Connexion...");
			   //  so=new Socket(serverhost,PORT); 
			     // Cr�ation du socket
			     System.out.println("Connect�.");
		         // R�cup�ration des flux d�entr�e/sortie
			     System.out.println("Pour quitter tapez : quit");
		   
		    DataInputStream inStream=new DataInputStream(socket.getInputStream());
		    DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    String clientMessage="",serverMessage="";
		    while(!clientMessage.equals("quit")){
		      clientMessage=br.readLine();
		      outStream.writeUTF(clientMessage);
		      outStream.flush();
		      serverMessage=inStream.readUTF();
		      System.out.println("From Server: "+serverMessage);
		    }
		    outStream.close();
		    outStream.close();
		    socket.close();
		  }catch(Exception e){
		    System.out.println(e);
		  }
		  }

}
