package crowcing_CSCI201_FinalProject;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//Main class for client that setup window and go through all phases
//We also need JMenu
public class Crowcing extends JFrame{
	public static JPanel outerPanel = new JPanel();
	
	private LoginPanel loginPanel = new LoginPanel();
	public static CarChoosingPanel choosePanel;//=new CarChoosingPanel();
	private static ResultPanel resultPanel=new ResultPanel();
	private MainScreenPanel mainScreenPanel=new MainScreenPanel();
	private JLayeredPane lp = null;
	
	public Crowcing(){
		super("Crowcing");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Client client = new Client("10.120.71.144", 2222);
		
		lp = this.getLayeredPane(); 
		choosePanel=new CarChoosingPanel();
		
		outerPanel.setLayout(new CardLayout());
		
		outerPanel.add(loginPanel, "login");
		outerPanel.add(choosePanel, "chooseCar");
		outerPanel.add(resultPanel,"result");
		outerPanel.add(mainScreenPanel,"mainScreen");
		
		lp.add(outerPanel, new Integer(200));
		lp.add(MainScreenPanel.miniMapPanel, new Integer(300));
		lp.add(MainScreenPanel.chatPanel, new Integer(500));
		MainScreenPanel.miniMapPanel.setVisible(false);
		MainScreenPanel.chatPanel.setVisible(false);
		outerPanel.setVisible(true);
		
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
	
	public static ResultPanel getResultPanel(){
		return resultPanel;
	}
	
	
	public static void main(String[] args) {
		Crowcing crowcing = new Crowcing();

	}

}
