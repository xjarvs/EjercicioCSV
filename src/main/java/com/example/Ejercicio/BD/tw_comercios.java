package com.example.Ejercicio.BD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tw_comercios")
public class tw_comercios {
	@Id	
	@Column(name="id_comercio")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_comercio ;	
	private String nombre_comercio;
	public Long getId_comercio() {
		return id_comercio;
	}
	public void setId_comercio(Long id_comercio) {
		this.id_comercio = id_comercio;
	}
	public String getNombre_comercio() {
		return nombre_comercio;
	}
	public void setNombre_comercio(String nombre_comercio) {
		this.nombre_comercio = nombre_comercio;
	}
	
	@Override
	public String toString() {
		return "tw_comercios [id_comercio=" + id_comercio + ", nombre_comercio=" + nombre_comercio + "]";
	}
}
