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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

	public class traitement extends Thread{

	private Socket client;
	
	
	public traitement(String name,Socket client){
		super(name) ;
		this.client = client ;
		
	}
	
	public void run(){
		 System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
		
		
		 try{
		      DataInputStream inStream=new DataInputStream(client.getInputStream());
		      DataOutputStream outStream=new DataOutputStream(client.getOutputStream());
		      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		      String clientMessage="", serverMessage="";
		      while(!clientMessage.equals("bye")){
		        clientMessage=inStream.readUTF();
		        System.out.println("From Client: "+clientMessage);
		        serverMessage=reader.readLine();
		        outStream.writeUTF(serverMessage);
		        outStream.flush();
		      }
		      inStream.close();
		      outStream.close();
		      client.close();
		    }catch(Exception e){
		      System.out.println(e);
		    }
	}
	/*public static void main( String[] args ) throws Exception {
	
	/// Récupération des méta-données à partir de la classe.
    Class<traitement> metadata = traitement.class;   
    // On récupère les méthodes déclarées dans le type courant
    Method [] methods = metadata.getDeclaredMethods();
    
    // On affiche des informations sur les méthodes de la classe
    for( Method method : methods ) {
        System.out.println( method.getName() );
    }
	
	 }}*/
   

public static void main( String[] args ) throws Exception {

        
        // Récupération des méta-données à partir de la classe.
        Class<traitement> metadata = traitement.class;
        
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
        
    }}
    

