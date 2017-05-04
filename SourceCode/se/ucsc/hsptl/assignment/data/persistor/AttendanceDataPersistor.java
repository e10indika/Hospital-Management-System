package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceDataPersistor implements DataPersistor<AttendanceData>
{
  @Override
  public void save(AttendanceData attendanceData) throws DataPersistorException
  {

  }

  @Override
  public String saveAndGet(AttendanceData attendanceData) throws DataPersistorException
  {
    return null;
  }

  @Override
  public String update(AttendanceData attendanceData) throws DataPersistorException
  {
    return null;
  }
}
