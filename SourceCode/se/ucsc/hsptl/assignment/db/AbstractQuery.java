package se.ucsc.hsptl.assignment.db;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Indika on 4/29/2017.
 */
public abstract class AbstractQuery implements Query
{
  protected static final char SPACE = ' ';

  protected static final String WHERE = " where ";

  protected static final String COMMA_SPACE = ", ";

  protected static final char LEFT_PARENTHESIS = '(';

  protected static final char RIGHT_PARENTHESIS = ')';

  public PreparedStatement createPrepareStatement(String query) throws DataBaseException
  {
    Connection connection = DataBaseConnectionService.getConnection();
    try
    {
      return connection.prepareStatement(query);
    }
    catch (SQLException e)
    {
      throw new DataBaseException("Prepare Statement is failed");
    }
  }

  protected String getFieldsAsString(String[] fields)
  {
    StringBuffer stringBuffer = new StringBuffer();
    for (String field : fields)
    {
      stringBuffer.append(field).append(COMMA_SPACE);
    }
    return stringBuffer.toString().trim().substring(0, stringBuffer.toString().trim().length() - 1);
  }

  protected ResultSet executeQuery(PreparedStatement statement) throws DataBaseException
  {
    try
    {
      return statement.executeQuery();
    }
    catch (SQLException e)
    {
      throw new DataBaseException("Query executing is failed", e);
    }
  }

  protected int executeUpdate(PreparedStatement statement) throws DataBaseException
  {
    try
    {
      return statement.executeUpdate();
    }
    catch (SQLException e)
    {
      throw new DataBaseException("Query executing is failed", e);
    }
  }
}
