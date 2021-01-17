/**
* 2014, Antonio Jes�s Arquillos �lvarez
* M�ster en Dise�o y Desarrollo de Aplicaciones Web
* Universidad Nacional de Educaci�n a Distancia
*/

package oca;

// TODO: Auto-generated Javadoc

/**
 * Clase que representa a cada jugador que participa en la partida.
 * Guarda los principales campos de informaci�n de identificaci�n y estado
 * relativos al jugador, como su nombre, turno asignado y su situaci�n en 
 * la partida.
 * De cara a una ampliaci�n para juego en red distribuido puede pensarse
 * en los objetos jugador como representates o proxies de los jugadores
 * f�sicos conectados a la misma partida, con campos relativos a la conexi�n
 * (direcci�n IP, puerto y socket con sus correspondientes streams de entrada 
 * y salida)  
 * Jugador.
 */
public class Jugador {
    
	/** nombre del jugador.
     * @uml.property name="nombre" 
     */	
    private String nombre;

    /**
     * Devuelve el nombre del jugador.
     *
     * @return <tt>String</tt> nombre del jugador
     * @uml.property name="nombre"
     */
    public String getNombre() { 
       return this.nombre; 
    }
    
    /** Turno asignado al jugador en la partida.
     * @uml.property name="turno" 
     */	
    private int turno;

    /**
     * Devuelve el turno del jugador.
     *
     * @return <tt>int</tt> turno del jugador
     * @uml.property name="turno"
     */
    public int getTurno() { 
       return this.turno; 
    }

	/** casilla donde se encuentra el jugador. 
     * @uml.property name="casilla"
     * @uml.associationEnd */
    private Casilla casilla;    

    /**
     * Devuelve la casilla donde se encuentra el jugador.
     *
     * @return <tt>Casilla</tt> Casilla actual del jugador
     * @uml.property name="casilla"
     */
    public Casilla getCasilla() { 
       return this.casilla ; 
    }

    /**
     * Establece la casilla en la que se va a situar el jugador.
     *
     * @param casilla casilla destino 
     * @uml.property name="casilla"
     */
    public void setCasilla(Casilla casilla) { 
       this.casilla = casilla; 
    }    

    /** Rondas de penalizaci�n por caer en casilla castigo.
     * @uml.property  name="turnosSinJugar" 
     */	
    private int rondasSinJugar = 0;

    /**
     * Devuelve el n�mero de rondas que a�n deber� esperar el jugador.
     *
     * @return <tt>int</tt> rondas que restan sin posesi�n de turno 
     * @uml.property name="rondasSinJugar"
     */
    public int getRondasSinJugar() { 
       return this.rondasSinJugar; 
    }

    /**
     * Establece el n�mero de rondas sin turno.
     *
     * @param <tt>int</tt> rondas que restan sin posesi�n de turno 
     * @uml.property name="rondasSinJugar"
     */
    public void setRondasSinJugar( int rondasSinJugar ) { 
       this.rondasSinJugar = rondasSinJugar; 
    }
    
    /** Indicador de que el jugador debe seguir tirando.
     * @uml.property  name="repiteTurno" 
     */	
    private boolean repiteTurno = false;

    /**
     * Devuelve si el jugador debe volver a lanzar los dados.
     *
     * @return <tt>boolean</tt> cierto si debe volver a tirar; falso en caso contrario 
     * @uml.property name="repiteTurno"
     */
    public boolean getRepiteTurno() { 
       return this.repiteTurno; 
    }

    /**
     * Actualiza indicador de volver a jugar.
     *
     * @param <tt>boolean</tt> cierto si debe volver a tirar; falso en caso contrario
     * @uml.property name="repiteTurno"
     */
    public void setRepiteTurno( boolean repiteTurno ) { 
       this.repiteTurno = repiteTurno; 
    }

    /**
     * Consulta si el jugador ha ganado la partida
     * @return <tt>boolean</tt> cierto si ha ganado la partida; falso en caso contrario 
     * @uml.property name="haGanado"
     */
    public boolean esGanador() { 
       return ( this.getCasilla() == this.getCasilla().getTablero().getCasillaFinal() ) ; 
    }
    
    /**
     * Constructor. Instancia un nuevo jugador.
     *
     * @param nombre nombre del jugador
     * @param turno turno asignado
     * @param casilla casilla de inicio del jugador
     */
    public Jugador ( String nombre, int turno, Casilla casilla ){
        this.nombre = nombre;
        this.turno = turno;
        this.casilla = casilla;
    }
    
    /**
     * tirada de los dados.
     *
     * @return resultado aleatorio de tirar dos dados
     */ 	
    public int tirarDados() {
    	int resultado = 0; 
		for( Dado dado : casilla.getTablero().getJuego().getDados() ){
			dado.tirar();
			resultado += dado.getUltimaTirada();
		}    	
        return resultado;
    }

    public void jugarTurno() {
    	System.out.println( "Es mi turno (" + this + ")" );
    	System.out.println( "Tiro los dados" );
    	int tirada = tirarDados();
    	System.out.println( "Saco " + tirada + " puntos" );
    	casilla.getTablero().getCasilla( casilla, tirada ).entrar( this );
    	System.out.println( "Termino en la casilla " + casilla );
    }
    
    public void desplazar( Casilla casilla ) {
    	this.getCasilla().setJugador( null );
    	this.casilla = casilla;
    	casilla.setJugador( this );
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() { return nombre; }

    
} // Jugador
