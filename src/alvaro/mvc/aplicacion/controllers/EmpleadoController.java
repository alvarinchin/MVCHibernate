package alvaro.mvc.aplicacion.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;

import alvaro.mvc.aplicacion.models.CiudadModel;
import alvaro.mvc.aplicacion.models.EmpleadoModel;
import alvaro.mvc.aplicacion.models.LenguajeModel;
import alvaro.mvc.aplicacion.pojos.Ciudad;
import alvaro.mvc.aplicacion.pojos.Empleado;
import alvaro.mvc.aplicacion.pojos.LenguajeProgramacion;

@SuppressWarnings("serial")
@WebServlet({ "/empleado", "/empleado/", "/empleado/*" })
public class EmpleadoController extends Controller {

	public void indexGet() {
		view("empleado/index.jsp");
	}

	public void crearGet() {
		List<Ciudad> lc = new CiudadModel().listar();
		List<LenguajeProgramacion> lp = new LenguajeModel().listar();

		datos.put("ciudades", lc);
		datos.put("lenguajes", lp);
		view("empleado/empleadoCrear.jsp");
	}

	public void crearPost() throws IOException {
		String nombre = request.getParameter("nombre");
		Ciudad c = new CiudadModel().recuperarPorId(Long.parseLong(request.getParameter("ciudad")));
		String [] ids= request.getParameterValues("lenguajes[]");
		List<LenguajeProgramacion> lenguajes= new LenguajeModel().listaLenguajes(ids);
		try {
			new EmpleadoModel().crearEmpleado(nombre, c,lenguajes);

			view("empleado/empleadoListar.jsp");
		} catch (Exception e) {
			view("error/error.jsp");
		}
	}

	public void listarGet() {
		if (request.getParameter("filtro") == null) {
			List<Empleado> empleados = new EmpleadoModel().listar();

			datos.put("empleados", empleados);
			view("empleado/empleadoListar.jsp");
		} else {
			List<Empleado> empleados = new EmpleadoModel().listarFiltro(request.getParameter("filtro"));
			datos.put("empleados", empleados);
			view("empleado/empleadoListar.jsp");
		}

	}

	public void listarPost() {
		listarGet();
	}

}
