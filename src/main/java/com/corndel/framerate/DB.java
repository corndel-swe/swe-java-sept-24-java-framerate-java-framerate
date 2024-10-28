package com.corndel.framerate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
  public static final String dbUrl = "jdbc:sqlite:framerate.sqlite3";

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(dbUrl);
  }
}
