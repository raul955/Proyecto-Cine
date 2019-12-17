package cinespring.cinespring.boot.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cinespring.cinespring.boot.elementos.pelicula;
import cinespring.cinespring.boot.elementos.usuario;

public class BBDD implements BBDDDAO{

	pelicula pel;
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int result;
	String forName = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cine";
	String user = "root";
	String pass = "";
	
	//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BD_JPA");
	
	ArrayList<String> directorr = new ArrayList<String>();

	public List<pelicula> mostrarTablaPeliculas(String director) throws ClassNotFoundException, SQLException {

		ArrayList<pelicula> lista = new ArrayList<pelicula>();

		Class.forName(forName);

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("select * from cine where director like('"+director+"')");

		while (rs.next()) {

			lista.add(new pelicula(rs.getString("director"), rs.getString("titulo"),rs.getString("fecha"), rs.getInt("id")));
			if (!directorr.contains(rs.getString("director"))) {
				directorr.add(rs.getString("director"));
			}
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

		Class.forName(forName);

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

		Class.forName(forName);

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		rs = st.executeQuery("select * from cine");

		while (rs.next()) {

			lista.add(new pelicula(rs.getString("director"), rs.getString("titulo"),rs.getString("fecha"), rs.getInt("id")));

		}

		if (lista.isEmpty()) {
			lista.add(new pelicula("Error", ""));
		}

		return lista;

	}

	public void insertarPelicula(String director, String titulo,String fecha, int id) throws ClassNotFoundException, SQLException {

		Class.forName(forName);

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		st.executeUpdate(
				"insert into cine(director,titulo,fecha,id)values('" + director + "','" + titulo + "','"+fecha+"','" + id + "')");

	}

	public void modificarPelicula(int id, String director,String titulo, String fecha) throws ClassNotFoundException, SQLException {

		Class.forName(forName);

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		st.executeUpdate("update cine set titulo = '" + titulo + "' where id=" + id);
		st.executeUpdate("update cine set director = '" + director + "' where id=" + id);
		st.executeUpdate("update cine set fecha = '" + fecha + "' where id=" + id);

	}

	public void borrarPelicula(int id) throws ClassNotFoundException, SQLException {

		Class.forName(forName);

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		st.executeUpdate("delete from cine where id=" + id);

	}

	public void altaUsuario(String usuario, String password) throws ClassNotFoundException, SQLException {

		Class.forName(forName);

		con = DriverManager.getConnection(url, user, pass);

		st = con.createStatement();

		st.executeUpdate("insert into usuarios(usuario,password)values('" + usuario + "','" + password + "')");

	}

	public List<String> devuelveFinalizar() {
		return directorr;
	}

}
