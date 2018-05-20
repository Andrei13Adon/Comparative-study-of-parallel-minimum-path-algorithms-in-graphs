/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Paralel.AStar.parralelPart;

import AlgoritmRulare.Paralel.AStar.communResorc.AStarInfo;
import AlgoritmRulare.Paralel.AStar.communResorc.CommunResurces;
import java.util.concurrent.CyclicBarrier;
import AlgoritmRulare.Paralel.AStar.testData.TestData;
import java.awt.Graphics;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class AStarGarThreadNCreator {
    
    CommunResurces comRes;
    CyclicBarrier barrier;
    
    public void intialization(TestData td, int nrOfThreads,Graphics g){
        comRes = new CommunResurces();
        comRes.setNrCellsLab(td.getNrOfCells());
        comRes.setMaxThreads(nrOfThreads); 
        comRes.setMatrixLabirint(td.getMatrixLabirint());
        comRes.setStart(td.getStart());
        comRes.setEnd(td.getEnd());
        
        comRes.setDatePonderate(td.getDatePonderate());
        
        this.barrier = new CyclicBarrier(nrOfThreads,new BarrierExecutable(comRes));

    }
    
    public void start() {
        //cream Punctul de plecare
        
        comRes.setTimpInceput(System.currentTimeMillis());
        
        AStarInfo startingPoint;
        startingPoint = new AStarInfo(0, (int) comRes.Aprox(comRes.getStart(), comRes.getEnd()),null,comRes.getStart());
        
        comRes.getCoadaPrioritati().add(startingPoint);
        
        comRes.setTimpInceput( System.currentTimeMillis() );
        
        for(int i=0;i<comRes.getMaxThreads();i++){
             AStarGarThread themThreads = new AStarGarThread(comRes,barrier,i);
             new Thread(themThreads).start();
        }
        
    }
    
}
