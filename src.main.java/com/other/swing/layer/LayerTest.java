package com.other.swing.layer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.LayerUI;

public class LayerTest extends JFrame {

	public LayerTest() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(new JTextField(10));
		panel.add(new JButton("OK"));
		JLayer<JPanel> layer = new JLayer<JPanel>(panel);
		layer.setUI(new LayerUI<>() {
			private int lastX, lastY;
			@Override
			public void paint(Graphics g, JComponent c) {
				super.paint(g, c);
				g.setColor(Color.RED);
				g.fillOval(lastX, lastY, 15, 15);
			}
			
			@Override
			protected void processMouseMotionEvent(MouseEvent e, JLayer<? extends JPanel> l) {
				System.out.println("Ok");
				lastX = SwingUtilities.convertMouseEvent((Component)e.getSource(), e, layer).getX();
				lastY = SwingUtilities.convertMouseEvent((Component)e.getSource(), e, layer).getY();
				repaint();
			}
		});
		
		add(layer);
		setSize(400, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new LayerTest();
		});
	}
}
