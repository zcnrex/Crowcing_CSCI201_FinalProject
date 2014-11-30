package crowcing_CSCI201_FinalProject;

//In charge of communication between the players
//Does not do any calculation

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;

public class Server {
	private ArrayList<ServerThread> clientList;
	private ArrayList<ServerThread> chatList;
	private StringTokenizer st;
	private static final ClientThread[] threads = new ClientThread[10];
	
	public Server(int port) {
		clientList = new ArrayList<ServerThread>(); 
		try {
			ServerSocket ss= new ServerSocket( port );
			int i = 0;
			while(true) {
				Socket s = ss.accept();
				ServerThread st= new ServerThread(s, this);
				st.start();
				clientList.add(st);
	    		(threads[i] = new ClientThread(s, threads)).start();
//	    		ClientThread ct = new ClientThread(s, this);
				if (clientList.size() == 2){
					for(ServerThread c : clientList) {
						c.send("-1");						
					}
					break;
				}
				i++;
			}
			
			
		} catch (IOException ioe) {
			System.out.println("IOExceptionin Server constructor: " + ioe.getMessage());
		}
	}
	
	public static void main(String [] args) {
		Server server = new Server(2232);
        String[] arguments = new String[] {};
        new ChatServer().main(arguments);
	}
	public void sendMessage(String message, ServerThread ct) {
		for(ServerThread c : clientList) {
			if (!c.equals(ct)) {
				c.send(message);
			}
		}
	}
}
