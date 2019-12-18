package cinespring.cinespring.boot.elementos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class pelicula {

	@Column
	private String nombre;
	
	@Column
	private String director;
	
	@Column
	private String fecha;
	
	@Id
	private int id;
	
	@Column
	private String descripcion;
	
	@Column
	private String imagen;
	
	public pelicula(String nombre, String director, String fecha, int id) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.fecha = fecha;
		this.id = id;
	}
	
	public pelicula(String nombre, String director, String fecha, String imagen) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.fecha = fecha;
		this.imagen = imagen;
	}

	public pelicula(String nombre, String director, String fecha, int id, String descripcion, String imagen) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.fecha = fecha;
		this.id = id;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public pelicula(String nombre, String director, int id) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.id = id;
	}

	public pelicula(String nombre, String director) {
		super();
		this.nombre = nombre;
		this.director = director;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public pelicula(String director) {
		super();
		this.director = director;
	}

	public pelicula(String nombre, String director, String fecha) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

