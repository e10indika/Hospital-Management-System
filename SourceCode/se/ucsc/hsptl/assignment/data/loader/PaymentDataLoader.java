package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.PaymentData;
import se.ucsc.hsptl.assignment.data.PaymentData;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 4/30/2017.
 */
public class PaymentDataLoader implements DataLoader<PaymentData>
{
  @Override
  public PaymentData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getPaymentDataResult(SQLToolKit.getWhereClause("paymentId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Payment Data loading is failed", e);
    }
    return getPaymentData(resultSet).get(0);
  }

  @Override
  public List<PaymentData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getPaymentDataResult(SQLToolKit.getWhereClause("paymentId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Payment Data loading is failed", e);
    }
    return getPaymentData(resultSet);
  }

  private ResultSet getPaymentDataResult(String paymentId)
  {
    return null;
  }

  private List<PaymentData> getPaymentData(ResultSet resultSet) throws DataLoaderException
  {
    List<PaymentData> paymentDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        paymentDataList.add(getPaymentDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return paymentDataList;
  }

  private PaymentData getPaymentDataByRow(ResultSet resultSet)
  {
    return null;
  }
}
