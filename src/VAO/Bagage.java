/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VAO;

/**
 *
 * @author Adri
 */
public class Bagage extends DAO.DAO
{
    public String tb_name      = "bagage";
    public String tb_primaire  = "id_bagage";
    public int    ch_id_bagage = 0;
    public float  ch_poids;
    public int    ch_id_client;
    
    public Bagage() {}
    public Bagage(int id)
    {
        initWithID(id);
    }
    

    public int getCh_id_bagage() {
        return ch_id_bagage;
    }

    public void setCh_id_bagage(int ch_id_bagage) {
        this.ch_id_bagage = ch_id_bagage;
    }

    public int getCh_id_client() {
        return ch_id_client;
    }

    public void setCh_id_client(int ch_id_client) {
        this.ch_id_client = ch_id_client;
    }

    public float getCh_poids() {
        return ch_poids;
    }

    public void setCh_poids(float ch_poids) {
        this.ch_poids = ch_poids;
    }
 
      
} // Bagage
