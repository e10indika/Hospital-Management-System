package se.ucsc.hsptl.assignment.data.persistor;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import se.ucsc.hsptl.assignment.data.Data;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

import static se.ucsc.hsptl.assignment.db.SQLConstants.COMMA_SPACE;

/**
 * Created by Indika on 4/30/2017.
 */
public interface DataPersistor<D extends Data>
{
  void save(D d) throws DataPersistorException;

  int saveAndGet(D d) throws DataPersistorException;

  String update(D d) throws DataPersistorException;

  default String getFormattedValue(String value)
  {
    if (value == null)
    {
      value = "";
    }
    return "'".concat(value).concat("'").concat(COMMA_SPACE);
  }

  default String formatSql(StringBuffer stringBuffer)
  {
    return stringBuffer.substring(0, stringBuffer.lastIndexOf(COMMA_SPACE));
  }

  default String getFormattedValue(Date date)
  {
    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return getFormattedValue(formatter.format(date));
  }
}
