package alvaro.mvc.aplicacion.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;

import alvaro.mvc.aplicacion.models.CiudadModel;
import alvaro.mvc.aplicacion.models.EmpleadoModel;
import alvaro.mvc.aplicacion.models.LenguajeModel;
import alvaro.mvc.aplicacion.pojos.Ciudad;
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
		try {
			new EmpleadoModel().crearEmpleado(nombre, c);

			view("empleado/empleadoCrear.jsp");
		} catch (Exception e) {
			view("error/error.jsp");
		}
	}

	public void listarGet() {
		if (request.getParameter("filtro") == null) {
			List<Ciudad> lc = new CiudadModel().listar();

			datos.put("ciudades", lc);
			view("ciudad/ciudadListar.jsp");
		} else {
			List<Ciudad> lc = new CiudadModel().listarFiltro(request.getParameter("filtro"));
			datos.put("ciudades", lc);
			view("ciudad/ciudadListar.jsp");
		}

	}

	public void listarPost() {
		listarPost();
	}

}
