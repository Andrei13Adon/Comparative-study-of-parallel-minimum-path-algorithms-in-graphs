/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Single.DelataSteppingSingle.delatasteppingsingle;

import AlgoritmRulare.Single.DelataSteppingSingle.testData.TestData;
import java.awt.Graphics;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DelataSteppingSingle {

    /**
     * @param args the command line arguments
     */
    public static void start(Graphics g) {
        
        TestData td = new TestData();
            DeltaStepping deltaStepping = new DeltaStepping();
            deltaStepping.initilize(td,g);
            deltaStepping.start();
        
    }
    
}
