package etape3;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;


	public class server {
	public static  int i = 0 ;
	public static ArrayList<traitement> Ps = new ArrayList<traitement>() ;
	public LinkedList<Object> L = new LinkedList<Object>();
	private static ServerSocket ecoute;
	private static int PORT = 50005;
	//Ports disponibles 49152 jusqu'� 65535

public static void main(String[] args) {
		// TODO Auto-generated method stub
		        
	 // R�cup�ration des m�ta-donn�es � partir de la classe.
    Class<server> metadata = server.class;
    
    // On r�cup�re les attributs publics disponibles � partir de la classe
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
    	
	
		try {
			// On �coute sur le port <PORT>
			 ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialis�");
			 
			while (true) {
			// On accepte une demande de connexion d'un client
			System.out.println("Serveur en attente de connexion sur le port : "+PORT);
			Socket client=ecoute.accept();
			System.out.println("Client connect�(Serveur) : "+client.getInetAddress().toString());				
			traitement P = new traitement("Thread"+i,client) ;
			P.start();
			Ps.add(P);
			i++;		
			
			}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);
		 }

		

	}
}