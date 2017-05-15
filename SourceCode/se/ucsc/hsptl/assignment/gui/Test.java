package se.ucsc.hsptl.assignment.gui;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class Test
{

  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    MainWindow mainWindow = new MainWindow();
    JDesktopPane desktopPane = new JDesktopPane();
    UserRegistration registration = new UserRegistration();

    desktopPane.add(registration);
    registration.setBounds(25, 25, 200, 100);
    registration.setVisible(true);

    /*
     * mainWindow.add(desktopPane);
     * 
     * mainWindow.setVisible(true);
     */

    mainWindow.add(desktopPane, BorderLayout.CENTER);
    mainWindow.setSize(500, 300);
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setVisible(true);

    /*
     * JFrame frame = new JFrame(); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * 
     * JDesktopPane desktop = new JDesktopPane(); JInternalFrame internalFrame = new JInternalFrame("Can Do All", true,
     * true, true, true);
     * 
     * desktop.add(internalFrame);
     * 
     * internalFrame.setBounds(25, 25, 200, 100);
     * 
     * JLabel label = new JLabel(internalFrame.getTitle(), JLabel.CENTER); internalFrame.add(label,
     * BorderLayout.CENTER);
     * 
     * internalFrame.setVisible(true);
     * 
     * frame.add(desktop, BorderLayout.CENTER); frame.setSize(500, 300); frame.setVisible(true);
     */
  }

  /**
   * Create the frame.
   */
  public Test()
  {

  }
}
