package alvaro.mvc.aplicacion;

import javax.servlet.annotation.WebServlet;

import org.mvc.Controller;
@WebServlet("")
public class Welcome extends Controller {
	
	public void indexGet(){
		view("index.jsp");
	}

}
