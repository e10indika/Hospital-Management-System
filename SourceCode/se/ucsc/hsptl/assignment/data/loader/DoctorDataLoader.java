package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.DoctorData;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 4/30/2017.
 */
public class DoctorDataLoader implements DataLoader<DoctorData>
{
  @Override
  public DoctorData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getDoctorDataResult(SQLToolKit.getWhereClause("doctorId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Doctor Data loading is failed", e);
    }
    return getDoctorData(resultSet).get(0);
  }

  @Override
  public List<DoctorData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getDoctorDataResult(SQLToolKit.getWhereClause("doctorId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Doctor Data loading is failed", e);
    }
    return getDoctorData(resultSet);
  }

  private List<DoctorData> getDoctorData(ResultSet resultSet) throws DataLoaderException
  {
    List<DoctorData> doctorDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        doctorDataList.add(getDoctorDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return doctorDataList;
  }

  private DoctorData getDoctorDataByRow(ResultSet resultSet)
  {
    return null;
  }

  private ResultSet getDoctorDataResult(String doctorId) throws DataLoaderException
  {
    return null;
  }
}
