package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Representa un Healthtopic relacionado con el Healthtopic
 * principal.
 * Cada 'Healthtopic' puede tener '0' o m�s de un valor asociado.
 * @author alef
 */
/*
public class Relatedtopic implements Serializable {

	private static final long serialVersionUID = 1L;

	private int healthTopic_Id;//Id. del Healthtopic principal

	private int idRelatedTopic;//Id. del Healthtopic relacionado

	private String name;//Nombre del Healthtopic relacionado

	private String url;//URL del Healthtopic relacionado

	//Cosntructores
	public Relatedtopic() {
	}
	
	public Relatedtopic(int ht_id, int rel_id, String n, String u){
		this.healthTopic_Id = ht_id;
		this.idRelatedTopic = rel_id;
		this.name = n;
		this.url = u;
	}
	//Getters and Setters
	public int getHealthTopic_Id() {
		return this.healthTopic_Id;
	}
	public void setHealthTopic_Id(int healthTopic_Id) {
		this.healthTopic_Id = healthTopic_Id;
	}
	public int getIdRelatedTopic() {
		return this.idRelatedTopic;
	}
	public void setIdRelatedTopic(int idRelatedTopic) {
		this.idRelatedTopic = idRelatedTopic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	*/

	/**
	 * Inserta en la tabla 'languagemappedtopic' los atributos de la clase.
	 * @param conn = conexi�n que se utiliza para ejecutar el sql.
	 */
/*
	public void insert(Connection conn){
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement("INSERT INTO `medlinebennett`.`relatedtopic`(`HealthTopic_Id`," +
					"`idRelatedTopic`,`Name`,`URL`)VALUES(?,?,?,?);");
			ps.setInt(1, this.healthTopic_Id);
			ps.setInt(2, this.idRelatedTopic);
			ps.setString(3, this.name);
			ps.setString(4, this.url);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar el registro en la tabla Otherlanguage");
			e.printStackTrace();
		}

	}

	//M�todo que devuelve una lista con los resultados de la b�squeda en la BBDD seg�n el
	//criterio de b�squeda id.
	public ArrayList<Relatedtopic> listadoAlsoRelatedtopic(int id) throws Exception{
		ArrayList<Relatedtopic> miLista;
		BBDD miBd = new BBDD();
		miBd.abrirConexion(); 
		//Vamos a utilizar PrepareStatement
		miLista=miBd.listadoRelatedtopic("Select * from relatedtopic where HealthTopic_Id = ?", id);
		miBd.cerrarConexion();
		return miLista;		
	}
	*/
	/*
	 *  Seg�n la implementeci�n de equals() por defecto en la clase Object,
	 *  lo que hace es comparar las referencias de los objetos,
	 *  es decir sus direcciones de memoria. 
	 *  Para que el m�todo equals() funcione de manera correcto es necesario
	 *  reimplementarlo.
	 */
/*
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Relatedtopic)) {
			return false;
		}
		Relatedtopic castOther = (Relatedtopic)other;
		return 
				(this.healthTopic_Id == castOther.healthTopic_Id)
				&& (this.idRelatedTopic == castOther.idRelatedTopic);
	}
	*/
	/*
	 * La funci�n de dispersi�n permite localizar de forma r�pida 
	 * un elemento dentro del array sin tener que recorrerlo entero.
	 * si reimplementamos el m�todo equals, es obligatorio
	 * reimplementar el m�todo hashCode.
	 */
/*
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.healthTopic_Id;
		hash = hash * prime + this.idRelatedTopic;

		return hash;
	}
}
*/