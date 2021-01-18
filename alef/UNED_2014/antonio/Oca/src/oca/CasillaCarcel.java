/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;


// TODO: Auto-generated Javadoc
/**
 * Clase CasillaCarcel.
 */
public class CasillaCarcel extends CasillaEspera {

	private static final int RONDAS_ESPERA = 3; 
	
	/* (non-Javadoc)
	 * @see oca.CasillaEspera#setJugador( Jugador jugador )
	 */
	@Override
	public void entrar( Jugador jugador ) {
		System.out.println( "A la sombra durante " + RONDAS_ESPERA + " rondas." );
		super.entrar( jugador );
	}
		
	/**
	 * Instancia una nueva casilla c�rcel.
	 *
	 * @param tablero tablero del juego
	 * @param indice �ndice asignado a esta casilla
	 */
	public CasillaCarcel( Tablero tablero, int indice ) {
		super( tablero, indice, RONDAS_ESPERA );
	}

}