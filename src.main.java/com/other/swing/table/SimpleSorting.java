package com.other.swing.table;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class SimpleSorting extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5774500575553917575L;

	public SimpleSorting() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		SortModel sm = new SortModel();
		sm.setColumnCount(4);
		
		for(int i = 0; i < 100; i++) {
			
			sm.addRow(new Integer[] {
					i,
					(int) (5 * Math.random()),
					(int) (5 * Math.random()),
					(int) (5 * Math.random())
			});
		}
		
		JTable table = new JTable();
		
		table.setAutoCreateRowSorter(true);
		
//		((TableRowSorter) table.getRowSorter()).setMaxSortKeys(2);
		
		table.setModel(sm);
		add(new JScrollPane(table));
		setSize(400, 300);
		setVisible(true);
	}
	
	static class SortModel extends DefaultTableModel {
		
		public Class getColumnClass(int column) {
			
			return Integer.class;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SimpleSorting();
			}
		});
	}

}
