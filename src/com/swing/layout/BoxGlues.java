package com.swing.layout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoxGlues extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5078799920898936082L;
	
	public BoxGlues() {
		
		super();
		setSize(250,  200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel main = BoxLayoutUtils.createVerticalPanel();
		
		JPanel pVert = BoxLayoutUtils.createVerticalPanel();
		pVert.add(Box.createVerticalGlue());
		pVert.add(new JButton("Один"));
		pVert.add(new JButton("Два"));
		
		JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
		pHor.add(Box.createHorizontalGlue());
		pHor.add(new JButton("Три"));
		pHor.add(new JButton("Четыре"));
		pHor.add(Box.createHorizontalGlue());
		
		main.add(pVert);
		main.add(Box.createHorizontalStrut(15));
		main.add(pHor);
		
		getContentPane().add(main);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SwingUtilities.invokeLater(() -> {
//			
//			new BoxGlues();
//		});
		
		new BoxGlues();
	}

}
