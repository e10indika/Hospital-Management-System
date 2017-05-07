package se.ucsc.hsptl.assignment.db;

import java.sql.ResultSet;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

/**
 * Created by Indika on 4/29/2017.
 */
public class DataBaseService
{
  public static ResultSet executeQuery(String area, String[] fields, String condition, DataBaseQueryType dataBaseQueryType)
    throws DataBaseException
  {
    return dataBaseQueryType.getQueryInstance().executeQuery(area, fields, condition);
    /*
     * PreparedStatement statement = createPrepareStatement(sql);
     * 
     * statement.executeQuery();
     */
  }

  public static int executeQuery(String area,
                                 String[] fields,
                                 String valueString,
                                 String condition,
                                 DataBaseQueryType dataBaseQueryType)
    throws DataBaseException
  {
    return dataBaseQueryType.getQueryInstance().executeQuery(area, fields, valueString, condition);
  }
}
