/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarparalelguaranteed;

import parralelPart.AStarGarThreadNCreator;
import testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
//mai trebuie adaugat pentru cazul cand primul drum nu este minim si mai duce un drum la nodul final
public class AStarParalelGuaranteed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nrOfThreads = 16;
        
        TestData td = new TestData();
        
        AStarGarThreadNCreator ASGTC = new AStarGarThreadNCreator();
        ASGTC.intialization(td,nrOfThreads);
        ASGTC.start();
    }
    
}
