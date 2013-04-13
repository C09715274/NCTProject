package ie.nct.groupproject;

import javax.swing.JFrame;

public class MakeFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame;
	
	public MakeFrame(){
		frame = new JFrame("Foo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1366, 768);
		frame.setVisible(true);
	}

}
