package se.ucsc.hsptl.assignment.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

/**
 * Created by Indika on 4/29/2017.
 */
public class DeleteQuery extends AbstractQuery
{
  @Override
  public ResultSet executeQuery(String area, String[] fields, String sql) throws DataBaseException
  {
    String query = createSqlQuery(area, sql);
    PreparedStatement statement = createPrepareStatement(query);
    executeUpdate(statement);

    return null;
  }

  @Override
  public int executeQuery(String area, String[] fields, String value, String condition) throws DataBaseException
  {
    throw new DataBaseException("Method is not implemented");
  }

  private String createSqlQuery(String area, String condition)
  {
    StringBuffer stringBuffer = new StringBuffer("DELETE From ");
    stringBuffer.append(area.trim()).append(SPACE).append(WHERE).append(condition);
    return stringBuffer.toString();
  }
}
