/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VAO;

/**
 *
 * @author Adri
 */
public class BagageVol extends DAO.DAO
{
    public String tb_name      = "vol_bagage";
    public String tb_primaire  = "id_vb";
    public int    ch_id_vb = 0;
    public float  ch_id_vol;
    public int    ch_id_bagage;
    
    public BagageVol() {}
    public BagageVol(int id)
    {
        initWithID(id);
    }

	public int getCh_id_bagage() {
		return ch_id_bagage;
	}

	public void setCh_id_bagage(int ch_id_bagage) {
		this.ch_id_bagage = ch_id_bagage;
	}

	public int getCh_id_vb() {
		return ch_id_vb;
	}

	public void setCh_id_vb(int ch_id_vb) {
		this.ch_id_vb = ch_id_vb;
	}

	public float getCh_id_vol() {
		return ch_id_vol;
	}

	public void setCh_id_vol(float ch_id_vol) {
		this.ch_id_vol = ch_id_vol;
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
    

 
      
} // Bagage
