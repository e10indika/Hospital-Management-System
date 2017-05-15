package se.ucsc.hsptl.assignment.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
  private JMenuBar menuBar;
  private JMenu mnFile;
  private JMenu mnDoctor;
  private JMenu mnNurse;
  private JMenuItem mnItmLogout;
  private JMenuItem mnItmExit;
  private JMenuItem mnItmAbout;
  private JMenuItem mnItmMyProfile;
  private JMenuItem mnItmPatients;

  public MainWindow()
  {
    jbInit();

  }

  private void jbInit()
  {
    createMenuBar();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void createMenuBar()
  {
    menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    mnFile = new JMenu("File");
    mnDoctor = new JMenu("Doctor");
    mnNurse = new JMenu("Nurse");

    menuBar.add(mnFile);
    menuBar.add(mnDoctor);
    menuBar.add(mnNurse);

    mnItmLogout = new JMenuItem("Log out");
    mnItmMyProfile = new JMenuItem("My Profile");
    mnItmAbout = new JMenuItem("About");
    mnItmExit = new JMenuItem("Exit");

    mnFile.add(mnItmLogout);
    mnFile.add(mnItmMyProfile);
    mnFile.add(mnItmAbout);
    mnFile.add(mnItmExit);

    mnItmPatients = new JMenuItem("Patient");

    mnDoctor.add(mnItmPatients);

  }
}
