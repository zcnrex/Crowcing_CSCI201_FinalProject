package crowcing_CSCI201_FinalProject;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

//Display image and information of three cars
public class CarChoosingPanel extends JPanel{

	private JLabel speedLabel;
	private JLabel accelerationLabel;
	private JLabel handlingLabel;
	private Car car[]=new Car[3];
	private JButton carButton[]=new JButton[3];//buttons for car
	private int carNumSelect;
	public static Car chosenCar;
	
	private ImageIcon backgroundImage= new ImageIcon("image/Motor.jpg");
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Image image= backgroundImage.getImage().getScaledInstance(800, 560, Image.SCALE_SMOOTH);
		ImageIcon background= new ImageIcon(image);
		
		 g.drawImage(background.getImage(), 0, 0, this);
		
	}
	
	public CarChoosingPanel()
	{
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		
		
		
		
		for (int i=0;i<3;i++)//set imageIcon and absolute location of the button	
		{
			ImageIcon icon = new ImageIcon("car"+((1+i)+"")+".jpg");	
			Image image= icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
			ImageIcon icon1=new ImageIcon(image);
			
			carButton[i]=new JButton(icon1);
			carButton[i].setBounds(50+i*250, 200, 200, 100);
			
			//car[i]=new Car("car"+((i+1)+""),i+1,i+2,i+3);
		}
		
		car[0]=new Car("car"+(1+""),7,8,9);
		car[1]=new Car("car"+(2+""),8,9,7);
		car[2]=new Car("car"+(3+""),9,7,8);
		
		
		JButton startButton=new JButton("start");//set up start button
		startButton.setPreferredSize(new Dimension(80,60));
		
		startButton.setBounds(650, 430,  (int)startButton.getPreferredSize().getWidth(), (int)startButton.getPreferredSize().getHeight());
		
		
		
		startButton.addActionListener(new ActionListener()//actionListener for startButton
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cl = (CardLayout)Crowcing.outerPanel.getLayout();
				cl.show(Crowcing.outerPanel, "mainScreen");
				chosenCar=car[carNumSelect];
				System.out.println("Start car "+(carNumSelect+1));
				
			}
			
		});
		
		JLabel title=new JLabel("Choose the car you like...");//set Labels
		speedLabel=new JLabel("Top speed score: N/A");
		accelerationLabel=new JLabel("Acceleration score: N/A");
		handlingLabel=new JLabel("handling score: N/A");
		
		title.setFont(new Font("Dialog",   1,   30));
		speedLabel.setFont(new Font("Dialog",   1,   18));
		accelerationLabel.setFont(new Font("Dialog",   1,   18));
		handlingLabel.setFont(new Font("Dialog",   1,   18));
		title.setBounds(100,100,(int)title.getPreferredSize().getWidth(), (int)title.getPreferredSize().getHeight());
		speedLabel.setBounds(50,350,(int)speedLabel.getPreferredSize().getWidth(), (int)speedLabel.getPreferredSize().getHeight());
		accelerationLabel.setBounds(50,370,(int)accelerationLabel.getPreferredSize().getWidth(), (int)accelerationLabel.getPreferredSize().getHeight());
		handlingLabel.setBounds(50,390,(int)handlingLabel.getPreferredSize().getWidth(), (int)handlingLabel.getPreferredSize().getHeight());
		
		/*MiniMapPanel miniMap=new MiniMapPanel(); ///for test only
		miniMap.setPreferredSize(new Dimension(100, 100)); 
		miniMap.setBounds(300,300,(int)miniMap.getPreferredSize().getWidth(), (int)miniMap.getPreferredSize().getHeight());
		this.add(miniMap);*/
		
		class carListener implements ActionListener
		{
			private int index;
			
			public carListener(int i)
			{
				index=i;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				for (int i=0;i<3;i++)
				{
					Border blackline;
	    			blackline = BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK);	        				
	    			carButton[i].setBorder(blackline);
				}
				
				Border redline;
    			redline = BorderFactory.createMatteBorder(3,3,3,3,Color.RED);	        				
    			carButton[index].setBorder(redline);
    			
				carNumSelect=index;
				speedLabel.setText("Top speed score: "+(car[index].getTopSpeed()+""));
				accelerationLabel.setText("Acceleration score: "+(car[index].getAcceleration())+"");
				handlingLabel.setText("handling score: "+(car[index].getHandling())+"");
				
			}
			
			
		}
		
		for (int i=0;i<3;i++)
		{
			carButton[i].addActionListener(new carListener(i));
			
		}
		
		
		for (int i=0;i<3;i++)//add objects on the panel
		{
			this.add(carButton[i]);
		}
		
		this.add(startButton);
		this.add(title);
		this.add(speedLabel);
		this.add(accelerationLabel);
		this.add(handlingLabel);
		
	}
	
	
	
}
