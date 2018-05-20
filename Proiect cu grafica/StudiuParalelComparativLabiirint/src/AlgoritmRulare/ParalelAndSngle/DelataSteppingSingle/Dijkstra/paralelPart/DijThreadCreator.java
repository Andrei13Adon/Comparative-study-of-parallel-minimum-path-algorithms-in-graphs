/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.paralelPart;

import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.CommunResurces;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.DijkInfo;
import java.util.concurrent.CyclicBarrier;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DijThreadCreator {
    
    private int maxThreadNumber;
    private CyclicBarrier barrier;
    private CommunResurces comRes;
    
    public void setBarrier(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    
    public CyclicBarrier getBarrier() {
        return barrier;
    }
    
    public DijThreadCreator(){
        maxThreadNumber = 0;
        barrier = null;
    }

    public int getMaxThreadNumber() {
        return maxThreadNumber;
    }

    public void setMaxThreadNumber(int maxThreadNumber) {
        this.maxThreadNumber = maxThreadNumber;
    }
    
    
    public void goInitial(TestData td, int nrOfThreads){
        //starea resuselor comune
        comRes = new CommunResurces(); 
        this.maxThreadNumber = nrOfThreads;
        comRes.setMatrixLabirint(td.getMatrixLabirint());
        comRes.setNrCellsLab(td.getNrOfCells());
        comRes.setStart(td.getStart());
        comRes.setEnd(td.getEnd());
        
        //dupa introducere resurse apelam pentru initializare
       // comRes.initInernalLists();
        comRes.setNrThreads(maxThreadNumber);

        
        
        
        //crearea barierei necesita maxThreadNumber
        barrier = new CyclicBarrier(maxThreadNumber,new BarrierThreadClass(this.comRes));
        
        comRes.setDatePonderate(td.getDatePonderate());
    }
    
    public void goStart(){
        //introduce datele initiale in algoritm
        DijkInfo startDij = new DijkInfo(0,null,comRes.getStart());
        comRes.calculateNumarulDeVecini(startDij);
        boolean pointsVisited[][]  = comRes.getPointsVisited();
        pointsVisited[comRes.getStart().getLinie()][comRes.getStart().getColoana()] = false;
        comRes.getBorderArray().add(startDij);
        //pentru afisare:
        DijkInfo afisMatrix[][] = comRes.getAfisMatrix();
        afisMatrix[startDij.getPunctCurent().getLinie()][startDij.getPunctCurent().getColoana()] = startDij;
        
        comRes.setTimpInceput(System.currentTimeMillis());
        
        //crate all threads meaning maxThreadNumber
        DijkstraThread tempThread;
        for(int i=1;i<=this.maxThreadNumber;i++){
            tempThread = new DijkstraThread();
            tempThread.setThreadNumber(i);
            tempThread.setBarrier(barrier);
            tempThread.setComRes(comRes);
            new Thread(tempThread).start();
        }
        
    }
    
}
