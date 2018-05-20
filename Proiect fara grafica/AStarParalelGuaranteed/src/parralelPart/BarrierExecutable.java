/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parralelPart;

import communResorc.AStarInfo;
import communResorc.CommunResurces;
import communResorc.Punct;
import java.io.File;
import java.io.PrintWriter;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class BarrierExecutable implements Runnable{
    
    private CommunResurces comRes;
    
    public BarrierExecutable(CommunResurces comRes){
        this.comRes = comRes;
    }

    @Override
    public void run() {
        for(int i = 0; i<comRes.getMaxThreads();i++)
            if(comRes.getRezultatePeThreaduri()[i]!=null && !comRes.getRezultatePeThreaduri()[i].isEmpty())
                comRes.getCoadaPrioritati().addAll(comRes.getRezultatePeThreaduri()[i]);
        
      //  System.out.println("Barrier1");
      //  System.out.println(comRes.getCoadaPrioritati());
        
        AStarInfo punctTemporal;
        for(int i = 0; i<comRes.getMaxThreads();i++){

            punctTemporal = getPunctMinim();
            
          //  System.out.println(punctTemporal);
            
            if(punctTemporal!=null && punctTemporal.getPunctCurent().equals(comRes.getEnd())){
                
                comRes.setHasReachEnd(true);
                afis(comRes.getEnd());
                
                comRes.setTimpfinal( System.currentTimeMillis() );
                
                System.out.println("Timp utilizat:");
                System.out.println(comRes.getTimpfinal()-comRes.getTimpInceput());
                
                
        try{
            String numeFisier = "Rezultate";
            File f;
            PrintWriter pw;
            for(int j=0;j<10;j++){
                f = new File(numeFisier+j);
                if(f.length()==0){
                    pw = new PrintWriter(f);
                    pw.println(comRes.getTimpfinal()-comRes.getTimpInceput());
                    pw.close();
                    break;
                }
              //  System.out.println(f.length());
            
        }
        }catch(Exception ex){
            System.out.println(ex.getStackTrace());
        }
   
                        
            }
                
            comRes.getPunctThread()[i] = punctTemporal;
        }
        
    }
    
    private AStarInfo getPunctMinim(){
        
        AStarInfo punctTemporal;
        
        while(!comRes.getCoadaPrioritati().isEmpty()){
            
            punctTemporal = comRes.getCoadaPrioritati().poll();
                
            int linieCurennta = punctTemporal.getPunctCurent().getLinie();
            int colanaCurenta = punctTemporal.getPunctCurent().getColoana();
            
            if(punctTemporal.equals(comRes.getEnd()))
                comRes.setHasReachEnd(true);
                
            if(comRes.getPoinstVisited()[linieCurennta][colanaCurenta] == true){
                comRes.getPoinstVisited()[linieCurennta][colanaCurenta] = false;
                //pentru afisare
                comRes.getAfisMatrix()[linieCurennta][colanaCurenta] = punctTemporal;
                
                return punctTemporal;
                
            }
        }
        
        return null;
    }
    
    private void afis(Punct punct) {
        
        AStarInfo punctInfo = comRes.getAfisMatrix()[punct.getLinie()][punct.getColoana()];
        if(punctInfo.getTata()!=null){
            afis(punctInfo.getTata());
        }
        System.out.println(punctInfo.getPunctCurent() + " cu preturl: " + punctInfo.getPretCumulat());
       /*
        for(int i=0;i<comRes.getNrCellsLab();i++){
            for(int j=0;j<comRes.getNrCellsLab();j++)
                //System.out.print(comRes.getAfisMatrix()[i][j]+" ");
                System.out.print(comRes.getPoinstVisited()[i][j]+" ");
            System.out.println();
        }
         */
    }
    
    
}
