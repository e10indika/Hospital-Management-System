package se.ucsc.hsptl.assignment.exception;

import java.security.GeneralSecurityException;

/**
 * Created by Pathum on 5/7/2017.
 */
public class PassWordServiceException extends Exception
{
  public PassWordServiceException(String message, GeneralSecurityException exception)
  {
    super(message, exception);
  }
}
