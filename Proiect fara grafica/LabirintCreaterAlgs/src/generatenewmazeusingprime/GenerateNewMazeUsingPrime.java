/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatenewmazeusingprime;

import java.util.LinkedList;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class GenerateNewMazeUsingPrime {
    
    int marimeLab;
    boolean[][] Labirint;
    CodificarePunctMatrice Codder;
    
    public GenerateNewMazeUsingPrime(int marimeLab){
        this.marimeLab = marimeLab;
        this.Codder = new CodificarePunctMatrice();
        this.Labirint = new boolean[this.marimeLab][this.marimeLab];
    }  

    void generateNewMazeUsingPrime(Punct Plecare, Punct Destinatie) {
        for(int i=0;i<this.marimeLab;i++)
            for(int j=0;j<this.marimeLab;j++)
                this.Labirint[i][j] = false;
        LinkedList<Integer> pereti=new <Integer> LinkedList();
        
        pereti.add(this.Codder.getCodificare(Plecare.getLinie(), Plecare.getColoana(), marimeLab));
        int linieCurenta,coloanaCurenta;
        int codificarePunctCurent,pozitiePunctCurent;
        int obtiuni[] = new int[4];
        /*
        Codificare pbtiuni;
        0 - stanga
        1 - sus
        2 - dreapta
        3 - jos
        */
        int numarObtiuni;
        while(!pereti.isEmpty()){
            //selectare punct random pentru a fi facut casuta din zid
            pozitiePunctCurent = (int) ((Math.random() * this.marimeLab * this.marimeLab)%pereti.size());
            codificarePunctCurent = pereti.get(pozitiePunctCurent);
            pereti.remove(pozitiePunctCurent);
            linieCurenta = this.Codder.getLinie(codificarePunctCurent, marimeLab);
            coloanaCurenta = this.Codder.getColoana(codificarePunctCurent, marimeLab);
            if(!this.Labirint[linieCurenta][coloanaCurenta]){
                this.Labirint[linieCurenta][coloanaCurenta] = true;
                //adug vecnii sai care sunt ziduri
                numarObtiuni = 0;
                if(linieCurenta - 2 >= 0)
                    if(!this.Labirint[linieCurenta - 2][coloanaCurenta])
                        pereti.add(this.Codder.getCodificare(linieCurenta-2, coloanaCurenta, this.marimeLab));
                    else {
                        obtiuni[numarObtiuni] = 3; 
                        numarObtiuni++;
                    }
                if(linieCurenta + 2 < this.marimeLab)
                    if(!this.Labirint[linieCurenta + 2][coloanaCurenta])
                        pereti.add(this.Codder.getCodificare(linieCurenta+2, coloanaCurenta, this.marimeLab));
                    else {
                        obtiuni[numarObtiuni] = 1; 
                        numarObtiuni++;
                    }
                if(coloanaCurenta - 2 >= 0)
                    if(!this.Labirint[linieCurenta][coloanaCurenta - 2])
                        pereti.add(this.Codder.getCodificare(linieCurenta, coloanaCurenta-2, this.marimeLab));
                    else {
                        obtiuni[numarObtiuni] = 0; 
                        numarObtiuni++;
                    }
                if(coloanaCurenta + 2 < this.marimeLab)
                    if(!this.Labirint[linieCurenta][coloanaCurenta + 2])
                        pereti.add(this.Codder.getCodificare(linieCurenta, coloanaCurenta+2, this.marimeLab));
                    else {
                        obtiuni[numarObtiuni] = 2; 
                        numarObtiuni++;
                    }
                if(numarObtiuni!=0){
                //caut random un vecin care sa fie parte din labirint
                pozitiePunctCurent = (int) ((Math.random() * 10)%numarObtiuni); 
                //creez pasaz intre el si labirint devanind toti labirint
                switch (obtiuni[pozitiePunctCurent]){
                    case 0: this.Labirint[linieCurenta][coloanaCurenta - 1] =true; break;
                    case 1: this.Labirint[linieCurenta + 1][coloanaCurenta] = true; break;
                    case 2: this.Labirint[linieCurenta][coloanaCurenta + 1] = true; break;
                    case 3: this.Labirint[linieCurenta - 1][coloanaCurenta]= true; break;
                }
                }
            }
        }
        if(!this.Labirint[Destinatie.getLinie()][Destinatie.getColoana()]){
            int linie = Destinatie.getLinie();
            int coloana = Destinatie.getColoana();
            this.Labirint[linie][coloana] =true;
            boolean loc = false;
            if(linie-1 >= 0 && this.Labirint[linie-1][coloana])
                loc =true;
            if(linie+1 < this.marimeLab && this.Labirint[linie+1][coloana])
                loc =true;
            if(coloana-1 >= 0 && this.Labirint[linie][coloana-1])
                loc =true;
            if(coloana+1 < this.marimeLab && this.Labirint[linie][coloana+1])
                loc =true;
            if(!loc){
                if(linie-1 >= 0 && coloana-1 >= 0 && this.Labirint[linie-1][coloana-1]){
                    this.Labirint[linie-1][coloana] = true;
                    this.Labirint[linie][coloana-1] = true;
                }else if(linie-1 >= 0 && coloana+1 < this.marimeLab && this.Labirint[linie-1][coloana+1]){
                    this.Labirint[linie-1][coloana] = true;
                    this.Labirint[linie][coloana+1] = true;
                }else if(linie+1 < this.marimeLab && coloana-1 >= 0 && this.Labirint[linie+1][coloana-1]){
                    this.Labirint[linie+1][coloana] = true;
                    this.Labirint[linie][coloana-1] = true;
                }else if(linie+1 < this.marimeLab && coloana+1 < this.marimeLab && this.Labirint[linie+1][coloana+1]){
                    this.Labirint[linie+1][coloana] = true;
                    this.Labirint[linie][coloana+1] = true;
                }
            }
        }
    }

    public int getMarimeLab() {
        return marimeLab;
    }

    public void setMarimeLab(int marimeLab) {
        this.marimeLab = marimeLab;
    }

    public boolean[][] getLabirint() {
        return Labirint;
    }

    public void setLabirint(boolean[][] Labirint) {
        this.Labirint = Labirint;
    }

    
    
}
