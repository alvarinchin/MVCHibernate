package alvaro.mvc.aplicacion.models;

import java.util.List;

import org.hibernate.Transaction;

import alvaro.mvc.aplicacion.pojos.Ciudad;

public class CiudadModel extends org.mvc.Model {

	public void crearCiudad(String nombre)throws Exception {


			Transaction t = ses.beginTransaction();
			Ciudad c = new Ciudad(nombre);

			ses.save(c);
			t.commit();
			ses.close();

		

	}

	public List<Ciudad> listar() {

		List<Ciudad> ciudades = ses.createQuery("from Ciudad").list();
		ses.close();
		return ciudades;

	}

	public List<Ciudad> listarFiltro(String filtro) {

		filtro = "%" + filtro + "%";

		List<Ciudad> ciudades = ses.createQuery("from Ciudad where nombre like :filto ").setParameter("filtro", filtro)
				.list();
		ses.close();
		return ciudades;

	}
	
	public Ciudad recuperarPorId(Long id){
		return ses.get(Ciudad.class, id);
	}

	public boolean existe(String nombre) {

		List<Ciudad> l = ses.createQuery("from Ciudad where nombre = :nombre").setParameter("nombre", nombre).list();
		if (l.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void modificar(String nombre, Long id) {
		Transaction t = ses.beginTransaction();
		Ciudad c = ses.get(Ciudad.class, id);
		c.setNombre(nombre);
		ses.merge(c);
		t.commit();
		ses.close();

	}

}
