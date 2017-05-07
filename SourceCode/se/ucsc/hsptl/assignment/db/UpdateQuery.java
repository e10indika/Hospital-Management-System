package se.ucsc.hsptl.assignment.db;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    String sqlQuery = createSqlQuery(area, fields, String.valueOf(value));
    PreparedStatement statement = createPrepareStatement(sqlQuery);
    return executeUpdate(statement);
  }

  private String createSqlQuery(String area, String[] fields, String values)
  {
    StringBuffer stringBuffer = new StringBuffer("UPDATE ");
    stringBuffer.append(area.trim()).append(SPACE).append(LEFT_PARENTHESIS).append(getFieldsAsString(fields))
      .append(RIGHT_PARENTHESIS).append("VALUES").append(LEFT_PARENTHESIS).append(values).append(RIGHT_PARENTHESIS);
    return stringBuffer.toString();
  }
}
