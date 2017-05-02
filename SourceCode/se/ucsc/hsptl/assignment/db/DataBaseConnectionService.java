package se.ucsc.hsptl.assignment.db;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Indika on 4/28/2017.
 */
public class DataBaseConnectionService
{
  private static Connection conn = null;

  public static Connection createConnection() throws DataBaseException
  {
    try
    {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "admin", "admin");
    }
    catch (SQLException e)
    {
      throw new DataBaseException("Database connection failed", e);
    }

    if (conn != null)
    {
      System.out.println("Connected");
    }

    return conn;
  }

  public static Connection getConnection() throws DataBaseException
  {
    if (conn == null)
    {
      createConnection();
    }
    return conn;
  }
}
