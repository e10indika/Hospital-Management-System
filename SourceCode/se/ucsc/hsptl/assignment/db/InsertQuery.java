package se.ucsc.hsptl.assignment.db;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Indika on 4/29/2017.
 */
public class InsertQuery extends AbstractQuery
{
  @Override
  public ResultSet executeQuery(String area, String[] fields, String condition)
    throws DataBaseException
  {
    String sqlQuery = createSqlQuery(area, fields, String.valueOf(condition));
    PreparedStatement statement = createPrepareStatement(sqlQuery);
    return executePrepareStatement(statement);
  }

  @Override
  public ResultSet executeQuery(String area, String[] fields, String valueString, String condition)
    throws DataBaseException
  {
    String sqlQuery = createSqlQuery(area, fields, valueString);
    PreparedStatement statement = createPrepareStatement(sqlQuery);
    return executePrepareStatement(statement);
  }

  private String createSqlQuery(String area, String[] fields, String values)
  {
    StringBuffer stringBuffer = new StringBuffer("INSERT INTO ");
    stringBuffer.append(area.trim()).append(SPACE).append(LEFT_PARENTHESIS).append(getFieldsAsString(fields))
      .append(RIGHT_PARENTHESIS).append(" VALUES ").append(LEFT_PARENTHESIS).append(values).append(RIGHT_PARENTHESIS).append(SPACE);
    return stringBuffer.toString();
  }
}
