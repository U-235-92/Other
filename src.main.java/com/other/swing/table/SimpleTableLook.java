package com.other.swing.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class SimpleTableLook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8553214762682200011L;
	
	private Object[][] data = new String[][] {
		{"Мощная", "Синий", "Спортивный"},
		{"Экономичная", "Красный", "Классика"},
	};
	
	private Object[] columns = new String[] {"Модель", "Цвет", "Дизайн"};
	
	public SimpleTableLook() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTable table1 = new JTable(data, columns);
		table1.setRowHeight(40);
		table1.setIntercellSpacing(new Dimension(10, 10));
		table1.setGridColor(Color.green);
		table1.setShowVerticalLines(false);
		
		JTable table2 = new JTable(data, columns);
		table2.setForeground(Color.red);
		table2.setSelectionForeground(Color.yellow);
		table2.setSelectionBackground(Color.blue);
		table2.setShowGrid(false); 
//		table2.setRowSelectionAllowed(false);
		
		setLayout(new GridLayout(1, 2, 5, 5));
		add(new JScrollPane(table1));
		add(new JScrollPane(table2));
		
		setSize(600, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SimpleTableLook();
			}
		});
	}

}
