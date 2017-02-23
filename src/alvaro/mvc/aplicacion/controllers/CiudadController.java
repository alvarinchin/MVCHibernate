package alvaro.mvc.aplicacion.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import alvaro.mvc.aplicacion.models.CiudadModel;
import alvaro.mvc.aplicacion.pojos.Ciudad;

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

	public void modificarGet() {
		if (request.getParameter("id") == null) {
			try {
				response.sendRedirect(baseURL + "ciudad/listar");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				view("error/error.jsp");
			}
		} else {

			Long id = Long.parseLong((String) request.getParameter("id"));
			Ciudad ciudad = new CiudadModel().recuperarPorId(id);
			datos.put("ciudad", ciudad);
			view("ciudad/ciudadModificar.jsp");

		}
	}

	public void borrarGet() {
		view("ciudad/ciudadBorrar.jsp");

	}

	public void listarAjaxGet() {
		List<Ciudad> lc = new CiudadModel().listar();
		datos.put("ciudades", lc);
		view("ciudad/listarAjax.jsp",false);

	}

	public void borrarPost() {
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			new CiudadModel().borrar(id);
		} catch (Exception e) {
			view("error/error.jsp");
		}
	}

}
