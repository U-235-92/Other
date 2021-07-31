package com.other.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

public class SimpleButton extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1114115645817189004L;
	
	private ArrayList<ButtonPressListener> listenerList = new ArrayList<>();
	
	private ButtonPressEvent event = new ButtonPressEvent(this);
	
	public SimpleButton() {
		
		addMouseListener(new PressL());
		setPreferredSize(new Dimension(100, 100));
	}
	
	public void addButtonPressListener(ButtonPressListener  l) {
		
		listenerList.add(l);
	}

	public void removeButtonPressListener(ButtonPressListener l) {
		
		listenerList.remove(l);
	}
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.black);
		g.draw3DRect(0, 0, getWidth(), getHeight(), true);
	}
	
	protected void fireButtonPressed() {
		
		for(ButtonPressListener l : listenerList) {
			
			l.buttonPressed(event);
		}
	}
	
	class PressL extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			
			fireButtonPressed();
		}
	}
}
