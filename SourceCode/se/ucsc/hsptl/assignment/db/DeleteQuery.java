package se.ucsc.hsptl.assignment.db;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

import java.sql.ResultSet;

/**
 * Created by Indika on 4/29/2017.
 */
public class DeleteQuery extends AbstractQuery
{
  @Override
  public ResultSet executeQuery(String area, String[] fields, String sql) throws DataBaseException
  {
    String query = createSqlQuery(area, sql);
    return null;
  }

  @Override public ResultSet executeQuery(String area, String[] fields, String value, String condition)
    throws DataBaseException
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
