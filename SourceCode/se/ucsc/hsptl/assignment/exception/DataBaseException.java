package se.ucsc.hsptl.assignment.exception;

/**
 * Created by Indika on 4/29/2017.
 */
public class DataBaseException extends Exception
{
  public DataBaseException(String message)
  {
    super(message);
  }

  public DataBaseException(String message, Exception e)
  {
    super(message, e);
  }
}
