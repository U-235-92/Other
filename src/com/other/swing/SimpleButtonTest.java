package com.other.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimpleButtonTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1968750325221921479L;
	
	public SimpleButtonTest() {
		
		super("Test");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		SimpleButton button = new SimpleButton();
		
		button.addButtonPressListener(new ButtonPressListener() {
			
			@Override
			public void buttonPressed(ButtonPressEvent e) {
				// TODO Auto-generated method stub
				System.out.println("1!");
			}
		});
		
		button.addButtonPressListener(new ButtonL());
		
		JPanel contents = new JPanel();
		contents.add(button);
		setContentPane(contents);
		setSize(400, 300);
		setVisible(true);
		
	}

	class ButtonL implements ButtonPressListener {

		@Override
		public void buttonPressed(ButtonPressEvent e) {
			// TODO Auto-generated method stub
			System.out.println("2!");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			
			new SimpleButtonTest();
		});
	}

}
