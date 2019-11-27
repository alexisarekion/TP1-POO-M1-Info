package etape2;

	import java.io.IOException;
	import java.io.InputStream;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.OutputStream;
	import java.lang.reflect.Constructor;
	import java.lang.reflect.Field;
	import java.lang.reflect.Method;
	import java.net.Socket;


		public class traitement extends Thread{

		private Socket client;
		
		
		public traitement(String name,Socket client){
			super(name) ;
			this.client = client ;
			
		}
		
		public void run(){
			 System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
			
			
		
		
	

	}}


