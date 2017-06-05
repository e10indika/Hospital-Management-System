package se.ucsc.hsptl.assignment.db.dto;

import com.google.common.collect.ObjectArrays;

/**
 * Created by Pathum on 4/30/2017.
 */
public class PatientDTO
{
  private static String[] FIELDS =
    new String[] { "patientId", "firstName", "middleName", "lastName", "title", "birthDate", "bloodgroup", "address",
                   "contactNumber", "gender", "lastModifiedDate", "latest" };

  public static String[] getTableFields()
  {
    return FIELDS;
  }

  public static String[] getTableAllFields()
  {
    return ObjectArrays.concat("primaryKey", FIELDS);
  }
}
