package etape2;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.OutputStream;
	import java.lang.reflect.Field;
	import java.net.Socket;

	public class client {
		
		static boolean n = true;
		private static String serverhost = "localhost";
		private static int PORT = 51919;
		public static int i ;
		//Ports disponibles 49152 jusqu'à 65535
	    
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			
			Socket s=null;
			 try {
				 	
				     System.out.println("Connexion...");
				     s=new Socket(serverhost,PORT); 
				     // Création du socket
				     System.out.println("Connecté.");
			         // Récupération des flux d’entrée/sortie
				     
				    
				     i++;
					
			        s.close();
					
			} 
			 catch (IOException e) {System.err.println(e);}
			 
			 
		}}
