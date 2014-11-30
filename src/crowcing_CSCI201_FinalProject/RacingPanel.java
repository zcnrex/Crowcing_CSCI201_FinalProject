package crowcing_CSCI201_FinalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;

import javax.swing.JPanel;

//Display the move of cars and statistics
//One car or two?
//Constantly changing background to indicate moving
public class RacingPanel extends JPanel implements Runnable{
	private Car car = new Car("car"+(1+""),3,4,5);
	private CarThread carThread = new CarThread(car, 1);
	private Map map = new Map("map.txt");
	private int[][] mapPosition = new int[50][50];
	private int[] position = new int[2];
	private int type = 0;
	private final int len = 200;
	private Polygon poly = new Polygon();
	
	public RacingPanel()
	{
		this.setSize(600,600);
		//this.setLayout(new GridLayout(50,50));
		this.setVisible(true);
	} 
	
	public RacingPanel(int i ){
		this.setSize(600,600);
		//this.setLayout(new GridLayout(50,50));
		this.setVisible(true);
		mapPosition = map.getMap();
		carThread.start();
	}
	
	public void paintComponent(Graphics g){
		position[0] = carThread.getPositionX();
		position[1] = carThread.getPositionY();
		for (int i = -1; i < 1; i++){
			for (int j = -1; j < 1; j++){
				type = mapPosition[position[0]+i][position[1]+j];
//				
				if(type == 0){
					if(position[0] > 1 && position[0] < 49 && position[1] > 1 && position[1] < 49){
						if(mapPosition[position[0]+i][position[1]+j-1] == 8 || mapPosition[position[0]+i][position[1]+j-1] == 4 ||
								mapPosition[position[0]+i+1][position[1]+j] == 8 || mapPosition[position[0]+i+1][position[1]+j] == 4){
							
							poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.BLACK);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+1)*len, (j+2)*len);							
					        g.setColor(Color.GREEN);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
							continue;
						}
						else if(mapPosition[position[0]+i][position[1]+j+1] == 8 || mapPosition[position[0]+i][position[1]+j+1] == 4 ||
								mapPosition[position[0]+i-1][position[1]+j] == 8 || mapPosition[position[0]+i-1][position[1]+j] == 4){
							
							poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.GREEN);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+1)*len, (j+2)*len);							
					        g.setColor(Color.BLACK);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
							continue;
						}
						else if(mapPosition[position[0]+i][position[1]+j+1] == 6 || mapPosition[position[0]+i][position[1]+j+1] == 2 ||
								mapPosition[position[0]+i+1][position[1]+j] == 6 || mapPosition[position[0]+i+1][position[1]+j] == 2){
							
							poly = new Polygon();
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.BLACK);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+1)*len, (j+2)*len);							
					        g.setColor(Color.GREEN);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
							continue;
						}
						else if(mapPosition[position[0]+i][position[1]+j-1] == 6 || mapPosition[position[0]+i][position[1]+j-1] == 2 ||
								mapPosition[position[0]+i-1][position[1]+j] == 6 || mapPosition[position[0]+i-1][position[1]+j] == 2){
							
							poly = new Polygon();
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.GREEN);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+1)*len, (j+2)*len);							
					        g.setColor(Color.BLACK);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
							continue;
						}
					}
					g.setColor(Color.GREEN);
					g.drawRect((i+1)*len, (j+1)*len, len, len);
				}
				else {
					g.setColor(Color.BLACK);
					g.drawRect((i+1)*len, (j+1)*len, len, len);
				}
					
				
				
			}
		}
	}
	public void run(){
		while(true){
		repaint();
		}
	}
}
