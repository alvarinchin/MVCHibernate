package alvaro.mvc.aplicacion.models;



import java.util.Collection;

import org.hibernate.Transaction;
import org.mvc.Model;

import alvaro.mvc.aplicacion.pojos.Ciudad;
import alvaro.mvc.aplicacion.pojos.Empleado;
import alvaro.mvc.aplicacion.pojos.LenguajeProgramacion;

public class EmpleadoModel extends Model{
	
	public void crearEmpleado(String nombre,Ciudad ciudad,Collection<LenguajeProgramacion> lenguajes){
		Transaction t=ses.beginTransaction();
		Empleado e = new Empleado(nombre,ciudad,lenguajes);
		ciudad.addEmpleado(e);
		
		ses.merge(e.getCiudad());
		t.commit();
		ses.close();
		
	}

}
