package cinespring.cinespring.boot.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import cinespring.cinespring.boot.elementos.pelicula;
import cinespring.cinespring.boot.elementos.usuario;

public interface BBDDDAO {

	public List<pelicula> mostrarTablaPeliculas(String director) throws ClassNotFoundException, SQLException;

	public List<usuario> unsuccesfullLogin(String usuario, String password)	throws SQLException, ClassNotFoundException;

	public List<pelicula> mostrarTodo() throws ClassNotFoundException, SQLException;

	public void insertarPelicula(String director, String titulo,String fecha, int id, String descripcion, String imagen) throws ClassNotFoundException, SQLException;

	public void modificarPelicula(int id, String director,String titulo, String fecha, String descripcion, String imagen) throws ClassNotFoundException, SQLException;

	public void borrarPelicula(int id) throws ClassNotFoundException, SQLException;

	public void altaUsuario(String usuario, String password) throws Exception;
	public List<String> devuelveFinalizar();
	
	public List<pelicula> filtrado(String titulo)throws ClassNotFoundException, SQLException;
	
	public List<pelicula> informacionPel(String nombre) throws ClassNotFoundException, SQLException;
	
	public void actualizarCalificacion(int id)throws IllegalArgumentException;
	public void addCalificacion (int calificacion, int id)throws IllegalArgumentException;
}
