/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delatasteppingparalel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DeltaThread implements Runnable{
    
    private CyclicBarrier barrierBefore;
    private CyclicBarrier barrierAfter;
    private int threadNumber;

    DeltaThread(CyclicBarrier barrierBefore, CyclicBarrier barrierAfter, int threadNumber) {
        this.barrierBefore = barrierBefore;
        this.barrierAfter = barrierAfter;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            while(true){
           //  System.out.println("???????????????????????????????????????????");
            barrierBefore.await();
            //System.out.println("???/****************************************************");
            barrierAfter.await();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DeltaThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(DeltaThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
