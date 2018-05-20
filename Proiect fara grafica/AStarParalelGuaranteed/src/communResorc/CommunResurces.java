/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communResorc;

import java.util.LinkedList;
import java.util.PriorityQueue;
import pondereDate.DatePonderate;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class CommunResurces {
    int maxThreads;
    PriorityQueue<AStarInfo> coadaPrioritati;
    private boolean poinstVisited[][];
    private AStarInfo afisMatrix[][];
    
    private boolean matrixLabirint[][];
    private int nrCellsLab;
    private boolean hasReachEnd;
    private Punct start,end;
    
    private DatePonderate datePonderate ;

    
    private long timpInceput;
    private long timpfinal;
    
    //paralel data
    private LinkedList<AStarInfo> rezultatePeThreaduri[];
    private AStarInfo punctThread[];
    
    public CommunResurces(){
        maxThreads = 0;
        coadaPrioritati = new PriorityQueue<AStarInfo>();
        hasReachEnd = false;
        afisMatrix = null;
                
        matrixLabirint = null;
        nrCellsLab = 0;
        start = null;
        end = null;
    }
    
    public double Aprox(Punct plecare, Punct destinatie) {
        int linieDistanta = Math.abs(plecare.getLinie() - destinatie.getLinie());
        int coloanaDistanta = Math.abs(plecare.getColoana() - destinatie.getColoana());
       // System.out.println( Math.max(linieDistanta,coloanaDistanta)+"****");
      //  if(this.Euclidian)
            return  Math.sqrt(Math.pow(linieDistanta, 2)+Math.pow(coloanaDistanta, 2));
      /*  if(this.Manhattan)
            return Math.abs(linieDistanta) + Math.abs(coloanaDistanta);
        if(this.Octile)
            return Math.max(linieDistanta,coloanaDistanta)+(Math.sqrt(2)-1)*Math.min(linieDistanta,coloanaDistanta);
        //this.Chebyshev;
        return Math.max(linieDistanta,coloanaDistanta);
*/
    }

    public AStarInfo[] getPunctThread() {
        return punctThread;
    }

    public void setPunctThread(AStarInfo[] punctThread) {
        this.punctThread = punctThread;
    }

    public LinkedList<AStarInfo>[] getRezultatePeThreaduri() {
        return rezultatePeThreaduri;
    }

    public void setRezultatePeThreaduri(LinkedList<AStarInfo>[] rezultatePeThreaduri) {
        this.rezultatePeThreaduri = rezultatePeThreaduri;
    }

    public long getTimpInceput() {
        return timpInceput;
    }

    public void setTimpInceput(long timpInceput) {
        this.timpInceput = timpInceput;
    }

    public long getTimpfinal() {
        return timpfinal;
    }

    public void setTimpfinal(long timpfinal) {
        this.timpfinal = timpfinal;
    }

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
        this.rezultatePeThreaduri = new LinkedList[maxThreads];
        this.punctThread = new AStarInfo[maxThreads];
    //    for()
    }

    public PriorityQueue<AStarInfo> getCoadaPrioritati() {
        return coadaPrioritati;
    }

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
    
    public void afis(Punct punct) {
        AStarInfo punctInfo = this.getAfisMatrix()[punct.getLinie()][punct.getColoana()];
        if(punctInfo.getTata()!=null){
            afis(punctInfo.getTata());
        }
        System.out.println(punctInfo.getPunctCurent() + " cu preturl: " + punctInfo.getPretCumulat());
    }

    public boolean noMoreNeighbors(Punct end) {
        int linieCurenta = end.getLinie();
        int colanaCurenta = end.getColoana();
        
        if(linieCurenta-1 >= 0 && this.poinstVisited[linieCurenta-1][colanaCurenta] == true )
            return false;
        if(linieCurenta+1 < this.nrCellsLab && this.poinstVisited[linieCurenta+1][colanaCurenta] == true )
            return false;
        if(colanaCurenta+1 < this.nrCellsLab  && this.poinstVisited[linieCurenta][colanaCurenta+1] == true )
            return false;
        if(colanaCurenta-1 >= 0 && this.poinstVisited[linieCurenta][colanaCurenta-1] == true )
            return false;
        return true;
    }

    public DatePonderate getDatePonderate() {
        return datePonderate;
    }

    public void setDatePonderate(DatePonderate datePonderate) {
        this.datePonderate = datePonderate;
    }
    
}
