/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsingleguaranteed;

import communResorc.AStarInfo;
import communResorc.CommunResurces;
import communResorc.Punct;
import java.io.File;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
//mai trebuie adaugat pentru cazul cand primul drum nu este minim si mai duce un drum la nodul final
public class AStar {
    
    CommunResurces comRes;
    PriorityQueue<AStarInfo> minValPoint;
    AStarInfo currentPoint;
    
    public void intialization(TestData td){
        comRes = new CommunResurces(); 
        comRes.setNrCellsLab(td.getNrOfCells());
        comRes.setMatrixLabirint(td.getMatrixLabirint());
        comRes.setStart(td.getStart());
        comRes.setEnd(td.getEnd());
        
        comRes.setDatePonderate(td.getDatePonderate());
    }
    
    public void start() {
        
        long timpInceput = System.currentTimeMillis();
        
        //cream Punctul de plecare
        currentPoint = new AStarInfo(0, comRes.Aprox(comRes.getStart(), comRes.getEnd()),null,comRes.getStart());
        
        int linieCurennta, colanaCurenta; 
        boolean hasReachend = false;
        
        minValPoint = new PriorityQueue<AStarInfo>();
        
        
        while(currentPoint != null && !hasReachend){
            linieCurennta = currentPoint.getPunctCurent().getLinie();
            colanaCurenta = currentPoint.getPunctCurent().getColoana();
            /*
            System.out.println(minValPoint.size()+": " + linieCurennta+" " + colanaCurenta);
            System.out.println(currentPoint.getPunctCurent());*/
            
            
            if(comRes.getPoinstVisited()[linieCurennta][colanaCurenta] == true){
                comRes.getPoinstVisited()[linieCurennta][colanaCurenta] = false;
                //pentru afisare
                comRes.getAfisMatrix()[linieCurennta][colanaCurenta] = currentPoint;
                
                adaugaPuncte(linieCurennta, colanaCurenta);
                
            }/*else{
               if(currentPoint.getPretCumulat()<comRes.getAfisMatrix()[linieCurennta][colanaCurenta].getPretCumulat()){
                   comRes.getAfisMatrix()[linieCurennta][colanaCurenta] = currentPoint;
                   
                   adaugaPuncte(linieCurennta, colanaCurenta);
                   
               }
            }*/
            
            if(currentPoint.getPunctCurent().equals(comRes.getEnd())){
                //System.out.println(currentPoint.getPunctCurent() + " " + noMoreNeighbors(comRes.getEnd()));
                
             //  if(noMoreNeighbors(comRes.getEnd())){
                hasReachend = true; 
                break;
             //  }
               
               //mai trebuie adaugat pentru cazul cand primul drum nu este minim si mai duce un drum la nodul final
            } 
            
            currentPoint = minValPoint.poll();
            
            //verificam daca mai are vecini daca nu oprim;
        /*    if(currentPoint!=null && currentPoint.getPunctCurent().equals(comRes.getEnd())){
               if(noMoreNeighbors(comRes.getEnd())){
                   hasReachend = true; 
                   afis(comRes.getEnd());
               }
            }   
            */
             //  comRes.getAfisMatrix()[currentPoint.getPunctCurent().getLinie()][currentPoint.getPunctCurent().getColoana()] = currentPoint;
                
                
                
                /*
                //dauga afisare + matrice de afisare in comRes
                afis(comRes.getEnd());
                */
            
        }
    /*    if(hasReachend)
            afis(comRes.getEnd());*/
    
    long timpfinal = System.currentTimeMillis();
    if(hasReachend)
        afis(comRes.getEnd());
    
    System.out.println("Timp utilizat:");
    System.out.println(timpfinal-timpInceput);
    
    
        try{
            String numeFisier = "Rezultate";
            File f;
            PrintWriter pw;
            for(int i=0;i<10;i++){
                f = new File(numeFisier+i);
                if(f.length()==0){
                    pw = new PrintWriter(f);
                    pw.println(timpfinal-timpInceput);
                    pw.close();
                    break;
                }
              //  System.out.println(f.length());
            
        }
        }catch(Exception ex){
            System.out.println(ex.getStackTrace());
        }
   
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
    
    private void adaugaPuncte(int linieCurennta, int colanaCurenta){
        //aici se scrie practic pasul de interatie al algoritmului
        // addded comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat)
                if(linieCurennta-1 >= 0 && comRes.getPoinstVisited()[linieCurennta-1][colanaCurenta] == true ){
                    Punct punctNouAdugat = new Punct(linieCurennta-1, colanaCurenta);
                    
               //     System.out.println(linieCurennta+","+colanaCurenta+":"+currentPoint.getPunctCurent()+" "+punctNouAdugat +" "+comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat));
                    
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd());
                    minValPoint.add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
                if(linieCurennta+1 < comRes.getNrCellsLab() && comRes.getPoinstVisited()[linieCurennta+1][colanaCurenta] == true ){
                    Punct punctNouAdugat = new Punct(linieCurennta+1, colanaCurenta);
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd());
                    minValPoint.add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
                if(colanaCurenta+1 < comRes.getNrCellsLab() && comRes.getPoinstVisited()[linieCurennta][colanaCurenta+1] == true ){
                    
                    Punct punctNouAdugat = new Punct(linieCurennta, colanaCurenta+1);
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd());
                    minValPoint.add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
                if(colanaCurenta-1 >= 0 && comRes.getPoinstVisited()[linieCurennta][colanaCurenta-1] == true ){ 
                    Punct punctNouAdugat = new Punct(linieCurennta, colanaCurenta-1);
                    double pretNou = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat);
                    double pretPrezis = currentPoint.getPretCumulat() + comRes.getDatePonderate().getValue(currentPoint.getPunctCurent(), punctNouAdugat) + comRes.Aprox(punctNouAdugat, comRes.getEnd());
                    minValPoint.add(new AStarInfo(pretNou, pretPrezis, currentPoint.getPunctCurent(), punctNouAdugat));
                }
    }
/*
    private boolean noMoreNeighbors(Punct end) {
        int linieCurenta = end.getLinie();
        int colanaCurenta = end.getColoana();
        
        if(linieCurenta-1 >= 0 && comRes.getPoinstVisited()[linieCurenta-1][colanaCurenta] == true )
            return false;
        if(linieCurenta+1 < comRes.getNrCellsLab() && comRes.getPoinstVisited()[linieCurenta+1][colanaCurenta] == true )
            return false;
        if(colanaCurenta+1 < comRes.getNrCellsLab() && comRes.getPoinstVisited()[linieCurenta][colanaCurenta+1] == true )
            return false;
        if(colanaCurenta-1 >= 0 && comRes.getPoinstVisited()[linieCurenta][colanaCurenta-1] == true )
            return false;
        return true;
    }
*/
}
