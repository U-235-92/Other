package com.other.swing.awt_painting;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTPainting extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6956414468966370349L;

	public AWTPainting() {
		
		super();
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		setLayout(new FlowLayout());
		
		add(new Button("Button!") {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 216326030735762289L;

			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				g.setColor(Color.blue);
				g.fillRect(2, 2, getWidth() - 5, getHeight() - 5);
			}
		});
		
		setSize(200, 200);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public static void main(String[] args) {
		
		new AWTPainting().setVisible(true);
	}
}
