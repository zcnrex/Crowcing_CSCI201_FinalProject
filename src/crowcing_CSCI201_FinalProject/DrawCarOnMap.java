package crowcing_CSCI201_FinalProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;



public class DrawCarOnMap implements Icon {
	

	private int degree;
	private int index;
	private String type;
	private int visible;
	private int carNum;
	private List<Car> car=new ArrayList<Car>();
	int x=0;
	
	
	public DrawCarOnMap(Tiles t,int index, List<Car> _car,int visible,int carNum)
	{
		this.degree=t.degree;
		this.type=t.type;
		this.index=index;
		this.car=_car;
		this.visible=visible;
		this.carNum=carNum;
	}
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub

		 g.setColor(Color.cyan);
		    g.fillRect(x, y, getIconWidth(), getIconHeight());
		    if (type!=0)
		    {
		    	g.setColor(Color.black);
		    	g.fillRect(x, y, getIconWidth(),getIconHeight());
		    	
		    	
		    }

		    if (visible==1)
		    {
		    	Car cc=car.get(carNum);
		    	
		    		if (cc.color.equals("red"))
		    		{
		    			g.setColor(Color.red);
		    		}
		    		else if (cc.color.equals("blue"))
		    		{
		    			g.setColor(Color.blue);
		    		}
		    		else if (cc.color.equals("yellow"))
		    		{
		    			g.setColor(Color.yellow);
		    		}
		    		else if (cc.color.equals("orange"))
		    		{
		    			g.setColor(Color.orange);
		    		}
		    		else if (cc.color.equals("green"))
		    		{
		    			g.setColor(Color.green);
		    		}
		    		g.drawOval(15, 15,30, 30);
		    		g.fillOval(15, 15,30, 30);
		    		g.setColor(Color.black);
		    		g.drawString(""+(carNum+1), 30, 30);

		    }
		    	else if (visible==0)
		    	{
		    		
		    	}
		    
		    	
		   
		    
		   
		   // g.setColor(color);
		    //g.fillRect(x + borderWidth, y + borderWidth, getIconWidth() - 2 * borderWidth,
		       // getIconHeight() - 2 * borderWidth);

	}

}

