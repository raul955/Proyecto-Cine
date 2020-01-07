package cinespring.cinespring.boot.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	pelicula p;
	BBDD BBDD=  new BBDD();
	
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
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcome() {
		return "/welcome";
	}
	
	@RequestMapping(value="/informacion", method=RequestMethod.GET)
	public String informacion() {
		return "/informacion";
	}
	
	@RequestMapping(value="/nuevaPelicula", method=RequestMethod.GET)
	public String nuevaPelicula() {
		return "/nuevaPelicula";
	}
	
	@RequestMapping(value="/modificarPelicula", method=RequestMethod.GET)
	public String modificarPelicula() {
		return "/modificarPelicula";
	}
	
	@RequestMapping(value="/borrarPelicula", method=RequestMethod.GET)
	public String borrarPelicula() {
		return "/borrarPelicula";
	}
	
	@RequestMapping(value="/consult", method=RequestMethod.GET)
	public String consult() {
		return "/consultaDir";
	}
	
	@RequestMapping(value="/mantenimiento", method=RequestMethod.GET)
	public String mantenimiento() {
		return "/mantenimiento";
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
		
		return new ModelAndView("mantenimiento");
		
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/nuevaPeliculaa")
    public ModelAndView nuevaPelicula(HttpServletRequest request) throws ServletException, IOException {

		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");
		int id = Integer.parseInt(request.getParameter("id"));
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		

		try {

			BBDD.insertarPelicula(director, titulo,fecha, id, descripcion, imagen);

			String mensaje = "Película insertada";

			request.setAttribute("men", mensaje);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("/errorExistente");
		} catch (SQLException e) {

			e.printStackTrace();
			return new ModelAndView("/errorExistente");
		}
		
		return new ModelAndView("/nuevaPelicula");
		
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/modify")
    public ModelAndView modify(HttpServletRequest request) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");

		try {

			String mensaje = "Película modificada";

			BBDD.modificarPelicula(id,director,titulo,fecha,descripcion, imagen);

			request.setAttribute("men", mensaje);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("/errorExistente");
		} catch (SQLException e) {
			e.printStackTrace();
			return new ModelAndView("/errorExistente");
		}
		
		return new ModelAndView("/modificarPelicula");
		
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/delete")
    public ModelAndView delete(HttpServletRequest request) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {

			String mensaje = "Película borrada";

			BBDD.borrarPelicula(id);

			request.setAttribute("men", mensaje);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return new ModelAndView("/errorBorrado");
		} catch (SQLException e) {
			e.printStackTrace();
			return new ModelAndView("/errorBorrado");
		}
		
		return new ModelAndView("/borrarPelicula");
		
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/neww")
    public ModelAndView neww(HttpServletRequest request) throws ServletException, SQLIntegrityConstraintViolationException {

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		try {

			String mensaje = "Usuario insertado";

			BBDD.altaUsuario(usuario, password);

			request.setAttribute("men", mensaje);
			
//		} catch (SQLIntegrityConstraintViolationException e) {			
//			return new ModelAndView("/errorExistente");
//		} catch (ClassNotFoundException e) {
//			return new ModelAndView("/errorExistente");
//		} catch (SQLException e) {
//			return new ModelAndView("/errorExistente");
		} catch (Exception e) {
			e.printStackTrace();
			if(e.getCause().getCause().getCause().getClass().equals(SQLIntegrityConstraintViolationException.class)) {
				return new ModelAndView("/errorExistente");
			}
		}
		
		return new ModelAndView("/newUser");
		
    }
	@RequestMapping(method=RequestMethod.POST, value="/consulta")
	public ModelAndView consulta(HttpServletRequest request) throws ServletException, IOException, java.lang.NullPointerException, ClassNotFoundException, SQLException {

		
		String director = request.getParameter("director");

		try {
			List<pelicula> pel = BBDD.mostrarTablaPeliculas(director);
			request.setAttribute("listaPel", pel);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("/errorUsuario");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("/errorUsuario");
			
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
			return new ModelAndView("/listapeliculas");
		}
		
		return new ModelAndView("/listapeliculas");
		
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/finalizar")
	public ModelAndView finalizar(HttpServletRequest request) throws ServletException, IOException, java.lang.NullPointerException, ClassNotFoundException, SQLException {


		List<String> pel = BBDD.devuelveFinalizar();
		
		request.setAttribute("men", pel);
		
		return new ModelAndView("/finalizar");
		
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/fin")
	public ModelAndView fin(HttpServletRequest request) throws ServletException, IOException, java.lang.NullPointerException, ClassNotFoundException, SQLException {

		BBDD = new BBDD();
		
		return new ModelAndView("/index");
		
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/cardPeliculas")
    public ModelAndView cardPeliculas(HttpServletRequest request) throws ServletException, IOException, ClassNotFoundException, SQLException {
			
			List<pelicula> pel = BBDD.mostrarPeliculas();
			request.setAttribute("listaPel", pel);
		
		return new ModelAndView("/cardPeliculas");
		
    }
	
	
}
