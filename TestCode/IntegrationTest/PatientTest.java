package IntegrationTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.junit.Test;

import se.ucsc.hsptl.assignment.common.Gender;
import se.ucsc.hsptl.assignment.common.PersonTitle;
import se.ucsc.hsptl.assignment.data.ContactData;
import se.ucsc.hsptl.assignment.data.Name;
import se.ucsc.hsptl.assignment.data.PatientData;
import se.ucsc.hsptl.assignment.data.PersonData;
import se.ucsc.hsptl.assignment.data.loader.PatientDataLoader;
import se.ucsc.hsptl.assignment.data.persistor.PatientDataPersistor;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 6/4/2017.
 */
public class PatientTest
{
  @Test
  public void testPatientSave()
  {
    Name name = new Name("Indika", "Saman", "Kumara", PersonTitle.MR.getTitle());
    PersonData personData = new PersonData(String.valueOf(Gender.MALE.getChar()), new java.util.Date(), "Sinhalese");
    ContactData contactData = new ContactData("mobile", "home", "office", new String[] {}, "email@email");

    PatientData patientData = new PatientData("1", personData, name, contactData);

    try
    {
      PatientDataPersistor.getInstance().save(patientData);
    }
    catch (DataPersistorException e)
    {
      e.printStackTrace();
    }

    PatientData getPatientData = null;
    try
    {
      getPatientData = PatientDataLoader.getInstance().loadById("1");
    }
    catch (DataLoaderException e)
    {
      e.printStackTrace();
    }
    assertNotNull(getPatientData);
    assertEquals("1", getPatientData.getPatientId());
    assertEquals("Mr. KUMARA I. S.", getPatientData.getName().getPresentationName());

  }
}
