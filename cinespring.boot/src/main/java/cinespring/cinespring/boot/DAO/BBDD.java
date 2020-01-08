package cinespring.cinespring.boot.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cinespring.cinespring.boot.elementos.pelicula;
import cinespring.cinespring.boot.elementos.usuario;

public class BBDD implements BBDDDAO {

	pelicula pel;
	int result;
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("conexion");

	ArrayList<String> directorr = new ArrayList<String>();

	public List<pelicula> mostrarTablaPeliculas(String director) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM pelicula p WHERE p.director = :director");
		query.setParameter("director", director);

		ArrayList<pelicula> lista = new ArrayList<pelicula>();

		lista = (ArrayList<pelicula>) query.getResultList();

		if (!directorr.contains(director)) {
			directorr.add(director);
		}
		
//		Class.forName(forName);
//		con = DriverManager.getConnection(url, user, pass);
//		st = con.createStatement();
//		rs = st.executeQuery("select * from cine where director like('"+director+"')");
//		while (rs.next()) {
//			lista.add(new pelicula(rs.getString("director"), rs.getString("titulo"),rs.getString("fecha"), rs.getInt("id")));
//			if (!directorr.contains(rs.getString("director"))) {
//				directorr.add(rs.getString("director"));
//			}
//		}

		if (lista.isEmpty()) {
			lista.add(new pelicula("", ""));
			lista.add(new pelicula("Sin resultado,  realice una nueva búsqueda", ""));
		}

		return lista;

	}

	public List<usuario> unsuccesfullLogin(String usuario, String password)
			throws SQLException, ClassNotFoundException {

		ArrayList<usuario> array = new ArrayList<>();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager
				.createQuery("SELECT u FROM usuario u WHERE u.usuario = :usuario AND u.password = :password");

		query.setParameter("usuario", usuario);
		query.setParameter("password", password);

		array = (ArrayList<usuario>) query.getResultList();
//		Class.forName(forName);
//		con = DriverManager.getConnection(url, user, pass);
//		st = con.createStatement();
//		rs = st.executeQuery(
//				"select * from usuarios where usuario like('" + usuario + "') and password like('" + password + "')");
//		while (rs.next()) {
//			array.add(new usuario(rs.getString("usuario"), rs.getString("password")));
//
//		}

		if (array.isEmpty()) {
			array.add(new usuario("Error, vuelva a intentarlo", ""));
		} else {
			array.clear();
		}

		return array;
	}

	public List<pelicula> mostrarTodo() throws ClassNotFoundException, SQLException {

		ArrayList<pelicula> lista = new ArrayList<pelicula>();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("SELECT p FROM pelicula p");

		lista = (ArrayList<pelicula>) query.getResultList();

//		Class.forName(forName);
//		con = DriverManager.getConnection(url, user, pass);
//		st = con.createStatement();
//		rs = st.executeQuery("select * from cine");
//		while (rs.next()) {
//			lista.add(new pelicula(rs.getString("director"), rs.getString("titulo"),rs.getString("fecha"), rs.getInt("id")));
//		}

		if (lista.isEmpty()) {
			lista.add(new pelicula("Error", ""));
		}

		return lista;

	}

	public void insertarPelicula(String director, String nombre, String fecha, int id, String descripcion,
			String imagen) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		pelicula pel = new pelicula();
		pel.setId(id);
		pel.setDirector(director);
		pel.setNombre(nombre);
		pel.setFecha(fecha);
		pel.setImagen(imagen);

		entitymanager.persist(pel);
		entitymanager.getTransaction().commit();

//		Class.forName(forName);
//		con = DriverManager.getConnection(url, user, pass);
//		st = con.createStatement();
//		st.executeUpdate(
//				"insert into cine(director,titulo,fecha,id,descripcion,imagen)values('" + director + "','" + titulo + "','"+fecha+"','" + id + "','"+ descripcion +"','"+ imagen +"')");

	}

	public void modificarPelicula(int id, String director, String nombre, String fecha, String descripcion,
			String imagen) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery(
				"UPDATE pelicula p SET p.nombre = :nombre, p.director = :director, p.fecha = :fecha, p.imagen = :imagen WHERE p.id = :id ");
		query.setParameter("id", id);
		query.setParameter("director", director);
		query.setParameter("nombre", nombre);
		query.setParameter("fecha", fecha);
		query.setParameter("imagen", imagen);

		query.executeUpdate();

		entitymanager.getTransaction().commit();

//		Class.forName(forName);
//
//		con = DriverManager.getConnection(url, user, pass);
//
//		st = con.createStatement();
//
//		st.executeUpdate("update cine set titulo = '" + titulo + "' where id=" + id);
//		st.executeUpdate("update cine set director = '" + director + "' where id=" + id);
//		st.executeUpdate("update cine set fecha = '" + fecha + "' where id=" + id);
//		st.executeUpdate("update cine set descripcion = '" + descripcion + "' where id=" + id);
//		st.executeUpdate("update cine set imagen = '" + imagen + "' where id=" + id);

	}

	public void borrarPelicula(int id) throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("DELETE FROM pelicula p WHERE p.id = :id ");
		query.setParameter("id", id);

		query.executeUpdate();

		entitymanager.getTransaction().commit();

//		Class.forName(forName);
//		con = DriverManager.getConnection(url, user, pass);
//		st = con.createStatement();
//		st.executeUpdate("delete from cine where id=" + id);

	}

	public void altaUsuario(String usuario, String password) throws Exception {

		
			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();

			usuario u = new usuario();
			u.setUsuario(usuario);
			u.setPassword(password);

			entitymanager.persist(u);
			entitymanager.getTransaction().commit();
			
		

//		Class.forName(forName);
//		con = DriverManager.getConnection(url, user, pass);
//		st = con.createStatement();
//		st.executeUpdate("insert into usuarios(usuario,password)values('" + usuario + "','" + password + "')");

	}

	public List<String> devuelveFinalizar() {
		return directorr;
	}

	public List<pelicula> mostrarPeliculas() throws ClassNotFoundException, SQLException {

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		ArrayList<pelicula> lista = new ArrayList<pelicula>();

		Query query = entitymanager.createQuery("select p FROM pelicula p");
		
		lista = (ArrayList<pelicula>) query.getResultList();
		
//		Class.forName(forName);
//		con = DriverManager.getConnection(url, user, pass);
//		st = con.createStatement();
//		rs = st.executeQuery("select * from cine");
//		while (rs.next()) {
//			lista.add(new pelicula(rs.getString("director"), rs.getString("titulo"), rs.getString("fecha"),
//					rs.getString("imagen")));
//		}

		if (lista.isEmpty()) {
			lista.add(new pelicula("", ""));
			lista.add(new pelicula("Sin resultado,  realice una nueva búsqueda", ""));
		}

		return lista;

	}
	
	public List<pelicula> filtrado(String nombre){
		
		ArrayList<pelicula> lista = new ArrayList<>();
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Query query = entitymanager.createQuery("SELECT p FROM pelicula p where p.nombre = :nombre");
		query.setParameter("nombre", nombre);

		lista = (ArrayList<pelicula>) query.getResultList();
				
		return lista;
	}

}
