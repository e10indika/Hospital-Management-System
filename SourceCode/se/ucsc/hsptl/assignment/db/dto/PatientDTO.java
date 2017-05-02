package se.ucsc.hsptl.assignment.db.dto;

/**
 * Created by Indika on 4/30/2017.
 */
public class PatientDTO
{
  private static String[] FIELDS =
    new String[] { "primaryKey", "patientId", "fName", "mName", "lName", "mobilePhone", "homePhone" };

  public static String[] getPatientTableFields()
  {
    return FIELDS;
  }
}
