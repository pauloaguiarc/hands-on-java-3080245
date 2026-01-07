package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {

  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(db_file);
      System.out.println("Connection to database established.");
    } catch (SQLException e) {
      System.out.println("Error connecting to database: " + e.getMessage());
    }
    return connection;
  }

  public static void main(String[] args) {
    connect();
  }

  public static Customer getCustomer(String username) {
    String sql = "SELECT * FROM customers WHERE username = ?";
    Customer customer = null;
    try(Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, username);
      try(ResultSet resultSet = statement.executeQuery()) {
        customer = new Customer(
          resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getString("username"),
          resultSet.getString("password"),
          resultSet.getInt("account_id")
        );
      }
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    return customer;
  }

  public static Account getAccount(int accountId) {
    String sql = "SELECT * FROM Accounts WHERE accountId = ?";
    Account account = null;
    try(Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, accountId);
      try(ResultSet resultSet = statement.executeQuery()) {
        account = new Account(resultSet.getInt("id"), resultSet.getDouble("balance"), resultSet.getString("type"));
      }
      catch(SQLException e) {
        e.printStackTrace();
      }
    }
    catch(SQLException e) {
      e.printStackTrace();
    }

    return account;
  }

}
