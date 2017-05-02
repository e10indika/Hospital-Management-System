package se.ucsc.hsptl.assignment.db;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Indika on 4/29/2017.
 */
public class SelectQuery extends AbstractQuery
{

  public ResultSet executeQuery(String area, String[] fields, String condition) throws DataBaseException
  {
    String sqlQuery = createSqlQuery(area, fields, condition);
    PreparedStatement statement = createPrepareStatement(sqlQuery);
    return executePrepareStatement(statement);
  }

  @Override
  public ResultSet executeQuery(String area, String[] fields, String valueString, String condition) throws DataBaseException
  {
    throw new DataBaseException("Method is not implemented");
  }

  private String createSqlQuery(String area, String[] fields, String condition)
  {
    StringBuffer stringBuffer = new StringBuffer("Select From ");
    stringBuffer.append(area.trim()).append(SPACE).append(getFieldsAsString(fields)).append(WHERE).append(condition);
    return stringBuffer.toString();
  }

}
