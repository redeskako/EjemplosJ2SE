package Servidor;

import java.net.*;
import java.io.*;


/**
 * Se define una clase ClienteThread para que el Servidor se comunique a trav�s de conexiones Socket 
 * de manera simult�nea con los diferentes Clientes.
 * 
 * @author	Alef UNED 2014
 * @version	Oca 3.0
 * @fecha 	Mayo 2014
 */
public class ClienteThread extends Thread{
    // Variables necesarias para establecer una conexi�n Socket.
	private Socket socket;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	
	// Identificador del Cliente: el color del jugador
	private Color id;
	
	// Mensaje que puede enviar/recibir
	private Comunicacion comunicacion;

    /**
	 * M�todo constructor: cada hilo se construye con un �nico par�metro: la conexi�n socket del Cliente.
	 * @param Socket del Cliente que se acaba de conectar
	 * @return null
	 * @throws null
	 */
    public ClienteThread (Socket s, Color c){
    	// Se asigna la conexi�n recibida como par�metro a la variable socket
    	this.socket = s;
    	// Se asigna el color como id de la conexi�n
    	this.id = c;
    	
    	// Canales de entrada y salida
    	// Se informa en la GUI:
    	Servidor.getServidorGUI().infoConexiones("Intentando establecer los canales de entrada y salida de datos");
    	// Se crean los canales:
    	try{
    		this.entrada = new ObjectInputStream(socket.getInputStream());
    		this.salida = new ObjectOutputStream(socket.getOutputStream());
    		Servidor.getServidorGUI().infoConexiones("El Jugador " + this.id + " se ha conectado al Servidor.");
    	} catch (IOException e) {
    		Servidor.getServidorGUI().infoConexiones("Se ha producido un error al establecer "
    				+ "los canales de entrada y salida de datos");
        }
    }

    
    
    
    
    
    
    
    public void cerrar(){
    	try{
	    	this.entrada.close();
	    	this.salida.close();
	    	this.socket.close();
    	} catch (IOException e){
    		Servidor.getServidorGUI().infoConexiones("Se ha producido un error al cerrar la conexi�n con el Cliente " + this.id);
    	}
    }

	public Color getColorId() {
		return id;
	}

}
