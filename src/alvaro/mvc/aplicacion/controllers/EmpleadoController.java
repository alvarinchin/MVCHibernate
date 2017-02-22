package alvaro.mvc.aplicacion.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

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
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("password");
		Ciudad c = new CiudadModel().recuperarPorId(Long.parseLong(request.getParameter("ciudad")));
		String[] ids = request.getParameterValues("lenguajes[]");
		List<LenguajeProgramacion> lenguajes = new LenguajeModel().listaLenguajes(ids);
		try {
			new EmpleadoModel().crearEmpleado(nombre, userName, pwd, c, lenguajes);

			response.sendRedirect(baseURL + "empleado/listar");
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

	public void loginPost() {
		String username = request.getParameter("usu");
		String password = request.getParameter("pwd");
		try {
			Empleado e = new EmpleadoModel().login(username, password).get(0);
			// session
			HttpSession ss = request.getSession(true);
			ss.setAttribute("userName", e.getUsername());
			ss.setAttribute("nombre", e.getNombre());
			ss.setAttribute("id", e.getId());
			response.sendRedirect(baseURL);
		} catch (Exception e) {
			view("error/error.jsp");
		}
		// sesion();
	}

	public void sesion() {
		HttpSession ss = request.getSession(true);
		String ssUsername = (String) ss.getAttribute("userName");
		String ssNombre = (String) ss.getAttribute("nombre");
		String ssId = (String) String.valueOf(ss.getAttribute("id"));
		datos.put("userName", ssUsername);
		datos.put("sesNombre", ssNombre);
		datos.put("id", ssId);
	}

	public void modificarGet() {
		if (request.getParameter("id") == null) {
			try {
				response.sendRedirect(baseURL + "empleado/listar");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				view("error/error.jsp");
			}
		} else {

			Long id = Long.parseLong((String) request.getParameter("id"));
			Empleado empleado = new EmpleadoModel().recuperarPorId(id);
			List<LenguajeProgramacion> lc = new LenguajeModel().listar();
			List<Ciudad> c = new CiudadModel().listar();
			datos.put("ciudades", c);
			datos.put("lenguajes", lc);
			datos.put("empleado", empleado);
			view("empleado/empleadoModificar.jsp");

		}
	}

	public void modificarPost() {
		String nombre = request.getParameter("nombre");
		Long id = Long.parseLong(request.getParameter("id"));
		try {
			new CiudadModel().modificar(nombre, id);
			response.sendRedirect(baseURL + "ciudad/listar");
		} catch (Exception e) {
			view("error/error.jsp");
		}
	}

}
