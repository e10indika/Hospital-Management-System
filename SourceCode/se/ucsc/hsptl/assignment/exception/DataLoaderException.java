package se.ucsc.hsptl.assignment.exception;

import java.sql.SQLException;

/**
 * Created by Pathum on 4/29/2017.
 */
public class DataLoaderException extends Exception
{
  public DataLoaderException(String s, Exception e)
  {
    super(s, e);
  }

}
