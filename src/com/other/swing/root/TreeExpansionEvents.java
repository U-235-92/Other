package com.other.swing.root;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeModel;

public class TreeExpansionEvents extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 597219771919300255L;
	
	public TreeExpansionEvents() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTree tree = new JTree(createTreeModel());
		
		TreeListener listener = new TreeListener();
		
		tree.addTreeExpansionListener(listener);
		tree.addTreeWillExpandListener(listener);
		
		add(new JScrollPane(tree));
		setSize(400, 300);
		setVisible(true);
	}
	
	private String[] langs = {"Java", "Scala", "Ruby"};
	
	private String[] ides = {"IDEA", "Eclipse", "NetBeans"};
	
	private TreeModel createTreeModel() {
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("—оздание кода");
		
		DefaultMutableTreeNode lang = new DefaultMutableTreeNode("языки");
		
		DefaultMutableTreeNode ide = new DefaultMutableTreeNode("—реды");
		
		root.add(lang);
		root.add(ide);
		
		for(int i= 0; i< langs.length;i++) {
			
			lang.add(new DefaultMutableTreeNode(langs[i]));
			ide.add(new DefaultMutableTreeNode(ides[i]));
		}
		
		return new DefaultTreeModel(root);
	}

	class TreeListener implements TreeExpansionListener, TreeWillExpandListener {

		@Override
		public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
			// TODO Auto-generated method stub
			if(event.getPath().getLastPathComponent().toString().equals("языки")) {
				
				throw new ExpandVetoException(event);
			}
		}

		@Override
		public void treeExpanded(TreeExpansionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("”зел развернут: " + event.getPath());
		}

		@Override
		public void treeCollapsed(TreeExpansionEvent event) {
			// TODO Auto-generated method stub
			System.out.println("”зел свернут: " + event.getPath());
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			
			new TreeExpansionEvents();
		});
	}

}
