package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Representa un una ampliaci�n de informaci�n relacionada 
 * con el Site principal.
 * Cada 'Site' puede tener '0' o m�s de un valor asociado.
 * @author alef
 */
/*
public class Siteinfocategory implements Serializable {

	private static final long serialVersionUID = 1L;

	private int site_URL_Id;//Id. del Site relacionado

	private String infoCategory;//Informaci�n adicional

	//Constructores
	public Siteinfocategory() {
	}

	public Siteinfocategory(int site_URL_Id, String infoCategory) {
		super();
		this.site_URL_Id = site_URL_Id;
		this.infoCategory = infoCategory;
	}
	//Getters and Setters
	public int getSite_URL_Id() {
		return this.site_URL_Id;
	}
	public void setSite_URL_Id(int site_URL_Id) {
		this.site_URL_Id = site_URL_Id;
	}
	public String getInfoCategory() {
		return this.infoCategory;
	}
	public void setInfoCategory(String infoCategory) {
		this.infoCategory = infoCategory;
	}
	*/

	/**
	 * Inserta en la tabla 'siteinfocategory' los atributos de la clase.
	 * @param conn = conexi�n que se utiliza para ejecutar el sql.
	 */
/*
	public void insert(Connection conn){
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement("INSERT INTO `medlinebennett`.`siteinfocategory`(`Site_URL_Id`," +
					"`InfoCategory`)VALUES(?,?);");
			ps.setInt(1, this.site_URL_Id);
			ps.setString(2, this.infoCategory);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar el registro en la tabla Siteinfocategory");
			e.printStackTrace();
		}

	}

	//M�todo que devuelve una lista con los resultados de la b�squeda en la BBDD Siteinfocategory seg�n el
	//criterio de b�squeda id.
	public ArrayList<Siteinfocategory> listadoSiteinfocategory(int id) throws Exception{
		ArrayList<Siteinfocategory> miLista;
		BBDD miBd = new BBDD();
		miBd.abrirConexion(); 
		//Vamos a utilizar PrepareStatement
		miLista=miBd.listadoSiteinfocategory("Select * from siteinfocategory where Site_URL_Id = ?", id);
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
		if (!(other instanceof Siteinfocategory)) {
			return false;
		}
		Siteinfocategory castOther = (Siteinfocategory)other;
		return 
				(this.site_URL_Id == castOther.site_URL_Id)
				&& this.infoCategory.equals(castOther.infoCategory);
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
		hash = hash * prime + this.site_URL_Id;
		hash = hash * prime + this.infoCategory.hashCode();

		return hash;
	}
}
*/