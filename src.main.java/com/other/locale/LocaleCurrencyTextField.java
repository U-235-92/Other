package com.other.locale;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class LocaleCurrencyTextField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(() -> {
			localeNumTF();
		});
	}

	private static void localeNumTF() {
		JFrame frame = new JFrame("Currency frame example");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		Locale locale = Locale.forLanguageTag("ru-RU");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		JFormattedTextField currencyField = new JFormattedTextField(numberFormat);
		currencyField.setColumns(10);
		JButton button = new JButton("OK");
		button.addActionListener(e -> {
			System.out.println(currencyField.getText());
		});
		panel.add(currencyField);
		panel.add(button);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(200, 200));
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void maskFormatTF() {
		JFrame f = new JFrame();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container content = f.getContentPane();
	    content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

	    MaskFormatter mf1 = null;
		try {
			mf1 = new MaskFormatter("###-###-###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    mf1.setPlaceholderCharacter('_');
	    JFormattedTextField ftf1 = new JFormattedTextField(mf1);
	    content.add(ftf1);

	    MaskFormatter mf2 = null;
		try {
			mf2 = new MaskFormatter("(###) ###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    JFormattedTextField ftf2 = new JFormattedTextField(mf2);
	    content.add(ftf2);
	    f.setSize(300, 100);
	    f.setVisible(true);
	}
}
