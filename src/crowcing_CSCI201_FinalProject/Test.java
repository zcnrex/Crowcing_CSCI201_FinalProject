package crowcing_CSCI201_FinalProject;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Test {

	public static void main(String []args)
	{
//		JFrame jf=new JFrame();
//
//		//jf.setSize(800,600);
//		//CarChoosingPanel choosePanel=new CarChoosingPanel();
//		//jf.add(choosePanel);
//		
//		jf.setSize(100,100);
//		MiniMapPanel miniMap=new MiniMapPanel();
//		miniMap.setPreferredSize(new Dimension(200, 200));  
//		jf.add(miniMap);
//
//		//jf.setSize(800,600);
//		//LoginPanel lp = new LoginPanel();
//		//jf.add(lp);
////		while(true){
////			if (lp.getDone()) {
////				jf.remove(lp);
////				CarChoosingPanel choosePanel=new CarChoosingPanel();
////				jf.add(choosePanel);
////				break;
////			}
////		}
//		
//
//		jf.setVisible(true);
		Car car1 = new Car("car1", 10, 2, 2);
		CarThread ct = new CarThread(car1, 1);
	}
}
