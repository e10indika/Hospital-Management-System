package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.AttendantData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public class AttendentDataPersistor implements DataPersistor<AttendantData>
{
  @Override
  public void save(AttendantData attendantData) throws DataPersistorException
  {

  }

  @Override
  public String saveAndGet(AttendantData attendantData) throws DataPersistorException
  {
    return null;
  }

  @Override
  public String update(AttendantData attendantData) throws DataPersistorException
  {
    return null;
  }
}
