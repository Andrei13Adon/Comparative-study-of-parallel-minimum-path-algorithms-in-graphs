/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communResorc;

import java.util.ArrayList;
import java.util.LinkedList;
import pondereDate.DatePonderate;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class CommunResurces {
    private boolean matrixLabirint[][];
    private int nrCellsLab;
    private boolean hasReachEnd;
    private Punct start,end;
    
    //pentru afisare
    private Punct matriceTati[][];
    
    //for the Delata Stepping algoritm
    private double delta; 
    private double costMatrix[][];
    private LinkedList<BBaketInfo> B;
    private DatePonderate datePonderate;
    
    
    private int maxThreadNumber;
    private Interval intervalThread[];//creaza Interval de 4
    
    
    
    public CommunResurces(){
  //      coadaPrioritati = null;
        hasReachEnd = false;
        
        matrixLabirint = null;
        nrCellsLab = 0;
        start = null;
        end = null;
    }
    
    public void initlaizeForDetaStepping(double delta) {
        this.delta = delta;
        this.costMatrix = new double[this.nrCellsLab][this.nrCellsLab];
        for(int i=0;i<this.nrCellsLab;i++)
            for(int j=0;j<this.nrCellsLab;j++)
                this.costMatrix[i][j] = Double.MAX_VALUE;
        
        this.B = new LinkedList<BBaketInfo>();
        
        //intializare matrice tati
        this.matriceTati = new Punct[nrCellsLab][nrCellsLab];
          for(int i=0;i<this.nrCellsLab;i++)
            for(int j=0;j<this.nrCellsLab;j++)
                this.matriceTati[i][j] = null;
        
    }

    public int getMaxThreadNumber() {
        return maxThreadNumber;
    }

    public void setMaxThreadNumber(int maxThreadNumber) {
        this.maxThreadNumber = maxThreadNumber;
        this.intervalThread = new Interval[maxThreadNumber];
        for(int i=0;i<maxThreadNumber;i++)
            intervalThread[i] = new Interval();
    }

    public Interval[] getIntervalThread() {
        return intervalThread;
    }

    public void setIntervalThread(Interval[] intervalThread) {
        this.intervalThread = intervalThread;
    }

    public Punct[][] getMatriceTati() {
        return matriceTati;
    }

    public void setMatriceTati(Punct[][] matriceTati) {
        this.matriceTati = matriceTati;
    }

    public DatePonderate getDatePonderate() {
        return datePonderate;
    }

    public void setDatePonderate(DatePonderate datePonderate) {
        this.datePonderate = datePonderate;
    }
    
    public LinkedList<BBaketInfo> getB() {
        return B;
    }

    public void setB(LinkedList<BBaketInfo> B) {
        this.B = B;
    }
    

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double[][] getCostMatrix() {
        return costMatrix;
    }

    public void setCostMatrix(double[][] costMatrix) {
        this.costMatrix = costMatrix;
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

}
