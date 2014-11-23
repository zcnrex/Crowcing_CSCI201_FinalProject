package crowcing_CSCI201_FinalProject;

import javax.swing.JFrame;

public class Test {

	public static void main(String []args)
	{
		JFrame jf=new JFrame();
		jf.setSize(800,600);
		CarChoosingPanel choosePanel=new CarChoosingPanel();
		jf.add(choosePanel);
		jf.setVisible(true);
	}
}
