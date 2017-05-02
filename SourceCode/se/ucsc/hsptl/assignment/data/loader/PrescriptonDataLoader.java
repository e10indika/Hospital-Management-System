package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.PrescriptionData;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 4/30/2017.
 */
public class PrescriptonDataLoader implements DataLoader<PrescriptionData>
{
  @Override
  public PrescriptionData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getPrescriptionDataResult(SQLToolKit.getWhereClause("prescriptionId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Prescription Data loading is failed", e);
    }
    return getPrescriptionData(resultSet).get(0);
  }

  @Override
  public List<PrescriptionData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getPrescriptionDataResult(SQLToolKit.getWhereClause("prescriptionId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Prescription Data loading is failed", e);
    }
    return getPrescriptionData(resultSet);
  }

  private ResultSet getPrescriptionDataResult(String prescriptionId)
  {
    return null;
  }

  private List<PrescriptionData> getPrescriptionData(ResultSet resultSet) throws DataLoaderException
  {
    List<PrescriptionData> prescriptionDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        prescriptionDataList.add(getPrescriptionDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return prescriptionDataList;
  }

  private PrescriptionData getPrescriptionDataByRow(ResultSet resultSet)
  {
    return null;
  }
}
