package cinespring.cinespring.boot.elementos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class calificacion {
	
	@Column
	private double calificacion;
	
	@Column
	private int id;
	
	@Id
	private int idd;

	public calificacion() {
		super();
	}

	public calificacion(double calificacion, int id) {
		super();
		this.calificacion = calificacion;
		this.id = id;
	}
	
	

	public calificacion(double calificacion, int id, int idd) {
		super();
		this.calificacion = calificacion;
		this.id = id;
		this.idd = idd;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdd() {
		return idd;
	}

	public void setIdd(int idd) {
		this.idd = idd;
	}
	
	

}
