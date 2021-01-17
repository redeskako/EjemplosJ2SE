/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;

/**
 * casilla del tablero en el juego de la oca. <br/>Como m�ximo s�lo 
 * puede haber un jugador por casilla en un momento dado, a excepci�n 
 * de la casilla de inicio.
 */
public abstract class Casilla {

	/** �ndice. */
	protected int indice;

	/**
	 * devuelve el �ndice correspondiente a la casilla en el tablero
	 *
	 * @return el indice
	 */
	public int getIndice(){
		return indice;
	}

	/** �ndice. */
	protected int indiceDestino;

	/**
	 * devuelve el �ndice al que se redirige al jugador
	 *
	 * @return el �ndice
	 */
	public int getIndiceDestino(){
		return indiceDestino;
	}
	
	/** Jugador. */
	protected Jugador jugador;

	/**
	 * M�todo al que llama el jugador que cae en la casilla.
	 * Como resultado, la casilla actualiza la referencia al jugador que va a ocuparla
	 * as� como el estado del jugador en funci�n del tipo de casilla (normal, castigo o premio)  
	 * @param  jugador jugador que cae en la casilla
	 * @uml.property  name="jugador" 
	 */
	public void setJugador( Jugador jugador ) {
		this.jugador = jugador;		
	}
		
	/**
	 * devuelve el jugador en esta casilla <tt>null</tt> si vac�a.
	 *
	 * @return jugador el jugador
	 * @uml.property name="jugador"
	 * @uml.associationEnd
	 */
	public Jugador getJugador() {
		return this.jugador;
	}

	public void entrar( Jugador jugador ) {
		if ( jugador != null ) {
			Casilla casillaOrigen = jugador.getCasilla();
			casillaOrigen.salir( jugador );
			if ( this.estaOcupada() ) {
				// el jugador debe retroceder a la casilla de partida del jugador que llega
				System.out.println( this.getJugador() + " de vuelta a " +  casillaOrigen );
				casillaOrigen.setJugador( this.getJugador() );
				this.getJugador().setCasilla( casillaOrigen );
				this.getJugador().setRondasSinJugar( 0 );
				this.getJugador().setRepiteTurno( false );
			}
			// actualizamos jugador asociado ...
			this.jugador = jugador;
			jugador.setCasilla( this );
			if ( this.getIndice() != this.getIndiceDestino() ) {
				// desplazamiento
				jugador.desplazar( this.getTablero().getCasilla( this.getIndiceDestino() ) );
			}
		}
	}
	
	public void salir( Jugador jugador ) {
		if( this.jugador != jugador ) {
			System.out.println( this.getTablero().comoTexto() );
			throw new RuntimeException();
		}
		this.setJugador( null );		
	}
		
	/** Tablero. */
	protected Tablero tablero;

	/**
	 * Devuelve el tablero en que se sit�a la casilla.
	 *
	 * @return <tt>Tablero</tt> Devuelve el tablero.
	 * @uml.property name="tablero"
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * Instancia una nueva casilla.
	 *
	 * @param tablero el tablero
	 * @param indice el �ndice en el tablero
	 */
	public Casilla( Tablero tablero, int indice, int indiceDestino ) {
		this.tablero = tablero;
		this.indice = indice;
		this.indiceDestino = indiceDestino;
	}
	
	/**
	 * devuelve <tt>true</tt> si un jugador est� en esta casilla
	 *
	 * @return true, si ocupada
	 */
	public boolean estaOcupada() {
		return this.jugador != null;
	}
	
	public String toString() {
		return "(" + indice + ")";
	}
	
		
} // Casilla
