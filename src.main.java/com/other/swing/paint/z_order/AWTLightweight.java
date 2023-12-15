package com.other.swing.paint.z_order;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTLightweight extends Frame {

	public AWTLightweight() {
		super("Frame");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		LightweightRect rectBlue = new LightweightRect(Color.BLUE, true);
		LightweightRect rectRed = new LightweightRect(Color.RED, true);
		LightweightRect rectTransparent = new LightweightRect(Color.BLACK, false);
		setLayout(null);
		rectBlue.setBounds(40, 40, 100, 100);
		rectRed.setBounds(50, 50, 100, 100);
		rectTransparent.setBounds(35, 35, 150, 150);
		add(rectTransparent);
		add(rectBlue);
		add(rectRed);
		setSize(250, 250);
		setVisible(true);
	}
}
