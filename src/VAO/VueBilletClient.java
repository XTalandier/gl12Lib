/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VAO;

/**
 *
 * @author Jean-Hugues
 */
public class VueBilletClient extends DAO.DAO {
	public String tb_name     = "vue_billet_client";
	public String tb_primaire = "id_billet";
	public int    ch_id_billet   = 0;
	public int    ch_id_client;
	public int    ch_id_trajet;
	public int    ch_id_vol;
	public String ch_nom;
	public String ch_prenom;
	public String ch_email;
	
	public VueBilletClient(int id) {
		initWithID(id);
	}

	public VueBilletClient() {
	}

	public String getCh_email() {
		return ch_email;
	}

	public void setCh_email(String ch_email) {
		this.ch_email = ch_email;
	}

	public int getCh_id_billet() {
		return ch_id_billet;
	}

	public void setCh_id_billet(int ch_id_billet) {
		this.ch_id_billet = ch_id_billet;
	}

	public int getCh_id_client() {
		return ch_id_client;
	}

	public void setCh_id_client(int ch_id_client) {
		this.ch_id_client = ch_id_client;
	}

	public int getCh_id_trajet() {
		return ch_id_trajet;
	}

	public void setCh_id_trajet(int ch_id_trajet) {
		this.ch_id_trajet = ch_id_trajet;
	}

	public int getCh_id_vol() {
		return ch_id_vol;
	}

	public void setCh_id_vol(int ch_id_vol) {
		this.ch_id_vol = ch_id_vol;
	}

	public String getCh_nom() {
		return ch_nom;
	}

	public void setCh_nom(String ch_nom) {
		this.ch_nom = ch_nom;
	}

	public String getCh_prenom() {
		return ch_prenom;
	}

	public void setCh_prenom(String ch_prenom) {
		this.ch_prenom = ch_prenom;
	}

	public String getTb_name() {
		return tb_name;
	}

	public void setTb_name(String tb_name) {
		this.tb_name = tb_name;
	}

	public String getTb_primaire() {
		return tb_primaire;
	}

	public void setTb_primaire(String tb_primaire) {
		this.tb_primaire = tb_primaire;
	}
	
	
}
