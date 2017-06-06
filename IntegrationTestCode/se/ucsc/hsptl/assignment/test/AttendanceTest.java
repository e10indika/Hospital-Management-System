package se.ucsc.hsptl.assignment.test;

import org.junit.Test;

import se.ucsc.hsptl.assignment.data.AttendanceData;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;
import se.ucsc.hsptl.assignment.service.AttendanceService;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * Created by Pathum on 6/5/2017.
 */
public class AttendanceTest
{
  @Test
  public void testInTime() throws DataPersistorException, DataLoaderException
  {
    AttendanceService.getInstance().addInTime("12346");
  }

  @Test
  public void testOutTime() throws DataPersistorException, DataLoaderException
  {
    AttendanceService.getInstance().addOutTime("12346");
  }

  @Test
  public void testLoadByIds() throws DataLoaderException
  {
    List<String> employeeIds = new ArrayList<>();
    employeeIds.add("12345");
    employeeIds.add("12346");
    List<AttendanceData> attendanceDatas = AttendanceService.getInstance().loadByEmployeeIds(employeeIds);

    assertNotNull(attendanceDatas);
    assertEquals(2, attendanceDatas.size());
  }
}
