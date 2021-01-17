package Client;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// El proceso de comunicaci�n es el siguiente .

/*
 * 1.- Establecer la comunicaci�n con el cliente : Se crea un socket.
 * 2.- Se obtienen los flujos de entrada salida
 * 3.- Procesar la informaci�n
 * 4.- Cerrar la conexi�n. 
 */


public class Client extends JFrame{
	   private JTextField campoIntroducir;
	   private JTextArea areaPantalla;
	   private ObjectOutputStream salida;
	   private ObjectInputStream entrada;
	   private String mensaje = "";
	   private String servidorChat;
	   private Socket cliente;
	   
	   public Client (String host){
		    super ("cliente");
		    servidorChat = host; // �C�mo le paso el nombre del host al hacer la llamada?
		    Container contenedor=getContentPane();
		    campoIntroducir = new JTextField();
		    campoIntroducir.setEditable( false );
		    
		  /* Se asocia al objeto campoIntroducir (campo de texto) el evento actionPerformed. El evento actioPerformed
		   * est� implementado en el interfaz ActionListener.
		   * En este caso en lugar de crear una clase  gestionadora de las acciones a realizar cuando se produzca el 
		   * evento ActionListener se crea una clase interna. 
		   *   
		   */
		    campoIntroducir.addActionListener(
		            new ActionListener() {

		               // enviar mensaje al servidor
		               public void actionPerformed( ActionEvent evento )
		               {
		                  enviarDatos(evento.getActionCommand() );
		                  campoIntroducir.setText( "" );
		               }
		            }  
		         ); 

		    /* Ubica el campo de texto en el contenedor seg�n el Gestor de organizaci�n.  
		     * 
		     */
		    contenedor.add( campoIntroducir, BorderLayout.NORTH );

		      // crear areaPantalla
		      areaPantalla = new JTextArea();
		      contenedor.add( new JScrollPane( areaPantalla ),
		       BorderLayout.CENTER );

		      setSize( 300, 150 );
		      setVisible( true );
	   
	   
	   }
	   
	   public void ejecutarCliente(){
		   try {
	         conectarAServidor(); // Paso 1: crear un socket para realizar la conexión
	         obtenerFlujos();      // Paso 2: obtener los flujos de entrada y salida
	         procesarConexion(); // Paso 3: procesar la conexión
		      }catch ( EOFException excepcionEOF ) {// el servidor cerró la conexión
		         System.err.println( "El cliente termino la conexión" );
		      }catch ( IOException excepcionES ) {      // procesar los problemas que pueden ocurrir al comunicarse con el servidor
		         excepcionES.printStackTrace();
		      }finally {
		         cerrarConexion(); // Paso 4: cerrar la conexión
		      }
	   }
	   
	   public void conectarAServidor () throws IOException{
		   /*
		    * Se crea un objeto (cliente) de tipo socket. Uno de los constructores de la clase socket tiene como parametros
		    * la direcci�n IP del servidor al que nos vamos a conectar y el puerto por el cual lo vamos a hacer.
		    * Para recuperar la direcci�n IP del servidor empleamos el m�todo est�tico getByName de la clase InetAddress 
		    * El m�todo InetAddress devuelve la direcci�n IP de un servidor partiendo del nombre de un servidor 
		    */
		   
		   cliente = new Socket( InetAddress.getByName( servidorChat ), 12345 );
	  	   }
	  
	   public void obtenerFlujos()throws IOException{
	       /*
	        * Crea el objeto por el que se efectuar� la salida de los datos desde el cliente
	        */
	        salida = new ObjectOutputStream( cliente.getOutputStream() );
	        salida.flush(); // vaciar buffer de salida para enviar informaci�n de encabezado
	        /*
	         * Crea el objeto por el que se efectuar� la entrada de los datos hacia el cliente
	         */
	        entrada = new ObjectInputStream( cliente.getInputStream() );
	        
	   } 
	   
	   
	   private void procesarConexion() throws IOException{
		   establecerCampoTextoEditable(true);
		   /*
		    * Mientras que al cliente no le llegue el mensaje  "SERVIDOR>>> TERMINAR" 
		    * Se lee el ObjectInputStream. Recordar que el ObjectInputStream recibe los datos a leer provenientes
		    * del servidor.
		    *  
		    */
		   
		   do {
			   try{
		        mensaje = ( String ) entrada.readObject();
		        mostrarMensaje( "\n" + mensaje );
			   }catch  
		   } while(!mensaje.equals( "SERVIDOR>>> TERMINAR" ));
	   }
	   
	   private void establecerCampoTextoEditable( final boolean editable ){
		      // mostrar mensaje del subproceso de ejecución de la GUI
		      SwingUtilities.invokeLater(
		         new Runnable() {  // clase interna para asegurar que la GUI se actualice apropiadamente

		            public void run(){  // establece la capacidad de modificar campoIntroducir
		               campoIntroducir.setEditable( editable );
		            }

		         }  // fin de la clase interna

		      ); // fin de la llamada a SwingUtilities.invokeLater
		   }

public void cerrarConexion(){
	  mostrarMensaje( "\nCerrando conexión" );
      establecerCampoTextoEditable( false ); // deshabilitar campoIntroducir

      try {
         salida.close();
         entrada.close();
         cliente.close();
      }catch( IOException excepcionES ) {
         excepcionES.printStackTrace();
      }
}
private void enviarDatos( String mensaje ){
    // enviar objeto al servidor
    try {
       salida.writeObject( "CLIENTE>>> " + mensaje );
       salida.flush();
       mostrarMensaje( "\nCLIENTE>>> " + mensaje );
    }catch ( IOException excepcionES ) { // procesar los problemas que pueden ocurrir al enviar el objeto
       areaPantalla.append( "\nError al escribir el objeto" );
    }
 }

private void mostrarMensaje( final String mensajeAMostrar ){
    // mostrar mensaje del subproceso de ejecución de la GUI
    SwingUtilities.invokeLater(
       new Runnable() {  // clase interna para asegurar que la GUI se actualice apropiadamente

          public void run(){ // actualiza areaPantalla
             areaPantalla.append( mensajeAMostrar );
             areaPantalla.setCaretPosition( 
             areaPantalla.getText().length() );
          }

       }  // fin de la clase interna

    ); // fin de la llamada a SwingUtilities.invokeLater
 }
}
