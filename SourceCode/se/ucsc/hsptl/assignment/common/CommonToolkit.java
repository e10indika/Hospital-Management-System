package se.ucsc.hsptl.assignment.common;

import java.util.Date;

/**
 * Created by Indika on 6/4/2017.
 */
public class CommonToolkit
{
  public static Date getCurrentDate()
  {
    return new Date();
  }

  public static String isLatest(boolean latest)
  {
    return latest ? "1" : "0";
  }
}
