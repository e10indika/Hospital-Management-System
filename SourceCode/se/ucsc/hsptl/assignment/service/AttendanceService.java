package se.ucsc.hsptl.assignment.service;

import static se.ucsc.hsptl.assignment.common.CommonConstants.ATTENDANCE_IN_TYPE;
import static se.ucsc.hsptl.assignment.common.CommonConstants.ATTENDANCE_OUT_TYPE;
import static se.ucsc.hsptl.assignment.common.CommonConstants.DATE_FORMAT;
import static se.ucsc.hsptl.assignment.common.CommonConstants.TIME_FORMAT;

import java.sql.Time;
import java.util.Date;

import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.data.loader.AttendanceDataLoader;
import se.ucsc.hsptl.assignment.data.persistor.AttendanceDataPersistor;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

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
    AttendanceData attendanceData = AttendanceDataLoader.getInstance().loadByEmployeeId(employeeId, ATTENDANCE_IN_TYPE);
    if (attendanceData == null)
    {
      AttendanceDataPersistor.getInstance().save(getAttendanceData(employeeId, ATTENDANCE_IN_TYPE));
    }
  }

  public void addOutTime(String employeeId) throws DataLoaderException, DataPersistorException
  {
    AttendanceData attendanceData =
      AttendanceDataLoader.getInstance().loadByEmployeeId(employeeId, ATTENDANCE_OUT_TYPE);
    if (attendanceData == null)
    {
      AttendanceDataPersistor.getInstance().save(getAttendanceData(employeeId, ATTENDANCE_OUT_TYPE));
    }
  }

  private AttendanceData getAttendanceData(String employeeId, int type)
  {
    return new AttendanceData().setEmployeeId(employeeId).setType(type)
      .setDate(java.sql.Date.valueOf(DATE_FORMAT.format(new Date())))
      .setTime(Time.valueOf(TIME_FORMAT.format(new Date())));
  }
}
