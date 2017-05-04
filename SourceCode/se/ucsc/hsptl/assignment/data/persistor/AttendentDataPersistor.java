package se.ucsc.hsptl.assignment.data.persistor;

import java.sql.SQLException;

import se.ucsc.hsptl.assignment.data.AttendantData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.dto.AttendantDTO;
import se.ucsc.hsptl.assignment.db.dto.PatientDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public class AttendentDataPersistor implements DataPersistor<AttendantData>
{
  @Override
  public void save(AttendantData attendantData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.PATIENT_TABLE,
                                   PatientDTO.getPatientTableFields(),
                                   getAttendantValues(attendantData),
                                   null,
                                   DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Attendant data saving is failed for patient =" + attendantData.getAttendantId(),
                                       e);
    }
  }

  @Override
  public String saveAndGet(AttendantData attendantData) throws DataPersistorException
  {
    try
    {
      return DataBaseService
        .executeQuery(SQLConstants.ATTENDANT_TABLE,
                      AttendantDTO.getAttendantTableFields(),
                      getAttendantValues(attendantData),
                      null,
                      DataBaseQueryType.INSERT)
        .getString(0);
    }
    catch (DataBaseException | SQLException e)
    {
      throw new DataPersistorException("Attendant data saving is failed for patient =", e);
    }
  }

  @Override
  public String update(AttendantData attendantData) throws DataPersistorException
  {
    return null;
  }

  private String getAttendantValues(AttendantData attendantData)
  {
    return null;
  }
}
