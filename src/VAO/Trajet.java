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
public class Trajet extends DAO {
	public String tb_name      = "trajet";
	public String tb_primaire  = "id_trajet";
	public int    ch_id_trajet = 0;
	public String ch_libelle;

	public Trajet() {
	}
	public Trajet(int id) {
		initWithID(id);
	}

	/**
	 * @return the tb_name
	 */
	public String getTb_name() {
		return tb_name;
	}

	/**
	 * @param tb_name the tb_name to set
	 */
	public void setTb_name(String tb_name) {
		this.tb_name = tb_name;
	}

	/**
	 * @return the tb_primaire
	 */
	public String getTb_primaire() {
		return tb_primaire;
	}

	/**
	 * @param tb_primaire the tb_primaire to set
	 */
	public void setTb_primaire(String tb_primaire) {
		this.tb_primaire = tb_primaire;
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
	 * @return the ch_libelle
	 */
	public String getCh_libelle() {
		return ch_libelle;
	}

	/**
	 * @param ch_libelle the ch_libelle to set
	 */
	public void setCh_libelle(String ch_libelle) {
		this.ch_libelle = ch_libelle;
	}

}
