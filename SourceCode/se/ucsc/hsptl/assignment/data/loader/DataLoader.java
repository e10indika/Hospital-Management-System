package se.ucsc.hsptl.assignment.data.loader;

import se.ucsc.hsptl.assignment.data.Data;
import se.ucsc.hsptl.assignment.exception.DataLoaderException;

import java.util.List;

/**
 * Created by Indika on 4/30/2017.
 */
public interface DataLoader<D extends Data>
{
  D loadById(String id) throws DataLoaderException;

  List<D> loadByIds(List<String> ids) throws DataLoaderException;
}
