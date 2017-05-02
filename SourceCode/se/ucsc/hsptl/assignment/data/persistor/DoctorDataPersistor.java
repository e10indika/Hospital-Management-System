package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.DoctorData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public class DoctorDataPersistor implements DataPersistor<DoctorData>
{
  @Override
  public void save(DoctorData doctorData) throws DataPersistorException
  {

  }

  @Override
  public String saveAndGet(DoctorData doctorData) throws DataPersistorException
  {
    return null;
  }

  @Override
  public String update(DoctorData doctorData) throws DataPersistorException
  {
    return null;
  }
}
