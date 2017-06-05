package se.ucsc.hsptl.assignment.db;

import static se.ucsc.hsptl.assignment.db.SQLConstants.AND;
import static se.ucsc.hsptl.assignment.db.SQLConstants.COMMA;
import static se.ucsc.hsptl.assignment.db.SQLConstants.EQUAL;
import static se.ucsc.hsptl.assignment.db.SQLConstants.IN;

import java.util.List;
import java.util.Map;
import java.util.Set;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

/**
 * Created by Pathum on 4/29/2017.
 */
public class SQLToolKit
{
  public static String getWhereClause(String field, String conditionValue) throws DataBaseException
  {
    return createWhereClause(field, conditionValue);
  }

  public static String getWhereClause(String field, List<String> conditionValues) throws DataBaseException
  {
    return createWhereClause(field, conditionValues);
  }

  public static String getWhereClause(String[] fields, String[] conditionValues) throws DataBaseException
  {
    if (validate(fields, conditionValues))
    {
      StringBuffer stringBuffer = new StringBuffer();
      for (int i = 0; i < fields.length; i++)
      {
        if (i != 0)
        {
          stringBuffer.append(AND);
        }
        stringBuffer = stringBuffer.append(getWhereClause(fields[i], conditionValues[i]));
      }
      return stringBuffer.toString();
    }
    throw new DataBaseException("Where clause creating process failed.");
  }

  public static String getWhereClause(Map<String, String> mapElements) throws DataBaseException
  {
    if (!mapElements.isEmpty())
    {
      StringBuffer stringBuffer = new StringBuffer();
      Set<String> fields = mapElements.keySet();
      for (String field : fields)
      {
        if (stringBuffer.length() > 0)
        {
          stringBuffer.append(AND);
        }
        stringBuffer.append(createWhereClause(field, mapElements.get(field)));
      }
      return stringBuffer.toString();
    }
    throw new DataBaseException("Where clause creation failed");
  }

  private static boolean validate(String[] fields, String[] conditionValues) throws DataBaseException
  {
    if (fields != null && conditionValues != null && fields.length == conditionValues.length)
    {
      return true;
    }
    throw new DataBaseException("fields and conditionValues are can be " +
                                "null or values are not match with field length");
  }

  private static String createWhereClause(String field, String conditionValue) throws DataBaseException
  {
    if (validate(field) && validate(conditionValue))
    {
      return new StringBuffer(field.trim()).append(EQUAL).append("'" + conditionValue.trim() + "'").toString();
    }
    throw new DataBaseException("Where clause creation process failed");
  }

  private static String createWhereClause(String field, List<String> conditionValues) throws DataBaseException
  {
    if (validate(field) && !conditionValues.isEmpty())
    {
      return new StringBuffer(field.trim()).append(IN).append(getListAsString(conditionValues)).toString();
    }
    throw new DataBaseException("Where clause creation process failed");
  }

  private static String getListAsString(List<String> conditionValues)
  {
    StringBuffer stringBuffer = new StringBuffer().append(" (");
    for (String value : conditionValues)
    {
      stringBuffer.append(value).append(", ");
    }
    return stringBuffer.substring(0, stringBuffer.lastIndexOf(String.valueOf(COMMA))).concat(")");
  }

  private static boolean validate(String value) throws DataBaseException
  {
    if (value != null && !value.trim().isEmpty())
    {
      return true;
    }
    throw new DataBaseException("Invalid field/value");
  }
}
