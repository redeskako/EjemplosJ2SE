package org.aprende.java.bbdd;

import java.util.*;
import java.io.Serializable;

public class Disconformidad implements Comparable, Serializable{

	private int numero;
	private Date fecha;
	private String motivo;
	private String docs;
	private int servicio;
	private int usuario;
	private boolean devolucion;
	private String comentario;

	//constructores
	public Disconformidad(){
		this.numero = 0;
		this.fecha = null;
		this.docs = null;
		this.servicio = 0;
		this.usuario = 0;
		this.devolucion = false;
		this.motivo = null;
		this.comentario = null;
	}

	public Disconformidad(int numero, int servicio, int usuario, boolean confirmacion){
		this.numero = numero;
		this.fecha = new Date();
		this.docs = "";
		this.servicio = servicio;
		this.usuario = usuario;
		this.devolucion = false;
		this.motivo = "";
		this.comentario = "";
	}

	public Disconformidad(int numero, Date fecha, String doc, int servicio, int usuario, boolean devolucion,String motivo,String comentario){
		this.numero=numero;
		this.fecha=fecha;
		this.docs=doc;
		this.servicio=servicio;
		this.usuario=usuario;
		this.devolucion=devolucion;
		this.motivo=motivo;
		this.comentario=comentario;
	}

	//get y set de las variables de clase
	public boolean devolucion(){
		return devolucion;
	}

	public void devolucion(boolean confirmacion){
		this.devolucion = confirmacion;
	}

	public String docs(){
		return docs;
	}

	public void docs(String doc){
		this.docs = doc;
	}

	public Date fecha(){
		return fecha;
	}

	public void fecha(Date fecha){
		this.fecha = fecha;
	}

	public int numero(){
		return numero;
	}

	public void numero(int numero){
		this.numero = numero;
	}

	public int servicio(){
		return servicio;
	}

	public void servicio(int servicio){
		this.servicio = servicio;
	}

	public int usuario(){
		return usuario;
	}

	public void usuario(int usuario){
		this.usuario = usuario;
	}

	public String motivo(){
		return motivo;
	}

	public void motivo(String motivo){
		this.motivo = motivo;
	}

	public String comentario(){
		return comentario;
	}

	public void comentario(String coment){
		this.comentario = coment;
	}

	//metodos
	public String toString(){
		return " (Numero: " + this.numero + " - Fecha: " + this.fecha + " - Documentos afectados: " + this.docs + " - Servicio: " + this.servicio + " - usuario: " + this.usuario + " - Devolucion: " + this.devolucion + " - Motivo: " + this.motivo + " - Comentario: " + this.comentario +")";
	}

	public int compareTo(Object o){
		Disconformidad d= (Disconformidad) o;
		return this.fecha().compareTo(d.fecha()); //Ordenar por fecha
	}

	public boolean equals(Object o){
		Disconformidad d= (Disconformidad) o;
		//Dos disconformidades son iguales si son iguales todos sus propiedades, excepto el numero por ser clave autonumerica
		//no comparamos el atributo numero porque al ser autonumerico no pueden haber dos disconformidades con el mismo numero
		return ( (this.fecha().equals(d.fecha()) && (this.docs().equals(d.docs())) && (this.servicio()== d.servicio()) && (this.usuario()==d.usuario())));
	}

	//Metodo que devuelve una lista de usuarios
	//Si nos llegan errores de los m�todos abrirConexion y cerrarConexion se lanzan a la clase DisconformidadException
	public ArrayList<Disconformidad> listadoDisconformidades() throws DisconformidadException{
		ArrayList<Disconformidad> miLista;
		BBDD miBd = new BBDD();
		miBd.abrirConexion(); //No hacemos tratamiento de errores porque ya se ha hecho en el m�todo abrirConexi�n
		miLista=miBd.listadoDisconformidades("Select * from Disconformidad");
		miBd.cerrarConexion();//No hacemos tratamiento de errores porque ya se ha hecho en el m�todo abrirConexi�n
		return miLista;
	}
}