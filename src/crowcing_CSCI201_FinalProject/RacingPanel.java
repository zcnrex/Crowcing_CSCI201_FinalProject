package crowcing_CSCI201_FinalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//Display the move of cars and statistics
//One car or two?
//Constantly changing background to indicate moving
public class RacingPanel extends JPanel implements Runnable{
	private Car car = new Car("car"+(1+""),7,8,9);
	private CarThread carThread;// = new CarThread(car, 1);
	private Map map = new Map("map.txt");
	private int[][] mapPosition = new int[50][50];
	private int[] position = new int[2], prevPosition = new int[2];
	private int type = 0, odd = 0;
	private final int len = 200;
	private Polygon poly = new Polygon();

	
	public RacingPanel( ){
		this.setSize(600,600);
		//this.setLayout(new GridLayout(50,50));
		this.setVisible(true);
		int[][] tempMap = new int[50][50];
		tempMap = map.getMap();
		for (int i = 0; i < 50; i++){
			for (int j = 0; j < 50; j++){
				mapPosition[i][j] = tempMap[j][i];
			}
		}
	}

	public void paintComponent(Graphics g){
		position[0] = carThread.getPositionX();
		position[1] = carThread.getPositionY();
		for (int i = -1; i < 2; i++){
			for (int j = -1; j < 2; j++){
				type = mapPosition[position[0]+i][position[1]+j];
//				System.out.println("X " + position[0] + " Y " + position[1]);
//				System.out.println("YO" + type);
				if(type == 0){
					if(position[0] > 1 && position[0] < 49 && position[1] > 1 && position[1] < 49){
						
						//draw this shape
						//*000
						//**00
						//***0						
						if(mapPosition[position[0]+i][position[1]+j-1] == 8 || mapPosition[position[0]+i][position[1]+j-1] == 4 ||
								mapPosition[position[0]+i+1][position[1]+j] == 8 || mapPosition[position[0]+i+1][position[1]+j] == 4){
							
							poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.YELLOW);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.RED);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
							continue;
						}
						
						//draw
						//0***
						//00**
						//000*
						else if(mapPosition[position[0]+i][position[1]+j+1] == 8 || mapPosition[position[0]+i][position[1]+j+1] == 4 ||
								mapPosition[position[0]+i-1][position[1]+j] == 8 || mapPosition[position[0]+i-1][position[1]+j] == 4){
							
							poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.RED);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+1)*len);
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+2)*len, (j+2)*len);							
					        g.setColor(Color.YELLOW);
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
					        g.setColor(Color.YELLOW);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+1)*len, (j+1)*len);							
					        g.setColor(Color.RED);
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
					        g.setColor(Color.RED);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
					        
					        poly = new Polygon();
							poly.addPoint((i+1)*len, (j+2)*len);
							poly.addPoint((i+2)*len, (j+1)*len);
							poly.addPoint((i+1)*len, (j+1)*len);							
					        g.setColor(Color.YELLOW);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
							continue;
						}
					}
					g.setColor(Color.RED);
					g.drawRect((i+1)*len, (j+1)*len, len, len);
					g.fillRect((i+1)*len, (j+1)*len, len, len);
				}
				else {
					g.setColor(Color.YELLOW);
					g.drawRect((i+1)*len, (j+1)*len, len, len);
					g.fillRect((i+1)*len, (j+1)*len, len, len);
					if(type == 1 || type == 5){
						if ((position[0] + i + position[1] + j) % 2 == 0){
							g.setColor(Color.WHITE);
							poly = new Polygon();
							poly.addPoint((i+1)*len + 20, (j+1)*len + len/2 - 10);
							poly.addPoint((i+1)*len + 20, (j+1)*len + len/2 + 10);
							poly.addPoint((i+2)*len - 20, (j+1)*len + len/2 + 10);
							poly.addPoint((i+2)*len - 20, (j+1)*len + len/2 - 10);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
						}
					}
					else if(type == 3 || type == 7){
						if ((position[0] + i + position[1] + j) % 2 == 0){
							g.setColor(Color.WHITE);
							poly = new Polygon();
							poly.addPoint((i+1)*len + len/2 - 10, (j+1)*len + 20);
							poly.addPoint((i+1)*len + len/2 + 10, (j+1)*len + 20);
							poly.addPoint((i+1)*len + len/2 + 10, (j+2)*len - 20);
							poly.addPoint((i+1)*len + len/2 - 10, (j+2)*len - 20);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
						}
					}
					else if(type == 2 || type == 6){
						if ((position[0] + i) % 2 == 0){
							g.setColor(Color.WHITE);
							poly = new Polygon();
							poly.addPoint((i+2)*len - 60, (j+1)*len + 40);
							poly.addPoint((i+2)*len - 40, (j+1)*len + 60);
							poly.addPoint((i+1)*len + 60, (j+2)*len - 40);
							poly.addPoint((i+1)*len + 40, (j+2)*len - 60);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
						}
					}
					else if(type == 4 || type == 8){
						if ((position[0] + i) % 2 == 0){
							g.setColor(Color.WHITE);
							poly = new Polygon();
							poly.addPoint((i+1)*len + 40, (j+1)*len + 60);
							poly.addPoint((i+1)*len + 60, (j+1)*len + 40);
							poly.addPoint((i+2)*len - 40, (j+2)*len - 60);
							poly.addPoint((i+2)*len - 60, (j+2)*len - 40);
					        g.drawPolygon(poly);
					        g.fillPolygon(poly);
						}
					}
				}
					
				if (odd == 0) odd = 1;
				else odd = 0;
				
			}
		}

		type = mapPosition[position[0]][position[1]];
		String carName=carThread.getCarName();
		ImageIcon carImg = new ImageIcon("car/"+carName+"-" + type + ".png");
//		Image ca = carImg.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		ImageIcon carImg = new ImageIcon("car/car1-" + type + ".png");
		int size = (int) (len/2*1.5);
		switch (type){
			case 1: 
				g.drawImage(carImg.getImage(), len, len-len/8, size, size, null);
				break;
			case 2:
				g.drawImage(carImg.getImage(), len, len - len/4, size, size, null);
				break;
			case 3:
				g.drawImage(carImg.getImage(), len-len/8, len, size, size, null);
				break;
			case 4:
				g.drawImage(carImg.getImage(), len, len + len/4*3, size, size, null);
				break;
			case 5:
				g.drawImage(carImg.getImage(), len, len*3/2-len/8, size, size, null);
				break;
			case 6: 
				g.drawImage(carImg.getImage(), len*3/2, len*3/2, size, size, null);
				break;
			case 7: 
				g.drawImage(carImg.getImage(), len*3/2-len/8, len, size, size, null);
				break;
			case 8: 
				g.drawImage(carImg.getImage(), len*3/2, len, size, size, null);
				break;
		}
	}
	public void run(){
	    carThread = new CarThread(CarChoosingPanel.chosenCar, 1);
		carThread.start();
		while(true){
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
