package com.other.swing.root;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class TreeDefaultEditing extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8213294891009646274L;
	private String[] basics = {"Красный", "Зеленый", "Синий"};
	private String[] extendeds = {"Желтый", "Голубой", "Розовый"};
	
	public TreeDefaultEditing() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTree tree = new JTree(createTreeModel());
		
		tree.setEditable(true);
		
		JComboBox<String> combo = new JComboBox<>(new String[] {"Красный", "Зеленый"});
		
		DefaultCellEditor editor = new DefaultCellEditor(combo);
		
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		
		DefaultTreeCellEditor treeEditor = new DefaultTreeCellEditor(tree, renderer, editor);
		
		tree.setCellEditor(treeEditor);
		
		add(new JScrollPane(tree));
		setSize(400, 300);
		setVisible(true);
		
	}
	
	private TreeModel createTreeModel() {
		
		DefaultMutableTreeNode root =new DefaultMutableTreeNode("Цвета");
		
		DefaultMutableTreeNode basic = new DefaultMutableTreeNode("Основные");
		DefaultMutableTreeNode extended = new DefaultMutableTreeNode("Дополнительные");
		
		root.add(basic);
		root.add(extended);
		
		for(int i = 0; i < basics.length; i++) {
			
			basic.add(new DefaultMutableTreeNode(basics[i]));
			extended.add(new DefaultMutableTreeNode(extendeds[i]));
		}
		
		return new DefaultTreeModel(root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				new TreeDefaultEditing();
			}
		});
	}

}
