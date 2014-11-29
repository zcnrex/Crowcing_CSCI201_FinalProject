package crowcing_CSCI201_FinalProject;

import javax.swing.JFrame;

public class Test {

	public static void main(String []args)
	{
		JFrame jf=new JFrame();
		jf.setSize(800,600);
		LoginPanel lp = new LoginPanel();
		jf.add(lp);
//		while(true){
//			if (lp.getDone()) {
//				jf.remove(lp);
//				CarChoosingPanel choosePanel=new CarChoosingPanel();
//				jf.add(choosePanel);
//				break;
//			}
//		}
		
		jf.setVisible(true);
	}
}
