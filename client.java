package etape3;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.Socket;

public class client {  
	static boolean n = true;
	private static String serverhost = "localhost";
	private static int PORT = 50005;
	public static int i ;
	//Ports disponibles 49152 jusqu'à 65535
    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Class<client> metadata = client.class;
	     
	     // On récupère les attributs publics disponibles à partir de la classe
	     // (et y compris dans les classes parentes : Base et Object).
	     Field [] attributes = metadata.getFields();
	     
	     // On affiche des informations sur ces attributs publics.
	     for( Field attribute : attributes ) {
	         System.out.printf( 
	                 "%s of type %s (isPrimitive: %b)\n",
	                 attribute.getName(), 
	                 attribute.getType().getName(),
	                 attribute.getType().isPrimitive()
	         );
	     }
		Socket s=null;
		 try {
			 	
			     System.out.println("Connexion...");
			     s=new Socket(serverhost,PORT); 
			     // Création du socket
			     System.out.println("Connecté.");
		         // Récupération des flux d’entrée/sortie
			     
			        // Récupération des flux d’entrée/sortie
						//System.out.println("Pour quitter tapez : quit");
					    DataInputStream inStream=new DataInputStream(s.getInputStream());
					    DataOutputStream outStream=new DataOutputStream(s.getOutputStream());
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
					    i++;
					    s.close();
					  }catch(Exception e){
					    System.out.println(e);
					  }  

	
	    	}}
        
    
     
        
    
	
		
