package alvaro.mvc.aplicacion.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import alvaro.mvc.aplicacion.models.CiudadModel;
import alvaro.mvc.pojos.Ciudad;



@SuppressWarnings("serial")
@WebServlet({ "/ciudad", "/ciudad/*" })
public class CiudadController extends org.mvc.Controller {

	public void indexGet() {
		view("ciudad/index.jsp");
	}

	public void crearGet() {
		view("ciudad/ciudadCrear.jsp");
	}

	public void crearPost() throws IOException {
		String nombre = request.getParameter("nombre");
		try {
			new CiudadModel().crearCiudad(nombre);
			response.sendRedirect(baseURL + "ciudad/listar");
		}
		catch (Exception e){
			view("error/error.jsp");
		}
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

}
