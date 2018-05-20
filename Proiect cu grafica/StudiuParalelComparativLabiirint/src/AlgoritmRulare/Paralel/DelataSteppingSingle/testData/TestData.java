/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Paralel.DelataSteppingSingle.testData;

import AlgoritmRulare.Paralel.DelataSteppingSingle.communResorc.Punct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import AlgoritmRulare.Paralel.DelataSteppingSingle.pondereDate.DatePonderate;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class TestData {
    boolean matrixLabirint[][];
    int nrOfCells;
    Punct start,end;
    DatePonderate datePonderate ;

    public DatePonderate getDatePonderate() {
        return datePonderate;
    }

    public void setDatePonderate(DatePonderate datePonderate) {
        this.datePonderate = datePonderate;
    }
    
    public boolean[][] getMatrixLabirint() {
        return matrixLabirint;
    }

    public void setMatrixLabirint(boolean[][] matrixLabirint) {
        this.matrixLabirint = matrixLabirint;
    }

    public int getNrOfCells() {
        return nrOfCells;
    }

    public void setNrOfCells(int nrOfCells) {
        this.nrOfCells = nrOfCells;
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
    
    public TestData(){
        
        try {
            Scanner sc = new Scanner(new File("imput.txt"));
            
            nrOfCells = sc.nextInt();
            
            start = new Punct(sc.nextInt()-1,sc.nextInt()-1);
            end = new Punct(sc.nextInt()-1,sc.nextInt()-1);
            
            matrixLabirint = new boolean[nrOfCells][nrOfCells];
            for(int i=0;i<nrOfCells;i++){
                for(int j=0;j<nrOfCells;j++){
                    if(sc.nextInt() == 1)
                        matrixLabirint[i][j] = true;
                    else
                        matrixLabirint[i][j] = false;
                //    System.out.print(matrixLabirint[i][j]);
                }
              //  System.out.println();
            }
            
            datePonderate = new DatePonderate();
            datePonderate.setSc(sc);
            datePonderate.start();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
