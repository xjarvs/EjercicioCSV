package com.example.Ejercicio.BD;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Ejercicio.CSV.Reporte2;

public interface tw_transaccionesRepository extends JpaRepository<tw_transacciones, Long> {

	
	 @Query("select t from tw_transacciones t where t.fecha_transaccion BETWEEN '01/01/2020' and '31/03/2020'")
	 List<tw_transacciones> getTransaccionByDateRange();
	 
	
	 @Query("SELECT NEW com.example.Ejercicio.CSV.Reporte2(c.id_cliente  , c.nombre  , sum(t.importe_transaccion) )  FROM tw_transacciones t "
	 		+ " INNER JOIN t.tarjeta ta "
	 		+ " INNER JOIN ta.cliente c "
	 		+ " WHERE t.fecha_transaccion BETWEEN  :fechaInicio AND :fechaFin "
	 		+ " GROUP BY c.id_cliente, c.nombre "
	 		+ " ORDER BY c.nombre")
	 List<Reporte2> getReporte2(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

	 
}
