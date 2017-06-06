package se.ucsc.hsptl.assignment.db.dto;

import com.google.common.collect.ObjectArrays;

/**
 * Created by Pathum on 5/7/2017.
 */
public class UserLoginDTO
{
  private static final String[] FIELDS =
    new String[] { "userId", "employeeId", "password", "lastLoginTime", "lastLogoutTime", "latest" };

  public static String[] getTableFields()
  {
    return FIELDS;
  }

  public static String[] getTableAllFields()
  {
    return ObjectArrays.concat("primaryKey", FIELDS);
  }
}
