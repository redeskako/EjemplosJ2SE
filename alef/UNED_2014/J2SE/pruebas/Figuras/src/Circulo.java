
public class Circulo extends Poligonos {
	/* En esta clase adem�s del concepto de herencia utilizamos
	 * el m�todo est�tico PI de la clase Math.
	 * Recordad lo que dijo Carlos en la �ltima sesi�n. Los m�todo estaticos 
	 * se asocian a la clase y no al objeto. Por tanto no hace falta crear un objeto
	 * de una determinada clase para su utilizaci�n. Se utilizan con la clase directamente.
	 * Como la clase Math pertenece al paquete java lang no es necesario hacer ningun import
	 * al comienzo. 
	 * 
	 */
	private int radio;
	
	public Circulo(int radio, String color){
		   super(color);
		   this.radio=radio;
		}
	
	public double area(){
		return Math.PI*radio*radio;
	}
	
	
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
}
