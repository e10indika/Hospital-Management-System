package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.NurseData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Pathum on 4/30/2017.
 */
public class NurseDataPersistor implements DataPersistor<NurseData>
{
  @Override
  public void save(NurseData nurseData) throws DataPersistorException
  {

  }

  @Override
  public int saveAndGet(NurseData nurseData) throws DataPersistorException
  {
    return 0;
  }

  @Override
  public String update(NurseData nurseData) throws DataPersistorException
  {
    return null;
  }
}
