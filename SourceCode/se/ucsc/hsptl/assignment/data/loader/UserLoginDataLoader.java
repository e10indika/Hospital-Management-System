package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.UserLoginData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.db.dto.UserLoginDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Pathum on 5/7/2017.
 */
public class UserLoginDataLoader implements DataLoader<UserLoginData>
{
  private static UserLoginDataLoader INSTANCE = new UserLoginDataLoader();

  private UserLoginDataLoader()
  {
  }

  public static UserLoginDataLoader getInstance()
  {
    return INSTANCE;
  }

  @Override
  public UserLoginData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getUserLoginDataResult(SQLToolKit.getWhereClause("userId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Attendant Data loading is failed", e);
    }
    return getUserLoginData(resultSet).get(0);
  }

  @Override
  public List<UserLoginData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getUserLoginDataResult(SQLToolKit.getWhereClause("userId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Attendant Data loading is failed", e);
    }
    return getUserLoginData(resultSet);
  }

  private List<UserLoginData> getUserLoginData(ResultSet resultSet) throws DataLoaderException
  {
    List<UserLoginData> userLoginDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        userLoginDataList.add(getUserLoginDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return userLoginDataList;

  }

  private UserLoginData getUserLoginDataByRow(ResultSet resultSet) throws DataLoaderException
  {
    try
    {
      return new UserLoginData().setPrimaryKey(resultSet.getLong(1)).setUserId(resultSet.getString(2))
        .setEmployeeId(resultSet.getString(3)).setPassword(resultSet.getString(4))
        .setLastLoginTime(resultSet.getDate(5)).setLastLogoutTime(resultSet.getDate(6)).setLatest(resultSet.getInt(7));
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("User LoginDate creation is failed", e);
    }

  }

  private ResultSet getUserLoginDataResult(String condition) throws DataLoaderException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.USER_LOGIN_TABLE,
                                          UserLoginDTO.getTableFields(),
                                          condition,
                                          DataBaseQueryType.SELECT);
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("User Login Data loading failed", e);
    }
  }
}
