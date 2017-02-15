package alvaro.mvc.aplicacion.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;

import alvaro.mvc.aplicacion.models.LenguajeModel;
import alvaro.mvc.aplicacion.pojos.LenguajeProgramacion;

@WebServlet({ "/lenguaje", "/lenguaje/*" })
public class LenguajeController extends Controller{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void indexGet() {
		view("lenguaje/index.jsp");
	}

	public void crearGet() {
		view("lenguaje/lenguajeCrear.jsp");
	}

	public void crearPost() throws IOException {
		String nombre = request.getParameter("nombre");
		try {
			new LenguajeModel().crearLenguaje(nombre);	
			response.sendRedirect(baseURL + "lenguaje/listar");
		} catch (Exception e) {
			view("error/error.jsp");
		}
	}

	public void listarGet() {
		if (request.getParameter("filtro") == null) {
			List<LenguajeProgramacion> lc = new LenguajeModel().listar();
			
			datos.put("lenguajes", lc);
			view("lenguaje/lenguajeListar.jsp");
		} else {
			List<LenguajeProgramacion> lc = new LenguajeModel().listarFiltro(request
					.getParameter("filtro"));
			datos.put("lenguajes", lc);
			view("lenguaje/lenguajeListar.jsp");
		}

	}

	public void listarPost() {
		if (request.getParameter("filtro") == null) {
			List<LenguajeProgramacion> lc = new LenguajeModel().listar();
			datos.put("lenguajes", lc);
			view("lenguaje/lenguajeListar.jsp");
		} else {
			List<LenguajeProgramacion> lc = new LenguajeModel().listarFiltro(request
					.getParameter("filtro"));
			datos.put("lenguajes", lc);
			view("lenguaje/LenguajeListar.jsp");

		}

	}


}
