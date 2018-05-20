/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communResorc;

import java.util.LinkedList;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class BBaketInfo {
    private double valIndexInterval; // intervalu este [ valIndexInterval*dexta, (valIndexInterval+1) * delra )
    private LinkedList<Punct> valori;

    public double getValIndexInterval() {
        return valIndexInterval;
    }

    public void setValIndexInterval(double valIndexInterval) {
        this.valIndexInterval = valIndexInterval;
        valori = new  LinkedList<Punct>();
    }

    public LinkedList<Punct> getValori() {
        return valori;
    }

    public void setValori(LinkedList<Punct> valori) {
        this.valori = valori;
    }

    @Override
    public String toString() {
        return "BBaketInfo{" + "valIndexInterval=" + valIndexInterval + ", valori=" + valori + '}';
    }
    
}
