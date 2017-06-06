package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.common.CommonToolkit;
import se.ucsc.hsptl.assignment.data.DoctorData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.db.dto.DoctorDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Pathum on 4/30/2017.
 */
public class DoctorDataPersistor implements DataPersistor<DoctorData>
{
  private static DoctorDataPersistor INSTANCE = new DoctorDataPersistor();

  private DoctorDataPersistor()
  {

  }

  public static DoctorDataPersistor getInstance()
  {
    return INSTANCE;
  }

  @Override
  public void save(DoctorData doctorData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.DOCTOR_TABLE,
                                   DoctorDTO.getTableFields(),
                                   getDoctorValues(doctorData),
                                   null,
                                   DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Doctor data saving is failed for doctor =" + doctorData.getDoctorId(), e);
    }

  }

  @Override
  public int saveAndGet(DoctorData doctorData) throws DataPersistorException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.DOCTOR_TABLE,
                                          DoctorDTO.getTableFields(),
                                          getDoctorValues(doctorData),
                                          null,
                                          DataBaseQueryType.INSERT);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Doctor data saving is failed for doctor =" + doctorData.getDoctorId(), e);
    }
  }

  @Override
  public String update(DoctorData doctorData) throws DataPersistorException
  {
    EmployeeDataPersistor.getInstance().update(doctorData);
    return updateDoctorData(doctorData);

  }

  private String updateDoctorData(DoctorData doctorData) throws DataPersistorException
  {
    try
    {
      DataBaseService.executeQuery(SQLConstants.DOCTOR_TABLE,
                                   new String[] { "lastModifiedDate", "latest" },
                                   new String[] { getFormattedValue(CommonToolkit.getCurrentDateTime()),
                                                  getFormattedValue(CommonToolkit.isLatest(false)) },
                                   SQLToolKit.getWhereClause(new String[] { "doctorId", "latest" },
                                                             new String[] { doctorData.getDoctorId(),
                                                                            CommonToolkit.isLatest(true) }),
                                   DataBaseQueryType.UPDATE);
      int value = saveAndGet(doctorData);
      return String.valueOf(value);
    }
    catch (DataBaseException e)
    {
      throw new DataPersistorException("Doctor updating failed", e);
    }
  }

  private String getDoctorValues(DoctorData doctorData)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(getFormattedValue(doctorData.getDoctorId()))
      .append(getFormattedValue(doctorData.getDesignation())).append(getFormattedValue(doctorData.getEmployeeId()))
      .append(getFormattedValue(CommonToolkit.getCurrentDateTime()))
      .append(getFormattedValue(CommonToolkit.isLatest(true)));
    return formatSql(stringBuffer).toString();
  }
}
