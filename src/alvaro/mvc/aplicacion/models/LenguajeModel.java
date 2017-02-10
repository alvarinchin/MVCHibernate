package alvaro.mvc.aplicacion.models;

import java.util.List;

import org.hibernate.Transaction;

import alvaro.mvc.pojos.LenguajeProgramacion;;

public class LenguajeModel extends org.mvc.Model{


	public boolean crearLenguaje(String nombre) {
		
		if (existe(nombre)){

		Transaction t = ses.beginTransaction();
		LenguajeProgramacion l = new LenguajeProgramacion(nombre);
		ses.save(c);
		t.commit();
		ses.close();
		return true;
		}else{
			return false;
		}
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
