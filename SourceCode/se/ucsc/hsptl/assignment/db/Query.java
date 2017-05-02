package se.ucsc.hsptl.assignment.db;

import java.sql.ResultSet;

import se.ucsc.hsptl.assignment.exception.DataBaseException;

public interface Query
{
  ResultSet executeQuery(String area, String[] fields, String sql) throws DataBaseException;

  ResultSet executeQuery(String area, String[] fields, String value, String condition) throws DataBaseException;

  //ResultSet executeQuery(String area, String[] fields, Object value) throws DataBaseException;
}
