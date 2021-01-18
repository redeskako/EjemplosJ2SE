package es.uned2013.parchis;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Crea el tablero donde se jugarÃ¡ la partida, situando
 * las fichas de los jugadores en su posiciÃ³n inicial e
 * inicializando todas las casillas.
 * Controla durante el juego, todo lo 'fÃ­sico' del juego
 * colocar y mover fichas de una casilla a otra e informando
 * al jugador de las nuevas situaciones del juego que
 * provoca el movimiento de las fichas. 
 * @author alef
 *
 */

public class Tablero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean juegoFinalizado = false; // 'true' cuando todas las fichas del jugador estÃ¡n en la casilla final
	private HashMap<Integer,Casilla> juego = new HashMap<Integer,Casilla>(); // Tablero del juego actual

	/**
	* Crea todas las casillas del tablero e inicializa los
	* atributos casillaActual, casillaCasa, casillaFinal y
	* casillaSalida de cada ficha.
	*
	* @param fichas: ArrayList<Ficha>, arraylist de fichas a mover
	*
	*/ 
	public Tablero(ArrayList<Ficha> fichas){
		
		int[] arrayCasillaSeguro={12, 17, 29, 34, 46, 51, 63, 68};
		int[] arrayCasillaSalida={Colores.AMARILLO.getCasillaSalida(), Colores.AZUL.getCasillaSalida(), Colores.ROJO.getCasillaSalida(), Colores.VERDE.getCasillaSalida()};
		//Inicializamos las casilla casa de los jugadores, la salida y el pasillo
		for (Colores c: Colores.values())
		{
			if (c != Colores.NEUTRO)
			{
				//Casilla casa del color
				juego.put(c.getCasillaCasa(), new Casilla(c, c.getCasillaCasa(), true, false, false, false, false, false, 0));
				// casilla salida del color
				juego.put(c.getCasillaSalida(), new Casilla(c, c.getCasillaSalida(), false, false, true, true, false, false, 0));
				//Casilla pasillo del color
				for (int x = 0; x < 8; x++) 
					juego.put(c.getCasillaInicioPasillo()+x, new Casilla(c, c.getCasillaInicioPasillo()+x, false, false, false, false, true, false, 0));
				//Ãšltima casilla del jugador
				juego.put(c.getCasillaFinal(), new Casilla(c, c.getCasillaFinal(), false, true, false, false, true, false, 0));
			}
		}
		// Creamos las casillas de la 1 a la 68 (excepto las de salida que ya han sido inicializadas)
		for (int i = 1; i<= 68;i++)
		{
			//Si es un seguro
			if (Arrays.binarySearch(arrayCasillaSeguro, i) >= 0)
				juego.put(i, new Casilla(Colores.NEUTRO, i, false, false, true, false, false, false, 0));
			else if (Arrays.binarySearch(arrayCasillaSalida, i) < 0) // No es una de las casilla salida
				juego.put(i, new Casilla(Colores.NEUTRO, i, false, false, false, false, false, false, 0));
		}	
		//Ahora inicializamos las casillas donde hay una ficha colocada
		for (int i=0; i < fichas.size();i+=4)
		{
			//Primera ficha en la casilla de salida del color
			juego.get(fichas.get(i).getCasillaActual()).setTieneFicha(1);
			juego.get(fichas.get(i).getCasillaActual()).setFicha1(fichas.get(i));
			//Actualizamos la casilla casa con tres fichas
			juego.get(fichas.get(i).getCasillaCasa()).setTieneFicha(3);
		}
		
	}
	
	/**
	* Comprueba si en el recorrido de la ficha existe alguna
	* casilla con barrera o la casilla final.
	*
	* @param  fic ficha a mover
	* @param  avance valor del dado a avanzar
	* @return boolean que define si es movible o no
	* 
	* Si la ficha se encuentra en la casilla de salida solo
	* sera movible si -> avances=5 y en la casilla salida de
	* la ficha no se encuentran dos fichas de su mismo color.
	* 
	* Una vez en el pasillo, para llegar a la meta el jugador debe tener 
	* las posiciones exactas hasta la meta, si no, la ficha no es movible
	* 
	* comprobamos si:
	* 1- la ficha se encuentra en la casilla de casa (salida) ,
	* 2- si se ha sacado un 5 y  
	* 3- si no estÃ¡ bloqueada la casilla de salida
	*/
	public boolean esMovible(Ficha fic, int avances){
		
		boolean movible = true;
		int i=0;
		int sig = 0;
		
		if ((fic.getCasillaActual()== fic.getCasillaCasa()) && (avances!=5)){
			movible = false;
		}
		else if (fic.getCasillaActual()== fic.getCasillaFinal()){
			movible = false;
		}
		else if((fic.getCasillaActual()== fic.getCasillaCasa()) && (avances==5) && juego.get(fic.getCasillaSalida()).isEsBarrera() && juego.get(fic.getCasillaSalida()).getFicha1().getColor() == fic.getColor()){ 
			//si:la ficha esta en casa y ha salido un 5 y hay una barrera en la casilla salida               
			//y la barrera es del mismo color que la ficha -> no es movible.
			movible = false;			
		}
		//En este condicional se revisa si es una casilla de pasillo. 
		//En este caso solo podra moverse si el numero de avances corresponde con el numero de casillas restantes hasta meta
		else if (juego.get(fic.getCasillaActual()).isEsPasillo() && (avances != (fic.getCasillaFinal()-fic.getCasillaActual()) ) ){
			if (fic.getCasillaFinal()-fic.getCasillaActual() != 6) movible = false; //para que no se bloquee la partida con la ultima ficha a 6 casillas de meta
		}
		//Si es una ficha movible en casa no consultamos si hay barreras en su avance
		else if (fic.getCasillaActual() != fic.getCasillaCasa()){
			//Consultamos si hay barreras en sus X avances
			sig = juego.get(fic.getCasillaActual()).siguiente(fic); //posicionamos el puntuero en la casilla actual para empezar a iterar // CORRIJO
			do{
				//realizamos el bucle dando por hecho que se podrÃ¡ mover hasta que encontremos alguna barrera en el camino, en ese caso movible = false y saldrÃ¡ del bucle
				if (juego.get(sig).isEsBarrera()){
					movible = false;
				}
				// Si he llegado a la Ãºltima casilla y todavÃ­a quedan movimientos, no es movible.
				else if (juego.get(sig).isEsUltima() && avances > i+1){
					movible = false;
				}
				//Si he llegado a la ÃƒÂºltima casilla y todavÃƒÂ­a quedan movimientos, no es movible.
				//Esto sÃ³lo pasa si me cuento 20 Ã³ 10 con una ficha
				else if ((i == avances - 1) && (juego.get(sig).getTieneFicha() == 2) && ((!juego.get(sig).isEsUltima()))){
					movible = false;
				}
				sig = juego.get(sig).siguiente(fic); 
				i++;
			}while( avances > i && movible == true );
			
		}
		return movible;
	}
	
	/**
	* Actualiza la casilla donde se encuentra la ficha
	* actualmente y la ficha donde se mueve.
	* Actualiza el atributo 'casillaActual' de la ficha.
	* @param jug jugador en turno
	* @param fic ficha a mover
	*
	* Si la ficha se mueve a una casilla donde existe 
	* otra ficha:
	* - si es del mismo color, forma barrera.
	* - si es de otro color y no es una casilla seguro
	*   -> jugador.movimientoAdicional = true
	*   -> jugador.tirada = 20
	*   
	* Si se mueve a la casilla final de la ficha, y ademÃ¡s
	* su casilla final tiene tres fichas
	*  -> juegoFinalizado = true
	* si no  
	*  -> jugador.movimientoAdicional = true
	*  -> jugador.tirada = 10
	*/
	public void mueve(Jugador jug, Ficha fic)  throws RemoteException{

		int sig = fic.getCasillaActual();
		for (int i=0; i< jug.getTirada() ;i++ ){
			if (juego.get(sig).getNumero() != fic.getCasillaFinal())
				sig = juego.get(sig).siguiente(fic);
		}
		
		//EstÃ¡ en la casa
		if (fic.getCasillaActual()==fic.getCasillaCasa())
		{
			this.sacaFicha(jug, fic);
		}
		else{
			if (juego.get(sig).getNumero() == fic.getCasillaFinal()){
				if (juego.get(sig).getTieneFicha() == 3){
					//Juego finalizado, han llegado todas las casillas a su destino
					this.juegoFinalizado= true; 
				}
				else{
					//Ha llegado a meta pero no es la final
					jug.setMovimientoAdicional(true); 
					jug.setTirada(10);
				}
				
			}
			else if (juego.get(sig).getTieneFicha() == 1){
				//El movimiento es hacia una casilla con ficha
				if (juego.get(sig).getFicha1().getColor() == fic.getColor()){
					//Si la ficha es del mismo color, forma barrera
					juego.get(sig).setEsBarrera(true);
				}
				//Las fichas son de colores diferentes
				else{
					//Compruebo que no sea un seguro
					if (!juego.get(sig).isEsSeguro())
					{
						//Las fichas son de diferentes colores, por lo que en este caso come ficha
						fichaComida(juego.get(sig).getFicha1());
						jug.setMovimientoAdicional(true); 
						jug.setTirada(20);
					}
				}
			}
			//Lo Ãºnico que nos queda es actualizar las casillas
			juego.get(fic.getCasillaActual()).setEsBarrera(false); //desbloqueamos una posible barrera en la casilla anterior
			juego.get(sig).colocarFicha(fic);//posicionamos la ficha en la casilla nueva
			juego.get(fic.getCasillaActual()).quitarFicha(fic);//quitamos la ficha de la casilla anterior
			fic.setCasillaActual(sig);//se actualiza la casilla actual de la ficha
		}
		
		// Actualizamos el interfaz CONSOLA o GUI
		Parchis.getUI().moverFicha(juego.get(sig), fic);
	}
	
	/**
	* Gestiona el proceso de comer ficha
	* @param fic ficha comida
	*
	* Actualiza el atributo 'casillaActual' de la ficha.
	* Actualiza la casilla donde se encuentra la ficha
	* actualmente y la casilla a donde se mueve.
	*/
	public void fichaComida(Ficha fic)  throws RemoteException{
		//Si nos hemos comido la primera ficha que llegï¿½
		if (fic.getIdentificador() == juego.get(fic.getCasillaActual()).getFicha1().getIdentificador())
		{
			//si hay dos en mi casa y una no es de mi color siempre me voy a comer esa
			if (juego.get(fic.getCasillaActual()).getTieneFicha() == 2)
			{
				juego.get(fic.getCasillaActual()).setFicha1(juego.get(fic.getCasillaActual()).getFicha2());
				juego.get(fic.getCasillaActual()).setFicha2(null);
			}
			else
				juego.get(fic.getCasillaActual()).setFicha1(null);
		}
		//Si hay dos fichas y nos hemos comido la segunda
		else
			juego.get(fic.getCasillaActual()).setFicha2(null);
		
		//Si habï¿½a barrera: Podrï¿½a darse este caso si en la casilla de salida tuvieramos dos fichas del mismo color 
		//y nos saliese un cinco y tuvieramos que sacar la ficha.
		if (juego.get(fic.getCasillaActual()).isEsBarrera())
			juego.get(fic.getCasillaActual()).setEsBarrera(false);
		//Ahora hay una ficha menos
		juego.get(fic.getCasillaActual()).setTieneFicha(juego.get(fic.getCasillaActual()).getTieneFicha()-1);
		
		//Actualizamos ahora la casilla a la que va la ficha: casilla casa
		juego.get(fic.getColor().getCasillaCasa()).setTieneFicha(juego.get(fic.getColor().getCasillaCasa()).getTieneFicha()+1);
		//Por ï¿½ltimo actualizamos la ficha
		fic.setCasillaActual(fic.getColor().getCasillaCasa());
		
		// Actualizamos el interfaz CONSOLA o GUI
		Parchis.getUI().comerFicha(fic, juego.get(fic.getCasillaActual()));
	}
	
	/**
	* Establece el movimiento de salida de una ficha de una casilla y
	* las consecuencias de sacar la ficha.
	* @param jug jugador al que pertenece la ficha
	* @param fic ficha a sacar de la casilla
	* 
	* Actualiza el atributo 'casillaActual' de la ficha.
	* Actualiza la casilla donde se encuentra la ficha
	* actualmente y la ficha donde se mueve.
	* 
	* Si en la salida, la casilla salida tiene dos fichas
	* y la 'ficha2' de la casilla actual no es del mismo 
	* color:
	*   fichaComida(Ficha ficha2)
	*   Jugador.movimientoAdicional = true
	*   Jugador.tirada = 20
	*/
	public void sacaFicha(Jugador jug, Ficha fic) throws RemoteException{	
		//Actualizamos la casilla donde se encontraba la ficha: casilla casa
		juego.get(fic.getCasillaActual()).setTieneFicha(juego.get(fic.getCasillaActual()).getTieneFicha()-1);
		
		//Si tiene dos fichas la casilla salida nos tenemos que comer una
		if (juego.get(fic.getCasillaSalida()).getTieneFicha() == 2)
		{
			//Mandamos la ficha a su casa: comprobamos si hay alguna que es de nuestro color
			//Si ninguna es de nuestro color nos comeremos la ï¿½ltima en llegar
			if (juego.get(fic.getCasillaSalida()).getFicha2().getColor() != fic.getColor())
				this.fichaComida(juego.get(fic.getCasillaSalida()).getFicha2());
			else
				this.fichaComida(juego.get(fic.getCasillaSalida()).getFicha1());
			//Actualizamos la segunda ficha como la nuestra
			juego.get(fic.getCasillaSalida()).setFicha2(fic);
			//Si la otra ficha es del mismo color se forma barrera
			if (juego.get(fic.getCasillaSalida()).getFicha1().getColor() == fic.getColor())
				juego.get(fic.getCasillaSalida()).setEsBarrera(true);
			jug.setMovimientoAdicional(true);
			jug.setTirada(20);		
		}
		//NO nos tenemos que comer ninguna ficha
		else
		{
			if (juego.get(fic.getCasillaSalida()).getTieneFicha()==1)
			{
				juego.get(fic.getCasillaSalida()).setFicha2(fic);
				//Si es una ficha del mismo color que la que intentamos sacar: forman barrera
				if (juego.get(fic.getCasillaSalida()).getFicha2().getColor() == juego.get(fic.getCasillaSalida()).getFicha1().getColor())					
					juego.get(fic.getCasillaSalida()).setEsBarrera(true);
			}
			//NO habï¿½a ninguna ficha
			else
				juego.get(fic.getCasillaSalida()).setFicha1(fic);
		}
		juego.get(fic.getCasillaSalida()).setTieneFicha(juego.get(fic.getCasillaSalida()).getTieneFicha()+1);
		//Sacamos la ficha a la casilla de salida
		fic.setCasillaActual(fic.getCasillaSalida());
		
		// Actualizamos el interfaz CONSOLA o GUI
		Parchis.getUI().moverFicha(juego.get(fic.getCasillaSalida()), fic);
	}
	
	/**
	* Devuelve la casilla que corresponde
	* a un nÃºmero de casilla concreto
	* @param numero nÃºmero de casillaI
	* @return casilla requerida en funciÃƒÂ³n del identificador entrada
	*/
	public Casilla getCasilla(int numero) {
		return (juego.get(numero));
	}

	


	
	
}