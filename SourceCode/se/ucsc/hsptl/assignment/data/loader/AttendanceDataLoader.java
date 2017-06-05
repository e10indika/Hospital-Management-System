package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.ucsc.hsptl.assignment.common.AttendanceType;
import se.ucsc.hsptl.assignment.common.CommonToolkit;
import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.db.dto.AttendanceDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceDataLoader implements DataLoader<AttendanceData>
{
  private static AttendanceDataLoader INSTANCE = new AttendanceDataLoader();

  private AttendanceDataLoader()
  {
  }

  public static AttendanceDataLoader getInstance()
  {
    return INSTANCE;
  }

  @Override
  public AttendanceData loadById(String id) throws DataLoaderException
  {
    return null;
  }

  @Override
  public List<AttendanceData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getAttendanceDataResult(SQLToolKit.getWhereClause("employeeId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Attendance Data loading is failed", e);
    }
    return getAttendanceData(resultSet);
  }

  public AttendanceData loadByEmployeeId(String employeeId, int type, String date) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      Map<String, String> mapElements = new HashMap<>();
      mapElements.put("employeeId", employeeId);
      mapElements.put("type", String.valueOf(type));
      mapElements.put("date", date);
      resultSet = getAttendanceDataResult(SQLToolKit.getWhereClause(mapElements));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Attendance Data loading is failed", e);
    }
    List<AttendanceData> attendanceDatas = getAttendanceData(resultSet);
    if (attendanceDatas.size() > 0)
    {
      return attendanceDatas.get(0);
    }
    return null;
  }

  private List<AttendanceData> getAttendanceData(ResultSet resultSet) throws DataLoaderException
  {
    List<AttendanceData> attendanceDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        attendanceDataList.add(getAttendanceDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return attendanceDataList;
  }

  private AttendanceData getAttendanceDataByRow(ResultSet resultSet) throws SQLException
  {
    return new AttendanceData("12345",
                              AttendanceType.IN,
                              CommonToolkit.getCurrentDate(),
                              CommonToolkit.getCurrentTime());
  }

  private ResultSet getAttendanceDataResult(String condition) throws DataLoaderException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.ATTENDANCE_TABLE,
                                          AttendanceDTO.getTableFields(),
                                          condition,
                                          DataBaseQueryType.SELECT);
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Patient Data loading failed", e);
    }
  }
}
