package com.other.swing.midi;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

public class SimpleMIDI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9024136416748210949L;

	public SimpleMIDI() {
		
		super();
		
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		add(desktopPane);
		
		JInternalFrame frame1 = new JInternalFrame("Frame_1", true);
		JInternalFrame frame2 = new JInternalFrame("Frame_2", true, true, true, true);
		JInternalFrame frame3 = new JInternalFrame("Frame_3", false, true);
		
		frame3.putClientProperty("JInternalFrame.isPalette", true);
		desktopPane.add(frame1);
		desktopPane.add(frame2);
		desktopPane.add(frame3);
		
		frame1.setSize(200, 100);
		frame1.setLocation(80, 100);
		
		frame2.setSize(200, 60);
		
		frame3.setSize(100, 200);
		
		frame1.setVisible(true);
		frame2.setVisible(true);
		frame3.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SimpleMIDI().setVisible(true);
			}
		});
	}

}
