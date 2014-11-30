package crowcing_CSCI201_FinalProject;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//First panel a player would see. 
//Doesn't share window with ChatPanel
//Send input info to database and receive feedback
public class LoginPanel extends JPanel implements Runnable{
	private JButton newUserButton, existingUserButton, registerButton, loginButton, backButton;
	private JLabel userNameLabel, passwordLabel;
	private JTextField userNameField, passwordField;
	
	private InitialPanel initialPanel = new InitialPanel();
	private RegisterPanel registerPanel = new RegisterPanel();
	private ExistingPanel existingPanel = new ExistingPanel();
	
//	private Client client = new Client();
	private String error = "";
	private boolean done = false;
	
	private Car car = new Car();
	
	public LoginPanel(){
		this.setSize(800, 600);
		this.setLayout(null);
//		initialPanel = new InitialPanel();
		ImageIcon icon1 = new ImageIcon("car1.jpg");	
		Image image1= icon1.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
//		ImageIcon icon1_1=new ImageIcon(image1);
		
		ImageIcon icon2 = new ImageIcon("car2.jpg");	
		Image image2= icon2.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
//		ImageIcon icon1_2=new ImageIcon(image1);
//		add(icon1);
		
//		g.drawImage(image1, 200, 200, null);
//		g.drawImage(image2, 400, 200, null);
		add(initialPanel);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		
		

		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier", Font.BOLD, 80));
		g.drawString("Crowcing", 220, 100);
		drawError(g);
	}
	
	public void drawError(Graphics g){
		g.setColor(Color.RED);
		g.drawString(error, 250, 300);
	}
	
	public void changePanel(JPanel x, JPanel y){
		this.remove(x);
		repaint();
		this.add(y);
	}
	
	public boolean getDone(){
		return done;
	}
	
	class SendText implements ActionListener{
		private JTextField username, password;
		private String status;
		
		public SendText(JTextField username, JTextField password, String status){
			this.username = username;
			this.password = password;
			this.status = status;
			done = true;
		}
		
		public void actionPerformed(ActionEvent ae){

			System.out.println(username.getText() +" "+ password.getText() +" "+ status);
			username.setText("");
			password.setText("");
		}
	}
	
	
	
	class InitialPanel extends JPanel{


		public InitialPanel(){
			this.setLayout(null);
			this.setBounds(0, 300, 800, 300);
			newUserButton = new JButton("New User");
			newUserButton.setBounds(250, 0, 100, 50);
			newUserButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					changePanel(initialPanel, registerPanel);
				}
			});
			existingUserButton = new JButton("Login");
			existingUserButton.setBounds(450, 0, 100, 50);
			existingUserButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					changePanel(initialPanel, existingPanel);
				}
			});
			
			this.add(newUserButton);
			this.add(existingUserButton);
		}
	}
	
	class RegisterPanel extends JPanel{
		
		public RegisterPanel(){
			this.setLayout(null);
			this.setBounds(0, 250, 800, 300);
			
			userNameLabel = new JLabel("User Name: ");
			passwordLabel = new JLabel("Password: ");
			userNameLabel.setBounds(200, 0, 100, 40);
			passwordLabel.setBounds(200, 50, 100, 40);

			userNameField = new JTextField();
			userNameField.setBounds(300, 0, 300, 40);
			passwordField = new JTextField();
			passwordField.setBounds(300, 50, 300, 40);
			
			registerButton = new JButton("Register");
			registerButton.setBounds(250, 150, 100, 50);
//			registerButton.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent ae){
//					
//				}
//			});
			registerButton.addActionListener(new SendText(userNameField, passwordField, "New"));
			backButton = new JButton("Back");
			backButton.setBounds(450, 150, 100, 50);
			backButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					changePanel(registerPanel, initialPanel);
				}
			});
			
			this.add(userNameLabel);
			this.add(passwordLabel);
			this.add(userNameField);
			this.add(passwordField);
			this.add(registerButton);
			this.add(backButton);
		}
	}
	
	class ExistingPanel extends JPanel{
		
		public ExistingPanel(){
			this.setLayout(null);
			this.setBounds(0, 250, 800, 300);

			userNameLabel = new JLabel("User Name: ");
			passwordLabel = new JLabel("Password: ");
			userNameLabel.setBounds(200, 0, 100, 50);
			passwordLabel.setBounds(200, 50, 100, 50);
			
			userNameField = new JTextField();
			userNameField.setBounds(300, 0, 300, 50);
			passwordField = new JTextField();
			passwordField.setBounds(300, 50, 300, 50);
			
			loginButton = new JButton("Login");
			loginButton.setBounds(250, 150, 100, 50);
			
			loginButton.addActionListener(new ActionListener()///change JPanel to CarChoosing Panel
			{
				public void actionPerformed(ActionEvent ae){
//					changePanel(initialPanel, registerPanel);
					CardLayout cl = (CardLayout)Crowcing.outerPanel.getLayout();
					cl.show(Crowcing.outerPanel, "chooseCar");
				}
			});
			
			loginButton.addActionListener(new SendText(userNameField, passwordField, "Existing"));
			System.out.println(userNameField.getText() +" "+ passwordField.getText());
			backButton = new JButton("Back");
			backButton.setBounds(450, 150, 100, 50);
			backButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					changePanel(existingPanel, initialPanel);
				}
			});
			
			this.add(userNameLabel);
			this.add(passwordLabel);
			this.add(userNameField);
			this.add(passwordField);
			this.add(loginButton);
			this.add(backButton);
		}
		
	}
	
	public void run(){
		revalidate();
	}
}
