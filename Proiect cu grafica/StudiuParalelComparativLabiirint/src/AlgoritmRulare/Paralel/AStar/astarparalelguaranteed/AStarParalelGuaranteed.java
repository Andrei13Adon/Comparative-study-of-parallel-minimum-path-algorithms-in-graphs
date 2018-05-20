/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Paralel.AStar.astarparalelguaranteed;

import AlgoritmRulare.Paralel.AStar.parralelPart.AStarGarThreadNCreator;
import AlgoritmRulare.Paralel.AStar.testData.TestData;
import java.awt.Graphics;

/**
 *
 * @author Mocioi Andrei Adonis
 */
//mai trebuie adaugat pentru cazul cand primul drum nu este minim si mai duce un drum la nodul final
public class AStarParalelGuaranteed {

    /**
     * @param args the command line arguments
     */
    public static void start(Graphics g, int nrThreads) {
        int nrOfThreads = nrThreads;
        
        TestData td = new TestData();
        
        AStarGarThreadNCreator ASGTC = new AStarGarThreadNCreator();
        ASGTC.intialization(td,nrOfThreads,g);
        ASGTC.start();
    }
    
}
