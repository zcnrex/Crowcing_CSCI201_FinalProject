package crowcing_CSCI201_FinalProject;



import java.awt.Dimension;

import javax.swing.JPanel;

//add all components inside this panel when racing starts.
public class MainScreenPanel extends JPanel implements Runnable// contain ChatPanel, miniMapPanel and RacingPanel
{
	public static MiniMapPanel miniMapPanel=new MiniMapPanel();
	public static ChatPanel chatPanel=new ChatPanel();
	public static RacingPanel racingPanel=new RacingPanel();

	public MainScreenPanel()
	{
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		
		//racingPanel.setPreferredSize(new Dimension(600,600));
		
		chatPanel.setBounds(600, 0, 200, 600);
		miniMapPanel.setBounds(500, 0, 100, 100);
		racingPanel.setBounds(0, 0, 800, 600);
		//Thread t = new Thread(racingPanel);
		this.add(racingPanel);
		this.add(chatPanel);
		this.add(miniMapPanel);
		
	}
	
	public void run(){
		revalidate();
	}
}
