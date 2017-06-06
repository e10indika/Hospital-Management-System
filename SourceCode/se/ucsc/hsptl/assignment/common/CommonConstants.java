package se.ucsc.hsptl.assignment.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Pathum on 5/7/2017.
 */
public class CommonConstants
{
  public static final int ATTENDANCE_IN_TYPE = 1;
  public static final int ATTENDANCE_OUT_TYPE = 2;
  public static final int USER_ID_MINIMUM_LENGTH = 6;
  public static final int PASSWORD_MINIMUM_LENGTH = 6;
  public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/mm/dd");
  public static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
  public static final DateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm:ss");
}
