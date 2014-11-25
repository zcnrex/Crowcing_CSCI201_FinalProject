package crowcing_CSCI201_FinalProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Display result of a player
public class ResultPanel extends JPanel{
	private JButton JBrematch;
	private JButton JBexit;
	private JLabel JLfinalRank;
	private JLabel JLbestLap;
	private JLabel JLtotalLap;
	private int rank;
	private int laptime;
	private JOptionPane newRecord;
	
	public ResultPanel(int finalRank, int bestLap, int totalLap){
		setSize(800,600);
		setLayout(null);
		JLfinalRank = new JLabel("Final Rank: " + String.valueOf(finalRank));
		JLfinalRank.setFont(new Font("Dialog", 1, 22));
		JLfinalRank.setBounds(300, 120, 200, 30);
		add(JLfinalRank);
		
		JLbestLap = new JLabel("Best Lap Time: " + String.valueOf(bestLap));
		JLbestLap.setFont(new Font("Dialog", 1, 22));
		JLbestLap.setBounds(300, 180, 200, 30);
		add(JLbestLap);
		
		JLtotalLap = new JLabel("Total Lap Time: " + String.valueOf(totalLap));
		JLtotalLap.setFont(new Font("Dialog", 1, 22));
		JLtotalLap.setBounds(300, 240, 200, 30);
		add(JLtotalLap);
		
		JBrematch = new JButton("Rematch");
		JBrematch.setFont(new Font("Dialog", 1, 22));
		JBrematch.setBounds(330, 380, 140, 30);
		add(JBrematch);
		
		JBexit = new JButton("Exit");
		JBexit.setFont(new Font("Dialog", 1, 22));
		JBexit.setBounds(330, 480, 140, 30);
		add(JBexit);
		
		JBrematch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//call carChoosingPanel
			}
		});
		JBexit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
}
