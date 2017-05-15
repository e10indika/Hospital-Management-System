package se.ucsc.hsptl.assignment.gui;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDate;

import javax.swing.JFrame;

import se.ucsc.hsptl.assignment.data.ContactData;
import se.ucsc.hsptl.assignment.data.Name;
import se.ucsc.hsptl.assignment.data.PatientData;
import se.ucsc.hsptl.assignment.data.PersonData;
import se.ucsc.hsptl.assignment.data.UserLoginData;
import se.ucsc.hsptl.assignment.data.persistor.PatientDataPersistor;
import se.ucsc.hsptl.assignment.data.persistor.UserLoginDataPersistor;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;
import se.ucsc.hsptl.assignment.exception.PassWordServiceException;
import se.ucsc.hsptl.assignment.service.PassWordService;

/**
 * Created by Indika on 4/30/2017.
 */
public class PatientTestGUI
{
  PatientData patientData = new PatientData();

  public PatientTestGUI()
  {

  }

  public static void main(String[] args)
  {
    PatientTestGUI patientTestGUI = new PatientTestGUI();
    try
    {
      patientTestGUI.saveUser();
    }
    catch (PassWordServiceException e)
    {
      e.printStackTrace();
    }
    catch (DataPersistorException e)
    {
      e.printStackTrace();
    }

    JFrame frame = new JFrame("Test App");
    // frame.setContentPane(new App().getLoginPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void savePatient()
  {
    patientData.setName(new Name("indika", "saman", "kumara", "Mr."));
    patientData.setContactData(new ContactData("", "", null, null, null));
    patientData.setPersonData(new PersonData("male", null, null));

    try
    {
      PatientDataPersistor.getInstance().save(patientData);
    }
    catch (DataPersistorException e)
    {
      e.printStackTrace();
    }

  }

  public void saveUser() throws PassWordServiceException, DataPersistorException
  {
    UserLoginData userLoginData = new UserLoginData("indikas",
                                                    "1251",
                                                    "cambio123",
                                                    Date.valueOf(LocalDate.now(Clock.systemUTC())),
                                                    Date.valueOf(LocalDate.now(Clock.systemUTC())),
                                                    1);

    UserLoginDataPersistor.getInstance().save(userLoginData);
  }
}
