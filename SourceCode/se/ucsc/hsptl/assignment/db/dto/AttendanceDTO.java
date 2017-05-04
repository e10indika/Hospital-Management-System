package se.ucsc.hsptl.assignment.db.dto;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceDTO
{
  private int attendanceId;

  private String employeeId;

  private int type;

  private Date date;

  private Time time;

  public AttendanceDTO()
  {
  }
}
