package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.ContactData;
import se.ucsc.hsptl.assignment.data.EmployeeData;
import se.ucsc.hsptl.assignment.data.Name;
import se.ucsc.hsptl.assignment.data.PersonData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.db.dto.EmployeeDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Pathum on 6/5/2017.
 */
public class EmployeeDataLoader implements DataLoader<EmployeeData>
{
  private static EmployeeDataLoader INSTANCE = new EmployeeDataLoader();

  private EmployeeDataLoader()
  {

  }

  public static EmployeeDataLoader getInstance()
  {
    return INSTANCE;
  }

  @Override
  public EmployeeData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getEmployeeDataAsResult(SQLToolKit.getWhereClause("employeeId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Employee Data loading is failed", e);
    }
    return getEmployeeData(resultSet).get(0);
  }

  @Override
  public List<EmployeeData> loadByIds(List<String> ids) throws DataLoaderException
  {
    return null;
  }

  private List<EmployeeData> getEmployeeData(ResultSet resultSet) throws DataLoaderException
  {
    List<EmployeeData> employeeDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        employeeDataList.add(getDoctorDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return employeeDataList;
  }

  private EmployeeData getDoctorDataByRow(ResultSet resultSet) throws SQLException
  {
    return new EmployeeData(resultSet.getString(EmployeeDTO.getTableFields()[0]),
                            getName(resultSet),
                            getContactData(resultSet),
                            getPersonData(resultSet))
      {
      };
  }

  private ResultSet getEmployeeDataAsResult(String condition) throws DataLoaderException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.EMPLOYEE_TABLE,
                                          EmployeeDTO.getTableAllFields(),
                                          condition,
                                          DataBaseQueryType.SELECT);
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Employee Data loading failed", e);
    }
  }

  private PersonData getPersonData(ResultSet resultSet) throws SQLException
  {
    return new PersonData(resultSet.getString(EmployeeDTO.getTableAllFields()[13]),
                          resultSet.getDate(EmployeeDTO.getTableAllFields()[6]),
                          resultSet.getString(EmployeeDTO.getTableAllFields()[14]));
  }

  private ContactData getContactData(ResultSet resultSet) throws SQLException
  {
    return new ContactData(resultSet.getString(EmployeeDTO.getTableAllFields()[10]),
                           resultSet.getString(EmployeeDTO.getTableAllFields()[11]),
                           null,
                           new String[] { resultSet.getString(EmployeeDTO.getTableAllFields()[7]),
                                          resultSet.getString(EmployeeDTO.getTableAllFields()[8]),
                                          resultSet.getString(EmployeeDTO.getTableAllFields()[9]) },
                           resultSet.getString(EmployeeDTO.getTableAllFields()[12]));
  }

  private Name getName(ResultSet resultSet) throws SQLException
  {
    return new Name(resultSet.getString(EmployeeDTO.getTableAllFields()[2]),
                    resultSet.getString(EmployeeDTO.getTableAllFields()[3]),
                    resultSet.getString(EmployeeDTO.getTableAllFields()[4]),
                    resultSet.getString(EmployeeDTO.getTableAllFields()[5]));
  }
}
