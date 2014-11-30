package crowcing_CSCI201_FinalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ServerThread extends Thread {
	private Socket s;
	private Server fs;
	private PrintWriter pw;
	private BufferedReader br;
	public ServerThread(Socket s, Server fs) {
		this.s = s;
		this.fs = fs;
		try{
			this.pw = new PrintWriter(s.getOutputStream());
			this.br = new BufferedReader( new InputStreamReader(s.getInputStream() ) );
		}catch (IOException ioe) {
			System.out.println("ioe in ChatThread: " + ioe.getMessage());
		}
	}
	
	public void send(String st){
		pw.println(st);
		pw.flush();
	}
	public void run() {
		try {
			
			while(true){
				String line = br.readLine();
				fs.sendMessage(line, this);
			}
		} catch (IOException ioe) {
			System.out.println("IOExceptionin ServerThreadconstructor: " + ioe.getMessage());
		}
	}
}