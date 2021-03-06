package alvaro.mvc.aplicacion.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import alvaro.mvc.aplicacion.pojos.Ciudad;
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
		ses.clear();
		if(l.size()>0){
			return true;
		} else {
			return false;
		}
	}

	public List<LenguajeProgramacion> listaLenguajes(String[] ids) {
		List <LenguajeProgramacion> lenguajes=new ArrayList<LenguajeProgramacion>();
		for (int i = 0; i < ids.length; i++) {
			LenguajeProgramacion l= ses.get(LenguajeProgramacion.class, Long.parseLong(ids[i]));
			lenguajes.add(l);
		}
		
		return lenguajes;
	}
	public LenguajeProgramacion recuperarPorId(Long id){
		return ses.get(LenguajeProgramacion.class, id);
	}
	
	public void modificar(String nombre, Long id) {
		Transaction t = ses.beginTransaction();
		LenguajeProgramacion l = ses.get(LenguajeProgramacion.class, id);
		l.setNombre(nombre);
		ses.merge(l);
		t.commit();
		ses.close();

	}
	
	


}
