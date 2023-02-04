package com.other.swing.table;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.util.Vector;

public class SimpleTables extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -278212309285833771L;
	
	private Object[][] colors = new String[][] {
		{"Красный", "Зеленый", "Желтый"},
		{"Синий", "Оранжевый", "Белый"},
	};
	
	private Object[] colorsHeader = new String[] {"Цвет", "Еще цвет", "Тоже цвет"};
	
	public SimpleTables() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTable table1 = new JTable(colors, colorsHeader);
		JTable table2 = new JTable(5, 5);
		
		Vector<Vector<String>> data = new Vector<>();
		
		Vector<String> row1 = new Vector<String>();
		Vector<String> row2 = new Vector<String>();
		
		Vector<String> columnNames = new Vector<String>();
		
		for(int i = 0; i < 3; i++) {
			
			row1.add("Ячейка 1." + i);
			row2.add("Ячейка 2." + i);
			columnNames.add("Столбец #" + i);
		}
		
		data.add(row1);
		data.add(row2);
		
		JTable table3 = new JTable(data, columnNames);
		
		setLayout(new GridLayout(3, 1));
		
		add(new JScrollPane(table1));
		add(new JScrollPane(table2));
		
		add(table3);
		setSize(350, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SimpleTables();
			}
		});
	}

}
