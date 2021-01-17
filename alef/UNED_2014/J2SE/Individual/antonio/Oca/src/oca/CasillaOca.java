/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;


// TODO: Auto-generated Javadoc
/**
 * Clase CasillaOca.
 */
public class CasillaOca extends CasillaDesplazamiento {

	/* (non-Javadoc)
	 * @see oca.CasillaDesplazamiento#setJugador( Jugador jugador )
	 */
	@Override
	public void entrar( Jugador jugador ) {				
		super.entrar( jugador );
		System.out.println( "de oca a oca y tiro porque me toca." );
	}
		
	/**
	 * Instancia una nueva casilla oca.
	 *
	 * @param tablero tablero del juego
	 * @param indice �ndice asignado a esta casilla
	 * @param destino casilla de destino
	 */
	public CasillaOca( Tablero tablero, int indice, int indiceDestino ) {
		super( tablero, indice, indiceDestino );
	}
}