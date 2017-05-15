package se.ucsc.hsptl.assignment.gui;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class UserRegistration extends JInternalFrame
{

  /**
   * Create the panel.
   */
  public UserRegistration()
  {

    super("User Registration", true, true, true, true);

    JSplitPane splitPane = new JSplitPane();
    add(splitPane);

    JPanel panel = new JPanel();
    splitPane.setLeftComponent(panel);

    JLabel lblNewLabel = new JLabel("New label");
    panel.add(lblNewLabel);

    JLabel lblNewLabel_1 = new JLabel("New label");
    panel.add(lblNewLabel_1);

    JLabel lblNewLabel_2 = new JLabel("New label");
    panel.add(lblNewLabel_2);

    JPanel panel_1 = new JPanel();
    splitPane.setRightComponent(panel_1);

  }

}
