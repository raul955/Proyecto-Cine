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
		this.id = id;
		
		if(calificacion>=0 && calificacion <=10) {
			this.calificacion = calificacion;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	

	public calificacion(double calificacion, int id, int idd) {
		super();
		
		if(calificacion>=0 && calificacion <=10) {
			this.calificacion = calificacion;
		}else {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.idd = idd;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		if(calificacion>=0 && calificacion <=10) {
			this.calificacion = calificacion;
		}else {
			throw new IllegalArgumentException();
		}
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
