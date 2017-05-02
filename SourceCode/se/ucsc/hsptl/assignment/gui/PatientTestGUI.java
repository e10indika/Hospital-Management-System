package se.ucsc.hsptl.assignment.gui;

import se.ucsc.hsptl.assignment.data.ContactData;
import se.ucsc.hsptl.assignment.data.Name;
import se.ucsc.hsptl.assignment.data.PatientData;
import se.ucsc.hsptl.assignment.data.PersonData;
import se.ucsc.hsptl.assignment.data.persistor.PatientDataPersistor;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

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
    patientTestGUI.savePatient();
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
}
