package crowcing_CSCI201_FinalProject;



import javax.swing.JPanel;

//add all components inside this panel when racing starts.
public class MainScreenPanel extends JPanel implements Runnable// contain ChatPanel, miniMapPanel and RacingPanel
{
	public static MiniMapPanel miniMapPanel=new MiniMapPanel();
	private ChatPanel chatPanel=new ChatPanel();
	private RacingPanel racingPanel=new RacingPanel();

	public MainScreenPanel()
	{
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		
		chatPanel.setBounds(600, 0, (int)chatPanel.getPreferredSize().getWidth(), (int)chatPanel.getPreferredSize().getHeight());
		miniMapPanel.setBounds(500, 0, (int)miniMapPanel.getPreferredSize().getWidth(), (int)miniMapPanel.getPreferredSize().getHeight());
		racingPanel.setBounds(0, 0, (int)racingPanel.getPreferredSize().getWidth(), (int)racingPanel.getPreferredSize().getHeight());
		Thread t = new Thread(racingPanel);
		this.add(racingPanel);
		this.add(chatPanel);
		this.add(miniMapPanel);
		
	}
	
	public void run(){
		revalidate();
	}
}
