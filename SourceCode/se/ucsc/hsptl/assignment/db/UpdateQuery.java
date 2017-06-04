package se.ucsc.hsptl.assignment.db;

import static se.ucsc.hsptl.assignment.db.SQLConstants.EQUAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

/**
 * Created by Indika on 4/29/2017.
 */
public class UpdateQuery extends AbstractQuery
{
  public ResultSet executeQuery(String area, String[] fields, String condition)
  {
    return null;
  }

  @Override
  public int executeQuery(String area, String[] fields, String value, String condition) throws DataBaseException
  {
    /*
     * String sqlQuery = createSqlQuery(area, fields, String.valueOf(value), condition); PreparedStatement statement =
     * createPrepareStatement(sqlQuery); return executeUpdate(statement);
     */
    throw new DataBaseException("this is not implemented");
  }

  @Override
  public int executeQuery(String area, String[] fields, String[] values, String condition) throws DataBaseException
  {
    String sqlQuery = createSqlQuery(area, fields, values, condition);
    PreparedStatement statement = createPrepareStatement(sqlQuery);
    return executeUpdate(statement);
  }

  private String createSqlQuery(String area, String[] fields, String[] values, String condition)
    throws DataBaseException
  {
    StringBuffer stringBuffer = new StringBuffer("UPDATE ");
    stringBuffer.append(area.trim()).append(SPACE).append("SET ").append(getUpdatedValueString(fields, values))
      .append(SPACE).append("WHERE").append(SPACE).append(condition);
    return stringBuffer.toString();
  }

  private String getUpdatedValueString(String[] fields, String[] values) throws DataBaseException
  {
    if (!validate(fields, values))
    {
      throw new DataBaseException("fields and values are not matched");
    }

    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < fields.length; i++)
    {
      stringBuffer.append(fields[i]).append(EQUAL).append(values[i]);
    }

    return stringBuffer.substring(0, stringBuffer.lastIndexOf(","));
  }

  private boolean validate(String[] fields, String[] values)
  {
    return fields.length == values.length;
  }
}
