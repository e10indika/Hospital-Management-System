package se.ucsc.hsptl.assignment.data.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.ucsc.hsptl.assignment.data.ContactData;
import se.ucsc.hsptl.assignment.data.Name;
import se.ucsc.hsptl.assignment.data.PatientData;
import se.ucsc.hsptl.assignment.data.PersonData;
import se.ucsc.hsptl.assignment.db.DataBaseQueryType;
import se.ucsc.hsptl.assignment.db.DataBaseService;
import se.ucsc.hsptl.assignment.db.SQLConstants;
import se.ucsc.hsptl.assignment.db.SQLToolKit;
import se.ucsc.hsptl.assignment.db.dto.PatientDTO;
import se.ucsc.hsptl.assignment.exception.DataBaseException;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 4/29/2017.
 */
public class PatientDataLoader implements DataLoader<PatientData>
{
  private static PatientDataLoader INSTANCE = new PatientDataLoader();

  private PatientDataLoader()
  {

  }

  public static PatientDataLoader getInstance()
  {
    return INSTANCE;
  }

  @Override
  public PatientData loadById(String id) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getPatientDataResult(SQLToolKit.getWhereClause("patientId", id));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Patient Data loading is failed", e);
    }
    return getPatientData(resultSet).get(0);
  }

  @Override
  public List<PatientData> loadByIds(List<String> ids) throws DataLoaderException
  {
    ResultSet resultSet;
    try
    {
      resultSet = getPatientDataResult(SQLToolKit.getWhereClause("patientId", ids));
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Patient Data loading is failed", e);
    }
    return getPatientData(resultSet);
  }

  private List<PatientData> getPatientData(ResultSet resultSet) throws DataLoaderException
  {
    List<PatientData> patientDataList = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        patientDataList.add(getPatientDataByRow(resultSet));
      }
    }
    catch (SQLException e)
    {
      throw new DataLoaderException("Data loading is failed", e);
    }
    return patientDataList;
  }

  private PatientData getPatientDataByRow(ResultSet resultSet) throws SQLException
  {
    return new PatientData(resultSet.getString(PatientDTO.getPatientTableAllFields()[1])).setName(getName(resultSet))
      .setContactData(getContactData(resultSet))
      .setPersonData(getPersonData(resultSet));
  }

  private PersonData getPersonData(ResultSet resultSet) throws SQLException
  {
    return new PersonData(resultSet.getString(PatientDTO.getPatientTableAllFields()[10]),
                          resultSet.getDate(PatientDTO.getPatientTableAllFields()[11]),
                          resultSet.getString(PatientDTO.getPatientTableAllFields()[10]));
  }

  private ContactData getContactData(ResultSet resultSet) throws SQLException
  {
    return new ContactData(resultSet.getString(PatientDTO.getPatientTableAllFields()[9]),
                           resultSet.getString(PatientDTO.getPatientTableAllFields()[9]),
                           resultSet.getString(PatientDTO.getPatientTableAllFields()[9]),
                           new String[] { resultSet.getString(PatientDTO.getPatientTableAllFields()[8]) },
                           resultSet.getString(PatientDTO.getPatientTableAllFields()[9]));
  }

  private Name getName(ResultSet resultSet) throws SQLException
  {
    return new Name(resultSet.getString(PatientDTO.getPatientTableAllFields()[2]),
                    resultSet.getString(PatientDTO.getPatientTableAllFields()[3]),
                    resultSet.getString(PatientDTO.getPatientTableAllFields()[4]),
                    resultSet.getString(PatientDTO.getPatientTableAllFields()[5]));
  }

  private ResultSet getPatientDataResult(String condition) throws DataLoaderException
  {
    try
    {
      return DataBaseService.executeQuery(SQLConstants.PATIENT_TABLE,
                                          PatientDTO.getPatientTableAllFields(),
                                          condition,
                                          DataBaseQueryType.SELECT);
    }
    catch (DataBaseException e)
    {
      throw new DataLoaderException("Patient Data loading failed", e);
    }
  }
}
