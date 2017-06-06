package se.ucsc.hsptl.assignment.db.dto;

import com.google.common.collect.ObjectArrays;

/**
 * Created by Pathum on 4/30/2017.
 */
public class DoctorDTO
{
  private static final String[] FIELDS =
    new String[] { "doctorId", "designation", "employeeId", "lastModifiedDate", "latest" };

  public static String[] getTableFields()
  {
    return FIELDS;
  }

  public static String[] getTableAllFields()
  {
    return ObjectArrays.concat("primaryKey", FIELDS);
  }
}
