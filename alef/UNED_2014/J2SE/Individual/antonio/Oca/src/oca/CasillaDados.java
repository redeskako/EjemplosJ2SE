/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;


// TODO: Auto-generated Javadoc
/**
 * Clase CasillaDados.
 */
public class CasillaDados extends CasillaDesplazamiento {

	/* (non-Javadoc)
	 * @see oca.CasillaDesplazamiento#setJugador( Jugador jugador )
	 */
	@Override
	public void entrar( Jugador jugador ) {				
		super.entrar( jugador );
		System.out.print( "De dado a dado y tiro porque me ha tocado." );
	}
		
	/**
	 * Instancia una nueva casilla dados.
	 *
	 * @param tablero tablero del juego
	 * @param indice �ndice asignado a esta casilla
	 * @param destino casilla donde se avanza o retrocede (de tipo dados)
	 */
	public CasillaDados( Tablero tablero, int indice, int indiceDestino ) {
		super( tablero, indice, indiceDestino );
	}

}