package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.common.CommonToolkit;
import se.ucsc.hsptl.assignment.data.EmployeeData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.db.dto.EmployeeDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 6/5/2017.
 */
public class EmployeeDataPersistor implements DataPersistor<EmployeeData>
{
  private static EmployeeDataPersistor INSTANCE = new EmployeeDataPersistor();

  private EmployeeDataPersistor()
  {

  }

  public static EmployeeDataPersistor getInstance()
  {
    return INSTANCE;
  }

  @Override
  public void save(EmployeeData employeeData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.EMPLOYEE_TABLE,
                                   EmployeeDTO.getTableFields(),
                                   getEmployeeValues(employeeData),
                                   null,
                                   DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Employee data saving is failed for employee =" + employeeData.getEmployeeId(),
                                       e);
    }
  }

  @Override
  public int saveAndGet(EmployeeData employeeData) throws DataPersistorException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.EMPLOYEE_TABLE,
                                          EmployeeDTO.getTableFields(),
                                          getEmployeeValues(employeeData),
                                          null,
                                          DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Employee data saving is failed for employee =" + employeeData.getEmployeeId(),
                                       e);
    }
  }

  @Override
  public String update(EmployeeData employeeData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.EMPLOYEE_TABLE,
                                   new String[] { "lastModifiedDate", "latest" },
                                   new String[] { getFormattedValue(CommonToolkit.getCurrentDate()),
                                                  getFormattedValue(CommonToolkit.isLatest(false)) },
                                   SQLToolKit.getWhereClause(new String[] { "employeeId", "latest" },
                                                             new String[] { employeeData.getEmployeeId(),
                                                                            CommonToolkit.isLatest(true) }),
                                   DataBaseQueryType.UPDATE);
      int value = saveAndGet(employeeData);
      return String.valueOf(value);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Employee updating failed", e);
    }
  }

  private String getEmployeeValues(EmployeeData employeeData)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(getFormattedValue(employeeData.getEmployeeId()))
      .append(getFormattedValue(employeeData.getName().getFirstName()))
      .append(getFormattedValue(employeeData.getName().getMiddleName()))
      .append(getFormattedValue(employeeData.getName().getLastName()))
      .append(getFormattedValue(employeeData.getName().getTitle()))
      .append(getFormattedValue(employeeData.getPersonData().getBirthDate()))
      .append(getFormattedValue(employeeData.getContactData().getAddress()[0]))
      .append(getFormattedValue(employeeData.getContactData().getAddress()[1]))
      .append(getFormattedValue(employeeData.getContactData().getAddress()[2]))
      .append(getFormattedValue(employeeData.getContactData().getMobilePhone()))
      .append(getFormattedValue(employeeData.getContactData().getHomePhone()))
      .append(getFormattedValue(employeeData.getContactData().getEmail()))
      .append(getFormattedValue(employeeData.getPersonData().getGender()))
      .append(getFormattedValue(employeeData.getPersonData().getNationality()))
      .append(getFormattedValue(CommonToolkit.getCurrentDate()))
      .append(getFormattedValue(CommonToolkit.isLatest(true)));
    return formatSql(stringBuffer).toString();
  }
}
