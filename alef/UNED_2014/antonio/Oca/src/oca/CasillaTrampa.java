/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;

// TODO: Auto-generated Javadoc
/**
 * Clase CasillaTrampa.
 */
public class CasillaTrampa extends CasillaEspera {

	/**
	 * Instancia una nueva CasillaTrampa.
	 *
	 * @param juego referencia a juego
	 * @param indice �ndice de esta casilla
	 */
	public CasillaTrampa( Tablero tablero, int indice, int rondas ) {
		super( tablero, indice, rondas );
	}
	
	/* (non-Javadoc)
	 * @see oca.CasillaCastigo#setJugador(oca.Jugador)
	 */
	@Override
	public void entrar(Jugador jugador) {
		super.entrar( jugador );
		System.out.println( "caes en el vac�o. Debes esperar a otro jugador para salir" );
	}
}