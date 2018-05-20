/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.paralelPart;

import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.CommunResurces;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.DijkInfo;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.IntervalClass;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.Punct;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DijkstraThread implements Runnable{
    private int threadNumber;
    private CyclicBarrier barrier;
    private CommunResurces comRes;

    public CommunResurces getComRes() {
        return comRes;
    }

    public void setComRes(CommunResurces comRes) {
        this.comRes = comRes;
    }
    
    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    
    public void setThreadNumber(int threadNumber){
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run(){/*
        int max = 10;
        int i = 0;
        i<max&&
        while(!this.comRes.getHasReachEnd()){
        //i++;
            try {
                //la final
                System.out.println(this.threadNumber+" ");
                this.barrier.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
                System.out.println(ex);
            }
        }
        */
        IntervalClass intervalThread[] = comRes.getListofIntervalsForEachThread();
        
        while(!comRes.getHasReachEnd()&&!comRes.getBorderArray().isEmpty()){
         //   System.out.println(this.threadNumber+" ");
            //intervatul din Array 
            int start = intervalThread[threadNumber].getStart();
            int end = intervalThread[threadNumber].getEnd();
            //Prepare retinere punct minim, lavoare si tata
            double costDrum = Integer.MAX_VALUE;
            Punct PunctMinim = null;
            int indexTataPunctMinim = 0;
            //selectez punctul care are suma punt idax + costPuntAdaugat(in cazul acesta 1) minima
            // System.out.println(this.threadNumber+" " + comRes.getBorderArray().size() + " - "+start + " " + end);
            for(int i=start;i<=end;i++){
               
                Punct tempPunct;
                tempPunct = comRes.getNearestNeighbor(comRes.getBorderArray().get(i).getPunctCurent());
                double constPunctTemp;
                constPunctTemp = comRes.getBorderArray().get(i).getPretCumulat()+comRes.getDatePonderate().getValue(comRes.getBorderArray().get(i).getPunctCurent(), tempPunct);
                if(tempPunct!=null && costDrum>constPunctTemp){
                    //retinem punctul prin valoreMinima, index, noulPunct
                    PunctMinim = tempPunct;
                    costDrum = constPunctTemp;
                    indexTataPunctMinim = i;
                }
            }
            //verificam daca Punctul de la indexul Vechi mai mare vecini daca NU elimnam altfel adaugam noul Punct
            if(PunctMinim != null){
                DijkInfo punctNouDeAdaugat = new DijkInfo(costDrum, comRes.getBorderArray().get(indexTataPunctMinim).getPunctCurent(), PunctMinim);
                comRes.calculateNumarulDeVecini(punctNouDeAdaugat);
                DijkInfo minThread[] =  comRes.getThreadMinim();
                minThread[this.threadNumber] = punctNouDeAdaugat;
                int indexTata[] = comRes.getIndexTata();
                indexTata[this.threadNumber] = indexTataPunctMinim;
                
                /*
                this.pointsVisited[PunctMinim.getLinie()][PunctMinim.getColoana()] = false;
                this.borderArray.add(punctNouDeAdaugat);
                //pentru afisare:
                afisMatrix[punctNouDeAdaugat.getPunctCurent().getLinie()][punctNouDeAdaugat.getPunctCurent().getColoana()] = punctNouDeAdaugat;
                */
            }else{
                DijkInfo minThread[] = comRes.getThreadMinim();
                minThread[this.threadNumber] = null;
            }
            try {
                //la final
              //  System.out.println(this.threadNumber+" ");
                this.barrier.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
                System.out.println(ex);
            }
            
            /*
            if(PunctMinim.equals(this.endPoint)){
                haveReachEnd = true;
            }*/
        }
        
    }
    
}
