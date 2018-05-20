/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Single.AStar.communResorc;

import java.util.PriorityQueue;
import AlgoritmRulare.Single.AStar.pondereDate.DatePonderate;
import ReprezentareGf.Grafic;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class CommunResurces {
 //   PriorityQueue<Integer> coadaPrioritati;
    private boolean poinstVisited[][];
    private AStarInfo afisMatrix[][];
    
    private boolean matrixLabirint[][];
    private int nrCellsLab;
    private boolean hasReachEnd;
    private Punct start,end;
    
    private DatePonderate datePonderate ;
    
    private Graphics g;
    
    private int fPrecis;
    
    private final long Secunda = 1000;

    
    public CommunResurces(){
  //      coadaPrioritati = null;
        hasReachEnd = false;
        
        matrixLabirint = null;
        nrCellsLab = 0;
        start = null;
        end = null;
        afisMatrix = null;
    }
    
    public double Aprox(Punct plecare, Punct destinatie) {
        int linieDistanta = Math.abs(plecare.getLinie() - destinatie.getLinie());
        int coloanaDistanta = Math.abs(plecare.getColoana() - destinatie.getColoana());
        double pondere = 0.5;
       // System.out.println( Math.max(linieDistanta,coloanaDistanta)+"****");
      //  if(this.Euclidian)
            return  Math.sqrt(Math.pow(linieDistanta, 2)+Math.pow(coloanaDistanta, 2)) * pondere;
      /*  if(this.Manhattan)
            return Math.abs(linieDistanta) + Math.abs(coloanaDistanta) * pondere;
        if(this.Octile)
            return Math.max(linieDistanta,coloanaDistanta)+(Math.sqrt(2)-1)*Math.min(linieDistanta,coloanaDistanta) * pondere;
        //this.Chebyshev;
        return Math.max(linieDistanta,coloanaDistanta) * pondere;
*/
    }
/*
    public PriorityQueue<Integer> getCoadaPrioritati() {
        return coadaPrioritati;
    }
*/
    public boolean[][] getMatrixLabirint() {
        return matrixLabirint;
    }

    public void setMatrixLabirint(boolean[][] matrixLabirint) {
        this.matrixLabirint = matrixLabirint;
        this.poinstVisited = matrixLabirint.clone();
        this.afisMatrix = new AStarInfo[this.getNrCellsLab()][this.getNrCellsLab()];
    }

    public int getNrCellsLab() {
        return nrCellsLab;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public long getSecunda() {
        return Secunda;
    }

    public void setNrCellsLab(int nrCellsLab) {
        this.nrCellsLab = nrCellsLab;
        this.fPrecis = (int)500/nrCellsLab;
    }

    public boolean isHasReachEnd() {
        return hasReachEnd;
    }

    public void setHasReachEnd(boolean hasReachEnd) {
        this.hasReachEnd = hasReachEnd;
    }

    public Punct getStart() {
        return start;
    }

    public void setStart(Punct start) {
        this.start = start;
    }

    public Punct getEnd() {
        return end;
    }

    public void setEnd(Punct end) {
        this.end = end;
    }

    public boolean[][] getPoinstVisited() {
        return poinstVisited;
    }

    public AStarInfo[][] getAfisMatrix() {
        return afisMatrix;
    }

    public DatePonderate getDatePonderate() {
        return datePonderate;
    }

    public void setDatePonderate(DatePonderate datePonderate) {
        this.datePonderate = datePonderate;
    }

    public int getfPrecis() {
        return fPrecis;
    }

    public void setfPrecis(int fPrecis) {
        this.fPrecis = fPrecis;
    }
        
    public void delay(long timp){
        try {
            Thread.sleep(timp/this.nrCellsLab);
        } catch (InterruptedException ex) {
            Logger.getLogger(Grafic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
