/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parralelPart;

import communResorc.AStarInfo;
import communResorc.CommunResurces;
import communResorc.Punct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class AStarGarThread implements Runnable{
    
    CommunResurces comRes;
    AStarInfo currentPoint;
    CyclicBarrier barrier;
    int threadNumber;
    
    AStarGarThread(CommunResurces comRes, CyclicBarrier barrier, int threadNumber) {
        this.comRes = comRes;
        this.barrier = barrier;
        this.threadNumber = threadNumber;
    }
    
    
    @Override
    public void run() {
        while(!comRes.isHasReachEnd()){
            
            try {
                barrier.await();
                
                currentPoint = comRes.getPunctThread()[threadNumber]; 
                
                if(currentPoint!=null){
                    int linie = currentPoint.getPunctCurent().getLinie();;
                    int coloana =  currentPoint.getPunctCurent().getColoana();
                    
                    comRes.getRezultatePeThreaduri()[threadNumber] = new LinkedList<AStarInfo>();

                    adaugaPuncte(linie, coloana);
                    
                }else{
                    comRes.getRezultatePeThreaduri()[threadNumber] = null;
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(AStarGarThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(AStarGarThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    private void adaugaPuncte(int linieCurennta, int colanaCurenta){
        //aici se scrie practic pasul de interatie al algoritmului
                if(linieCurennta-1 >= 0 && comRes.getPoinstVisited()[linieCurennta-1][colanaCurenta] == true ){
                    Punct punctNouAdugat = new Punct(linieCurennta-1, colanaCurenta);
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd());
                    comRes.getRezultatePeThreaduri()[threadNumber].add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
                if(linieCurennta+1 < comRes.getNrCellsLab() && comRes.getPoinstVisited()[linieCurennta+1][colanaCurenta] == true ){
                    Punct punctNouAdugat = new Punct(linieCurennta+1, colanaCurenta);
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = currentPoint.getPretCumulat() +  comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd());
                    comRes.getRezultatePeThreaduri()[threadNumber].add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
                if(colanaCurenta+1 < comRes.getNrCellsLab() && comRes.getPoinstVisited()[linieCurennta][colanaCurenta+1] == true ){
                    Punct punctNouAdugat = new Punct(linieCurennta, colanaCurenta+1);
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = (int) (currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd()));
                    comRes.getRezultatePeThreaduri()[threadNumber].add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
                if(colanaCurenta-1 >= 0 && comRes.getPoinstVisited()[linieCurennta][colanaCurenta-1] == true ){
                    Punct punctNouAdugat = new Punct(linieCurennta, colanaCurenta-1);
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = (int) (currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd()));
                    comRes.getRezultatePeThreaduri()[threadNumber].add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
    }
    
}
