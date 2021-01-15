package com.example.Ejercicio.CSV;

public class Reporte1 {
private String COMERCIO ;
private Double IMPORTE;
public String getCOMERCIO() {
	return COMERCIO;
}
public void setCOMERCIO(String cOMERCIO) {
	COMERCIO = cOMERCIO;
}
public Double getIMPORTE() {
	return IMPORTE;
}
public void setIMPORTE(Double iMPORTE) {
	IMPORTE = iMPORTE;
}
@Override
public String toString() {
	return "Reporte1 [COMERCIO=" + COMERCIO + ", IMPORTE=" + IMPORTE + "]";
}

}
