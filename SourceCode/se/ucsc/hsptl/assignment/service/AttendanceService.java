package se.ucsc.hsptl.assignment.service;

import static se.ucsc.hsptl.assignment.common.AttendanceType.IN;
import static se.ucsc.hsptl.assignment.common.AttendanceType.OUT;

import se.ucsc.hsptl.assignment.common.AttendanceType;
import se.ucsc.hsptl.assignment.common.CommonToolkit;
import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.data.loader.AttendanceDataLoader;
import se.ucsc.hsptl.assignment.data.persistor.AttendanceDataPersistor;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

import java.util.List;

/**
 * Created by Indika on 5/7/2017.
 */
public class AttendanceService
{
  private static final AttendanceService INSTANCE = new AttendanceService();

  private AttendanceService()
  {
  }

  public static AttendanceService getInstance()
  {
    return INSTANCE;
  }

  public void addInTime(String employeeId) throws DataLoaderException, DataPersistorException
  {
    AttendanceData attendanceData =
      AttendanceDataLoader.getInstance().loadByEmployeeId(employeeId, IN.getValue(), CommonToolkit.getCurrentDate());
    if (attendanceData == null)
    {
      AttendanceDataPersistor.getInstance().save(createAttendanceData(employeeId, IN));
    }
  }

  public void addOutTime(String employeeId) throws DataLoaderException, DataPersistorException
  {
    AttendanceData attendanceData =
      AttendanceDataLoader.getInstance().loadByEmployeeId(employeeId, OUT.getValue(), CommonToolkit.getCurrentDate());
    if (attendanceData == null)
    {
      AttendanceDataPersistor.getInstance().save(createAttendanceData(employeeId, OUT));
    }
  }

  public List<AttendanceData> loadByEmployeeIds(List<String> employeeIds) throws DataLoaderException
  {
    return AttendanceDataLoader.getInstance().loadByIds(employeeIds);
  }

  private AttendanceData createAttendanceData(String employeeId, AttendanceType type)
  {
    return new AttendanceData(employeeId, type, CommonToolkit.getCurrentDate(), CommonToolkit.getCurrentTime());
  }
}
