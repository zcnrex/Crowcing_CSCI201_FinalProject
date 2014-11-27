package crowcing_CSCI201_FinalProject;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Test {

	public static void main(String []args)
	{
		JFrame jf=new JFrame();
		//jf.setSize(800,600);
		//CarChoosingPanel choosePanel=new CarChoosingPanel();
		//jf.add(choosePanel);
		
		jf.setSize(100,100);
		MiniMapPanel miniMap=new MiniMapPanel();
		miniMap.setPreferredSize(new Dimension(200, 200));  
		jf.add(miniMap);
		jf.setVisible(true);
	}
}
