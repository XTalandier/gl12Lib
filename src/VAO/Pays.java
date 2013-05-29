/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VAO;
import DAO.*;
/**
 *
 * @author Duss
 */
public class Pays extends DAO {
	public String tb_name     = "pays";
	public String tb_primaire = "id_pays";
	public int    ch_id_pays  = 0;
	public String ch_ISO;
	public String ch_nom;

	public Pays() {
	}
	public Pays(int id) {
		initWithID(id);
	}

}
