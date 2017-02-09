package alvaro.mvc.aplicacion.models;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;


import org.hibernate.Transaction;

import alvaro.mvc.pojos.Ciudad;


public class CiudadModel extends org.mvc.Model {
	
	public void crearCiudad(String nombre){
		
		Transaction t= ses.beginTransaction();
		Ciudad c= new Ciudad (nombre);
		ses.save(c);
		t.commit();
		ses.close();
	}
	
	public List <Ciudad> listar(){
		
	 List <Ciudad> ciudades=ses.createQuery("from Ciudad").list();
		 ses.close();
			return ciudades ;
		
	}
	public boolean existe(String nombre){
		
		ses.createQuery("from ciudad where nombre = :nombre");
		
		return false;
	}

}
