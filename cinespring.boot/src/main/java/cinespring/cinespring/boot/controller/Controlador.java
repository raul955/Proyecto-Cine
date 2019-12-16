package cinespring.cinespring.boot.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cinespring.cinespring.boot.elementos.pelicula;
import cinespring.cinespring.boot.elementos.usuario;
import cinespring.cinespring.boot.elementos.peliculaRep;
import cinespring.cinespring.boot.elementos.usuarioRep;
import cinespring.cinespring.boot.DAO.BBDD;



@Controller
@RequestMapping("/views")
public class Controlador {
	
	@Autowired
	private peliculaRep pr;
	
	@Autowired
	private usuarioRep ur;
	
	BBDD BBDD;
	String pagina=null;

	@RequestMapping(value="/newUser", method=RequestMethod.GET)
	public String newUser() {
		return "/newUser";
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String goIndex() {
	    return "/views/index";
	}
	
	@RequestMapping(value="/salir", method=RequestMethod.GET)
	public String salir() {
		return "/salir";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "/login";
	}
	
	@RequestMapping(value="/informacion", method=RequestMethod.GET)
	public String informacion() {
		return "/informacion";
	}
	
	@RequestMapping(value="/consultaDir", method=RequestMethod.GET)
	public String consultaDir() {
		return "/consultaDir";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "/index";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
    public ModelAndView logearse(HttpServletRequest request) throws ServletException, IOException {

    	BBDD =  new BBDD();
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		try {
			
			List<usuario> usr = BBDD.unsuccesfullLogin(usuario, password);

			if (!usr.isEmpty()) {
				request.setAttribute("listaUsr", usr);
				pagina="/login";

			} else {

				request.setAttribute("user", usuario);
				pagina="/welcome";

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView(pagina);
			
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/welcome")
    public ModelAndView welcome(HttpServletRequest request) throws ServletException, IOException {

		try {

			List<pelicula> pel = BBDD.mostrarTodo();

			request.setAttribute("listaPel", pel);		

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("/mantenimiento");
		
    }
	
	
	
}
