package com.cozentusDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cozentus.model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root@123";

	private static final String INSERT_USERS_SQL = "INSERT INTO user_details  VALUES (?,?,?,?);";
	private static final String ALL_USERS = "select * from user_details";
	private static final String DELETE_USERS_SQL = "delete from user_details where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user_details set name = ?,email= ?, country =? where id = ?;";
	private static final String FETCH_USERS_SQL = "select * from user_details where id = ?;";
	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	public void selectuserById(int id) throws SQLException {
		System.out.println(FETCH_USERS_SQL);
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FETCH_USERS_SQL)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name, email, country);
			}
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
	}


	public List<User> selectAllUsers() {
System.out.println(ALL_USERS);
		
		List<User> users = new ArrayList<>();

		try (Connection connection = getConnection();

				
			PreparedStatement preparedStatement = connection.prepareStatement(ALL_USERS);) {
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} catch (Exception e) {
			
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		System.out.println(DELETE_USERS_SQL);
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		System.out.println(UPDATE_USERS_SQL);
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}