package se.ucsc.hsptl.assignment.exception;

/**
 * Created by Pathum on 4/30/2017.
 */
public class DataPersistorException extends Exception
{
  public DataPersistorException(String message)
  {
    super(message);
  }

  public DataPersistorException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
