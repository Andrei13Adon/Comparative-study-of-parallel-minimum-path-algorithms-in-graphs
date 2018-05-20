/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Single.DelataSteppingSingle.communResorc;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class PunctValuClass {
    
    Punct punct;
    double value;
    Punct tata;
    
    public PunctValuClass(Punct punct, double value, Punct tata){
        this.punct = punct;
        this.value = value;
        this.tata = tata;
        //System.out.println(this.toString()+", " + tata);
    } 

    public Punct getPunct() {
        return punct;
    }

    public void setPunct(Punct punct) {
        this.punct = punct;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PunctValuClass{" + "punct=" + punct + ", value=" + value + '}';
    }

    public Punct getTata() {
        return tata;
    }

    public void setTata(Punct tata) {
        this.tata = tata;
    }
    
    
}
