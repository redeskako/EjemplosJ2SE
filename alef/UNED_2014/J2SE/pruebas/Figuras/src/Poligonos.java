
public abstract class Poligonos {
	/* �Por qu� se define la clase Poligonos como abstracta?. Simplemente porque 
	 * tiene un m�todo que es abstracto. En este caso el m�todo area. En una clase
	 * abstracta puede haber m�s de un m�todo abstracto.Una clase es abstracta cuando tiene
	 * al menos un m�todo abstracto. Si una clase tiene todos sus m�todos abstractos se dice que
	 * es un interface, pero esto lo va a explicar Carlos.
	 * 
	 * �Cuando se dice que un m�todo es abstracto?. Cuando solamente se define
	 * el nombre, los parametros que recibe para su ejecuci�n y el tipo de valor que
	 * devuelve.NO HAY FUNCIONALIDAD.NO TIENE DEFINIDO EL CUERPO.
	 * 
	 * �Para que se definen los m�todos abstractos. Por cuestiones de dise�o. Al emplear un m�todo 
	 * abstracto, el dise�ador de la aplicaci�n obliga al programador a definir la funcionalidad del
	 * m�todo abstracto, pero le deja total libertad a como hacerlo. Solamente le obliga a utilizar un
	 * determinado nombre y a que devuelva un determinado tipo de valor.  
	 * 
	 * 
	 * De una clase abstracta no se pueden crear objetos. Es decir no se puede hacer
	 * Poligono obj = new Poligono();
	 */
	
	
	private String color;
	
	public Poligonos(String arg){
	  this.color=arg;
	}

	public abstract double area();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
		
	
	
}
