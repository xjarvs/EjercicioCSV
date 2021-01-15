package com.example.Ejercicio.BD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tw_clientes")
public class tw_clientes {
@Id	
@Column(name="id_cliente")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id_cliente ;
private String nombre ;
private long celular;
private String sexo;
private String correo_electronico;
public Long getId_cliente() {
	return id_cliente;
}
public void setId_cliente(Long id_cliente) {
	this.id_cliente = id_cliente;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public long getCelular() {
	return celular;
}
public void setCelular(long celular) {
	this.celular = celular;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getCorreo_electronico() {
	return correo_electronico;
}
public void setCorreo_electronico(String correo_electronico) {
	this.correo_electronico = correo_electronico;
}
@Override
public String toString() {
	return "Reporte1 [id_cliente=" + id_cliente + ", nombre=" + nombre + ", celular=" + celular + ", sexo=" + sexo
			+ ", correo_electronico=" + correo_electronico + "]";
}



}
