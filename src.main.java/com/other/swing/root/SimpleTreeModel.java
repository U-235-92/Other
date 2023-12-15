package com.other.swing.root;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class SimpleTreeModel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2919829041226439120L;

	public SimpleTreeModel()
	{
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTree tree = new JTree(new SimpleModel());
		
		add(new JScrollPane(tree));
		setSize(300, 200);
		setVisible(true);
	}
	
	class SimpleModel implements TreeModel {

		private String root = "Кое-что";
		
		private String colors = "Цвета";
		private String food = "Еда";
		
		private List<String> rootList = new ArrayList<>();
		private List<String> colorsList = new ArrayList<>();
		private List<String> foodList = new ArrayList<>();
		
		public SimpleModel() {
			
			rootList.add(colors);
			rootList.add(food);
			colorsList.add("Красный");
			colorsList.add("Зеленый");
			foodList.add("Мороженое");
			foodList.add("Бутерброд");
		}
		
		@Override
		public Object getRoot() {
			// TODO Auto-generated method stub
			return root;
		}

		@Override
		public Object getChild(Object parent, int index) {
			// TODO Auto-generated method stub
			if(parent == root) {
				
				return rootList.get(index);
			} else if(parent == colors) {
				
				return colorsList.get(index);
			} else if(parent == food) {
				
				return foodList.get(index);
			}
			
			return null;
		}

		@Override
		public int getChildCount(Object parent) {
			// TODO Auto-generated method stub
			if(parent == root) {
				
				return rootList.size();
			} else if(parent == colors) {
				
				return colorsList.size();
			} else if(parent == food) {
				
				return foodList.size();
			}
			
			return 0;
		}

		@Override
		public boolean isLeaf(Object node) {
			// TODO Auto-generated method stub
			if(colorsList.contains(node) || foodList.contains(node)) {
				
				return true;
			}
			return false;
		}

		@Override
		public void valueForPathChanged(TreePath path, Object newValue) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getIndexOfChild(Object parent, Object child) {
			// TODO Auto-generated method stub
			if(parent == root) {
				
				return rootList.indexOf(child);
			} else if(parent == colors) {
				
				return colorsList.indexOf(child);
			} else if(parent == food) {
				
				return foodList.indexOf(child);
			}
			return 0;
		}

		@Override
		public void addTreeModelListener(TreeModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTreeModelListener(TreeModelListener l) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			
			new SimpleTreeModel();
		});
	}

}
