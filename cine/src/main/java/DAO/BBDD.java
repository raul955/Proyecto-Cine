package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cine.pelicula;
import cine.usuario;

public class BBDD {

	pelicula pel;
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int result;
	String forName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
	String user = "cine";
	String pass = "cine";
	ArrayList<pelicula> directorr = new ArrayList<pelicula>();

	public List<pelicula> mostrarTablaPeliculas(String director) throws ClassNotFoundException, SQLException {

		ArrayList<pelicula> lista = new ArrayList<pelicula>();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("select * from cine where director like('" + director + "')");

		while (rs.next()) {

			lista.add(new pelicula(rs.getString("director"), rs.getString("titulo"), rs.getInt("id")));
			directorr.add(new pelicula(rs.getString("director")));
			
		}
		

		if (lista.isEmpty()) {
			lista.add(new pelicula("", ""));
			lista.add(new pelicula("Sin resultado,  realice una nueva búsqueda", ""));
		}

		return lista;

	}

	public List<usuario> unsuccesfullLogin(String usuario, String password)
			throws SQLException, ClassNotFoundException {

		ArrayList<usuario> array = new ArrayList<>();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery(
				"select * from usuarios where usuario like('" + usuario + "') and password like('" + password + "')");

		while (rs.next()) {

			array.add(new usuario(rs.getString("usuario"), rs.getString("password")));

		}

		if (array.isEmpty()) {
			array.add(new usuario("Error, vuelva a intentarlo", ""));
		} else {
			array.clear();
		}

		return array;
	}

	public List<pelicula> mostrarTodo() throws ClassNotFoundException, SQLException {

		ArrayList<pelicula> lista = new ArrayList<pelicula>();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("select * from cine");

		while (rs.next()) {

			lista.add(new pelicula(rs.getString("director"), rs.getString("titulo"), rs.getInt("id")));

		}

		if (lista.isEmpty()) {
			lista.add(new pelicula("Error", ""));
		}

		return lista;

	}

	public void insertarPelicula(String director, String titulo, int id) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery(
				"insert into cine(director,titulo,id)values('" + director + "','" + titulo + "','" + id + "')");

	}

	public void modificarPelicula(int id, String director, String titulo) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("update cine set titulo = '" + titulo + "' where id=" + id);
		rs = st.executeQuery("update cine set director = '" + director + "' where id=" + id);

	}

	public void borrarPelicula(int id) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("delete from cine where id=" + id);

	}
	
	public void altaUsuario(String usuario, String password) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("insert into usuarios(usuario,password)values('"+usuario+"','"+password+"')");

	}
	
	public void finalizar(String director) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("select * from cine where director like('" + director + "')");

		while (rs.next()) {

			directorr.add(new pelicula(rs.getString("director")));
			
		}
		

		if (directorr.isEmpty()) {
			directorr.add(new pelicula(""));
			directorr.add(new pelicula("Sin resultado"));
		}

	}
	
	public List<pelicula> devuelveFinalizar(){
		return directorr;
	}

}
