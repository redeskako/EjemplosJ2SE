package org.BBDD;

public class BBDDException extends RuntimeException{
	
	public BBDDException(){
		super();
	}
	public BBDDException(String err){
		super("\nError en Proyecto1:\n\t"+err); 
	}
}
