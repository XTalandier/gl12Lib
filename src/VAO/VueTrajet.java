/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VAO;

/**
 *
 * @author Jean-Hugues
 */
public class VueTrajet extends DAO.DAO {
    public String tb_name      = "vue_trajet_vols";
    public String tb_primaire  = "id_tv";
	public int    ch_id_tv = 0;
    public int    ch_id_trajet = 0;
    public String  ch_libelle;
    public int ch_id_vol;
    public int ch_lieu1;
	public String  ch_iata1;
	public String  ch_depart;
	public int ch_lieu2;
	public String  ch_iata2;
	public String  ch_arrivee;
	public String ch_date_depart;
	public String ch_date_arrive;
	public String	  ch_duree;
	
    
    public VueTrajet() {}
    public VueTrajet(int id)
    {
        initWithID(id);
    }

	public String getCh_arrivee() {
		return ch_arrivee;
	}

	public void setCh_arrivee(String ch_arrivee) {
		this.ch_arrivee = ch_arrivee;
	}

	public String getCh_date_arrive() {
		return ch_date_arrive;
	}

	public void setCh_date_arrive(String ch_date_arrive) {
		this.ch_date_arrive = ch_date_arrive;
	}

	public String getCh_date_depart() {
		return ch_date_depart;
	}

	public void setCh_date_depart(String ch_date_depart) {
		this.ch_date_depart = ch_date_depart;
	}

	public String getCh_depart() {
		return ch_depart;
	}

	public void setCh_depart(String ch_depart) {
		this.ch_depart = ch_depart;
	}

	public String getCh_duree() {
		return ch_duree;
	}

	public void setCh_duree(String ch_duree) {
		this.ch_duree = ch_duree;
	}

	public String getCh_iata1() {
		return ch_iata1;
	}

	public void setCh_iata1(String ch_iata1) {
		this.ch_iata1 = ch_iata1;
	}

	public String getCh_iata2() {
		return ch_iata2;
	}

	public void setCh_iata2(String ch_iata2) {
		this.ch_iata2 = ch_iata2;
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

	public String getCh_libelle() {
		return ch_libelle;
	}

	public void setCh_libelle(String ch_libelle) {
		this.ch_libelle = ch_libelle;
	}

	public int getCh_lieu1() {
		return ch_lieu1;
	}

	public void setCh_lieu1(int ch_lieu1) {
		this.ch_lieu1 = ch_lieu1;
	}

	public int getCh_lieu2() {
		return ch_lieu2;
	}

	public void setCh_lieu2(int ch_lieu2) {
		this.ch_lieu2 = ch_lieu2;
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
