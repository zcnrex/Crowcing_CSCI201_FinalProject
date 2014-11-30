package crowcing_CSCI201_FinalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.Timer;

// send action only
// handling: get arbitrary function first
// get index

//Updates position of a car, 
//consider speed, acceleration, handling, NO2, bombing
public class CarThread extends Car implements Runnable
{
	/*private ImageIcon carImg;
	private int topSpeed, acceleration, handling, bombValue;
	private String carName, bombName;
*/
	private double currentTopSpeed; 
	private double currentAcceleration;
	private double currentHandling;
	private int index;

	private int totalDistanceTraveled = 0;
	private int positionx = 0;
	private int positiony = 0;
	private Map map;
	private int mapArray[][];
	private Vector<Vector<Integer>> indexOfPosition;
	private int currentSpeed = 0;
	
	public CarThread(Car carInfo, int index)
	{
		this.setAcceleration(carInfo.getAcceleration());
		this.setTopSpeed(carInfo.getTopSpeed());
		this.setHandling(carInfo.getHandling());
		this.index = index;
		
		currentTopSpeed=(double)this.getTopSpeed();
		currentAcceleration=(double)this.getAcceleration();
		currentHandling=(double)this.getHandling();
		map = new Map("map.txt");
		mapArray = map.getMap();
		indexOfPosition = map.getIndexOfPosition();
	}

	@Override
	public void run() {
		while(totalDistanceTraveled<=indexOfPosition.size()){
//			if(getRoadType()%2==1){
//				if()
//			}
			
			totalDistanceTraveled++;
			positionx = map.getIndexOfPosition().get(totalDistanceTraveled).get(1);
			positiony = map.getIndexOfPosition().get(totalDistanceTraveled).get(0);
			//Thread.sleep()
		}
		
		
		
				
		/*while (true)
		{
			if get message from server, then start
			break;
		}*/
		
		
		
	}
	
	public void reduceCurrentTopSpeed(double speedReduced,int time)
	{
		currentTopSpeed-=speedReduced;
	}
	
	public void reduceCurrentAcceleration(double accelerationReduced,int time)
	{
		currentAcceleration-=accelerationReduced;
	}
	
	public void reduceCurrentHandling(double handlingReduced,int time)
	{
		currentHandling-=handlingReduced;
	}
	
	public int getTotalDistanceTraveled(){
		return totalDistanceTraveled;
	}
	
	public int getPositionX(){
		return positionx;
	}
	
	public int getPositionY(){
		return positiony;
	}
	
	public int getRoadType(){
		int position=totalDistanceTraveled%indexOfPosition.size();
		int type=mapArray[indexOfPosition.get(position).get(0)][indexOfPosition.get(position).get(1)];
		return type;
	}
	
}
