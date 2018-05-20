/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Single.DelataSteppingSingle.communResorc;

import java.util.ArrayList;
import java.util.LinkedList;
import AlgoritmRulare.Single.DelataSteppingSingle.pondereDate.DatePonderate;
import ReprezentareGf.Grafic;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
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

    public long getSecunda() {
        return Secunda;
    }

    
}
