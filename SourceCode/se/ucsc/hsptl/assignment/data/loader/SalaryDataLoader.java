package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.SalaryData;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 4/30/2017.
 */
public class SalaryDataLoader implements DataLoader<SalaryData>
{
  @Override
  public SalaryData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getSalaryDataResult(SQLToolKit.getWhereClause("salaryId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Salary Data loading is failed", e);
    }
    return getSalaryData(resultSet).get(0);
  }

  @Override
  public List<SalaryData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getSalaryDataResult(SQLToolKit.getWhereClause("salaryId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Salary Data loading is failed", e);
    }
    return getSalaryData(resultSet);
  }

  private ResultSet getSalaryDataResult(String salaryId)
  {
    return null;
  }

  private List<SalaryData> getSalaryData(ResultSet resultSet) throws DataLoaderException
  {
    List<SalaryData> salaryDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        salaryDataList.add(getSalaryDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return salaryDataList;
  }

  private SalaryData getSalaryDataByRow(ResultSet resultSet)
  {
    return null;
  }
}
