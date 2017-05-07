package se.ucsc.hsptl.assignment.db.dto;

import java.sql.Time;
import java.sql.Date;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceDTO
{
  private long attendanceId;

  private String employeeId;

  private int type;

  private Date date;

  private Time time;

  public AttendanceDTO()
  {
  }

  public static String[] getAttendanceTableFields()
  {
    return new String[0];
  }
}
