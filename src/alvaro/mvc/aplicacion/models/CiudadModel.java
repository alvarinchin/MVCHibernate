package alvaro.mvc.aplicacion.models;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import net.sf.json.util.JSONBuilder;

import org.hibernate.Query;
import org.hibernate.Transaction;

import alvaro.mvc.pojos.Ciudad;

public class CiudadModel extends org.mvc.Model {

	public boolean crearCiudad(String nombre) {
		
		//if (existe(nombre)){

		Transaction t = ses.beginTransaction();
		Ciudad c = new Ciudad(nombre);
		
		ses.save(c);
		t.commit();
		ses.close();
		return true;
		//}else{
			//return false;
		//}
	}

	public List<Ciudad> listar() {

		List<Ciudad> ciudades = ses.createQuery("from Ciudad").list();
		ses.close();
		return ciudades;

	}
	public List<Ciudad> listarFiltro(String filtro) {
		
		filtro="%"+filtro+"%";
		
		List<Ciudad> ciudades = ses.createQuery("from Ciudad where nombre like :filto ").setParameter("filtro",filtro).list();
		ses.close();
		return ciudades;

	}

	public boolean existe(String nombre) {

		List <Ciudad> l= ses.createQuery("from Ciudad where nombre = :nombre").setParameter("nombre", nombre).list();
		if(l.size()>0){
			return true;
		} else {
			return false;
		}
	}

}
