package testclientes01.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testclientes01.DAO.ClienteDAO;
import testclientes01.model.Cliente;

@WebServlet("/adminArticulo")
public class ControllerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO cliente;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			cliente = new ClienteDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// init

	public ControllerCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}// doPost

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest rs, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		int ci = Integer.parseInt(rs.getParameter("ci"));
		String nombre = rs.getParameter("nombre");
		String apellido = rs.getParameter("apellido");
		String contrasena = rs.getParameter("contrasena");
		String direccion = rs.getParameter("direccion");
		String telefono = rs.getParameter("telefono");
		String estado = rs.getParameter("estado");
		String mail = rs.getParameter("mail");
		Cliente newcli = new Cliente(ci, nombre, apellido, contrasena, direccion, estado, mail, telefono);
		try {
			cliente.insertCliente(newcli);
			RequestDispatcher dispatcher = rs.getRequestDispatcher("index.jsp");
			dispatcher.forward(rs, response);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
			rs.setAttribute("errmsg", e.getMessage());
			rs.getRequestDispatcher("/vista/register.jsp").forward(rs, response);
		}

	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		List<Cliente> listaArticulos = cliente.selectAllClientes();
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
	}

	private void showEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Cliente newCli = cliente.selectCliente((Integer.parseInt(request.getParameter("cod"))));
		request.setAttribute("user", newCli);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest rs, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int cod = Integer.parseInt(rs.getParameter("cod"));
		int ci = Integer.parseInt(rs.getParameter("ci"));
		String nombre = rs.getParameter("nombre");
		String apellido = rs.getParameter("apellido");
		String contrasena = rs.getParameter("contrasena");
		String direccion = rs.getParameter("direccion");
		String telefono = rs.getParameter("telefono");
		String estado = rs.getParameter("estado");
		String mail = rs.getParameter("mail");
		Cliente newCli = new Cliente(cod, ci, nombre, apellido, contrasena, direccion, estado, mail, telefono);
		cliente.updateCliente(newCli);
		index(rs, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Cliente newCli = cliente.selectCliente((Integer.parseInt(request.getParameter("cod"))));
		cliente.deleteCliente(newCli);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

}// end class
