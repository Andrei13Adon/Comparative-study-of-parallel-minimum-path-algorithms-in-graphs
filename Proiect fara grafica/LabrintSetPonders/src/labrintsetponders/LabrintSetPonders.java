/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labrintsetponders;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class LabrintSetPonders {

    private int marimeLabirint;
    private Punct punctStart,punctStop;
    private boolean matrice[][];
    
    public void start() {
        try {
            
            Scanner sc = new Scanner(new File("imputLab.txt"));
            marimeLabirint = sc.nextInt();
            punctStart = new Punct(sc.nextInt(), sc.nextInt());
            punctStop = new Punct(sc.nextInt(), sc.nextInt());
            
            matrice = new boolean[marimeLabirint][marimeLabirint];
            
            for(int i=0;i<marimeLabirint;i++)
                for(int j=0;j<marimeLabirint;j++)
                    if(sc.nextInt() == 1)
                        matrice[i][j] = true;
                    else 
                        matrice[i][j] = false;
            
            PrintWriter pw = new PrintWriter(new File("imput.txt"));
            pw.println(marimeLabirint);
            pw.println(punctStart.getLinie() + " " + punctStart.getColoana());
            pw.println(punctStop.getLinie() + " " + punctStop.getColoana());
            
            for(int i=0;i<marimeLabirint;i++){
                for(int j=0;j<marimeLabirint;j++)
                    if(matrice[i][j])
                        pw.print(1 + " ");
                    else 
                        pw.print(0 + " ");
                 pw.println();
            }
            
            pw.flush();
            //stare punct start si punct stop
            punctStart.setLinie(punctStart.getLinie()-1);
            punctStart.setColoana(punctStart.getColoana()-1);
            
            punctStop.setLinie(punctStop.getLinie()-1);
            punctStop.setColoana(punctStop.getColoana()-1);
            
            
            /*
            GenerateNewMazeUsingPrime usingPrime = new GenerateNewMazeUsingPrime(marimeLabirint);
       //     usingPrime.setMarimeLab(marimeLabirint);
            usingPrime.generateNewMazeUsingPrime(punctStart, punctStop);
            
            for(int i=0;i<marimeLabirint; i++){
                for(int j=0;j<marimeLabirint; j++)
                    if(usingPrime.getLabirint()[i][j])
                        pw.print(1 + " ");
                    else 
                        pw.print(0 + " ");
                pw.println();
            }
            */
            
            CreateMatriceAdiacenta cma = new CreateMatriceAdiacenta();
            cma.setMarimeLabirint(marimeLabirint);
            cma.setMatrice(matrice);
            cma.setPunctStart(punctStart);
            cma.setPw(pw);
            cma.start();
            
            pw.flush();
            
            sc.close();
            pw.close();
            
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getStackTrace());
        }
    }
    
}
