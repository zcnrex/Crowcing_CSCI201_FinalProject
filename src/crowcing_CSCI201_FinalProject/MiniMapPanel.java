package crowcing_CSCI201_FinalProject;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

//In charge of drawing MiniMap on left bottom corner of the screen
public class MiniMapPanel extends JPanel implements Runnable{
	
	private Vector<Vector<Integer>> indexOfPosition;
	private int map[][];//the original data of map.txt
	private JLabel label[][];//the GUI JLabel of every pixel, only used in MiniMapPanel 
	
	
	
	public MiniMapPanel()
	{
		this.setSize(100,100);
		this.setLayout(new GridLayout(50,50));
		this.setVisible(true);
		
		
		
	
		
		Map newMap=new Map("map.txt");
		map=newMap.getMap();
		JLabel label[][]=newMap.getLabel();
		indexOfPosition=newMap.getIndexOfPosition();
				
		/*for (int i=0;i<50;i++)
		{
			for (int j=0;j<50;j++)
			{
				System.out.print(map[i][j]+" ");
			}
			System.out.println(i);
		}
		
		System.out.println(label.length+"  "+label[49].length);*/
		
		for (int i=0;i<50;i++)
		{
			for (int j=0;j<50;j++)
			{
				label[i][j].setIcon(new DrawMap(map[i][j]));
				MiniMapPanel.this.add(label[i][j]);
			}
			
		}
		
	}
	
	public int distacePerLap()
	{
		return indexOfPosition.size();
	}
	
	public Vector<Integer> currCoordinates(int totalDistanceTraveled)// vector[0]==y coordinates, vector[1]==x coordinates
	{
		int position=totalDistanceTraveled%indexOfPosition.size();
		return indexOfPosition.get(position);
	}
	
	public int currRoadType(int totalDistanceTraveled)// vector[0]==y coordinates, vector[1]==x coordinates
	{
		int position=totalDistanceTraveled%indexOfPosition.size();
		int type=map[indexOfPosition.get(position).get(0)][indexOfPosition.get(position).get(1)];
		return type;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
