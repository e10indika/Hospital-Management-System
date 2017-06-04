package se.ucsc.hsptl.assignment.db;

import static se.ucsc.hsptl.assignment.db.SQLConstants.AND;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import se.ucsc.hsptl.assignment.common.CommonToolkit;
import se.ucsc.hsptl.assignment.exception.DataBaseException;

/**
 * Created by Indika on 4/29/2017.
 */
public class SelectQuery extends AbstractQuery
{

  public ResultSet executeQuery(String area, String[] fields, String condition) throws DataBaseException
  {
    String sqlQuery = createSqlQuery(area, fields, condition);
    PreparedStatement statement = createPrepareStatement(sqlQuery);
    return executeQuery(statement);
  }

  @Override
  public int executeQuery(String area, String[] fields, String valueString, String condition) throws DataBaseException
  {
    throw new DataBaseException("Method is not implemented");
  }

  @Override
  public int executeQuery(String area, String[] fields, String[] values, String condition) throws DataBaseException
  {
    throw new DataBaseException("Method is not implemented");
  }

  private String createSqlQuery(String area, String[] fields, String condition)
  {
    StringBuffer stringBuffer = new StringBuffer("Select ");
    stringBuffer.append(getFieldsAsString(fields)).append(" FROM ").append(area.trim()).append(SPACE).append(WHERE)
      .append(condition).append(AND).append("latest ='").append(CommonToolkit.isLatest(true)).append("'");
    return stringBuffer.toString();
  }

}
