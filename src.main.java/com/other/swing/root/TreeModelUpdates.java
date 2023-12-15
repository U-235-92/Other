package com.other.swing.root;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreeModelUpdates extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8429519479656632309L;
	
	private JTree tree;
	
	private DefaultTreeModel model;
	
	public TreeModelUpdates() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tree = new JTree(model = createTreeModel());
		
		add(new JScrollPane(tree));
		setSize(400, 300);
		setVisible(true);
	}
	
	private DefaultTreeModel createTreeModel() {
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Big tree");
		
		for(int i =0; i < 100;i++) {
			
			DefaultMutableTreeNode node = new ChangeableColorNode();
			
			root.add(node);
			
			for(int k = 0; k < 10; k++) {
				
				node.add(new ChangeableColorNode());
			}
		}
		
		return new DefaultTreeModel(root);
	}
	
	class ChangeableColorNode extends DefaultMutableTreeNode implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 76293552273577354L;

		private int delay = (int) (Math.random() * 3000 + 500);
		
		private int r, g, b;
		
		public ChangeableColorNode() {
			
			generateColors();
			new Timer(delay, this).start();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			generateColors();
			
			TreePath path = new TreePath(model.getPathToRoot(this));
			
			if(tree.isVisible(path)) {
				
				model.nodeChanged(this);
			}
		}
		
		public void generateColors() {
			
			r = (int) (Math.random() * 255);
			g = (int) (Math.random() * 255);
			b = (int) (Math.random() * 255);
			
			setUserObject("<html><font color = rgb("+r+", "+g+","+b+")>Какой-то цвет!");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new  Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new TreeModelUpdates();
			}
		});
	}

}
