package se.ucsc.hsptl.assignment.data;

import java.sql.Date;

/**
 * Created by Indika on 5/7/2017.
 */
public class UserLoginData implements Data
{
  private long primaryKey;
  private String userId;
  private String employeeId;
  private String password;
  private Date lastLoginTime;
  private Date lastLogoutTime;
  private int latest;

  public UserLoginData()
  {
  }

  public UserLoginData(String userId,
                       String employeeId,
                       String password,
                       Date lastLoginTime,
                       Date lastLogoutTime,
                       int latest)
  {
    this.userId = userId;
    this.employeeId = employeeId;
    this.password = password;
    this.lastLoginTime = lastLoginTime;
    this.lastLogoutTime = lastLogoutTime;
    this.latest = latest;
  }

  public int getLatest()
  {
    return latest;
  }

  public UserLoginData setLatest(int latest)
  {
    this.latest = latest;
    return this;
  }

  public long getPrimaryKey()
  {
    return primaryKey;
  }

  public UserLoginData setPrimaryKey(long primaryKey)
  {
    this.primaryKey = primaryKey;
    return this;
  }

  public String getUserId()
  {
    return userId;
  }

  public UserLoginData setUserId(String userId)
  {
    this.userId = userId;
    return this;
  }

  public String getEmployeeId()
  {
    return employeeId;
  }

  public UserLoginData setEmployeeId(String employeeId)
  {
    this.employeeId = employeeId;
    return this;
  }

  public String getPassword()
  {
    return password;
  }

  public UserLoginData setPassword(String password)
  {
    this.password = password;
    return this;
  }

  public Date getLastLoginTime()
  {
    return lastLoginTime;
  }

  public UserLoginData setLastLoginTime(Date lastLoginTime)
  {
    this.lastLoginTime = lastLoginTime;
    return this;
  }

  public Date getLastLogoutTime()
  {
    return lastLogoutTime;
  }

  public UserLoginData setLastLogoutTime(Date lastLogoutTime)
  {
    this.lastLogoutTime = lastLogoutTime;
    return this;
  }
}
