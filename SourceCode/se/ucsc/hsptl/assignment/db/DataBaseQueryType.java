package se.ucsc.hsptl.assignment.db;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

/**
 * Created by Pathum on 4/29/2017.
 */
public enum DataBaseQueryType
{
  SELECT(SelectQuery.class), UPDATE(UpdateQuery.class), INSERT(InsertQuery.class), DELETE(DeleteQuery.class);

  private Class queryClass = null;

  <T extends Query> DataBaseQueryType(Class<T> queryClass)
  {
    this.queryClass = queryClass;
  }

  public <T extends Query> T getQueryInstance() throws DataBaseException
  {
    try
    {
      return (T) this.queryClass.newInstance();
    }
    catch (InstantiationException | IllegalAccessException e)
    {
      throw new DataBaseException("Query Object creation failed", e);
    }
  }
}
