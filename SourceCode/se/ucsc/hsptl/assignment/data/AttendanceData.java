package se.ucsc.hsptl.assignment.data;

import se.ucsc.hsptl.assignment.common.AttendanceType;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceData implements Data
{
  private String attendanceId;

  private String employeeId;

  private int type;

  private String date;

  private String time;

  public AttendanceData(String employeeId, AttendanceType type, String currentDate, String currentTime)
  {
    this.employeeId = employeeId;
    this.type = type.getValue();
    this.date = currentDate;
    this.time = currentTime;
  }

  public String getAttendanceId()
  {
    return attendanceId;
  }

  public AttendanceData setAttendanceId(String attendanceId)
  {
    this.attendanceId = attendanceId;
    return this;
  }

  public String getEmployeeId()
  {
    return employeeId;
  }

  public AttendanceData setEmployeeId(String employeeId)
  {
    this.employeeId = employeeId;
    return this;
  }

  public int getType()
  {
    return type;
  }

  public AttendanceData setType(int type)
  {
    this.type = type;
    return this;
  }

  public String getDate()
  {
    return date;
  }

  public AttendanceData setDate(String date)
  {
    this.date = date;
    return this;
  }

  public String getTime()
  {
    return time;
  }

  public AttendanceData setTime(String time)
  {
    this.time = time;
    return this;
  }
}
