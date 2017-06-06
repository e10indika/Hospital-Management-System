package se.ucsc.hsptl.assignment.data.loader;

import se.ucsc.hsptl.assignment.data.DrugData;
import se.ucsc.hsptl.assignment.data.DrugData;
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
public class DrugDataLoader implements DataLoader<DrugData>
{
  @Override public DrugData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getDrugDataResult(SQLToolKit.getWhereClause("drugId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Drug Data loading is failed", e);
    }
    return getDrugData(resultSet).get(0);
  }

  @Override public List<DrugData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getDrugDataResult(SQLToolKit.getWhereClause("drugId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Drug Data loading is failed", e);
    }
    return getDrugData(resultSet);
  }

  private ResultSet getDrugDataResult(String drugId)
  {
    return null;
  }

  private List<DrugData> getDrugData(ResultSet resultSet) throws DataLoaderException
  {
    List<DrugData> drugDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        drugDataList.add(getDrugDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return drugDataList;
  }

  private DrugData getDrugDataByRow(ResultSet resultSet)
  {
    return null;
  }
}
