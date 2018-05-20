/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communResorc;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class AStarInfo implements Comparable<AStarInfo>{
    
    
     private double PretCumulat;
     private Punct Tata;
     private Punct PunctCurent;
  //   private int vecini;
     private double PretTotalPrezis;
/*
    public DijkInfo() {
    }
*/
    public AStarInfo(double PretCumulat, double PretTotalPrezis, Punct Tata, Punct PunctCurent) {
        this.PretCumulat = PretCumulat;
        this.Tata = Tata;
        this.PunctCurent = PunctCurent;
   //     this.vecini = -1;
        this.PretTotalPrezis = PretTotalPrezis;
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
/*
    public int getNrVecini() {
        return vecini;
    }

    public void setNrVecini(int vecini) {
        this.vecini = vecini;
    }
*/
    public double getPretTotalPrezis() {
        return PretTotalPrezis;
    }

    public void setPretTotalPrezis(double PretTotalPrezis) {
        this.PretTotalPrezis = PretTotalPrezis;
    }

    @Override
    public int compareTo(AStarInfo o) {
       // if(o instanceof AStarInfo)
       if(this.getPretTotalPrezis() < o.getPretTotalPrezis())
            return -1;
        if(this.getPretTotalPrezis() > o.getPretTotalPrezis())
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "{" + PunctCurent + '}';
    }
    
    
    
}
