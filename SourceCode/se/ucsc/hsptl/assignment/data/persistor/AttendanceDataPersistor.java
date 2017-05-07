package se.ucsc.hsptl.assignment.data.persistor;

import java.sql.SQLException;

import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.dto.AttendanceDTO;
import se.ucsc.hsptl.assignment.db.dto.PatientDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceDataPersistor implements DataPersistor<AttendanceData>
{
  @Override
  public void save(AttendanceData attendanceData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.PATIENT_TABLE,
                                   PatientDTO.getPatientTableFields(),
                                   getAttendanceValues(attendanceData),
                                   null,
                                   DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Attendance data saving is failed for patient =" +
                                       attendanceData.getAttendanceId(), e);
    }
  }

  @Override
  public int saveAndGet(AttendanceData attendanceData) throws DataPersistorException
  {
    try
    {
      return DataBaseService
        .executeQuery(SQLConstants.ATTENDANCE_TABLE,
                      AttendanceDTO.getAttendanceTableFields(),
                      getAttendanceValues(attendanceData),
                      null,
                      DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Attendance data saving is failed for patient =", e);
    }
  }

  @Override
  public String update(AttendanceData attendanceData) throws DataPersistorException
  {
    return null;
  }

  private String getAttendanceValues(AttendanceData attendanceData)
  {
    return null;
  }
}
