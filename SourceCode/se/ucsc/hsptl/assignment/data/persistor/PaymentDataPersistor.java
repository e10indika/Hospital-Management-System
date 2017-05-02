package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.PatientData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public class PaymentDataPersistor implements DataPersistor<PatientData>
{
  @Override
  public void save(PatientData patientData) throws DataPersistorException
  {

  }

  @Override
  public String saveAndGet(PatientData patientData) throws DataPersistorException
  {
    return null;
  }

  @Override
  public String update(PatientData patientData) throws DataPersistorException
  {
    return null;
  }
}
