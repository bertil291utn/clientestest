package testclientes01.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private Connection jdbcConnection;
	private String URL;
	private String Usernam;
	private String Password;

	public Conexion(String URL, String Usernam, String Password) {
		this.URL = URL;
		this.Usernam = Usernam;
		this.Password = Password;
	}

//	public void conectar() throws SQLException {
//        if (jdbcConnection == null || jdbcConnection.isClosed()) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                throw new SQLException(e);
//            }
//            jdbcConnection = DriverManager.getConnection(
//                                        jdbcURL, jdbcUsername, jdbcPassword);
//        }
//    }
//	

	public Connection conectar() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, Usernam, Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}// getconnection

	public void desconectar() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public Connection getJdbcConnection() {
		return jdbcConnection;
	}

}// end class
