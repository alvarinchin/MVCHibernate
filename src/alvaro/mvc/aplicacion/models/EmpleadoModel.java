package alvaro.mvc.aplicacion.models;



import org.hibernate.Transaction;
import org.mvc.Model;

import alvaro.mvc.aplicacion.pojos.Ciudad;
import alvaro.mvc.aplicacion.pojos.Empleado;

public class EmpleadoModel extends Model{
	
	public void crearEmpleado(String nombre,Ciudad ciudad){
		Transaction t=ses.beginTransaction();
		Empleado e = new Empleado(nombre,ciudad);
		ciudad.addEmpleado(e);
		
		ses.merge(e.getCiudad());
		t.commit();
		ses.close();
		
	}

}
