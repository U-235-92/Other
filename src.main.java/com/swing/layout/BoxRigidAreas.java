package com.swing.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxRigidAreas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -58560417987690496L;
	
	public BoxRigidAreas() {
		
		super();
		
		setSize(250,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pVert = BoxLayoutUtils.createVerticalPanel();
		pVert.add(new JButton("Один"));
		
		JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
		pHor.add(new JButton("Два"));
		pHor.add(Box.createRigidArea(new Dimension(50, 120)));
		pHor.add(new JButton("Три"));
		pVert.add(pHor);
		add(pVert);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoxRigidAreas();
	}

}
