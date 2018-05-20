/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.Paralel.DelataSteppingSingle.delatasteppingparalel;

import AlgoritmRulare.Paralel.DelataSteppingSingle.communResorc.CommunResurces;
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
    private CommunResurces comRes;

    DeltaThread(CyclicBarrier barrierBefore, CyclicBarrier barrierAfter, int threadNumber, CommunResurces comRes) {
        this.barrierBefore = barrierBefore;
        this.barrierAfter = barrierAfter;
        this.threadNumber = threadNumber;
        this.comRes = comRes;
    }

    @Override
    public void run() {
        try {
            while(!comRes.isHasReachEnd()){
           //  System.out.println("???????????????????????????????????????????");
            barrierBefore.await();
            if(comRes.isHasReachEnd())
                break;
            //System.out.println("???/****************************************************");
            barrierAfter.await();
            if(comRes.isHasReachEnd())
                break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DeltaThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(DeltaThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
