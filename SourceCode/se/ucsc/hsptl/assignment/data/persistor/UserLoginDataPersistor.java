package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.UserLoginData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.dto.UserLoginDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 5/7/2017.
 */
public class UserLoginDataPersistor implements DataPersistor<UserLoginData>
{
  private static UserLoginDataPersistor INSTANCE = new UserLoginDataPersistor();

  private UserLoginDataPersistor()
  {
  }

  public static UserLoginDataPersistor getInstance()
  {
    return INSTANCE;
  }

  @Override
  public void save(UserLoginData userLoginData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.USER_LOGIN_TABLE,
                                   UserLoginDTO.getTableFieldsToInsert(),
                                   getUserLoginDTOValues(userLoginData),
                                   null,
                                   DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("User Login data saving is failed for user =" + userLoginData.getUserId(), e);
    }
  }

  @Override
  public int saveAndGet(UserLoginData userLoginData) throws DataPersistorException
  {
    return 0;
  }

  @Override
  public String update(UserLoginData userLoginData) throws DataPersistorException
  {
    return null;
  }

  private String getUserLoginDTOValues(UserLoginData userLoginData)
  {
    StringBuffer stringBuffer = new StringBuffer(getFormattedValue(userLoginData.getUserId()))
      .append(getFormattedValue(userLoginData.getEmployeeId())).append(getFormattedValue(userLoginData.getPassword()))
      .append(getFormattedValue(String.valueOf(userLoginData.getLastLoginTime())))
      .append(getFormattedValue(String.valueOf(userLoginData.getLastLogoutTime()))).append(getFormattedValue("1"));
    return stringBuffer.substring(0, stringBuffer.length() - 2);
  }
}
