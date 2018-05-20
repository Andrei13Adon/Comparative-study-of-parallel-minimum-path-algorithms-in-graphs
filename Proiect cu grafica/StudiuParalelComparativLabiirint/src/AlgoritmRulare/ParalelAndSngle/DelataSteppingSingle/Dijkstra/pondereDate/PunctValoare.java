/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.pondereDate;

import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.Punct;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class PunctValoare {
    
    private Punct punctCurent;
    private double valoareArc;
    
    public PunctValoare(Punct punctCurent, double valoareArc){
        this.punctCurent = punctCurent;
        this.valoareArc = valoareArc;
    }

    public Punct getPunctCurent() {
        return punctCurent;
    }

    public void setPunctCurent(Punct punctCurent) {
        this.punctCurent = punctCurent;
    }

    public double getValoareArc() {
        return valoareArc;
    }

    public void setValoareArc(double valoareArc) {
        this.valoareArc = valoareArc;
    }
    
    
    
}
