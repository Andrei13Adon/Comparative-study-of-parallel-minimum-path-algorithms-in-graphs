/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delatasteppingsingle;

import testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DelataSteppingSingle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TestData td = new TestData();
            DeltaStepping deltaStepping = new DeltaStepping();
            deltaStepping.initilize(td);
            deltaStepping.start();
        
    }
    
}
