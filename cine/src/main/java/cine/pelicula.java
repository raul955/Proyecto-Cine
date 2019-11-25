package cine;

import java.util.Date;

public class pelicula {

	private String nombre;
	private String director;
	private Date date;
	private int id;
	
	public pelicula(String nombre, String director, Date date, int id) {
		super();
		this.nombre = nombre;
		this.director = director;
		this.date = date;
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
