/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package communResorc;

/**
 *
 * @author STOLO
 */
public class DijkInfo{
    
     private double PretCumulat;
     private Punct Tata;
     private Punct PunctCurent;
     private int vecini;
/*
    public DijkInfo() {
    }
*/
    public DijkInfo(double PretCumulat, Punct Tata, Punct PunctCurent) {
        this.PretCumulat = PretCumulat;
        this.Tata = Tata;
        this.PunctCurent = PunctCurent;
        this.vecini = -1;
    }

    public Punct getTata() {
        return Tata;
    }

    public Punct getPunctCurent() {
        return PunctCurent;
    }


    public double getPretCumulat() {
        return PretCumulat;
    }

    public int getNrVecini() {
        return vecini;
    }

    public void setNrVecini(int vecini) {
        this.vecini = vecini;
    }
    
    
}
