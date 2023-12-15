package com.other.swing.root;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class UsingDefaultTreeModel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9147670013959985733L;

	private String[] drinks = {"Коктейль", "Сок", "Морс"};
	private String[] fruits = {"Яблоки", "Апельсины"};
	
	public UsingDefaultTreeModel() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode root =new DefaultMutableTreeNode("Корень дерева");
		DefaultMutableTreeNode drink = new DefaultMutableTreeNode("Напитки");
		DefaultMutableTreeNode fruit = new DefaultMutableTreeNode("Фрукты");
		
		root.add(drink);
		root.add(fruit);
		
		root.add(new DefaultMutableTreeNode("Десерт", true));
		
		for(String _drink : drinks) {
			
			drink.add(new DefaultMutableTreeNode(_drink, false));
		}
		
		for(String _fruit : fruits) {
			
			fruit.add(new DefaultMutableTreeNode(_fruit, false));
		}
		
		DefaultTreeModel dtm1 = new DefaultTreeModel(root, true);
		JTree tree1 = new JTree(dtm1);
		
		DefaultTreeModel dtm2 = new DefaultTreeModel(drink, true);
		JTree tree2 = new JTree(dtm2);
		
		setLayout(new GridLayout(1, 2));
		add(new JScrollPane(tree1));
		add(new JScrollPane(tree2));
		setSize(400, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			
			new UsingDefaultTreeModel();
		});
	}

}
