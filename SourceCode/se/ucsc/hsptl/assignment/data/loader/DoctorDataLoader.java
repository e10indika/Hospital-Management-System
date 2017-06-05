package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.DoctorData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.db.dto.DoctorDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Pathum on 4/30/2017.
 */
public class DoctorDataLoader implements DataLoader<DoctorData>
{
  private static final DoctorDataLoader INSTANCE = new DoctorDataLoader();

  private DoctorDataLoader()
  {

  }

  public static DoctorDataLoader getINSTANCE()
  {
    return INSTANCE;
  }

  @Override
  public DoctorData loadById(String id) throws DataLoaderException
  {
    DoctorData doctorData = getDoctorData(id);
    return doctorData.setEmployeeData(EmployeeDataLoader.getInstance().loadById(doctorData.getEmployeeId()));

  }

  @Override
  public List<DoctorData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getDoctorDataResult(SQLToolKit.getWhereClause("doctorId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Doctor Data loading is failed", e);
    }
    return getDoctorData(resultSet);
  }

  private DoctorData getDoctorData(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getDoctorDataResult(SQLToolKit.getWhereClause("doctorId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Doctor Data loading is failed", e);
    }
    return getDoctorData(resultSet).get(0);
  }

  private List<DoctorData> getDoctorData(ResultSet resultSet) throws DataLoaderException
  {
    List<DoctorData> doctorDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        doctorDataList.add(getDoctorDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return doctorDataList;
  }

  private DoctorData getDoctorDataByRow(ResultSet resultSet) throws SQLException
  {
    String[] fieldNames = DoctorDTO.getTableAllFields();
    DoctorData doctorData = new DoctorData(resultSet.getString(fieldNames[1]),
                                           resultSet.getString(fieldNames[2]),
                                           null,
                                           null,
                                           null,
                                           resultSet.getString(fieldNames[3]));
    return doctorData;
  }

  private ResultSet getDoctorDataResult(String condition) throws DataLoaderException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.DOCTOR_TABLE,
                                          DoctorDTO.getTableAllFields(),
                                          condition,
                                          DataBaseQueryType.SELECT);
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Patient Data loading failed", e);
    }
  }
}
