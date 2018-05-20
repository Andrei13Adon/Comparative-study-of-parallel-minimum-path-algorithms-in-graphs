/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.dijkstraparalelalg;

import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.paralelPart.DijThreadCreator;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.singleThread.DijSingleThread;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.testData.TestData;
import java.awt.Graphics;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DijkstraParalelAlg {

    /**
     * @param args the command line arguments
     */
    public static void singleStart(Graphics g){
        
        TestData td = new TestData();
        DijSingleThread DST = new DijSingleThread(td,g);
        DST.go();
    }
    
    
    public static void paralelStart(int nrProcese) {
        int nrOfThreads = nrProcese;
        
        TestData td = new TestData();
        
        DijThreadCreator DTC = new DijThreadCreator();
        DTC.goInitial(td,nrOfThreads);
        DTC.goStart();
        
    }
    
}
