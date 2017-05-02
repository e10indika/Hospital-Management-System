package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.DrugData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public class DrugDataPersistor implements DataPersistor<DrugData>
{
  @Override
  public void save(DrugData drugData) throws DataPersistorException
  {

  }

  @Override
  public String saveAndGet(DrugData drugData) throws DataPersistorException
  {
    return null;
  }

  @Override
  public String update(DrugData drugData) throws DataPersistorException
  {
    return null;
  }
}
