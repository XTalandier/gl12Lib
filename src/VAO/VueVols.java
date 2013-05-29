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
public class VueVols extends DAO {
	public String tb_name     = "vue_vols";
	public String tb_primaire = "id_vol";
	public int    ch_id_vol   = 0;
	public int    ch_lieu1    = 0;
	public String ch_iata1;
	public String ch_depart;
	public int    ch_lieu2    = 0;
	public String ch_iata2;
	public String ch_arrivee;
	public String ch_date_depart;
	public String ch_date_arrive;
	public String ch_duree;
	
	public VueVols(int id) {
		initWithID(id);
	}

	public VueVols() {
	}

}
