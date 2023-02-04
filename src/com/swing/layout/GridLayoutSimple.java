package com.swing.layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GridLayoutSimple extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -886505866758723012L;

	public GridLayoutSimple() {
		
		super();
		setSize(300, 200);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel grid = new JPanel();
		GridLayout gl = new GridLayout(2, 0, 5, 12);
		grid.setLayout(gl);
		
		for(int i= 0;i < 8; i++) {
			
			grid.add(new JButton("Button " + i));
		}
		
		add(grid);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			
			new GridLayoutSimple();
		});
	}

}
