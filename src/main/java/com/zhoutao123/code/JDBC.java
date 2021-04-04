package com.zhoutao123.code;

import java.sql.*;

/** JDBC 样板代码 */
public class JDBC {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection =
        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", "name", "password");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT name,age FROM DB");
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      int age = resultSet.getInt("age");
      System.out.printf("name = %s, age = %d", name, age);
    }
    connection.close();
  }
}
