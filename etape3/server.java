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
	private static int PORT = 50000;
	//Ports disponibles 49152 jusqu'à 65535

public static void main(String[] args) {
		// TODO Auto-generated method stub
		        
		
		try {
			// On écoute sur le port <PORT>
			 ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialisé");
			 
			while (true) {
			// On accepte une demande de connexion d'un client
			System.out.println("Serveur en attente de connexion sur le port : "+PORT);
			Socket client=ecoute.accept();
			System.out.println("Client connecté(Serveur) : "+client.getInetAddress().toString());				
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
