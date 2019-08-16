package testclientes01.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import testclientes01.conexion.Conexion;
import testclientes01.model.Cliente;

public class ClienteDAO {
	private Conexion conn;

	public ClienteDAO(String URL, String Usernam, String Password) throws SQLException {
		System.out.println(URL);
		conn = new Conexion(URL, Usernam, Password);
	}

	private static final String INSERT_CLIENTE = "INSERT INTO cliente"
			+ "  (ci,nombre,apellido,contrasena,direccion,telefono,estado,mail) VALUES " + " (?, ?, ?,?,?,?,?,?);";

	private static final String SELECT_CLIENTE_BY_ID = "select * from cliente where cod =?";
	private static final String SELECT_ALL_CLIENTE = "select * from cliente";
	private static final String DELETE_CLIENTE = "delete from cliente where cod = ?;";
	private static final String UPDATE_CLIENTE = "update cliente set ci = ?, nombre= ?, apellido=?, contrasena=?, direccion=?, telefono=?, estado=?, mail=? where cod = ?;";

	public void insertCliente(Cliente user) throws SQLException, ServletException {
		System.out.println(INSERT_CLIENTE);
//		boolean rowInserted;
//		conn.conectar();
		try (Connection connection = conn.conectar();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENTE);) {
			if (!this.ingresoSameID(user.getCi())) {
				preparedStatement.setInt(1, user.getCi());
				preparedStatement.setString(2, user.getNombre());
				preparedStatement.setString(3, user.getApellido());
				preparedStatement.setString(4, user.getContrasena());
				preparedStatement.setString(5, user.getDireccion());
				preparedStatement.setString(6, user.getTelefono());
				preparedStatement.setString(7, user.getEstado());
				preparedStatement.setString(8, user.getMail());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
//				rowInserted = preparedStatement.executeUpdate() > 0;
				preparedStatement.close();
				conn.desconectar();
			} else
				throw new ServletException("Este numero de identificacion ya existe");
		} catch (SQLException e) {
			printSQLException(e);
		}
//		return rowInserted;
	}// insertar cliente

	public List<Cliente> selectAllClientes() {

		List<Cliente> users = new ArrayList<>();
		try (Connection connection = conn.conectar();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTE);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt("cod");
				int ci = rs.getInt("ci");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String contrasena = rs.getString("contrasena");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				String estado = rs.getString("estado");
				String mail = rs.getString("mail");
				users.add(new Cliente(cod, ci, nombre, apellido, contrasena, direccion, estado, mail, telefono));
			}
			conn.desconectar();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}// selectallclientes

	public Cliente selectCliente(int cod) throws SQLException {
		Cliente user = null;
//		conn.conectar();
		try (Connection connection = conn.conectar();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENTE_BY_ID);) {
			preparedStatement.setInt(1, cod);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ci = rs.getInt("ci");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String contrasena = rs.getString("contrasena");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				String estado = rs.getString("estado");
				String mail = rs.getString("mail");
				user = new Cliente(cod, ci, nombre, apellido, contrasena, direccion, estado, mail, telefono);
			}
			rs.close();
			conn.desconectar();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}// select cliente

	public boolean updateCliente(Cliente user) throws SQLException {
		boolean rowUpdated;
//		conn.conectar();
		try (Connection connection = conn.conectar();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENTE);) {
			preparedStatement.setInt(1, user.getCi());
			preparedStatement.setString(2, user.getNombre());
			preparedStatement.setString(3, user.getApellido());
			preparedStatement.setString(4, user.getContrasena());
			preparedStatement.setString(5, user.getDireccion());
			preparedStatement.setString(6, user.getTelefono());
			preparedStatement.setString(7, user.getEstado());
			preparedStatement.setString(8, user.getMail());
			preparedStatement.setInt(9, user.getCod());
			rowUpdated = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
			conn.desconectar();
		}
		return rowUpdated;
	}// updateclientes

	public boolean deleteCliente(Cliente cli) throws SQLException {
		boolean rowDeleted;
//		conn.conectar();
		try (Connection connection = conn.conectar();
				PreparedStatement statement = connection.prepareStatement(DELETE_CLIENTE);) {
			statement.setInt(1, cli.getCod());
			rowDeleted = statement.executeUpdate() > 0;
			statement.close();
			conn.desconectar();
		}
		return rowDeleted;
	}// delete clientes

	private boolean ingresoSameID(int ci) throws SQLException {
		boolean r = false;
		for (Cliente obj : this.selectAllClientes()) {
			if (obj.getCi() == ci) {
				r = true;
				break;
			}
		}
		return r;
	}// end ingresosameid

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
	}// printexception

}// end class
