package crowcing_CSCI201_FinalProject;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Main class for client that setup window and go through all phases
//We also need JMenu
public class Crowcing extends JFrame{
	public static JPanel outerPanel = new JPanel();
	
	private LoginPanel loginPanel = new LoginPanel();
	private CarChoosingPanel choosePanel=new CarChoosingPanel();
	private ResultPanel resultPanel=new ResultPanel(1,1,1);
	private MainScreenPanel mainScreenPanel=new MainScreenPanel();
	
	
	public Crowcing(){
		super("Crowcing");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		outerPanel.setLayout(new CardLayout());
		
//		outerPanel.add(loginPanel, "login");
//		outerPanel.add(choosePanel, "chooseCar");
//		outerPanel.add(resultPanel,"result");
		outerPanel.add(mainScreenPanel,"mainScreen");
		
		
		Thread t = new Thread(loginPanel);
		t.start();
		//add(loginPanel);
		add(outerPanel);
		
		
		//result panel
		/*
		JPanel result = new ResultPanel(2, 3, 4);
		add(result);
		*/
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Crowcing crowcing = new Crowcing();

	}

}
