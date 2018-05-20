/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Paralel.DelataSteppingSingle.deltasteppingparallelfast;

import AlgoritmRulare.Paralel.DelataSteppingSingle.delatasteppingparalel.DelataStepingParalel;
import AlgoritmRulare.Paralel.DelataSteppingSingle.testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DeltaSteppingParallelFast {

    /**
     * @param args the command line arguments
     */
    public static void start(int nrThreads) {
        
        int nrOfThreads = nrThreads;
        
        TestData td = new TestData();
        
        DelataStepingParalel deltaSteppingParalel = new DelataStepingParalel();
        deltaSteppingParalel.initilize(td,nrOfThreads);
        deltaSteppingParalel.start();
    }
    
}
