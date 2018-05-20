/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondereDate;

import communResorc.Punct;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DatePonderate {
    
    private Scanner sc;
    private ArrayList<PunctList> listaAdiacenta;
    
    public DatePonderate(){
        listaAdiacenta = new ArrayList<PunctList>();
    }

    public void start(){
        
        Punct p1, p2;
        double pondere;
        while(sc.hasNext()){
            p1 = new Punct(sc.nextInt(), sc.nextInt());
            p2 = new Punct(sc.nextInt(), sc.nextInt());
            pondere = sc.nextDouble();
            if(isPunt(p1)){
                listaAdiacenta.get(getPunctIndex(p1)).getPuncteContinute().add(new PunctValoare(p2,pondere));
            }else{
                listaAdiacenta.add(new PunctList(p1,p2,pondere));
            }
        }
        
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    private boolean isPunt(Punct p1) {
        for(int i=0;i<this.listaAdiacenta.size();i++)
            if(listaAdiacenta.get(i).getPunctIndex().equals(p1))
                return true;
        return false;
    }
    
    private int getPunctIndex(Punct p1){
        for(int i=0;i<this.listaAdiacenta.size();i++)
            if(listaAdiacenta.get(i).getPunctIndex().equals(p1))
                return i;
        return -1;
    }

    public ArrayList<PunctList> getListaAdiacenta() {
        return listaAdiacenta;
    }
    
    public double getValue(Punct p1, Punct p2){
        ArrayList<PunctValoare> puncteContinute;
        puncteContinute = listaAdiacenta.get(getPunctIndex(p1)).getPuncteContinute();
        
        for(int i=0;i<puncteContinute.size();i++)
            if(puncteContinute.get(i).getPunctCurent().equals(p2))
                return puncteContinute.get(i).getValoareArc();
         return Double.MIN_VALUE;
    } 
    
}
