package se.ucsc.hsptl.assignment.data;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceData implements Data
{
  private String attendanceId;

  private String employeeId;

  private int type;

  private Date date;

  private Time time;

  public AttendanceData()
  {
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

  public Date getDate()
  {
    return date;
  }

  public AttendanceData setDate(Date date)
  {
    this.date = date;
    return this;
  }

  public Time getTime()
  {
    return time;
  }

  public AttendanceData setTime(Time time)
  {
    this.time = time;
    return this;
  }
}
