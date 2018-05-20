/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralelPart;

import communResorc.CommunResurces;
import communResorc.DijkInfo;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class BarrierThreadClass implements Runnable{
    //pentru testare va trebui sa treaca de 10  ori
/*    int numberOfPsses;
    int pass;*/
    private CommunResurces comResorces;
    
    public BarrierThreadClass(CommunResurces comResorces){
    /*    this.numberOfPsses = 10;
        this.pass = 0;*/
        this.comResorces = comResorces;
    }
    
    @Override
    public void run() {
     /*   pass++;
        System.out.println("Sunt la Barrierul cu numarul: " + pass);
        if(pass>=numberOfPsses){
            comResorces.setHasReachEnd(true);
        }*/
 //    System.out.println("!BARRIER!");
     double costMinim = Integer.MAX_VALUE;
     int indexTataPunctMinim = 0;
     DijkInfo puntMinim = null;
     DijkInfo matrixOfPoints[]  = comResorces.getThreadMinim();
     for(int i=1;i<=comResorces.getNrThreads();i++){
         DijkInfo puntTemp = matrixOfPoints[i];
         if(puntTemp!=null && costMinim>puntTemp.getPretCumulat()){
             costMinim = puntTemp.getPretCumulat();
             puntMinim = puntTemp;
             indexTataPunctMinim = comResorces.getIndexTata()[i];
         }
     }
     
     int nrVeciniTat = comResorces.getBorderArray().get(indexTataPunctMinim).getNrVecini()-1;
     if( nrVeciniTat <= 0 ){
         comResorces.getBorderArray().remove(indexTataPunctMinim);
     }else{
         comResorces.getBorderArray().get(indexTataPunctMinim).setNrVecini(nrVeciniTat);
     }
//     System.out.println(puntMinim.getPunctCurent() +" " + comResorces.getEnd());
     comResorces.getPointsVisited()[puntMinim.getPunctCurent().getLinie()][puntMinim.getPunctCurent().getColoana()] = false;
     comResorces.calculateNumarulDeVecini(puntMinim);
     if(puntMinim.getNrVecini() > 0)
         comResorces.getBorderArray().add(puntMinim);
     //pentru afisare:
     comResorces.getAfisMatrix()[puntMinim.getPunctCurent().getLinie()][puntMinim.getPunctCurent().getColoana()] = puntMinim;
     comResorces.realocareThreadsDistribution();  
    
     if(puntMinim.getPunctCurent().equals(comResorces.getEnd())){
         comResorces.setHasReachEnd(true);
     }
     if(comResorces.getHasReachEnd()){
         comResorces.setTimpfinal(System.currentTimeMillis());
         comResorces.afis(comResorces.getEnd());
         System.out.println(comResorces.getTimpfinal() - comResorces.getTimpInceput());
         
         
        try{
            String numeFisier = "Rezultate";
            File f;
            PrintWriter pw;
            for(int i=0;i<10;i++){
                f = new File(numeFisier+i);
                if(f.length()==0){
                    pw = new PrintWriter(f);
                    pw.println(comResorces.getTimpfinal() - comResorces.getTimpInceput());
                    pw.close();
                    break;
                }
              //  System.out.println(f.length());
            
        }
        }catch(Exception ex){
            System.out.println(ex.getStackTrace());
        }
   
     }
     
//     System.out.println("BARRIER");
    }
    
}
