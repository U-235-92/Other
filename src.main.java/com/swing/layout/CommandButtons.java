package com.swing.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CommandButtons extends JFrame {

	public CommandButtons() {
		
		super();
		
		setSize(350, 250);
		setLocation(150, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel grid= new JPanel(new GridLayout(1, 2, 5, 0));
		grid.add(new JButton("OK"));
		grid.add(new JButton("Oòìåíà"));
		
		JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		flow.add(grid);
		
		add(flow, BorderLayout.SOUTH);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			
			new CommandButtons();
		});
	}

}
