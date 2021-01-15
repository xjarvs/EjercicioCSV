package com.example.Ejercicio.BD;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tw_transacciones")
public class tw_transacciones {
	@Id	
	@Column(name="id_txn")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_txn ;
	private Date fecha_transaccion;
	@JoinColumn(name = "id_comercio", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private tw_comercios comercio;
	@JoinColumn(name = "numero_tarjeta", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private tw_tarjetas tarjeta;
	private double importe_transaccion;
	public Long getId_txn() {
		return id_txn;
	}
	public void setId_txn(Long id_txn) {
		this.id_txn = id_txn;
	}
	public Date getFecha_transaccion() {
		return fecha_transaccion;
	}
	public void setFecha_transaccion(Date fecha_transaccion) {
		this.fecha_transaccion = fecha_transaccion;
	}
	public tw_comercios getComercio() {
		return comercio;
	}
	public void setComercio(tw_comercios comercio) {
		this.comercio = comercio;
	}
	public tw_tarjetas getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(tw_tarjetas tarjeta) {
		this.tarjeta = tarjeta;
	}
	public double getImporte_transaccion() {
		return importe_transaccion;
	}
	public void setImporte_transaccion(double importe_transaccion) {
		this.importe_transaccion = importe_transaccion;
	}
	@Override
	public String toString() {
		return "tw_transacciones [id_txn=" + id_txn + ", fecha_transaccion=" + fecha_transaccion + ", comercio="
				+ comercio + ", tarjeta=" + tarjeta + ", importe_transaccion=" + importe_transaccion + "]";
	}

}
