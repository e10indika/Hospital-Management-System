package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.DrugData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Pathum on 4/30/2017.
 */
public class DrugDataPersistor implements DataPersistor<DrugData>
{
  @Override
  public void save(DrugData drugData) throws DataPersistorException
  {

  }

  @Override
  public int saveAndGet(DrugData drugData) throws DataPersistorException
  {
    return 0;
  }

  @Override
  public String update(DrugData drugData) throws DataPersistorException
  {
    return null;
  }
}
