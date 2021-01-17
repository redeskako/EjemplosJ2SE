package es.uned2014.recursosAlpha.servlet;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import es.uned2014.recursosAlpha.clasesCliente.Conjunto;
import es.uned2014.recursosAlpha.clasesCliente.Reserva;


/**
 * Servlet implementation class FormularioEditarReserva
 * Se ejecuta cuando el usuario desea cargar el formulario para editar una Reserva.
 * Se realiza una llamada al servicio web correspondiente: combosFormulario.
 * La respuesta obtenida (XML) se traduce a un objeto Conjunto y se pasa el resultado
 * al archivo jsp.
 * 
 * @author	Alpha UNED 2014
 * @version	RecursosWS 1.0
 * @since 	Septiembre 2014
 */
public class FormularioEditarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	public FormularioEditarReserva() {
		super();
        // TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// PRIMERA FASE: Recuperar Reserva con ID:		
		// Se crea el cliente:
		Client cliente = ClientBuilder.newClient();
		
		// Se recupera el String con el nombreUsuario del usuario logueado
		String usuarioSesion = "";
		HttpSession session = request.getSession();	
		
		if (session.getAttribute("idSesion") != null
				&& !session.getAttribute("idSesion").equals("")) {
			usuarioSesion = (String)session.getAttribute("idSesion");
		}
		
		// Se indica a d�nde va a lanzar su consulta:
		WebTarget recurso = cliente.target("http://localhost:8080/alphaWS_Servidor/rest/misPeticiones"
				+ "?pagina=0&usuario=" + usuarioSesion);
		
		// Se indica qu� tipo de dato espera recibir:
		Builder constructor = recurso.request(MediaType.APPLICATION_XML);
		
		// Se ejecuta la consulta, indicando que es de tipo GET, y que la respuesta que se espera es String:
		String cargarReservas = constructor.get(String.class);

		// Se cierra el cliente:
		cliente.close();
		
		// Se convierte XML --> Objeto (Conjunto):
		Conjunto conjunto = new Conjunto();
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Conjunto.class);
			Unmarshaller um = context.createUnmarshaller();
			conjunto = (Conjunto)um.unmarshal(new File("conjunto.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		// Se extrae la reserva con id correspondiente
		ArrayList<Reserva> array = conjunto.getArrayReservas();
		Reserva reserva = new Reserva();
		
		// Se encuentra aquel cuyo ID coincida con la petici�n de edici�n
		int id = Integer.parseInt(request.getParameter("id"));
		for (Reserva r : array){
			if (id == r.getIdReserva()){
				reserva = r;
			}
		}
		
		// SEGUNDA FASE: Obtenci�n de listados para combos del formulario
		// Se crea el cliente:
		Client cliente2 = ClientBuilder.newClient();
		
		// Se indica a d�nde va a lanzar su consulta:
		WebTarget recurso2 = cliente2.target("http://localhost:8080/alphaWS_Servidor/rest/combosFormulario");
		
		// Se indica qu� tipo de dato espera recibir:
		Builder constructor2 = recurso2.request(MediaType.APPLICATION_XML);
		
		// Se ejecuta la consulta, indicando que es de tipo GET, y que la respuesta que se espera es String:
		String cargarListados = constructor2.get(String.class);

		// Se cierra el cliente:
		cliente.close();
		
		// Se convierte XML --> Objeto (Conjunto):
		Conjunto conjunto2 = new Conjunto();
		JAXBContext context2;
		try {
			context2 = JAXBContext.newInstance(Conjunto.class);
			Unmarshaller um2 = context2.createUnmarshaller();
			conjunto2 = (Conjunto)um2.unmarshal(new File("conjunto.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		// Se redirecciona:
		request.setAttribute("arrayUsuarios", conjunto2.getArrayUsuarios());
		request.setAttribute("arrayRecursos", conjunto2.getArrayRecursos());
		request.setAttribute("arrayEstados", conjunto2.getArrayEstados());
		request.setAttribute("arraySucursales", conjunto2.getArraySucursales());
		request.setAttribute("reserva", reserva);
		RequestDispatcher rd = request.getRequestDispatcher("reservasEditar.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
} // end class CargarListadosWS