/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatenewmazeusingprime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class LabirintCreaterAlgsPrime {

    private int marimeLabirint;
    private Punct punctStart,punctStop;
    
    public void start() {
        try {
            
            Scanner sc = new Scanner(new File("initData.txt"));
            marimeLabirint = sc.nextInt();
            punctStart = new Punct(sc.nextInt(), sc.nextInt());
            punctStop = new Punct(sc.nextInt(), sc.nextInt());
            sc.close();
            
            PrintWriter pw = new PrintWriter(new File("imputLab.txt"));
            pw.println(marimeLabirint);
            pw.println(punctStart.getLinie() + " " + punctStart.getColoana());
            pw.println(punctStop.getLinie() + " " + punctStop.getColoana());
            pw.flush();
            //stare punct start si punct stop
            punctStart.setLinie(punctStart.getLinie()-1);
            punctStart.setColoana(punctStart.getColoana()-1);
            
            punctStop.setLinie(punctStop.getLinie()-1);
            punctStop.setColoana(punctStop.getColoana()-1);
            
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
            
            pw.flush();
            
            pw.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LabirintCreaterAlgsPrime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
