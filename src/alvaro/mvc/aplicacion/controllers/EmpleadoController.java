package alvaro.mvc.aplicacion.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;

import alvaro.mvc.aplicacion.models.CiudadModel;
import alvaro.mvc.aplicacion.pojos.Ciudad;

@SuppressWarnings("serial")
@WebServlet({"/empleado","/empleado/","/empleado/*"})
public class EmpleadoController extends Controller{
	
	public void indexGet() {
		view("empleado/index.jsp");
	}

	public void crearGet() {
		List <Ciudad> lc = new CiudadModel().listar();
		datos.put("ciudades", lc);
		view("empleado/empleadoCrear.jsp");
	}

	public void crearPost() throws IOException {
		
	}

	public void listarGet() {
		if (request.getParameter("filtro") == null) {
			List<Ciudad> lc = new CiudadModel().listar();
			
			datos.put("ciudades", lc);
			view("ciudad/ciudadListar.jsp");
		} else {
			List<Ciudad> lc = new CiudadModel().listarFiltro(request
					.getParameter("filtro"));
			datos.put("ciudades", lc);
			view("ciudad/ciudadListar.jsp");
		}

	}

	public void listarPost() {
		listarPost();
	}

}
