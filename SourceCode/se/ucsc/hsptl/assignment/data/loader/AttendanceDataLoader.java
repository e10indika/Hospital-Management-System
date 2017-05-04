package se.ucsc.hsptl.assignment.data.loader;

import java.util.List;

import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

/**
 * Created by Indika on 5/4/2017.
 */
public class AttendanceDataLoader implements DataLoader<AttendanceData>
{
  @Override
  public AttendanceData loadById(String id) throws DataLoaderException
  {
    return null;
  }

  @Override
  public List<AttendanceData> loadByIds(List<String> ids) throws DataLoaderException
  {
    return null;
  }
}
