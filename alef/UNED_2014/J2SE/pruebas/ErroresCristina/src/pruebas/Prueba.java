package pruebas;

import java.util.Scanner;

public class Prueba {
	
	Scanner entrada = new Scanner(System.in);
	private char color;
	private int talla;
	
	//constructores:
	public Prueba(char x, int y){
		if(y<0){
			throw new ClaseError("tama�o introducido < 0");
		}
		if(x!='a' && x!='e' && x!='i' && x!='o' && x!='u'){
			Throwable causa = new Throwable ("Ha pasado porque los colores s�lo son aeiou.");
			throw new ClaseError("color introducido no v�lido", causa);
		}
		if(y<0){
			throw new ClaseError("valor introducido <= 0");
		}
		this.color = x;
		this.talla = y;
	}
	
	public Prueba(char x){
		if(x!='a' && x!='e' && x!='i' && x!='o' && x!='u'){
			Throwable causa = new Throwable ("Ha pasado porque los colores s�lo son aeiou.");
			throw new ClaseError("color introducido no v�lido", causa);
		}
		this.color = x;
		this.talla = 1;
	}
	
	public Prueba(int y){
		if(y<0){
			throw new ClaseError("valor introducido <= 0");
		}
		this.color = 'a';
		this.talla = y;
	}
	
	//getter de talla:
	public int getTalla(){
		return talla;
	}
	//getter de color:
	public int getColor(){
		return color;
	}
		
	
}// fin calse Prueba
