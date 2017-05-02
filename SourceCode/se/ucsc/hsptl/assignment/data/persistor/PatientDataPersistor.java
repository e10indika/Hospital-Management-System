package se.ucsc.hsptl.assignment.data.persistor;

import java.sql.SQLException;

import se.ucsc.hsptl.assignment.data.PatientData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.dto.PatientDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/29/2017.
 */
public class PatientDataPersistor implements DataPersistor<PatientData>
{
  private static final PatientDataPersistor INSTANCE = new PatientDataPersistor();

  private PatientDataPersistor()
  {
  }

  public static PatientDataPersistor getInstance()
  {
    return INSTANCE;
  }

  @Override
  public void save(PatientData patientData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.PATIENT_TABLE,
                                   PatientDTO.getPatientTableFields(),
                                   getPatientValues(patientData),
                                   null,
                                   DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Patient data saving is failed for patient =" + patientData.getPatientId(), e);
    }
  }

  @Override
  public String saveAndGet(PatientData patientData) throws DataPersistorException
  {
    try
    {
      return DataBaseService
        .executeQuery(SQLConstants.PATIENT_TABLE,
                      PatientDTO.getPatientTableFields(),
                      getPatientValues(patientData),
                      null,
                      DataBaseQueryType.INSERT)
        .getString(0);
    }
    catch (DataBaseException | SQLException e)
    {
      throw new DataPersistorException("Patient data saving is failed for patient =", e);
    }
  }

  @Override
  public String update(PatientData patientData) throws DataPersistorException
  {
    return null;
  }

  private String getPatientValues(PatientData patientData)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(getFormattedValue(patientData.getPatientId())).append(COMMA_SPACE).append(patientData.getName().getFirstName()).append(COMMA_SPACE);
    return stringBuffer.toString();
  }

  private String getFormattedValue(String value)
  {
    return null;
  }
}
