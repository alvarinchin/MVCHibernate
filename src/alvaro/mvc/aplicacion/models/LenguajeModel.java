package alvaro.mvc.aplicacion.models;

import java.util.List;

import org.hibernate.Transaction;

import alvaro.mvc.aplicacion.pojos.LenguajeProgramacion;

public class LenguajeModel extends org.mvc.Model{


	public void crearLenguaje(String nombre) {
	

		Transaction t = ses.beginTransaction();
		LenguajeProgramacion l = new LenguajeProgramacion(nombre);
		ses.save(l);
		t.commit();
		ses.close();
	
	}

	public List<LenguajeProgramacion> listar() {

		List<LenguajeProgramacion> lenguajes = ses.createQuery("from LenguajeProgramacion").list();
		ses.close();
		return lenguajes;

	}
	public List<LenguajeProgramacion> listarFiltro(String filtro) {
		
		filtro="%"+filtro+"%";
		
		List<LenguajeProgramacion> lenguajes = ses.createQuery("from LenguajeProgramacion where nombre like :filto ").setParameter("filtro",filtro).list();
		ses.close();
		return lenguajes;

	}

	public boolean existe(String nombre) {

		List <LenguajeProgramacion> l= ses.createQuery("from LenguajeProgramacion where nombre = :nombre").setParameter("nombre", nombre).list();
		if(l.size()>0){
			return true;
		} else {
			return false;
		}
	}


}
