/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsingleguaranteed;

import testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class AStarSingleGuaranteed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TestData td = new TestData();
        
            AStar ASTC = new AStar();
            ASTC.intialization(td);
            ASTC.start();
            
        
    }
    
}
