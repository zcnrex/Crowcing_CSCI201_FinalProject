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
	//private CarThread selfCar=new CarThread(CarChoosingPanel.chosenCar,1);
	//private CarThread selfCar;
	
	
	public MiniMapPanel()
	{
		this.setSize(100,100);
		this.setLayout(new GridLayout(50,50));
		this.setVisible(true);
		
//		
//		Car car=new Car("car"+(1+""),7,8,9);
//		CarThread selfCar=new CarThread(car,1);
		
		Map newMap=new Map("map.txt");
		map=newMap.getMap();
		label=newMap.getLabel();
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
		
		
		
		//selfCar.start();
		
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
		
		//Car car=new Car("car"+(1+""),7,8,9);
		//Car car=new Car("car"+(2+""),8,9,7);
		//Car car=new Car("car"+(3+""),9,7,8);
		
		//selfCar=new CarThread(car,1);
		CarThread selfCar=new CarThread(CarChoosingPanel.chosenCar,1);
		selfCar.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//System.out.println(selfCar.getTotalDistanceTraveled()+" **** "+distacePerLap());
		while (selfCar.getTotalDistanceTraveled()<distacePerLap())
		{
			int x=selfCar.getPositionX();
			int y=selfCar.getPositionY();
			System.out.println(x+" **** "+y);
			System.out.println(map[y][x]+" **** "+selfCar.getCarName()+"  "+label.length);
			
			label[y][x].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y][x],1));
			label[y][x+1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y][x+1],1));
			label[y+1][x].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y+1][x],1));
			label[y-1][x].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y-1][x],1));
			label[y][x-1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y][x-1],1));
			label[y-1][x-1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y-1][x-1],1));
			label[y+1][x+1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y+1][x+1],1));
			label[y+1][x-1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y+1][x-1],1));
			label[y-1][x+1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y-1][x+1],1));
			
			int sleepTime=(int)(5000/selfCar.getCurrentSpeed());
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			label[y][x].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y][x],0));
			label[y][x+1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y][x+1],0));
			label[y+1][x].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y+1][x],0));
			label[y-1][x].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y-1][x],0));
			label[y][x-1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y][x-1],0));
			label[y-1][x-1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y-1][x-1],0));
			label[y+1][x+1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y+1][x+1],0));
			label[y+1][x-1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y+1][x-1],0));
			label[y-1][x+1].setIcon(new DrawCarOnMap(selfCar.getCarName(),map[y-1][x+1],0));
			
		}
		
	}

}
