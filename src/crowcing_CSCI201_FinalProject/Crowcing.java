package crowcing_CSCI201_FinalProject;

import javax.swing.JFrame;

//Main class for client that setup window and go through all phases
//We also need JMenu
public class Crowcing extends JFrame{
	private LoginPanel loginPanel = new LoginPanel();
	
	public Crowcing(){
		super("Crowcing");
		setSize(800, 630);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread t = new Thread(loginPanel);
		t.start();
		add(loginPanel);
		
		
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Crowcing crowcing = new Crowcing();

	}

}
