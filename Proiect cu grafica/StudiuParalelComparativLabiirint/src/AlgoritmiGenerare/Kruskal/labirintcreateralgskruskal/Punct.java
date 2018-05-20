/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AlgoritmiGenerare.Kruskal.labirintcreateralgskruskal;

/**
 *
 * @author STOLO
 */
public class Punct {
    private int  linie;
    private int coloana;
    
    public Punct() {
        linie = 0;
        coloana = 0;
    }

    public Punct(int linie, int coloana) {
        this.linie = linie;
        this.coloana = coloana;
    }

    public int getColoana() {
        return coloana;
    }

    @Override
    public String toString() {
        return "line " + this.linie + ", colana: " + this.coloana;
    }

    public int getLinie() {
        return linie;
    }

    public void setColoana(int coloana) {
        this.coloana = coloana;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Punct){
            Punct tempPunct = (Punct) obj;
            if(this.linie == tempPunct.linie && this.coloana == tempPunct.coloana)
                return true;
        }
        return false;
    }
}
