/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctiiAjutatoare;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class FunctiiGrafice {
    
    public static void afisareMatriceGenerata(Graphics g){
        try{
            int fPrecis;
            int marimeLabirint;
            
            Scanner sc = new Scanner(new File("imput.txt"));
            marimeLabirint = sc.nextInt();
            sc.nextInt();
            sc.nextInt();
            sc.nextInt();
            sc.nextInt();

            fPrecis = (int)500/marimeLabirint;


            g.setColor(Color.WHITE);//umplere initiala
            g.fillRect(0,0, 501 , 501);
            g.setColor(Color.BLACK);
         //   int x1,y1,x2,y2;
          //  g.drawRect(0*fPrecis, 1*fPrecis, 1, 1);
            //creare grila
            for(int i=0; i<= marimeLabirint;i++)
                g.drawLine(i*fPrecis, 0, i*fPrecis, marimeLabirint*fPrecis);
            for(int j=0; j<= marimeLabirint; j++)
                g.drawLine(0, j*fPrecis, marimeLabirint*fPrecis, j*fPrecis);       
            //pune puncte pe figura
            //g.setColor(Color.RED);
            for(int i=0;i<marimeLabirint;i++)
                for(int j=0;j<marimeLabirint;j++)
                    if(sc.nextInt()==0){
                        g.fillRect(j*fPrecis+1, i*fPrecis+1, fPrecis-1 , fPrecis-1);
                    }
/*
            g.setColor(Color.GREEN);
            g.fillRect( Plecare.getColoana()*this.fPrecis+1 , Plecare.getLinie()*this.fPrecis+1 , this.fPrecis-1 , this.fPrecis-1);
*/
            sc.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
