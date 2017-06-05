package se.ucsc.hsptl.assignment.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.junit.Test;

import se.ucsc.hsptl.assignment.common.Gender;
import se.ucsc.hsptl.assignment.common.PersonTitle;
import se.ucsc.hsptl.assignment.data.ContactData;
import se.ucsc.hsptl.assignment.data.DoctorData;
import se.ucsc.hsptl.assignment.data.Name;
import se.ucsc.hsptl.assignment.data.PersonData;
import se.ucsc.hsptl.assignment.data.loader.DoctorDataLoader;
import se.ucsc.hsptl.assignment.data.persistor.DoctorDataPersistor;
import se.ucsc.hsptl.assignment.data.persistor.EmployeeDataPersistor;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 6/5/2017.
 */
public class DoctorTest
{
  @Test
  public void testSaveDoctor()
  {
    DoctorData doctorData = getDoctorData();

    try
    {
      EmployeeDataPersistor.getInstance().save(doctorData);
      DoctorDataPersistor.getInstance().save(doctorData);
    }
    catch (DataPersistorException e)
    {
      e.printStackTrace();
    }
  }

  @Test
  public void testDoctorLoadByID()
  {
    DoctorData doctorData = null;
    try
    {
      doctorData = DoctorDataLoader.getINSTANCE().loadById("12345");
    }
    catch (DataLoaderException e)
    {
      e.printStackTrace();
    }
    assertNotNull(doctorData);
    assertEquals("12345", doctorData.getDoctorId());
    assertEquals("Indika", doctorData.getName().getFirstName());
  }

  @Test
  public void testUpdate()
  {
    DoctorData doctorData = getDoctorData();
    doctorData.getName().setFirstName("Prasad");
    try
    {
      DoctorDataPersistor.getInstance().update(doctorData);
    }
    catch (DataPersistorException e)
    {
      e.printStackTrace();
    }
  }

  private DoctorData getDoctorData()
  {
    Name name = new Name("Indika", "Saman", "Kumara", PersonTitle.MR.getTitle());
    PersonData personData = new PersonData(String.valueOf(Gender.MALE.getChar()), new java.util.Date(), "Sinhalese");
    ContactData contactData = new ContactData("mobile", "home", "office", new String[] {}, "email@email");

    return new DoctorData("12345", "consultant", name, contactData, personData, "emp123");
  }
}
