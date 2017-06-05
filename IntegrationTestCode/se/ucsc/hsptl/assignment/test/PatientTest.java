package se.ucsc.hsptl.assignment.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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
 * Created by Pathum on 6/4/2017.
 */
public class PatientTest
{
  @Test
  public void testPatientSave()
  {
    PatientData patientData = getPatientData();

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
    assertEquals("Mr. KUMARA P. S.", getPatientData.getName().getPresentationName());

    List<PatientData> getPatientDatas = null;
    try
    {
      List<String> ids = new ArrayList<>();
      ids.add("1");
      ids.add("2");
      getPatientDatas = PatientDataLoader.getInstance().loadByIds(ids);
    }
    catch (DataLoaderException e)
    {
      e.printStackTrace();
    }
    assertNotNull(getPatientDatas);
    assertEquals(2, getPatientDatas.size());
    assertEquals("1", getPatientDatas.get(0).getPatientId());
    assertEquals("Mr. KUMARA P. S.", getPatientDatas.get(0).getName().getPresentationName());
    assertEquals("2", getPatientDatas.get(1).getPatientId());
    assertEquals("Mr. KUMARA P. S.", getPatientDatas.get(1).getName().getPresentationName());

  }

  @Test
  public void testPatientUpdate()
  {
    PatientData patientData = getPatientData();
    patientData.setName(patientData.getName().setFirstName("Prasad"));

    try
    {
      PatientDataPersistor.getInstance().update(patientData);
    }
    catch (DataPersistorException e)
    {
      e.printStackTrace();
    }

  }

  private PatientData getPatientData()
  {
    Name name = new Name("Indika", "Saman", "Kumara", PersonTitle.MR.getTitle());
    PersonData personData = new PersonData(String.valueOf(Gender.MALE.getChar()), new java.util.Date(), "Sinhalese");
    ContactData contactData = new ContactData("mobile", "home", "office", new String[] {}, "email@email");

    return new PatientData("1", personData, name, contactData);
  }
}
