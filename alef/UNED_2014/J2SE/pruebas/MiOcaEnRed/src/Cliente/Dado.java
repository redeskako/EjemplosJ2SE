package Cliente;

import java.util.Random;

public class Dado {
	public static int tirarDado(){
		// Se crea una instancia de Random (java.util)
		Random dado = new Random();
		// Se solicita un n�mero entero aleatorio entre 1 y 6
		return dado.nextInt(6)+1;
	}
}
