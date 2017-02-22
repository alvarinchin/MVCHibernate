package alvaro.mvc.aplicacion.models;



import java.util.Collection;
import java.util.List;

import org.hibernate.Transaction;
import org.mvc.Model;

import alvaro.mvc.aplicacion.pojos.Ciudad;
import alvaro.mvc.aplicacion.pojos.Empleado;
import alvaro.mvc.aplicacion.pojos.LenguajeProgramacion;

public class EmpleadoModel extends Model{
	
	public void crearEmpleado(String nombre,String userName,String pwd,Ciudad ciudad,Collection<LenguajeProgramacion> lenguajes){
		Transaction t=ses.beginTransaction();
		Empleado e = new Empleado(nombre,userName, pwd, ciudad,lenguajes);
		ciudad.addEmpleado(e);
		
		ses.merge(e.getCiudad());
		t.commit();
		ses.close();
		
	}
	
	public List<Empleado> listar() {

		List<Empleado> empleados = ses.createQuery("from Empleado").list();
		ses.close();
		return empleados;

	}

	public List<Empleado> listarFiltro(String filtro) {

		filtro = "%" + filtro + "%";

		List<Empleado> empleados = ses.createQuery("from Empleado where nombre like :filto ").setParameter("filtro", filtro)
				.list();
		ses.close();
		return empleados;

	}

	public List<Empleado> login(String username, String password) {
		
		return ses.createQuery("from Empleado where username = :username and password = :password").setParameter("username", username).setParameter("password", password).list();
		
	}

}
