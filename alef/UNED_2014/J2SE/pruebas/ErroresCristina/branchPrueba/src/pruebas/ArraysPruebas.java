package pruebas;
import java.util.Arrays;

public class ArraysPruebas {

	public static void main(String[] args){
		String[] array1 = {"Marta", "Miguel", "Symon", "Symon", "Cristina"};
		int posicion;
		
		posicion = Arrays.binarySearch(array1, "Symon");
		System.out.printf("El valor %s se encontr� en la posici�n %d \n", "Symon",  posicion );
		
		posicion = Arrays.binarySearch(array1, "Carlos");
		System.out.printf("El valor %s se encontr� en la posici�n %d \n","Carlos", posicion );
		
		//Para evitar que binarySearch() devuelva valores negativos:
		if (posicion >= 0)
			System.out.printf("El valor %s se encontr� en la posici�n %d \n","Carlos", posicion );
		else
			System.out.printf("El valor %s no se encontr� en el array \n", "Carlos");
		
	}
}
