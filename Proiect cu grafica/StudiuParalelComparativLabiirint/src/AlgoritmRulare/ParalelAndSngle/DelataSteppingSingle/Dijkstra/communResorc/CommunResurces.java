/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc;

import java.util.ArrayList;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.pondereDate.DatePonderate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class CommunResurces {
    
    private ArrayList<DijkInfo>borderArray;
    private boolean pointsVisited[][];
    private DijkInfo afisMatrix[][];
    private DijkInfo threadMinim[];
    private int indexTata[];
    
    private boolean matrixLabirint[][];
    private int nrCellsLab;
    private IntervalClass listofIntervalsForEachThread[];
    private int nrThreads;
    private boolean hasReachEnd;
    private Punct start,end;
    
    private DatePonderate datePonderate ;
    
    private long timpInceput;
    private long timpfinal;

    
    private int fPrecis;
    
    private final long Secunda = 1000;
    
    private PrintWriter pw;
    
    public boolean getHasReachEnd() {
        return hasReachEnd;
    }

    public void setHasReachEnd(boolean hasReachEnd) {
        this.hasReachEnd = hasReachEnd;
    }
    
    public CommunResurces(){
        matrixLabirint = null;
        nrCellsLab = 0;
        listofIntervalsForEachThread = null;
        nrThreads = 0;
        hasReachEnd = false;
        start = null;
        end = null;
        
        afisMatrix = null;
        pointsVisited = null;
        borderArray = null;
        indexTata = null;
        
        try {
            pw = new PrintWriter(new File("drumParale.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommunResurces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void afis(int line, int colona){
        pw.println(colona + " " + line);
    }
    
    public void close(){
        pw.flush();
        pw.close();
    }
    
    
    
    public void initInernalLists() {
        
        
        
        borderArray = new ArrayList<DijkInfo>();
        pointsVisited = this.matrixLabirint.clone();  
        afisMatrix = new DijkInfo[nrCellsLab][nrCellsLab];
        threadMinim = new DijkInfo[this.nrThreads+1]; //incep de la 1
        indexTata = new int[this.nrThreads + 1];
        
        //creeaza cate un obiect interval pentru fiecare threads+1];ead pentru a le putea accesa separt (Neserializat)
        listofIntervalsForEachThread = new IntervalClass[nrThreads+1];
        this.realocareThreadsDistribution();
    }
    
    public void realocareThreadsDistribution(){
        //realocarea zonelor pe care threadurile trebuie sa le execute
        for(int i=1;i<=nrThreads;i++){
            if(listofIntervalsForEachThread[i] == null)
                listofIntervalsForEachThread[i] = new IntervalClass();
            this.listofIntervalsForEachThread[i].setStart(0);
            this.listofIntervalsForEachThread[i].setEnd(0);
        }
        if(this.nrThreads>=this.borderArray.size())
            for(int i=0;i<this.borderArray.size();i++){
                this.listofIntervalsForEachThread[i+1].setStart(i);
                this.listofIntervalsForEachThread[i+1].setEnd(i);
            }
        else{
            int nrForEachThread = this.borderArray.size()/nrThreads;
            int difSurplus = this.borderArray.size()%nrThreads;
            int difRate;
            int lastAdded = 0;
            for(int i=1;i<=this.nrThreads;i++){
                if(difSurplus > 0){
                    difRate = 1;
                    difSurplus--;
                }
                else difRate = 0;
                
                this.listofIntervalsForEachThread[i].setStart(lastAdded);
                lastAdded = lastAdded + difRate + nrForEachThread - 1;
                this.listofIntervalsForEachThread[i].setEnd(lastAdded);
                lastAdded++;
            }
        }
    }
    /*
    public CommunResurces(int matrixLabirint[][], int nrCellsLab, int nrThreads ){
        this.matrixLabirint = matrixLabirint;
        this.nrCellsLab = nrCellsLab;
        this.nrThreads = nrThreads;
        hasReachEnd = false;
        //creeaza cate un obiect interval pentru fiecare threads+1];ead pentru a le putea accesa separt (Neserializat)
        listofIntervalsForEachThread = new IntervalClass[nrThreads+1];
        for(int i=1;i<=nrThreads;i++){
            listofIntervalsForEachThread[i] = new IntervalClass();
        }
        
    }
    */

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

    public IntervalClass[] getListofIntervalsForEachThread() {
        return listofIntervalsForEachThread;
    }

    public void setListofIntervalsForEachThread(IntervalClass[] listofIntervalsForEachThread) {
        this.listofIntervalsForEachThread = listofIntervalsForEachThread;
    }

    public int[] getIndexTata() {
        return indexTata;
    }

    public void setIndexTata(int[] indexTata) {
        this.indexTata = indexTata;
    }
    
    public boolean[][] getMatrixLabirint() {
        return matrixLabirint;
    }

    public void setMatrixLabirint(boolean[][] matrixLabirint) {
        this.matrixLabirint = matrixLabirint;
    }

    public int getNrCellsLab() {
        return nrCellsLab;
    }

    public void setNrCellsLab(int nrCellsLab) {
        this.nrCellsLab = nrCellsLab;
    }

    public int getNrThreads() {
        return nrThreads;
    }

    public void setNrThreads(int nrThreads) {
        this.nrThreads = nrThreads;
        this.initInernalLists();
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
    
    public ArrayList<DijkInfo> getBorderArray() {
        return borderArray;
    }

    public void setBorderArray(ArrayList<DijkInfo> borderArray) {
        this.borderArray = borderArray;
    }

    public boolean[][] getPointsVisited() {
        return pointsVisited;
    }

    public void setPointsVisited(boolean[][] pointsVisited) {
        this.pointsVisited = pointsVisited;
    }

    public DijkInfo[][] getAfisMatrix() {
        return afisMatrix;
    }

    public void setAfisMatrix(DijkInfo[][] afisMatrix) {
        this.afisMatrix = afisMatrix;
    }

    public DijkInfo[] getThreadMinim() {
        return threadMinim;
    }

    public void setThreadMinim(DijkInfo[] threadMinim) {
        this.threadMinim = threadMinim;
    }

    public DatePonderate getDatePonderate() {
        return datePonderate;
    }

    public void setDatePonderate(DatePonderate datePonderate) {
        this.datePonderate = datePonderate;
    }
    
    
    public void calculateNumarulDeVecini(DijkInfo punctCurent){
        //trebuie corectata doarece trebuie loati in considerare vecinii deja parcursi 
        int linie = punctCurent.getPunctCurent().getLinie();
        int coloana = punctCurent.getPunctCurent().getColoana();
        int nrVecini = 0;
        if(linie-1 >= 0 && pointsVisited[linie-1][coloana] == true )
            nrVecini++;
        if(coloana+1 < this.nrCellsLab && pointsVisited[linie][coloana+1] == true )
            nrVecini++;
        if(linie+1 < this.nrCellsLab && pointsVisited[linie+1][coloana] == true )
            nrVecini++;
        if(coloana-1 >= 0 && pointsVisited[linie][coloana-1] == true )
            nrVecini++;
        punctCurent.setNrVecini(nrVecini);
    }

    public Punct getNearestNeighbor(Punct punctCurent) {
        int linie = punctCurent.getLinie();
        int coloana = punctCurent.getColoana();
        if(linie-1 >= 0 && matrixLabirint[linie-1][coloana] == true )
            return new Punct(linie-1, coloana);
        if(coloana+1 < this.nrCellsLab && matrixLabirint[linie][coloana+1] == true )
            return new Punct(linie, coloana+1);
        if(linie+1 < this.nrCellsLab && matrixLabirint[linie+1][coloana] == true )
            return new Punct(linie+1, coloana);
        if(coloana-1 >= 0 && matrixLabirint[linie][coloana-1] == true )
            return new Punct(linie, coloana-1);
        return null;
    }

    public void afis(Punct end) {
        DijkInfo punctInfo = afisMatrix[end.getLinie()][end.getColoana()];
        if(punctInfo.getTata()!=null){
            afis(punctInfo.getTata());
            
            this.afis(end.getLinie(),end.getColoana());
        }
        
        
        //System.out.println(punctInfo.getPunctCurent() + " cu preturl: " + punctInfo.getPretCumulat());
    
    }

}
