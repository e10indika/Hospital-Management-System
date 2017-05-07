package se.ucsc.hsptl.assignment.data.persistor;

import se.ucsc.hsptl.assignment.data.Data;
import se.ucsc.hsptl.assignment.exception.DataPersistorException;

/**
 * Created by Indika on 4/30/2017.
 */
public interface DataPersistor<D extends Data>
{
  String COMMA_SPACE = ", ";

  void save(D d) throws DataPersistorException;

  int saveAndGet(D d) throws DataPersistorException;

  String update(D d) throws DataPersistorException;

  default String getFormattedValue(String value)
  {
    return "'".concat(value).concat("'").concat(COMMA_SPACE);
  }
}
