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
		
		Transaction t=ses.beginTransaction();
		List <Ciudad> lista= ses.createQuery("from ciudad").list();
		ses.close();
		return lista;
		
	}

}
