/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communResorc;

import java.util.PriorityQueue;
import pondereDate.DatePonderate;

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

    public void setNrCellsLab(int nrCellsLab) {
        this.nrCellsLab = nrCellsLab;
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
    
    
}
