/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;

// TODO: Auto-generated Javadoc
/**
 * Clase CasillaEspera.
 */
public class CasillaEspera extends Casilla {

	/** Rondas de penalizaci�n. 
	 * @uml.property name="rondasEspera" */
	private int rondasEspera;
		
	/**
	 * M�todo getter de la propiedad <tt>rondasEspera</tt>.
	 *
	 * @return Devuelve las rondas de penalizaci�n.
	 * @uml.property name="rondasEspera"
	 */
	public int getRondasEspera() {
		return rondasEspera;
	}

	/* (non-Javadoc)
	 * @see oca.Casilla#setJugador(int)
	 */
	public void entrar( Jugador jugador ) {
		super.entrar( jugador );		
		// turnos de penalizaci�n
		jugador.setRondasSinJugar( rondasEspera );
		System.out.print( this.getRondasEspera() + " rondas sin tirar" );
		// vuelve a tirar
		jugador.setRepiteTurno( false );		
	}
			
	/**
	 * Instancia una nueva casilla de espera.
	 *
	 * @param juego el juego
	 * @param indice �ndice casilla
	 * @param turnosEspera turnos penalizaci�n
	 */
	public CasillaEspera( Tablero tablero, int indice, int rondasEspera ) {
		super( tablero, indice, indice );
		this.rondasEspera = rondasEspera;
	}		
}
