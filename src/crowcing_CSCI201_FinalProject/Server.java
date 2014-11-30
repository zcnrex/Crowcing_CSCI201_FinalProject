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
	public Server(int port) {
		clientList = new ArrayList<ServerThread>(); 
		try {
			ServerSocket ss= new ServerSocket( port );
			while(true) {
				Socket s = ss.accept();
				ServerThread st= new ServerThread(s, this);
				st.start();
				clientList.add(st);
				if (clientList.size() == 2){
					for(ServerThread c : clientList) {
						c.send("-1");						
					}
					break;
				}
			}
		} catch (IOException ioe) {
			System.out.println("IOExceptionin Server constructor: " + ioe.getMessage());
		}
	}
	
	public static void main(String [] args) {
		Server server = new Server(12345);
	}
	public void sendMessage(String message, ServerThread ct) {
		for(ServerThread c : clientList) {
			if (!c.equals(ct)) {
				c.send(message);
			}
		}
	}
}
