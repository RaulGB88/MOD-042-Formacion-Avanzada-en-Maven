package com.lm2a.examen.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lm2a.examen.model.Usuario;



/**
 * Esta clase DAO proporciona las operaciones CRUD para la tabla Usuarios en la BBDD
 * @author lm2a
 *
 */
public class UsuarioDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/examen?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Nicanor1";

	private static final String INSERT_USERS_SQL = "INSERT INTO usuario" + "  (nombre, email, fechaNacimiento) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select * from usuario where id =?";
	private static final String SELECT_ALL_USERS = "select * from usuario";
	private static final String DELETE_USERS_SQL = "delete from usuario where id = ?;";
	private static final String UPDATE_USERS_SQL = "update usuario set nombre = ?,email= ?, fechaNac =? where id = ?;";

	public UsuarioDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(Usuario usuario) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setDate(3, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Usuario selectUser(int id) {
		Usuario user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("nombre");
				String email = rs.getString("email");
				Date fechaNac = rs.getDate("fechaNacimiento");
				user = new Usuario(id, name, email, fechaNac);
					}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<Usuario> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Usuario> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nombre");
				String email = rs.getString("email");
				Date fechaNac = rs.getDate("fechaNacimiento");
				users.add(new Usuario(id, name, email, fechaNac));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(Usuario usuario) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getEmail());
			statement.setDate(3, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
			statement.setInt(4, usuario.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
