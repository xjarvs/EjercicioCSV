package com.example.Ejercicio.CSV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.Ejercicio.BD.dbService;
import com.example.Ejercicio.BD.tw_clientes;
import com.example.Ejercicio.BD.tw_clientesRepository;
import com.example.Ejercicio.BD.tw_comercios;
import com.example.Ejercicio.BD.tw_comerciosRepository;
import com.example.Ejercicio.BD.tw_tarjetas;
import com.example.Ejercicio.BD.tw_tarjetasRepository;
import com.example.Ejercicio.BD.tw_transacciones;
import com.example.Ejercicio.BD.tw_transaccionesRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CSVController {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;	 	
	 @Autowired
	 private dbService service;
	 
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tstamp", LocalDateTime.now());
        return "index";
    }
    
    @GetMapping("/export1")
    public void exportToCSV1(HttpServletResponse response) {    	
    	
    	try {
    		
    		//Obtencion de datos via JDBC
    		String Query = "Select c.nombre_comercio COMERCIO,sum(importe_transaccion)IMPORTE from TW_TRANSACCIONES T\r\n"
        			+ "inner join TW_COMERCIOS c on t.id_comercio = c.id_comercio where t.fecha_transaccion BETWEEN '15/02/2020' and '31/03/2020'\r\n"
        			+ "group by c.nombre_comercio\r\n"
        			+ "order by c.nombre_comercio";
        	List<Reporte1> data = jdbcTemplate.query(Query, BeanPropertyRowMapper.newInstance(Reporte1.class));
        	
        	//Creacion del csv usando superCSV
    		response.setContentType("text/csv");
        	String fileName = "reporte1.csv";
        	String headerkey = "Content-Disposition";
        	String headerValue="attachment; filename="+fileName;
        	response.setHeader(headerkey,headerValue);
        	ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);  
        	String[] csvHeader =  { "COMERCIO", "IMPORTE"};
        	String[] nameMapping =  { "COMERCIO", "IMPORTE"};
			csvWriter.writeHeader(csvHeader);
			for(Reporte1 t : data) {
	    		csvWriter.write(t,nameMapping);
			}
			csvWriter.close();	
    	}	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	}    	
    }
    @GetMapping("/export2")
    public void exportToCSV2(HttpServletResponse response) {
    	try {
    	//Obtencion de datos via JPA,Hibernate, JPL
    	SimpleDateFormat dtParse = new SimpleDateFormat("dd-mm-yyyy"); 
    	Date fechainicio = dtParse.parse("01-01-2020"); 
    	Date fechafin = dtParse.parse("31-03-2020");  
    	List<Reporte2> datarep2 = service.GetReporte2(fechainicio,fechafin);    	
    	
    	//Creacion del csv usando superCSV
    	response.setContentType("text/csv");
    	String fileName = "reporte2.csv";
    	String headerkey = "Content-Disposition";
    	String headerValue="attachment; filename="+fileName;
    	response.setHeader(headerkey,headerValue);
    	ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
    	
    	
    	String[] csvHeader =  { "ID_CLIENTE", "NOMBRE","GASTOS"};
    	String[] nameMapping =  { "ID_CLIENTE", "NOMBRE","GASTOS"};
    	csvWriter.writeHeader(csvHeader);
    	for(Reporte2 r : datarep2) {    
    		csvWriter.write(r,nameMapping);
    	}
    	csvWriter.close();	
    	}
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
    	
    	}
    	catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
    	
    	}
    }
}
    
