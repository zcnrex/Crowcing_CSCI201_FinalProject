package crowcing_CSCI201_FinalProject;

import javax.swing.ImageIcon;


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
	
	
	
	public CarThread(Car carInfo)
	{
		this.setAcceleration(carInfo.getAcceleration());
		this.setTopSpeed(carInfo.getTopSpeed());
		this.setHandling(carInfo.getHandling());
		
		currentTopSpeed=(double)this.getTopSpeed();
		currentAcceleration=(double)this.getAcceleration();
		currentHandling=(double)this.getHandling();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
				
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
	
}
