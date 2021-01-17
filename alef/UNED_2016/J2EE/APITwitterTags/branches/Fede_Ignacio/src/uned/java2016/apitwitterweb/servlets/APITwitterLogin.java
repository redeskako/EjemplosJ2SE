package uned.java2016.apitwitterweb.servlets;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import uned.java2016.apitwitter.dao.UsuariosDAOImpl;
import uned.java2016.apitwitter.dao.ConnDAOImpl;




/**
 * Servlet implementation class APITwitterLogin.
 * Se ejecuta cuando el cliente env�a el formulario de acceso a la aplicaci�n.
 * Si el formulario se ha cumplimentado, se comprueba si existe un usuario con 
 * esos nombre de usuario y contrase�a en la base de datos. 
 * Si es as�, se accede en calidad de administrador o de usuario, seg�n sea su rol.
 *
 * @author	Ignacio UNED 2016
 * @version	Recursos 1.0
 * @fecha 	Mayo- 2016
 */
/*@WebServlet("/index.jsp")*/
public class APITwitterLogin extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APITwitterLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * M�todo que se ejecuta si se recibe una petici�n de tipo Get.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("ServedLOGIN at: ").append(request.getContextPath());
    	this.doService(request, response);
	}

	/**
	 * M�todo que se ejecuta si se recibe una petici�n de tipo Post.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doService(request, response);
	}
	

	protected void doService(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession sesion;  

	    RequestDispatcher requestDispatcher; 
	   // PrintWriter out = response.getWriter();  

	    response.setContentType("text/html");
	    String operation = request.getParameter("operacion");
	    
	    String ErrorAcceso = null;
	    
	    // Login.
	    if (operation.equals("login"))
	   {
	    	  	
	    	String sUsuario =request.getParameter("txtUsuario");  		    
	        String sPassword =request.getParameter("txtPassword");
	        
	     // Si usuario y contrase�a no vac�os: 	
			if (sUsuario!=null && sPassword!=null)
			{
				// Se crea un usuario como respuesta de comprobar los valores enviados 
				// (se comprueba en BBDD)
				ConnDAOImpl conexion = new ConnDAOImpl();
				conexion.abrirConexion();
				UsuariosDAOImpl u = new UsuariosDAOImpl(conexion.getConnection());
				
				
				if (u.getRol(sUsuario, sPassword) != null){
					
					// Se crea la cookie:
					Cookie miCookie = new Cookie("idCookie", sUsuario);
					miCookie.setMaxAge(15*60);
					response.addCookie(miCookie);
					
					// Se inicia la sesi�n:
					HttpSession session = request.getSession();
					session.setAttribute("idSesion", sUsuario);
					
					// Se almacena el rol del usuario en la sesi�n
					String rol = u.getRol(sUsuario, sPassword);
					session.setAttribute("rolSesion", rol);
		
					// Se carga la vista administrador/Usuario en funci�n del rol
					if (rol.equals("adm")){
						response.sendRedirect("AdminIndex.jsp");
					} else {
						response.sendRedirect("ViewIndex.jsp");
					}
				}
				else {
					// Si el usuario no aparece en la base de datos:
					System.out.println("Usuario no v�lido: usuario no registrado.");
					requestDispatcher = request.getRequestDispatcher("/index.jsp?estado=invalido");
					requestDispatcher.forward(request, response);
				}
				conexion.cerrarConexion();
			}
			
		}
		// Logout.
		else if (operation.equals("logout"))
		{
			if (operation.equals("logout"))
		    {  		
		    	sesion = request.getSession(); 
		        sesion.invalidate(); 
		        response.sendRedirect("index.jsp?estado=logout"); 
		    }
			    
		    //Si no se han rellenado los campos del formulario de acceso:
			else 
			{
			   	response.sendRedirect("index.jsp?estado=invalido");
			}
		}
	    //Intento de acceso no logado.
		else if (operation.equals("sinsesion"))
		{
		    response.sendRedirect("index.jsp?estado=ilegal"); 
		}
		
	}	
}