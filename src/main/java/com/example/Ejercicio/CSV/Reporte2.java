package com.example.Ejercicio.CSV;

import java.math.BigDecimal;

import javax.persistence.Entity;


public class Reporte2 {
private Long ID_CLIENTE ;
private String NOMBRE ;
private double GASTOS;
public Long getID_CLIENTE() {
	return ID_CLIENTE;
}
public void setID_CLIENTE(Long iD_CLIENTE) {
	ID_CLIENTE = iD_CLIENTE;
}
public String getNOMBRE() {
	return NOMBRE;
}
public void setNOMBRE(String nOMBRE) {
	NOMBRE = nOMBRE;
}
public double getGASTOS() {
	return GASTOS;
}
public void setGASTOS(double gASTOS) {
	GASTOS = gASTOS;
}

public Reporte2(Long iD_CLIENTE, String nOMBRE, double gASTOS) {
	super();
	ID_CLIENTE = iD_CLIENTE;
	NOMBRE = nOMBRE;
	GASTOS = gASTOS;
}
@Override
public String toString() {
	return "Reporte2 [ID_CLIENTE=" + ID_CLIENTE + ", NOMBRE=" + NOMBRE + ", GASTOS=" + GASTOS + "]";
}

}
