/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;

// TODO: Auto-generated Javadoc
/**
 * Clase CasillaInicio.
 */
public class CasillaFinal extends Casilla {

	/** �ndice. */
	protected int indice;

	/**
	 * devuelve el �ndice de la casilla.
	 *
	 * @return el indice
	 */
	public int getIndice() {
		return indice;
	}

	/** Jugador. */
	protected Jugador jugador;

	/**
	 * sit�a un jugador en la casilla.
	 *
	 * @param jugador jugador que llega a la casilla
	 * @uml.property name="jugador"
	 */
	public void entrar( Jugador jugador ) {		
		super.entrar( jugador );
		// turnos de penalizaci�n ( ninguno )
		jugador.setRondasSinJugar( 0 );
		// vuelve a tirar ( falso )
		jugador.setRepiteTurno( false );
	}
			
	/**
	 * Instancia una nueva casilla final.
	 *
	 * @param tablero el tablero
	 * @param indice el �ndice en el tablero
	 */
	public CasillaFinal( Tablero tablero, int indice ) {
		super( tablero, indice, indice );		
	}		
}	