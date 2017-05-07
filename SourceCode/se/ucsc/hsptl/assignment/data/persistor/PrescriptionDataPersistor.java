package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.PrescriptionData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public class PrescriptionDataPersistor implements DataPersistor<PrescriptionData>
{
  @Override
  public void save(PrescriptionData prescriptionData) throws DataPersistorException
  {

  }

  @Override
  public int saveAndGet(PrescriptionData prescriptionData) throws DataPersistorException
  {
    return 0;
  }

  @Override
  public String update(PrescriptionData prescriptionData) throws DataPersistorException
  {
    return null;
  }
}
