/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.singleThread;

import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.DijkInfo;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.communResorc.Punct;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.pondereDate.DatePonderate;
import AlgoritmRulare.ParalelAndSngle.DelataSteppingSingle.Dijkstra.testData.TestData;
import ReprezentareGf.Grafic;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class DijSingleThread {
    
    Punct starPoint,endPoint;
    boolean matrixLabirint[][];
    int nrOfCells;
    ArrayList<DijkInfo>borderArray;
    boolean pointsVisited[][];
    DijkInfo afisMatrix[][];
    
    DatePonderate datePonderate;
    
    
    private Graphics g;
    
    private int fPrecis;
    
    private final long Secunda = 1000;
    
    public DijSingleThread(TestData td, Graphics g) {
        starPoint = td.getStart();
        endPoint = td.getEnd();
        matrixLabirint = td.getMatrixLabirint();
        nrOfCells = td.getNrOfCells();
        borderArray = new ArrayList<DijkInfo>();
        pointsVisited = this.matrixLabirint.clone();  
        afisMatrix = new DijkInfo[nrOfCells][nrOfCells];
        
        this.setG(g);
        
        this.fPrecis = (int)500/nrOfCells;
        
        datePonderate = td.getDatePonderate();
    }

    public void go() {
        long timpInceput = System.currentTimeMillis();
        
        DijkInfo startDij = new DijkInfo(0,null,starPoint);
        this.calculateNumarulDeVecini(startDij);
        this.pointsVisited[starPoint.getLinie()][starPoint.getColoana()] = false;
        borderArray.add(startDij);
        //pentru afisare:
        afisMatrix[startDij.getPunctCurent().getLinie()][startDij.getPunctCurent().getColoana()] = startDij;
        
        boolean haveReachEnd = false;
        while(!haveReachEnd&&!borderArray.isEmpty()){
            //intervatul din Array 
            int start = 0;
            int end = borderArray.size()-1;
            //Prepare retinere punct minim, lavoare si tata
            double costDrum = Integer.MAX_VALUE;
            Punct PunctMinim = null;
            int indexTataPunctMinim = 0;
            //selectez punctul care are suma punt idax + costPuntAdaugat(in cazul acesta 1) minima
            for(int i=start;i<=end;i++){
                Punct tempPunct;
                tempPunct = this.getNearestNeighbor(borderArray.get(i).getPunctCurent());
                double constPunctTemp;
                constPunctTemp = borderArray.get(i).getPretCumulat() + datePonderate.getValue(borderArray.get(i).getPunctCurent(), tempPunct);
                if(tempPunct!=null && costDrum>constPunctTemp){
                    //retinem punctul prin valoreMinima, index, noulPunct
                    PunctMinim = tempPunct;
                    costDrum = constPunctTemp;
                    indexTataPunctMinim = i;
                }
            }
            
            
        this.delay(this.Secunda);
        this.getG().setColor(Color.GREEN);
        this.getG().fillRect(PunctMinim.getColoana()*this.getfPrecis()+1 ,PunctMinim.getLinie()*this.getfPrecis()+1 , this.getfPrecis()-1 , this.getfPrecis()-1);
        
            
            //verificam daca Punctul de la indexul Vechi mai mare vecini daca NU elimnam altfel adaugam noul Punct
            if(PunctMinim != null){
                DijkInfo punctNouDeAdaugat = new DijkInfo(costDrum, this.borderArray.get(indexTataPunctMinim).getPunctCurent(), PunctMinim);
                int nrVeciniTat = this.borderArray.get(indexTataPunctMinim).getNrVecini()-1; 
                if( nrVeciniTat <= 0 ){
                    this.borderArray.remove(indexTataPunctMinim);
                }else{
                    this.borderArray.get(indexTataPunctMinim).setNrVecini(nrVeciniTat);
                }
                this.pointsVisited[PunctMinim.getLinie()][PunctMinim.getColoana()] = false;
                this.calculateNumarulDeVecini(punctNouDeAdaugat);
                if(punctNouDeAdaugat.getNrVecini() > 0)
                    this.borderArray.add(punctNouDeAdaugat);
                //pentru afisare:
                afisMatrix[punctNouDeAdaugat.getPunctCurent().getLinie()][punctNouDeAdaugat.getPunctCurent().getColoana()] = punctNouDeAdaugat;
            }
            if(PunctMinim.equals(this.endPoint)){
                haveReachEnd = true;
            }
        }
        //afisarea la consolo
        if(haveReachEnd)
            afis(endPoint);
        else
            System.out.println("Nu s-a gasit drum!");
        
        long timpfinal = System.currentTimeMillis();
        /*
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
   */
        
    }
    
    private void calculateNumarulDeVecini(DijkInfo punctCurent){
        //trebuie corectata doarece trebuie loati in considerare vecinii deja parcursi 
        int linie = punctCurent.getPunctCurent().getLinie();
        int coloana = punctCurent.getPunctCurent().getColoana();
        int nrVecini = 0;
        if(linie-1 >= 0 && pointsVisited[linie-1][coloana] == true )
            nrVecini++;
        if(coloana+1 < this.nrOfCells && pointsVisited[linie][coloana+1] == true )
            nrVecini++;
        if(linie+1 < this.nrOfCells && pointsVisited[linie+1][coloana] == true )
            nrVecini++;
        if(coloana-1 >= 0 && pointsVisited[linie][coloana-1] == true )
            nrVecini++;
        punctCurent.setNrVecini(nrVecini);
    }

    private Punct getNearestNeighbor(Punct punctCurent) {
        
        int linie = punctCurent.getLinie();
        int coloana = punctCurent.getColoana();
        if(linie-1 >= 0 && matrixLabirint[linie-1][coloana] == true )
            return new Punct(linie-1, coloana);
        if(coloana+1 < this.nrOfCells && matrixLabirint[linie][coloana+1] == true )
            return new Punct(linie, coloana+1);
        if(linie+1 < this.nrOfCells && matrixLabirint[linie+1][coloana] == true )
            return new Punct(linie+1, coloana);
        if(coloana-1 >= 0 && matrixLabirint[linie][coloana-1] == true )
            return new Punct(linie, coloana-1);
        return null;
    }

    private void afis(Punct punct) {
        DijkInfo punctInfo = afisMatrix[punct.getLinie()][punct.getColoana()];
        if(punctInfo.getTata()!=null){
            afis(punctInfo.getTata());
        }
        
        
        this.delay(this.Secunda);
        this.getG().setColor(Color.RED);
        this.getG().fillRect(punctInfo.getPunctCurent().getColoana()*this.getfPrecis()+1 , punctInfo.getPunctCurent().getLinie()*this.getfPrecis()+1 , this.getfPrecis()-1 , this.getfPrecis()-1);

        
        //System.out.println(punctInfo.getPunctCurent() + " cu preturl: " + punctInfo.getPretCumulat());
        
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public int getfPrecis() {
        return fPrecis;
    }

    public void setfPrecis(int fPrecis) {
        this.fPrecis = fPrecis;
    }
    
    
    public void delay(long timp){
        try {
            Thread.sleep(timp/this.nrOfCells);
        } catch (InterruptedException ex) {
            Logger.getLogger(Grafic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
