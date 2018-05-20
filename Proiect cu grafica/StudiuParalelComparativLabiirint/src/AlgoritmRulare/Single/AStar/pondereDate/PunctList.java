/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Single.AStar.pondereDate;

import AlgoritmRulare.Single.AStar.communResorc.Punct;
import java.util.ArrayList;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class PunctList {
    
    private Punct punctIndex;
    private ArrayList<PunctValoare> puncteContinute;
    
    public PunctList(Punct p1, Punct p2, double valore){
        puncteContinute = new ArrayList<PunctValoare>();
        punctIndex = p1;
        puncteContinute.add(new PunctValoare(p2, valore));
    }

    public Punct getPunctIndex() {
        return punctIndex;
    }

    public void setPunctIndex(Punct punctIndex) {
        this.punctIndex = punctIndex;
    }

    public ArrayList<PunctValoare> getPuncteContinute() {
        return puncteContinute;
    }

    public void setPuncteContinute(ArrayList<PunctValoare> puncteContinute) {
        this.puncteContinute = puncteContinute;
    }
    
    
    
}
