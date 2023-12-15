package com.other.swing.label_mnemonic;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LabelMnemonic extends JFrame {

	public LabelMnemonic() {
		super("LabelMnemonic");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel contents = new JPanel(new GridLayout(2,  2));
		JTextField tf = new JTextField(10);
		JLabel label = new JLabel("Ваше имя:");
		label.setLabelFor(tf);
		label.setDisplayedMnemonic('И');
		contents.add(new JLabel("Ваша фамилия:"));
		contents.add(new JTextField(10));
		contents.add(label);
		contents.add(tf);
		setContentPane(contents);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			new LabelMnemonic();
		});
	}

}
