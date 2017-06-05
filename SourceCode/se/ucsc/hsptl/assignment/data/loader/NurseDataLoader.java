package se.ucsc.hsptl.assignment.data.loader;

import se.ucsc.hsptl.assignment.data.NurseData;
import se.ucsc.hsptl.assignment.data.NurseData;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pathum on 4/30/2017.
 */
public class NurseDataLoader implements DataLoader<NurseData>
{
  @Override public NurseData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getNurseDataResult(SQLToolKit.getWhereClause("nurseId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Nurse Data loading is failed", e);
    }
    return getNurseData(resultSet).get(0);
  }

  @Override public List<NurseData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getNurseDataResult(SQLToolKit.getWhereClause("nurseId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Nurse Data loading is failed", e);
    }
    return getNurseData(resultSet);
  }

  private ResultSet getNurseDataResult(String nurseId)
  {
    return null;
  }

  private List<NurseData> getNurseData(ResultSet resultSet) throws DataLoaderException
  {
    List<NurseData> nurseDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        nurseDataList.add(getNurseDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return nurseDataList;
  }

  private NurseData getNurseDataByRow(ResultSet resultSet)
  {
    return null;
  }
}
