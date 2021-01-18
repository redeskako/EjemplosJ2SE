/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Apicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;


// TODO: Auto-generated Javadoc
/**
 * Clase CasillaOca.
 */
public class CasillaMuerte extends CasillaDesplazamiento {
	
	/* (non-Javadoc)
	 * @see oca.CasillaDesplazamiento#setJugador( Jugador jugador )
	 */
	@Override
	public void entrar( Jugador jugador ) {				
		super.entrar( jugador );
		System.out.println( "Vuelves a la casilla de inicio." );
		// vuelve a tirar ( falso )
		jugador.setRepiteTurno( false );		
	}
		
	/**
	 * Instancia una nueva casilla muerte.
	 *
	 * @param tablero tablero del juego
	 * @param indice �ndice asignado a esta casilla
	 * @param destino casilla de destino
	 */
	public CasillaMuerte( Tablero tablero, int indice ) {
		super( tablero, indice, 1 );
	}

}