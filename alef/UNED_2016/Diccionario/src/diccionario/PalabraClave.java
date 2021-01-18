/*
 * Clase PalabraClave lo que hace es encapsular un string llamado palabra que va a contener
 * las palabras clave que luego se buscar�n en cada una de las frases.
 * @author carlos l
 * @version 1.0
 * @exception 
 * @fecha 2016/02/16
 * @licencia 
 * @detalles 
 */

package diccionario;

import java.util.StringTokenizer;

public class PalabraClave implements Comparable<PalabraClave>{

    //Atributos
    private String palabra;

    //M�todos
    /* Constructor de la clase, inicializar la palabra a may�sculas
     * @in String word es la palabra a la que se quiere dar la definci�n
     * @out no procede
     * @err ninguno
     */
    public PalabraClave(String word){
        this.palabra=word.toUpperCase();
    }
    /* Es una sobrecarga del m�todo compareTo que est� en la interfaz
     * Esta comparaci�n no tiene en cuenta diferencias entre may�sculas y min�sculas
     * @in PalabraClave pad que es la palabra de la cual se quiere dar la definici�n
     * @out int dando -1,0,1 seg�n que palabra es mayor seg�n el ASCII, 0 si son iguales
     * @err ninguno
     */
	@Override
	public int compareTo(PalabraClave pad){
		return this.palabra.compareToIgnoreCase(pad.palabra);
	}
	/* Para ver si dos palabras son iguales sin tener en cuenta la diferencia
	 * entre may�sculas y min�sculas.
     * @in PalabraClave pad que es la palabra de la cual se quiere dar la definici�n
     * @out boolean falso si las palabras son diferentes o true si son iguales
     * @err ninguno
     */
	public boolean equals(PalabraClave pad){
        return this.palabra.equalsIgnoreCase(pad.palabra);
    }
	/* Como estas estructuras no tienen un orden predeterminado, se usa este indicador
	 * para distinguir entre ellas y evitar colisiones al almacenar. En principio si 
	 * dos palabras son iguales seg�n el m�todo equals deben tener el mismo hashCode
     * @in 
     * @out int con el hashCode de la palabra.
     * @err ninguno
     */
	public int hashCode(){
        return this.palabra.toUpperCase().hashCode();
    }
	/* Funci�n para acceder la atributo palabra en may�sculas
     * @in 
     * @out String con el atributo en may�sculas
     * @err ninguno
     */
	public String toString(){
	       return this.palabra.toUpperCase();
	   }
	/* Funci�n para resaltar la palabra clave dentro de la frase
     * @in String frase, con la frase a procesar
     * @out String con la frase apa�ada
     * @err ninguno
     */
    public String resaltar(String frase){
        StringTokenizer st=new StringTokenizer(frase);
        String salida="";
        while(st.hasMoreTokens()){
        	PalabraClave token=new PalabraClave(st.nextToken());
            if(this.palabra.equals(token.toString())){
            	salida += "... ";
            }
            else{
            	salida += token +" ";
            }
        }
        return salida;
    }
}
