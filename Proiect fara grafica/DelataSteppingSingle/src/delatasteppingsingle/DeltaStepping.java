/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delatasteppingsingle;

import communResorc.BBaketInfo;
import communResorc.CommunResurces;
import communResorc.Punct;
import communResorc.PunctValuClass;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import testData.TestData;

/**
 *
 * @author Mocioi Andrei Adonis
 */
class DeltaStepping {
    
    CommunResurces comRes;
    
    boolean hasReachEnd;
    
    void initilize(TestData td) {
        comRes = new CommunResurces(); 
        comRes.setNrCellsLab( td.getNrOfCells() );
        comRes.setStart( td.getStart() );
        comRes.setEnd( td.getEnd() );
        comRes.setMatrixLabirint( td.getMatrixLabirint() );
        double delta = 1.0/4.0;// adica 1/d d= grad maxim din graf
       // System.out.println(delta +" beg");
        comRes.initlaizeForDetaStepping(delta);
        comRes.setDatePonderate(td.getDatePonderate());
        
        hasReachEnd = false;
    }

    void start() {
        /*
        for(int i=0;i<comRes.getNrCellsLab();i++){
            for(int j=0;j<comRes.getNrCellsLab();j++)
              //  System.out.print(comRes.getMatrixLabirint()[i][j] + " ");
                System.out.print(comRes.getCostMatrix()[i][j] + " ");
            System.out.println();
        }
        
        if(Long.MAX_VALUE > comRes.getCostMatrix()[1][1])
            System.out.println("Int este mai mare");
        else 
            System.out.println("Double este mai mare");
        */
        
    //    int linie, coloana;
    //    linie = comRes.getStart().getLinie();
    //    coloana = comRes.getStart().getColoana();
  /*      
        tempAfis(comRes.getNrCellsLab());
        afisMatrix();
        relax(comRes.getStart(), 1);
        tempAfis(comRes.getNrCellsLab());
        afisMatrix();*/
  
        long timpInceput = System.currentTimeMillis();
  
        relax(comRes.getStart(), 0);
   /*     tempAfis(comRes.getNrCellsLab());
        afisMatrix();*/
        while(!isEmptyOfValues(comRes.getB()) && !hasReachEnd){
            LinkedList<PunctValuClass> Req;
            BBaketInfo galetaCurenta;
            galetaCurenta = getMinIndexBaket();
         //   System.out.println(galetaCurenta);
            BBaketInfo R = null;
            while(!galetaCurenta.getValori().isEmpty()){
                Req = findRequests(galetaCurenta, -1); //-1 lighe edgies < delta 
                                                       // 1 hevy edges > delta
                R = reuniune(R,galetaCurenta);
                
                galetaCurenta.getValori().removeAll(galetaCurenta.getValori()) ;
                
                relaxRequests(Req);
            }
            Req = findRequests(R, 1);
            relaxRequests(Req);
        }
      //  tempAfis(comRes.getNrCellsLab());
     //   afisMatrix();
        
        long timpfinal = System.currentTimeMillis();
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

    private boolean relax(Punct varfCurent, double valoareCumulata) {
      //  System.out.println(varfCurent + " *");
        double tentW =  comRes.getCostMatrix()[varfCurent.getLinie()][varfCurent.getColoana()];
        if(valoareCumulata < tentW){
            double currentIndex = tentW / comRes.getDelta();
            if(getBacket(currentIndex)!= null && getBacket(currentIndex).getValori().contains(varfCurent))
              //  createNewBaket(currentIndex);
                removeFromBaket(currentIndex,varfCurent);
            
            
            double newIndex = valoareCumulata / comRes.getDelta();
         //   System.out.println(valoareCumulata + "---");
          //  System.out.println(comRes.getDelta() + "---2");
         //   System.out.println(newIndex + " **********");
            if(getBacket(newIndex) == null)   
                createNewBaket(newIndex);
            addToBaket(newIndex, varfCurent);
            
            comRes.getCostMatrix()[varfCurent.getLinie()][varfCurent.getColoana()] = valoareCumulata;
            return true;
        }
        return false;
            
    }

    private BBaketInfo getBacket(double currentIndex) {
        Iterator baketInterator = comRes.getB().iterator();
        BBaketInfo currentBaket;
        while(baketInterator.hasNext()){
            currentBaket = (BBaketInfo) baketInterator.next();
            if(currentBaket.getValIndexInterval() == currentIndex)
                return currentBaket;
        }
        return null;
    }

    private void createNewBaket(double currentIndex) {
     //   System.out.println(currentIndex + "**********2");
        BBaketInfo baketInfo = new BBaketInfo();
        baketInfo.setValIndexInterval(currentIndex);
        comRes.getB().add(baketInfo);
    }

    private void addToBaket(double newIndex, Punct varfCurent) {
        BBaketInfo baketInfo = getBacket(newIndex);
        baketInfo.getValori().add(varfCurent);
    }

    private void removeFromBaket(double currentIndex, Punct varfCurent) {
        BBaketInfo baketInfo = getBacket(currentIndex);
        baketInfo.getValori().remove(varfCurent);
    }
    
    public void tempAfis(int nrCellsLab){
        for(int i=0;i<nrCellsLab;i++){
            for(int j=0;j<nrCellsLab;j++)
                System.out.print(comRes.getCostMatrix()[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public void afisMatrix(){
        Iterator baketInterator = comRes.getB().iterator();
        BBaketInfo currentBaket;
        while(baketInterator.hasNext()){
            currentBaket = (BBaketInfo) baketInterator.next();
            System.out.print(currentBaket.getValIndexInterval() + " ");
        }
        System.out.println();
    }

    private BBaketInfo getMinIndexBaket() {
        double indexRez = Integer.MAX_VALUE;
        Iterator baketInterator = comRes.getB().iterator();
        BBaketInfo currentBaket;
        while(baketInterator.hasNext()){
            currentBaket = (BBaketInfo) baketInterator.next();
            if(indexRez > currentBaket.getValIndexInterval() && !currentBaket.getValori().isEmpty())
                indexRez = currentBaket.getValIndexInterval();
        }
        return getBacket(indexRez);
    }

    private LinkedList<PunctValuClass> findRequests(BBaketInfo galetaCurenta, int tipDeMuchii) {//-1 light si 1 hevy
        LinkedList<PunctValuClass> resulList = new LinkedList<PunctValuClass>();
        Punct currentBaket;
        
        Iterator baketInterator = galetaCurenta.getValori().iterator();
        while(baketInterator.hasNext()){
            currentBaket = (Punct) baketInterator.next();
            /*
            if(currentBaket.equals(comRes.getEnd()))
                this.hasReachEnd = true;
            */
            
            //cauat pe cele 4 pozitii si retuneaza un Punct
            for(int cod = 1; cod <= 4; cod++){
                Punct punctUrmator = getPunctOnPoz(currentBaket, cod);// codul este una din cel 4 valor 1,2,3,4
                //System.out.println(punctUrmator+" "+ cod);
                if(tipDeMuchii == -1 ){//inseamna ca este light < delta
                    if(punctUrmator!=null && 1 <= comRes.getDelta()){
                        resulList.add(new PunctValuClass(punctUrmator, comRes.getCostMatrix()[currentBaket.getLinie()][currentBaket.getColoana()]+ comRes.getDatePonderate().getValue(currentBaket, punctUrmator), currentBaket) );
                    }

                }else{//aici inseamna ca este hevy > delta 
                    if(punctUrmator!=null && 1 > comRes.getDelta()){
                        resulList.add(new PunctValuClass(punctUrmator, comRes.getCostMatrix()[currentBaket.getLinie()][currentBaket.getColoana()]+ comRes.getDatePonderate().getValue(currentBaket, punctUrmator), currentBaket) );
                    }
            }
            }
        }
        return resulList;
    }
    
        private Punct getPunctOnPoz(Punct punct,  int cod){
            //cod:
            //  1 - sus
            //  2 - dreapta
            //  3 - jos 
            //  4 - stamga
        int linie = punct.getLinie();
        int coloana = punct.getColoana();
        if(cod == 1 && linie-1 >= 0 && comRes.getMatrixLabirint()[linie-1][coloana] == true )
            return new Punct(linie-1, coloana);
        if(cod == 2 && coloana+1 < comRes.getNrCellsLab() && comRes.getMatrixLabirint()[linie][coloana+1] == true )
            return new Punct(linie, coloana+1);
        if(cod == 3 && linie+1 < comRes.getNrCellsLab() && comRes.getMatrixLabirint()[linie+1][coloana] == true )
            return new Punct(linie+1, coloana);
        if(cod == 4 && coloana-1 >= 0 && comRes.getMatrixLabirint()[linie][coloana-1] == true )
            return new Punct(linie, coloana-1);
        return null;
    }

    private BBaketInfo reuniune(BBaketInfo R, BBaketInfo galetaCurenta) {
        if(R == null){
            R = new BBaketInfo();
            R.setValIndexInterval(galetaCurenta.getValIndexInterval());
            R.setValori(new LinkedList<Punct>());
        }
        R.getValori().addAll(galetaCurenta.getValori());
        return R;
    }

    private void relaxRequests(LinkedList<PunctValuClass> Req) {
        Iterator baketInterator = Req.iterator();
        PunctValuClass punctValore;
      //   System.out.println(Req);
        while(baketInterator.hasNext()){
            punctValore = (PunctValuClass) baketInterator.next();
            if(relax(punctValore.getPunct(), punctValore.getValue()))
                //adaug la tati
                comRes.getMatriceTati()[punctValore.getPunct().getLinie()][punctValore.getPunct().getColoana()] = punctValore.getTata();
       //     System.out.println(punctValore.getPunct()+ " "+punctValore.getValue());
        }
    }

    private boolean isEmptyOfValues(LinkedList<BBaketInfo> BacketList) {
        Iterator baketInterator = BacketList.iterator();
        BBaketInfo currentBaket;
        while(baketInterator.hasNext()){
            currentBaket = (BBaketInfo) baketInterator.next();
            if(!currentBaket.getValori().isEmpty())
                return false;
        }
        return true;
    }
    
    private void afis(Punct punct) {
        Punct punctInfo = comRes.getMatriceTati()[punct.getLinie()][punct.getColoana()];
        if(punctInfo!=null){
            afis(punctInfo);
        }
        System.out.println(punct + " cu preturl: " + comRes.getCostMatrix()[punct.getLinie()][punct.getColoana()]);
/*
        for(int i =0; i< comRes.getNrCellsLab();i++){
            for(int j =0; j< comRes.getNrCellsLab();j++)
                System.out.print(comRes.getMatriceTati()[i][j] + " * ");
            System.out.println();
        }
*/
    }
    
}
