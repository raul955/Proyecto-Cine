package controllers;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BBDD;
import cine.pelicula;
import cine.usuario;

/**
 * Servlet implementation class controller
 */
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	pelicula pel;
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int result;
	String forName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.14.203:1521:xe";
	String user = "cine";
	String pass = "cine";
	BBDD BBDD;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controller() {
		super();
		// TODO Auto-generated constructor stub
		BBDD =  new BBDD();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String value = request.getParameter("action");

		if (value.equals("mostrarInformacion")) {

			
			RequestDispatcher rd;
			String director = request.getParameter("director");

			try {
				List<pelicula> pel = BBDD.mostrarTablaPeliculas(director);
				request.setAttribute("listaPel", pel);

				rd = request.getRequestDispatcher("listapeliculas.jsp");

				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (value.equals("loginValidate")) {

			
			RequestDispatcher rd;
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");

			try {

				List<usuario> usr = BBDD.unsuccesfullLogin(usuario, password);

				if (!usr.isEmpty()) {
					request.setAttribute("listaUsr", usr);

					rd = request.getRequestDispatcher("login.jsp");

					rd.forward(request, response);

				} else {

					request.setAttribute("user", usuario);

					rd = request.getRequestDispatcher("welcome.jsp");

					rd.forward(request, response);

				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (value.equals("mantenimientojsp")) {

			
			RequestDispatcher rd;
			// String usuario = request.getParameter("usuario");
			// String password = request.getParameter("password");

			try {

				List<pelicula> pel = BBDD.mostrarTodo();

				request.setAttribute("listaPel", pel);

				rd = request.getRequestDispatcher("mantenimiento.jsp");

				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (value.equals("crearPelicula")) {

			
			RequestDispatcher rd;

			String director = request.getParameter("director");
			String titulo = request.getParameter("titulo");
			String fecha = request.getParameter("fecha");
			int id = Integer.parseInt(request.getParameter("id"));

			try {

				BBDD.insertarPelicula(director, titulo,fecha, id);

				String mensaje = "Película insertada";

				request.setAttribute("men", mensaje);

				rd = request.getRequestDispatcher("nuevaPelicula.jsp");

				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				rd = request.getRequestDispatcher("errorExistente.jsp");
				e.printStackTrace();
			}

		} else if (value.equals("modificarPelicula")) {

			
			RequestDispatcher rd;

			int id = Integer.parseInt(request.getParameter("id"));
			String director = request.getParameter("director");
			String titulo = request.getParameter("titulo");
			String fecha = request.getParameter("fecha");

			try {

				String mensaje = "Película modificada";

				BBDD.modificarPelicula(id, director,fecha, titulo);

				request.setAttribute("men", mensaje);

				rd = request.getRequestDispatcher("modificarPelicula.jsp");

				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				rd = request.getRequestDispatcher("errorExistente.jsp");
				e.printStackTrace();
			}
		} else if (value.equals("borrarPelicula")) {

			
			RequestDispatcher rd;

			int id = Integer.parseInt(request.getParameter("id"));

			try {

				String mensaje = "Película borrada";

				BBDD.borrarPelicula(id);

				request.setAttribute("men", mensaje);

				rd = request.getRequestDispatcher("borrarPelicula.jsp");

				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				rd = request.getRequestDispatcher("errorBorrado.jsp");
				e.printStackTrace();
			}

		} else if (value.equals("altaUsuario")) {

			
			RequestDispatcher rd;

			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");

			try {

				String mensaje = "Usuario insertado";

				BBDD.altaUsuario(usuario, password);

				request.setAttribute("men", mensaje);

				rd = request.getRequestDispatcher("newUser.jsp");

				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				rd = request.getRequestDispatcher("errorBorrado.jsp");
				e.printStackTrace();
			}

		} else if (value.equals("finalizar")) {

			
			RequestDispatcher rd;

			List<String> pel = BBDD.devuelveFinalizar();
			
			request.setAttribute("men", pel);

			rd = request.getRequestDispatcher("finalizar.jsp");

			rd.forward(request, response);
			/*falta rellenar la lista para guardar los directores consultados.
			 * modificacion realizada en el primer método de BBDD
			 * 2 metodos implementados en BBDD
			 */
		}else if(value.equals("inicio")) {
			
			BBDD = new BBDD();
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("index.jsp");

			rd.forward(request, response);

		}

	}

}
