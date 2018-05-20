/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deltasteppingparallelfast;

import delatasteppingparalel.DelataStepingParalel;
import testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DeltaSteppingParallelFast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int nrOfThreads = 4;
        
        TestData td = new TestData();
        
        DelataStepingParalel deltaSteppingParalel = new DelataStepingParalel();
        deltaSteppingParalel.initilize(td,nrOfThreads);
        deltaSteppingParalel.start();
    }
    
}
