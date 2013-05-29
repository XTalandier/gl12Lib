/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VAO;

import java.sql.Timestamp;

/**
 *
 * @author Adri
 */
public class VueHistorique extends DAO.DAO
{
    public String tb_name      = "VueHistorique";
    public String tb_primaire  = "NoEnregistrement";
    public int    ch_NoEnregistrement = 0;
    public String ch_Lieu;
    public String ch_TypeLieu;
    public Timestamp ch_DateArrivee;
    
    public VueHistorique() {}
    public VueHistorique(int id)
    {
        initWithID(id);
    }

    public String getCh_TypeLieu() {
        return ch_TypeLieu;
    }

    public void setCh_TypeLieu(String ch_TypeLieu) {
        this.ch_TypeLieu = ch_TypeLieu;
    }

    public String getCh_Lieu() {
        return ch_Lieu;
    }

    public void setCh_Lieu(String ch_Lieu) {
        this.ch_Lieu = ch_Lieu;
    }

    public Timestamp getCh_DateArrivee() {
        return ch_DateArrivee;
    }

    public int getCh_NoEnregistrement() {
        return ch_NoEnregistrement;
    }

    public void setCh_NoEnregistrement(int ch_NoEnregistrement) {
        this.ch_NoEnregistrement = ch_NoEnregistrement;
    }

    public void setCh_DateArrivee(Timestamp ch_DateArrivee) {
        this.ch_DateArrivee = ch_DateArrivee;
    }
    
    

      
} // VueHistorique
