package com.other.swing.menu;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class GoodMenu extends JFrame {

	public GoodMenu() {
		super("GoodMenu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createEditMenu());
		setJMenuBar(menuBar);
		setSize(300, 200);
		setVisible(true);
	}
	private JMenu createEditMenu() {
		JMenu edit = new JMenu("Правка");
		edit.setMnemonic('П');
		JMenuItem cut = new JMenuItem("Вырезать");
		cut.setMnemonic('В');
		cut.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
		JMenuItem copy = new JMenuItem("Копировать");
		copy.setMnemonic('К');
		copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		edit.add(cut);
		edit.add(copy);
		return edit;
	}
	private JMenu createFileMenu() {
		JMenu file = new JMenu("Файл");
		file.setMnemonic('Ф');
		JMenuItem open = new JMenuItem("Открыть");
		open.setMnemonic('О');
		open.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
		JMenuItem save = new JMenuItem("Сохранить");
		save.setMnemonic('С');
		save.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		file.add(open);
		file.add(save);
		return file;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			new GoodMenu();
		});
	}

}
