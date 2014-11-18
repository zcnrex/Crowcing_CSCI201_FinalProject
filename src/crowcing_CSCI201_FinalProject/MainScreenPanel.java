package crowcing_CSCI201_FinalProject;

import javax.swing.JPanel;

//add all components inside this panel when racing starts.
public class MainScreenPanel extends JPanel implements Runnable{

	public void run(){
		revalidate();
	}
}
