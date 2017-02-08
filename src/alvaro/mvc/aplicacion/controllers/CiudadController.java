package alvaro.mvc.aplicacion.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import alvaro.mvc.aplicacion.models.CiudadModel;
import alvaro.mvc.pojos.Ciudad;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

@SuppressWarnings("serial")
@WebServlet({ "/ciudad", "/ciudad/*"})
public class CiudadController extends org.mvc.Controller {
	public void crearGet() {
		view("ciudad/ciudadCrear.jsp");
	}
	
	public void crearPost(){
		String nombre= request.getParameter("nombre");
		 new CiudadModel().crearCiudad(nombre);
		
			request.getRequestDispatcher("ciudad/ciudadListar");
		
		
	}
	
	public void listarGet(){
		List <Ciudad> lc= new CiudadModel().listar();
		datos.put("ciudades", lc);
		view("ciudad/ciudadListar.jsp");
		
	}
	public void listarPost(){
		List <Ciudad> lc= new CiudadModel().listar();
		datos.put("ciudades", lc);
		view("ciudad/ciudadListar.jsp");
		
	}
}
