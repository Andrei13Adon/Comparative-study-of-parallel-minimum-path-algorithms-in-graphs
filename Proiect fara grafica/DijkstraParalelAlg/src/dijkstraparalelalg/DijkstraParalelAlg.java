/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraparalelalg;

import paralelPart.DijThreadCreator;
import singleThread.DijSingleThread;
import testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DijkstraParalelAlg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nrOfThreads = 16;
        
        TestData td = new TestData();
        
       /*
        DijSingleThread DST = new DijSingleThread(td);
        DST.go();
        */
        
        DijThreadCreator DTC = new DijThreadCreator();
        DTC.goInitial(td,nrOfThreads);
        DTC.goStart();
        
    }
    
}
