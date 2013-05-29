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
public class TrajetVol extends DAO {
	public String tb_name      = "trajet_vol";
	public String tb_primaire  = "id_tv";
	public int    ch_id_tv     = 0;
	public int    ch_id_trajet = 0;
	public int    ch_id_vol    = 0;
	
	public TrajetVol(int id) {
		initWithID(id);
	}

	public TrajetVol() {
	}

	/**
	 * @return the ch_id
	 */
	public int getCh_id() {
		return ch_id_tv;
	}

	/**
	 * @param ch_id the ch_id to set
	 */
	public void setCh_id(int ch_id) {
		this.ch_id_tv = ch_id;
	}

	/**
	 * @return the ch_id_trajet
	 */
	public int getCh_id_trajet() {
		return ch_id_trajet;
	}

	/**
	 * @param ch_id_trajet the ch_id_trajet to set
	 */
	public void setCh_id_trajet(int ch_id_trajet) {
		this.ch_id_trajet = ch_id_trajet;
	}

	/**
	 * @return the ch_id_vol
	 */
	public int getCh_id_vol() {
		return ch_id_vol;
	}

	/**
	 * @param ch_id_vol the ch_id_vol to set
	 */
	public void setCh_id_vol(int ch_id_vol) {
		this.ch_id_vol = ch_id_vol;
	}

}
