/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctiiAjutatoare;

import ReprezentareGf.Punct;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class FunctiiFisiere {
    
    public static boolean initializareFisiere(Punct Plecare, Punct Destinatie, int marimeLab){
        
        try{
            PrintWriter pw = new PrintWriter(new File("initData.txt"));
            pw.println(marimeLab);
            pw.println((Plecare.getLinie()+1) + " " + (Plecare.getColoana()+1));
            pw.println((Destinatie.getLinie()+1) + " " + (Destinatie.getColoana()+1));
            
            pw.close();
            
            return true;
        
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
}
