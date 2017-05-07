package se.ucsc.hsptl.assignment.db.dto;

/**
 * Created by Indika on 5/7/2017.
 */
public class UserLoginDTO
{
  private static final String[] FIELDS =
    new String[] { "primaryKey", "userId", "employeeId", "password", "lastLoginTime", "lastLogoutTime", "latest" };
  private static final String[] FIELDS_TO_INSERT =
    new String[] { "userId", "employeeId", "password", "lastLoginTime", "lastLogoutTime", "latest" };

  public static String[] getTableFields()
  {
    return FIELDS;
  }

  public static String[] getTableFieldsToInsert()
  {
    return FIELDS_TO_INSERT;
  }
}
