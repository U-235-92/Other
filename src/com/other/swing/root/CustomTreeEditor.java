package com.other.swing.root;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeModel;

public class CustomTreeEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4538383625455676890L;
	
	public CustomTreeEditor() {
		
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTree tree = new JTree(createTreeModel());
		
		tree.setEditable(true);
		
		DefaultTreeCellRenderer renferer = new DefaultTreeCellRenderer();
		
		DefaultTreeCellEditor editor= new DefaultTreeCellEditor(tree, renferer, new MaskTreeEditor(tree));
		
		tree.setCellEditor(editor);
		
		add(new JScrollPane(tree));
		setSize(400,300);
		setVisible(true);
	}
	
	private String[] phoneDirectory = {"123-13-13", "444-23-45", "111-55-67"};
	
	private TreeModel createTreeModel() {
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Компания");
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Отдел кадров");
		
		root.add(node);
		
		for(String phone : phoneDirectory) {
			
			node.add(new DefaultMutableTreeNode(phone));
			
		}
		
		return new DefaultTreeModel(root);
	}
	
	class MaskTreeEditor extends AbstractCellEditor implements TreeCellEditor {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5304513265582381955L;
		
		private JTree tree;
		
		private JFormattedTextField editor;
		
		public MaskTreeEditor(JTree tree) {
			
			this.tree = tree;
			
			try {
				
				MaskFormatter phone = new MaskFormatter("###-##-##");
				
				editor = new JFormattedTextField(phone);
			} catch(Exception e) {
				
				e.printStackTrace();
			}
			
			editor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					stopCellEditing();
				}
			});
		}
		
		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return editor.getText();
		}

		@Override
		public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
				boolean leaf, int row) {
			// TODO Auto-generated method stub
			editor.setText(value.toString());
			
			return editor;
		}
		
		@Override
		public boolean isCellEditable(EventObject e) {
			// TODO Auto-generated method stub
			MutableTreeNode node = (MutableTreeNode) tree.getLastSelectedPathComponent();
			return ((node != null) && (node.isLeaf()));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomTreeEditor();
	}

}
