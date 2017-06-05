package se.ucsc.hsptl.assignment.common;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Indika on 6/4/2017.
 */
public class CommonToolkit
{
  private static final Format TIME_FORMAT = new SimpleDateFormat("hh:mm:ss");
  private static final Format DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  public static Date getCurrentDateTime()
  {
    return new Date();
  }

  public static String isLatest(boolean latest)
  {
    return latest ? "1" : "0";
  }

  public static String getCurrentTime()
  {
    return TIME_FORMAT.format(getCurrentDateTime());
  }

  public static String getCurrentDate()
  {
    return DATE_FORMAT.format(getCurrentDateTime());
  }
}
