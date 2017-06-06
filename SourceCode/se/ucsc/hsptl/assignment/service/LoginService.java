package se.ucsc.hsptl.assignment.service;

import se.ucsc.hsptl.assignment.data.UserLoginData;
import se.ucsc.hsptl.assignment.data.loader.UserLoginDataLoader;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;
import se.ucsc.hsptl.assignment.exception.PassWordServiceException;

/**
 * Created by Pathum on 5/7/2017.
 */
public class LoginService
{
  private static final LoginService INSTANCE = new LoginService();

  private LoginService()
  {
  }

  public static LoginService getInstance()
  {
    return INSTANCE;
  }

  public boolean login(String userName, String password) throws DataLoaderException
  {
    UserLoginData userLoginData = UserLoginDataLoader.getInstance().loadById(userName);

    try
    {
      if (PassWordService.getInstance().validatePassWords(userLoginData.getPassword(), password))
      {
        System.out.println("Success");
      }
      else
      {
        System.out.println("failed");
      }
    }
    catch (PassWordServiceException e)
    {
      throw new DataLoaderException("Login failed", e);
    }
    return false;
  }
}
