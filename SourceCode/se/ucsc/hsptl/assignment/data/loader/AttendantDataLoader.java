package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.AttendantData;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 4/30/2017.
 */
public class AttendantDataLoader implements DataLoader<AttendantData>
{
  @Override
  public AttendantData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getAttendantDataResult(SQLToolKit.getWhereClause("attendantId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Attendant Data loading is failed", e);
    }
    return getAttendantData(resultSet).get(0);
  }

  @Override
  public List<AttendantData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getAttendantDataResult(SQLToolKit.getWhereClause("attendantId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Attendant Data loading is failed", e);
    }
    return getAttendantData(resultSet);
  }

  private List<AttendantData> getAttendantData(ResultSet resultSet) throws DataLoaderException
  {
    List<AttendantData> attendantDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        attendantDataList.add(getAttendantDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return attendantDataList;
  }

  private AttendantData getAttendantDataByRow(ResultSet resultSet)
  {
    return null;
  }

  private ResultSet getAttendantDataResult(String attendantId)
  {
    return null;
  }
}
