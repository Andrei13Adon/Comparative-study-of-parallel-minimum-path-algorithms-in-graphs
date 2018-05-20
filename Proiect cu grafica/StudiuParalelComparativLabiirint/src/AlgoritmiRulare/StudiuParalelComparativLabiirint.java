/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmiRulare;

import ReprezentareGf.F;
import communResorc.Punct;
import java.util.ArrayList;
import pondereDate.PunctList;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class StudiuParalelComparativLabiirint {

    /**
     * @param args the command line arguments
     */
     private static boolean[][]labirint(int marime){
         int nrLinii = marime;
         int nrColoane = marime;
         boolean temp[][] = new boolean[nrLinii][nrLinii];
         for(int i=0; i<nrLinii; i++)
             for(int j=0; j<nrColoane; j++)
                 temp[i][j] = true;
         temp[1][1] = false;
         temp[2][1] = false;
         temp[3][1] = false;
         temp[4][1] = false;
         temp[5][1] = false;
         temp[6][1] = false;
         temp[7][1] = false;
         temp[2][5] = false;
         temp[2][6] = false;
         temp[2][7] = false;
         temp[2][8] = false;
         temp[4][4] = false;
         temp[5][4] = false;
         temp[6][4] = false;
         temp[7][4] = false;
         temp[8][4] = false;
         temp[9][4] = false;
         temp[6][5] = false;
         temp[6][6] = false;
         temp[6][7] = false;
         temp[8][7] = false;
         temp[8][8] = false;
         temp[8][9] = false;
         return temp;
     }
     
     private static ArrayList<PunctList> pondereLabirint(){
     
        ArrayList<PunctList> listaAdiacenta = new ArrayList<PunctList>();
        
        listaAdiacenta.add(new PunctList(new Punct(0,0),new Punct(0,1),0.57));
        listaAdiacenta.add(new PunctList(new Punct(0,1),new Punct(0,0),0.57));
        listaAdiacenta.add(new PunctList(new Punct(0,0),new Punct(1,0),0.1));
        listaAdiacenta.add(new PunctList(new Punct(1,0),new Punct(0,0),0.1));
        listaAdiacenta.add(new PunctList(new Punct(0,1),new Punct(0,2),0.06));
        listaAdiacenta.add(new PunctList(new Punct(0,2),new Punct(0,1),0.06));
        listaAdiacenta.add(new PunctList(new Punct(1,0),new Punct(2,0),0.12));
        listaAdiacenta.add(new PunctList(new Punct(2,0),new Punct(1,0),0.12));
        listaAdiacenta.add(new PunctList(new Punct(0,2),new Punct(0,3),0.81));
        listaAdiacenta.add(new PunctList(new Punct(0,3),new Punct(0,2),0.81));
        listaAdiacenta.add(new PunctList(new Punct(0,2),new Punct(1,2),0.46));
        listaAdiacenta.add(new PunctList(new Punct(1,2),new Punct(0,2),0.46));
        listaAdiacenta.add(new PunctList(new Punct(2,0),new Punct(3,0),0.78));
        listaAdiacenta.add(new PunctList(new Punct(3,0),new Punct(2,0),0.78));
        listaAdiacenta.add(new PunctList(new Punct(0,3),new Punct(0,4),0.27));
        listaAdiacenta.add(new PunctList(new Punct(0,4),new Punct(0,3),0.27));
        listaAdiacenta.add(new PunctList(new Punct(0,3),new Punct(1,3),0.69));
        listaAdiacenta.add(new PunctList(new Punct(1,3),new Punct(0,3),0.69));
        listaAdiacenta.add(new PunctList(new Punct(1,2),new Punct(1,3),0.07));
        listaAdiacenta.add(new PunctList(new Punct(1,3),new Punct(1,2),0.07));
        listaAdiacenta.add(new PunctList(new Punct(1,2),new Punct(2,2),0.03));
        listaAdiacenta.add(new PunctList(new Punct(2,2),new Punct(1,2),0.03));
        listaAdiacenta.add(new PunctList(new Punct(3,0),new Punct(4,0),0.96));
        listaAdiacenta.add(new PunctList(new Punct(4,0),new Punct(3,0),0.96));
        listaAdiacenta.add(new PunctList(new Punct(0,4),new Punct(0,5),0.73));
        listaAdiacenta.add(new PunctList(new Punct(0,5),new Punct(0,4),0.73));
        listaAdiacenta.add(new PunctList(new Punct(0,4),new Punct(1,4),0.76));
        listaAdiacenta.add(new PunctList(new Punct(1,4),new Punct(0,4),0.76));
        listaAdiacenta.add(new PunctList(new Punct(1,3),new Punct(1,4),0.39));
        listaAdiacenta.add(new PunctList(new Punct(1,4),new Punct(1,3),0.39));
        listaAdiacenta.add(new PunctList(new Punct(1,3),new Punct(2,3),0.82));
        listaAdiacenta.add(new PunctList(new Punct(2,3),new Punct(1,3),0.82));
        listaAdiacenta.add(new PunctList(new Punct(2,2),new Punct(2,3),0.59));
        listaAdiacenta.add(new PunctList(new Punct(2,3),new Punct(2,2),0.59));
        listaAdiacenta.add(new PunctList(new Punct(2,2),new Punct(3,2),0.45));
        listaAdiacenta.add(new PunctList(new Punct(3,2),new Punct(2,2),0.45));
        listaAdiacenta.add(new PunctList(new Punct(4,0),new Punct(5,0),0.47));
        listaAdiacenta.add(new PunctList(new Punct(5,0),new Punct(4,0),0.47));
        listaAdiacenta.add(new PunctList(new Punct(0,5),new Punct(0,6),0.45));
        listaAdiacenta.add(new PunctList(new Punct(0,6),new Punct(0,5),0.45));
        listaAdiacenta.add(new PunctList(new Punct(0,5),new Punct(1,5),0.46));
        listaAdiacenta.add(new PunctList(new Punct(1,5),new Punct(0,5),0.46));
        listaAdiacenta.add(new PunctList(new Punct(1,4),new Punct(1,5),0.99));
        listaAdiacenta.add(new PunctList(new Punct(1,5),new Punct(1,4),0.99));
        listaAdiacenta.add(new PunctList(new Punct(1,4),new Punct(2,4),0.59));
        listaAdiacenta.add(new PunctList(new Punct(2,4),new Punct(1,4),0.59));
        listaAdiacenta.add(new PunctList(new Punct(2,3),new Punct(2,4),0.27));
        listaAdiacenta.add(new PunctList(new Punct(2,4),new Punct(2,3),0.27));
        listaAdiacenta.add(new PunctList(new Punct(2,3),new Punct(3,3),0.87));
        listaAdiacenta.add(new PunctList(new Punct(3,3),new Punct(2,3),0.87));
        listaAdiacenta.add(new PunctList(new Punct(3,2),new Punct(3,3),0.48));
        listaAdiacenta.add(new PunctList(new Punct(3,3),new Punct(3,2),0.48));
        listaAdiacenta.add(new PunctList(new Punct(3,2),new Punct(4,2),0.02));
        listaAdiacenta.add(new PunctList(new Punct(4,2),new Punct(3,2),0.02));
        listaAdiacenta.add(new PunctList(new Punct(5,0),new Punct(6,0),0.94));
        listaAdiacenta.add(new PunctList(new Punct(6,0),new Punct(5,0),0.94));
        listaAdiacenta.add(new PunctList(new Punct(0,6),new Punct(0,7),0.71));
        listaAdiacenta.add(new PunctList(new Punct(0,7),new Punct(0,6),0.71));
        listaAdiacenta.add(new PunctList(new Punct(0,6),new Punct(1,6),0.78));
        listaAdiacenta.add(new PunctList(new Punct(1,6),new Punct(0,6),0.78));
        listaAdiacenta.add(new PunctList(new Punct(1,5),new Punct(1,6),0.09));
        listaAdiacenta.add(new PunctList(new Punct(1,6),new Punct(1,5),0.09));
        listaAdiacenta.add(new PunctList(new Punct(2,4),new Punct(3,4),0.79));
        listaAdiacenta.add(new PunctList(new Punct(3,4),new Punct(2,4),0.79));
        listaAdiacenta.add(new PunctList(new Punct(3,3),new Punct(3,4),0.15));
        listaAdiacenta.add(new PunctList(new Punct(3,4),new Punct(3,3),0.15));
        listaAdiacenta.add(new PunctList(new Punct(3,3),new Punct(4,3),0.37));
        listaAdiacenta.add(new PunctList(new Punct(4,3),new Punct(3,3),0.37));
        listaAdiacenta.add(new PunctList(new Punct(4,2),new Punct(4,3),0.64));
        listaAdiacenta.add(new PunctList(new Punct(4,3),new Punct(4,2),0.64));
        listaAdiacenta.add(new PunctList(new Punct(4,2),new Punct(5,2),0.97));
        listaAdiacenta.add(new PunctList(new Punct(5,2),new Punct(4,2),0.97));
        listaAdiacenta.add(new PunctList(new Punct(6,0),new Punct(7,0),0.74));
        listaAdiacenta.add(new PunctList(new Punct(7,0),new Punct(6,0),0.74));
        listaAdiacenta.add(new PunctList(new Punct(0,7),new Punct(0,8),0.9));
        listaAdiacenta.add(new PunctList(new Punct(0,8),new Punct(0,7),0.9));
        listaAdiacenta.add(new PunctList(new Punct(0,7),new Punct(1,7),0.52));
        listaAdiacenta.add(new PunctList(new Punct(1,7),new Punct(0,7),0.52));
        listaAdiacenta.add(new PunctList(new Punct(1,6),new Punct(1,7),0.5));
        listaAdiacenta.add(new PunctList(new Punct(1,7),new Punct(1,6),0.5));
        listaAdiacenta.add(new PunctList(new Punct(3,4),new Punct(3,5),0.91));
        listaAdiacenta.add(new PunctList(new Punct(3,5),new Punct(3,4),0.91));
        listaAdiacenta.add(new PunctList(new Punct(4,3),new Punct(5,3),0.6));
        listaAdiacenta.add(new PunctList(new Punct(5,3),new Punct(4,3),0.6));
        listaAdiacenta.add(new PunctList(new Punct(5,2),new Punct(5,3),0.03));
        listaAdiacenta.add(new PunctList(new Punct(5,3),new Punct(5,2),0.03));
        listaAdiacenta.add(new PunctList(new Punct(5,2),new Punct(6,2),0.19));
        listaAdiacenta.add(new PunctList(new Punct(6,2),new Punct(5,2),0.19));
        listaAdiacenta.add(new PunctList(new Punct(7,0),new Punct(8,0),0.17));
        listaAdiacenta.add(new PunctList(new Punct(8,0),new Punct(7,0),0.17));
        listaAdiacenta.add(new PunctList(new Punct(0,8),new Punct(0,9),0.2));
        listaAdiacenta.add(new PunctList(new Punct(0,9),new Punct(0,8),0.2));
        listaAdiacenta.add(new PunctList(new Punct(0,8),new Punct(1,8),0.77));
        listaAdiacenta.add(new PunctList(new Punct(1,8),new Punct(0,8),0.77));
        listaAdiacenta.add(new PunctList(new Punct(1,7),new Punct(1,8),0.93));
        listaAdiacenta.add(new PunctList(new Punct(1,8),new Punct(1,7),0.93));
        listaAdiacenta.add(new PunctList(new Punct(3,5),new Punct(3,6),0.55));
        listaAdiacenta.add(new PunctList(new Punct(3,6),new Punct(3,5),0.55));
        listaAdiacenta.add(new PunctList(new Punct(3,5),new Punct(4,5),0.43));
        listaAdiacenta.add(new PunctList(new Punct(4,5),new Punct(3,5),0.43));
        listaAdiacenta.add(new PunctList(new Punct(5,3),new Punct(6,3),0.24));
        listaAdiacenta.add(new PunctList(new Punct(6,3),new Punct(5,3),0.24));
        listaAdiacenta.add(new PunctList(new Punct(6,2),new Punct(6,3),0.51));
        listaAdiacenta.add(new PunctList(new Punct(6,3),new Punct(6,2),0.51));
        listaAdiacenta.add(new PunctList(new Punct(6,2),new Punct(7,2),0.11));
        listaAdiacenta.add(new PunctList(new Punct(7,2),new Punct(6,2),0.11));
        listaAdiacenta.add(new PunctList(new Punct(8,0),new Punct(8,1),0.4));
        listaAdiacenta.add(new PunctList(new Punct(8,1),new Punct(8,0),0.4));
        listaAdiacenta.add(new PunctList(new Punct(8,0),new Punct(9,0),0.05));
        listaAdiacenta.add(new PunctList(new Punct(9,0),new Punct(8,0),0.05));
        listaAdiacenta.add(new PunctList(new Punct(0,9),new Punct(1,9),0.18));
        listaAdiacenta.add(new PunctList(new Punct(1,9),new Punct(0,9),0.18));
        listaAdiacenta.add(new PunctList(new Punct(1,8),new Punct(1,9),0.96));
        listaAdiacenta.add(new PunctList(new Punct(1,9),new Punct(1,8),0.96));
        listaAdiacenta.add(new PunctList(new Punct(3,6),new Punct(3,7),0.47));
        listaAdiacenta.add(new PunctList(new Punct(3,7),new Punct(3,6),0.47));
        listaAdiacenta.add(new PunctList(new Punct(3,6),new Punct(4,6),0.68));
        listaAdiacenta.add(new PunctList(new Punct(4,6),new Punct(3,6),0.68));
        listaAdiacenta.add(new PunctList(new Punct(4,5),new Punct(4,6),0.94));
        listaAdiacenta.add(new PunctList(new Punct(4,6),new Punct(4,5),0.94));
        listaAdiacenta.add(new PunctList(new Punct(4,5),new Punct(5,5),0.79));
        listaAdiacenta.add(new PunctList(new Punct(5,5),new Punct(4,5),0.79));
        listaAdiacenta.add(new PunctList(new Punct(6,3),new Punct(7,3),0.35));
        listaAdiacenta.add(new PunctList(new Punct(7,3),new Punct(6,3),0.35));
        listaAdiacenta.add(new PunctList(new Punct(7,2),new Punct(7,3),0.11));
        listaAdiacenta.add(new PunctList(new Punct(7,3),new Punct(7,2),0.11));
        listaAdiacenta.add(new PunctList(new Punct(7,2),new Punct(8,2),0.17));
        listaAdiacenta.add(new PunctList(new Punct(8,2),new Punct(7,2),0.17));
        listaAdiacenta.add(new PunctList(new Punct(8,1),new Punct(8,2),0.04));
        listaAdiacenta.add(new PunctList(new Punct(8,2),new Punct(8,1),0.04));
        listaAdiacenta.add(new PunctList(new Punct(8,1),new Punct(9,1),0.14));
        listaAdiacenta.add(new PunctList(new Punct(9,1),new Punct(8,1),0.14));
        listaAdiacenta.add(new PunctList(new Punct(9,0),new Punct(9,1),0.48));
        listaAdiacenta.add(new PunctList(new Punct(9,1),new Punct(9,0),0.48));
        listaAdiacenta.add(new PunctList(new Punct(1,9),new Punct(2,9),0.02));
        listaAdiacenta.add(new PunctList(new Punct(2,9),new Punct(1,9),0.02));
        listaAdiacenta.add(new PunctList(new Punct(3,7),new Punct(3,8),0.39));
        listaAdiacenta.add(new PunctList(new Punct(3,8),new Punct(3,7),0.39));
        listaAdiacenta.add(new PunctList(new Punct(3,7),new Punct(4,7),0.06));
        listaAdiacenta.add(new PunctList(new Punct(4,7),new Punct(3,7),0.06));
        listaAdiacenta.add(new PunctList(new Punct(4,6),new Punct(4,7),0.83));
        listaAdiacenta.add(new PunctList(new Punct(4,7),new Punct(4,6),0.83));
        listaAdiacenta.add(new PunctList(new Punct(4,6),new Punct(5,6),0.22));
        listaAdiacenta.add(new PunctList(new Punct(5,6),new Punct(4,6),0.22));
        listaAdiacenta.add(new PunctList(new Punct(5,5),new Punct(5,6),0.85));
        listaAdiacenta.add(new PunctList(new Punct(5,6),new Punct(5,5),0.85));
        listaAdiacenta.add(new PunctList(new Punct(7,3),new Punct(8,3),0.33));
        listaAdiacenta.add(new PunctList(new Punct(8,3),new Punct(7,3),0.33));
        listaAdiacenta.add(new PunctList(new Punct(8,2),new Punct(8,3),0.26));
        listaAdiacenta.add(new PunctList(new Punct(8,3),new Punct(8,2),0.26));
        listaAdiacenta.add(new PunctList(new Punct(8,2),new Punct(9,2),0.73));
        listaAdiacenta.add(new PunctList(new Punct(9,2),new Punct(8,2),0.73));
        listaAdiacenta.add(new PunctList(new Punct(9,1),new Punct(9,2),0.72));
        listaAdiacenta.add(new PunctList(new Punct(9,2),new Punct(9,1),0.72));
        listaAdiacenta.add(new PunctList(new Punct(2,9),new Punct(3,9),0.61));
        listaAdiacenta.add(new PunctList(new Punct(3,9),new Punct(2,9),0.61));
        listaAdiacenta.add(new PunctList(new Punct(3,8),new Punct(3,9),0.86));
        listaAdiacenta.add(new PunctList(new Punct(3,9),new Punct(3,8),0.86));
        listaAdiacenta.add(new PunctList(new Punct(3,8),new Punct(4,8),0.68));
        listaAdiacenta.add(new PunctList(new Punct(4,8),new Punct(3,8),0.68));
        listaAdiacenta.add(new PunctList(new Punct(4,7),new Punct(4,8),0.37));
        listaAdiacenta.add(new PunctList(new Punct(4,8),new Punct(4,7),0.37));
        listaAdiacenta.add(new PunctList(new Punct(4,7),new Punct(5,7),0.82));
        listaAdiacenta.add(new PunctList(new Punct(5,7),new Punct(4,7),0.82));
        listaAdiacenta.add(new PunctList(new Punct(5,6),new Punct(5,7),0.4));
        listaAdiacenta.add(new PunctList(new Punct(5,7),new Punct(5,6),0.4));
        listaAdiacenta.add(new PunctList(new Punct(8,3),new Punct(9,3),0.41));
        listaAdiacenta.add(new PunctList(new Punct(9,3),new Punct(8,3),0.41));
        listaAdiacenta.add(new PunctList(new Punct(9,2),new Punct(9,3),0.17));
        listaAdiacenta.add(new PunctList(new Punct(9,3),new Punct(9,2),0.17));
        listaAdiacenta.add(new PunctList(new Punct(3,9),new Punct(4,9),0.97));
        listaAdiacenta.add(new PunctList(new Punct(4,9),new Punct(3,9),0.97));
        listaAdiacenta.add(new PunctList(new Punct(4,8),new Punct(4,9),0.2));
        listaAdiacenta.add(new PunctList(new Punct(4,9),new Punct(4,8),0.2));
        listaAdiacenta.add(new PunctList(new Punct(4,8),new Punct(5,8),0.68));
        listaAdiacenta.add(new PunctList(new Punct(5,8),new Punct(4,8),0.68));
        listaAdiacenta.add(new PunctList(new Punct(5,7),new Punct(5,8),0.09));
        listaAdiacenta.add(new PunctList(new Punct(5,8),new Punct(5,7),0.09));
        listaAdiacenta.add(new PunctList(new Punct(4,9),new Punct(5,9),0.01));
        listaAdiacenta.add(new PunctList(new Punct(5,9),new Punct(4,9),0.01));
        listaAdiacenta.add(new PunctList(new Punct(5,8),new Punct(5,9),0.47));
        listaAdiacenta.add(new PunctList(new Punct(5,9),new Punct(5,8),0.47));
        listaAdiacenta.add(new PunctList(new Punct(5,8),new Punct(6,8),0.97));
        listaAdiacenta.add(new PunctList(new Punct(6,8),new Punct(5,8),0.97));
        listaAdiacenta.add(new PunctList(new Punct(5,9),new Punct(6,9),0.78));
        listaAdiacenta.add(new PunctList(new Punct(6,9),new Punct(5,9),0.78));
        listaAdiacenta.add(new PunctList(new Punct(6,8),new Punct(6,9),0.98));
        listaAdiacenta.add(new PunctList(new Punct(6,9),new Punct(6,8),0.98));
        listaAdiacenta.add(new PunctList(new Punct(6,8),new Punct(7,8),0.98));
        listaAdiacenta.add(new PunctList(new Punct(7,8),new Punct(6,8),0.98));
        listaAdiacenta.add(new PunctList(new Punct(6,9),new Punct(7,9),0.89));
        listaAdiacenta.add(new PunctList(new Punct(7,9),new Punct(6,9),0.89));
        listaAdiacenta.add(new PunctList(new Punct(7,8),new Punct(7,9),0.86));
        listaAdiacenta.add(new PunctList(new Punct(7,9),new Punct(7,8),0.86));
        listaAdiacenta.add(new PunctList(new Punct(7,8),new Punct(7,7),0.2));
        listaAdiacenta.add(new PunctList(new Punct(7,7),new Punct(7,8),0.2));
        listaAdiacenta.add(new PunctList(new Punct(7,7),new Punct(7,6),0.6));
        listaAdiacenta.add(new PunctList(new Punct(7,6),new Punct(7,7),0.6));
        listaAdiacenta.add(new PunctList(new Punct(7,6),new Punct(8,6),0.47));
        listaAdiacenta.add(new PunctList(new Punct(8,6),new Punct(7,6),0.47));
        listaAdiacenta.add(new PunctList(new Punct(7,6),new Punct(7,5),0.51));
        listaAdiacenta.add(new PunctList(new Punct(7,5),new Punct(7,6),0.51));
        listaAdiacenta.add(new PunctList(new Punct(8,6),new Punct(9,6),0.36));
        listaAdiacenta.add(new PunctList(new Punct(9,6),new Punct(8,6),0.36));
        listaAdiacenta.add(new PunctList(new Punct(8,6),new Punct(8,5),0.59));
        listaAdiacenta.add(new PunctList(new Punct(8,5),new Punct(8,6),0.59));
        listaAdiacenta.add(new PunctList(new Punct(7,5),new Punct(8,5),0.05));
        listaAdiacenta.add(new PunctList(new Punct(8,5),new Punct(7,5),0.05));
        listaAdiacenta.add(new PunctList(new Punct(9,6),new Punct(9,7),0.7));
        listaAdiacenta.add(new PunctList(new Punct(9,7),new Punct(9,6),0.7));
        listaAdiacenta.add(new PunctList(new Punct(9,6),new Punct(9,5),0.42));
        listaAdiacenta.add(new PunctList(new Punct(9,5),new Punct(9,6),0.42));
        listaAdiacenta.add(new PunctList(new Punct(8,5),new Punct(9,5),0.7));
        listaAdiacenta.add(new PunctList(new Punct(9,5),new Punct(8,5),0.7));
        listaAdiacenta.add(new PunctList(new Punct(9,7),new Punct(9,8),0.89));
        listaAdiacenta.add(new PunctList(new Punct(9,8),new Punct(9,7),0.89));
        listaAdiacenta.add(new PunctList(new Punct(9,8),new Punct(9,9),0.13));
        listaAdiacenta.add(new PunctList(new Punct(9,9),new Punct(9,8),0.13));
     
    
     return listaAdiacenta;
     }
     
     private static void afis(boolean[][] Labirint, int marime) {
         for(int i=0; i<marime; i++){
             for(int j=0; j<marime; j++)
                 System.out.print(Labirint[i][j] +" ");
             System.out.println();
         }
     }
    
    public static void main(String[] args) {
        // Iniial creaza o matrice manual pentru a se folosi pentru ilustrarea algoritmului
       
       
        //creare marice
        boolean[][] Labirint;
        int marime = 10;
        Labirint = labirint(marime);
        
        ArrayList<PunctList> PonderiLabirint;
        PonderiLabirint = pondereLabirint();
        
        //apelare afisare grefica
        F  Figura;
        Figura = new F(" Studiu comparativ al algoritmilor paraleli de drumuri minime in grafuri. ", Labirint, PonderiLabirint, marime);
        
    }
    
}
