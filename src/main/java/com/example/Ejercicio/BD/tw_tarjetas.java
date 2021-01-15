package com.example.Ejercicio.BD;

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
@Table(name="tw_tarjetas")
public class tw_tarjetas {

	@Id	
	@Column(name="numero_tarjeta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero_tarjeta ;
    @JoinColumn(name = "id_cliente", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private tw_clientes cliente;
	private String tipo_tarjeta;
	public Long getNumero_tarjeta() {
		return numero_tarjeta;
	}
	public void setNumero_tarjeta(Long numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	public tw_clientes getCliente() {
		return cliente;
	}
	public void setCliente(tw_clientes cliente) {
		this.cliente = cliente;
	}
	public String getTipo_tarjeta() {
		return tipo_tarjeta;
	}
	public void setTipo_tarjeta(String tipo_tarjeta) {
		this.tipo_tarjeta = tipo_tarjeta;
	}
	@Override
	public String toString() {
		return "tw_tarjetas [numero_tarjeta=" + numero_tarjeta + ", cliente=" + cliente + ", tipo_tarjeta="
				+ tipo_tarjeta + "]";
	}

	
}
