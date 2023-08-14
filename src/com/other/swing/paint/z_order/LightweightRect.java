package com.other.swing.paint.z_order;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class LightweightRect extends Component {
	
	private Color color;
	private boolean fill;
	public LightweightRect(Color color, boolean fill) {
		super();
		this.color = color;
		this.fill = fill;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		if(fill) {
			g.fillRect(0,  0, getWidth() - 1, getHeight() - 1);
		} else {
			g.drawRect(0,  0, getWidth() - 1, getHeight() - 1);
		}
	}
}
