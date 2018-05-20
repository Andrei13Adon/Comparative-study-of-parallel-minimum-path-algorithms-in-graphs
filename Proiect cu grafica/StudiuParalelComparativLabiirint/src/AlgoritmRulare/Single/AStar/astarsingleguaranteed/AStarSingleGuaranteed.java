/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Single.AStar.astarsingleguaranteed;

import AlgoritmRulare.Single.AStar.testData.TestData;
import java.awt.Graphics;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class AStarSingleGuaranteed {

    /**
     * @param args the command line arguments
     */
    public static void start(Graphics g) {
        
        TestData td = new TestData();
        
            AStar ASTC = new AStar();
            ASTC.intialization(td,g);
            ASTC.start();
            
        
    }
    
}
