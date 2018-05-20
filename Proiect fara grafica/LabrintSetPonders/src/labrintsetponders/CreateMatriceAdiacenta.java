/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labrintsetponders;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Mocioi Andrei Adonis
 */

public class CreateMatriceAdiacenta {

    private int marimeLabirint;
    private boolean matrice[][];
    private double matriceAdiacenta[][];
    private Punct punctStart;
    private LinkedList<Punct> queue;
    private PrintWriter pw;
   // ArrayList<PunctList>//respectiv ArratList<Punct> 
    
    CreateMatriceAdiacenta(){
        queue = new LinkedList<Punct>();
        //r.nextDouble();
    }
    
    void start() {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    //    this.matrice[punctStart.getLinie()][punctStart.getColoana()] = false;
        Random r = new Random();
        Punct currentpunct;
        Punct nextPunct;
        double pondere;
        while(!queue.isEmpty()){
            currentpunct = queue.pollFirst();
            if(this.matrice[currentpunct.getLinie()][currentpunct.getColoana()]){
             //   System.out.println(currentpunct +" **********");
                this.matrice[currentpunct.getLinie()][currentpunct.getColoana()] = false;
                for(int i=1;i<=4;i++){
                    nextPunct = getPunctOnPoz(currentpunct,i);
                    if(nextPunct!=null){
                    //    this.matrice[nextPunct.getLinie()][nextPunct.getColoana()] = false;
                        pondere = r.nextDouble();
                        pw.println(currentpunct.getLinie()+" "+currentpunct.getColoana()+" "+nextPunct.getLinie()+" "+nextPunct.getColoana()+" "+twoDForm.format(pondere));
                        pw.println(nextPunct.getLinie()+" "+nextPunct.getColoana()+" "+currentpunct.getLinie()+" "+currentpunct.getColoana()+" "+twoDForm.format(pondere));
                        queue.addLast(nextPunct);
                   //     System.out.println(nextPunct);
                    }
                }
            }
        }
    }
    
        private Punct getPunctOnPoz(Punct punct,  int cod){
            //cod:
            //  1 - sus
            //  2 - dreapta
            //  3 - jos 
            //  4 - stamga
        int linie = punct.getLinie();
        int coloana = punct.getColoana();
        if(cod == 1 && linie-1 >= 0 && matrice[linie-1][coloana] == true )
            return new Punct(linie-1, coloana);
        if(cod == 2 && coloana+1 < marimeLabirint && matrice[linie][coloana+1] == true )
            return new Punct(linie, coloana+1);
        if(cod == 3 && linie+1 < marimeLabirint && matrice[linie+1][coloana] == true )
            return new Punct(linie+1, coloana);
        if(cod == 4 && coloana-1 >= 0 && matrice[linie][coloana-1] == true )
            return new Punct(linie, coloana-1);
        return null;
    }


    public int getMarimeLabirint() {
        return marimeLabirint;
    }

    public void setMarimeLabirint(int marimeLabirint) {
        this.marimeLabirint = marimeLabirint;
        matriceAdiacenta = new double[marimeLabirint][marimeLabirint];
        for(int i=0;i<marimeLabirint;i++)
            for(int j=0;j<marimeLabirint;j++)
                matriceAdiacenta[i][j] = 2;
    }

    public boolean[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(boolean[][] matrice) {
        this.matrice = matrice;
    }

    public Punct getPunctStart() {
        return punctStart;
    }

    public void setPunctStart(Punct punctStart) {
        this.punctStart = punctStart;
        this.queue.add(punctStart);
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
    
    
    
    
}
