/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timpmediu;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class TimpMediu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try{
            String numeFisier = "Rezultate";
            File f;
            Scanner sc;
            long sum = 0;
            for(int i=0;i<10;i++){
                f = new File(numeFisier+i);
                sc = new Scanner(f);
                sum += sc.nextLong();
            }
            System.out.println(sum/10.0);
            
        
        }catch(Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }
    
}
