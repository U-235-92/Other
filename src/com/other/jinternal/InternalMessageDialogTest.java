package com.other.jinternal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InternalMessageDialogTest {
  private final JDesktopPane desktop = new JDesktopPane();
  public JComponent makeUI() {
    JButton button = new JButton(new AbstractAction("open") {
      @Override public void actionPerformed(ActionEvent e) {
        JOptionPane.showInternalMessageDialog(
          desktop, "information", "modal",
          JOptionPane.INFORMATION_MESSAGE);
      }
    });
    JPanel panelMenu = new JPanel();
    panelMenu.setBackground(Color.YELLOW);
    panelMenu.add(button);
    panelMenu.setBounds(0, 0, 100, 100);

    JInternalFrame panelTable = new JInternalFrame("Table");
    panelTable.add(new JScrollPane(new JTable(30, 3)));
    panelTable.setBounds(100, 0, 200, 100);

    desktop.add(panelMenu);
    desktop.add(panelTable);
    panelMenu.setVisible(true);
    panelTable.setVisible(true);

    JPanel p = new JPanel(new BorderLayout());
    p.add(desktop);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new InternalMessageDialogTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}
