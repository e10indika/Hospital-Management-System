package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.common.CommonToolkit;
import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.dto.AttendanceDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceDataPersistor implements DataPersistor<AttendanceData>
{
  private static final AttendanceDataPersistor INSTANCE = new AttendanceDataPersistor();

  private AttendanceDataPersistor()
  {
  }

  public static AttendanceDataPersistor getInstance()
  {
    return INSTANCE;
  }

  @Override
  public void save(AttendanceData attendanceData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.ATTENDANCE_TABLE,
                                   AttendanceDTO.getTableFields(),
                                   getAttendanceValues(attendanceData),
                                   null,
                                   DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Attendance data saving is failed for attendance =" +
                                       attendanceData.getEmployeeId(), e);
    }
  }

  @Override
  public int saveAndGet(AttendanceData attendanceData) throws DataPersistorException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.ATTENDANCE_TABLE,
                                          AttendanceDTO.getTableFields(),
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
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(getFormattedValue(attendanceData.getEmployeeId()))
      .append(getFormattedValue(String.valueOf(attendanceData.getType())))
      .append(getFormattedValue(attendanceData.getDate())).append(getFormattedValue(attendanceData.getTime()))
      .append(getFormattedValue(CommonToolkit.isLatest(true)));
    return formatSql(stringBuffer);
  }
}
