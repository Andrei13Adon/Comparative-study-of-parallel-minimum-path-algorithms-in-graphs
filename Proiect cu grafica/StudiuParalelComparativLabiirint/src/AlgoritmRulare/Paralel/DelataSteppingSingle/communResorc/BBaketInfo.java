/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Paralel.DelataSteppingSingle.communResorc;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class BBaketInfo {
    private double valIndexInterval; // intervalu este [ valIndexInterval*dexta, (valIndexInterval+1) * delra )
    private ArrayList<Punct> valori;

    public double getValIndexInterval() {
        return valIndexInterval;
    }

    public void setValIndexInterval(double valIndexInterval) {
        this.valIndexInterval = valIndexInterval;
        valori = new  ArrayList<Punct>();
    }

    public ArrayList<Punct> getValori() {
        return valori;
    }

    public void setValori(ArrayList<Punct> valori) {
        this.valori = valori;
    }

    @Override
    public String toString() {
        return "BBaketInfo{" + "valIndexInterval=" + valIndexInterval + ", valori=" + valori + '}';
    }
    
}
