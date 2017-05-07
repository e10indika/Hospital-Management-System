package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.SalaryData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public class SalaryDataPersistor implements DataPersistor<SalaryData>
{
  @Override
  public void save(SalaryData salaryData) throws DataPersistorException
  {

  }

  @Override
  public int saveAndGet(SalaryData salaryData) throws DataPersistorException
  {
    return 0;
  }

  @Override
  public String update(SalaryData salaryData) throws DataPersistorException
  {
    return null;
  }
}
