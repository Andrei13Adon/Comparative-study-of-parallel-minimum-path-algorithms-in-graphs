/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labrintsetpondersmain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import labrintsetponders.LabrintSetPonders;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class LabrintSetPondersMain {
    
    public static void main(String[] args) {
        /*
        Random r = new Random();
//double mySample = r.nextGaussian()*desiredStandardDeviation+desiredMean;
        double test = 0;
        double tempVal;
        Queue<Double> queue = new LinkedList<Double>();
        for(int i=0;i<1000;i++){
            tempVal = r.nextDouble();
            System.out.println( tempVal );
            test += tempVal;
            queue.add(tempVal);
        }
        System.out.println(test/1000 + "  *****");
        
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
*/
        
        LabrintSetPonders lsp = new LabrintSetPonders();
        lsp.start();
        
    }
    
}
