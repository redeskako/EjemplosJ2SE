/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;

public abstract class Tablero {

	/**
	 * @uml.property  name="totalCasillas" readOnly="true"
	 */
	private final int totalCasillas;

	/**
	 * M�todo getter de la propiedad <tt>totalCasillas</tt>
	 * @return Devuelve el n�mero de casillas que contiene el tablero.
	 * @uml.property name="totalCasillas"
	 */
	public int getTotalCasillas() {
		return totalCasillas;
	}

	/**
	 * @uml.property name="casillas"
	 */
	private Casilla[] casillas;

	/**
	 * M�todo getter de la propiedad <tt>casillas</tt>
	 * @return Devuelve el conjunto de casillas que contiene el tablero.
	 * @uml.property name="casillas"
	 */
	public Casilla[] getCasillas() {
		return casillas;
	}

	/**
	 * M�todo setter de la propiedad <tt>casillas</tt>
	 * @param casillas Conjunto de casillas que se asigna.
	 * @uml.property name="casillas"
	 */
	public void setCasillas( Casilla[] casillas ) {
		this.casillas = casillas;
	}

	/**
	 * Devuelve la casilla a partir de su �ndice
	 * @return una casilla
	 */
	public Casilla getCasilla( int indice ) {
		return this.getCasillas()[ indice - 1 ];
	}

	/**
	 * Devuelve siguiente casilla a partir de un desplazamiento
	 * @return una casilla
	 */
	public abstract Casilla getCasilla( Casilla casilla, int desplazamiento );
	
	/**
	 * Devuelve la casilla donde se comienza la partida
	 * @return casilla inicio
	 */
	public abstract CasillaInicio getCasillaInicio();	

	/**
	 * Devuelve la casilla donde que se debe alcanzar para ganar la partida
	 * @return casilla final
	 */
	public abstract Casilla getCasillaFinal();	
	
	/**
	 * @uml.property name="juego"
	 */
	private Juego juego;

	/**
	 * M�todo getter de la propiedad <tt>juego</tt>
	 * @return Devuelve instancia de Juego asociada con el tablero.
	 * @uml.property name="juego"
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * M�todo setter de la propiedad <tt>juego</tt>
	 * @param juego Instancia de Juego que se asocia al tablero.
	 * @uml.property name="juego"
	 */
	public void setJuego( Juego juego ) {
		this.juego = juego;
	}

	/**
	 */
	public Tablero( int totalCasillas ) {
		this.totalCasillas = totalCasillas;
	}

	/**
	 * inicializar casillas de tablero
	 */
	public abstract void inicializarTablero();
		
	@Override
	public String toString() {
		String cadena = "";
		for ( Casilla casilla: this.getCasillas() ){ cadena += " -> "+ casilla; }
		return cadena;
	}
	
	/**
	 * 
	 * @return representaci�n del tablero como cadena de texto
	 */
	public String comoTexto(){
		String cadena = "";
		for ( Casilla casilla: this.getCasillas() ) {
			if( casilla.estaOcupada() ) {
				cadena += casilla.getJugador();
			}
			else cadena += "-"; }
		return cadena;
	}
}