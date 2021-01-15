package com.example.Ejercicio.BD;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ejercicio.CSV.Reporte2;

@Service
public class dbService {

	    @Autowired
	    private tw_transaccionesRepository tw_transaccionesRepo;	     
	  
	    public List<Reporte2> GetReporte2(Date fechainicio,Date fechafin) {
	        if (fechainicio != null && fechafin != null) {
	            return tw_transaccionesRepo.getReporte2(fechainicio,fechafin);
	        }
	        return null;
	    }
}
