package se.ucsc.hsptl.assignment.db.dto;

import com.google.common.collect.ObjectArrays;

/**
 * Created by Pathum on 4/30/2017.
 */
public class EmployeeDTO
{
  private static String[] FIELDS =
    new String[] { "employeeId", "firstName", "middleName", "lastName", "title", "birthDate", "address1", "address2",
                   "address3", "mobileNumber", "homePhone", "email", "gender", "nationality", "lastModifiedDate",
                   "latest" };

  public static String[] getTableFields()
  {
    return FIELDS;
  }

  public static String[] getTableAllFields()
  {
    return ObjectArrays.concat("primaryKey", FIELDS);
  }
}
