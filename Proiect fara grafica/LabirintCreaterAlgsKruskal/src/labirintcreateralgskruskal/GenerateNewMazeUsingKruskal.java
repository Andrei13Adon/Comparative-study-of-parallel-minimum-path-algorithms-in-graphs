/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labirintcreateralgskruskal;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Mocioi Andrei Adonis
 */
public class GenerateNewMazeUsingKruskal {
    
    int marimeLab;
    boolean[][] Labirint;
    CodificarePunctMatrice Codder;
    
    public GenerateNewMazeUsingKruskal(int marimeLab){
        this.marimeLab = marimeLab;
        this.Codder = new CodificarePunctMatrice();
        this.Labirint = new boolean[this.marimeLab][this.marimeLab];
    }
    
    void generateNewMazeUsingKruskal(Punct Plecare, Punct Destinatie) {
        for(int i=0;i<this.marimeLab;i++)
            for(int j=0;j<this.marimeLab;j++)
                this.Labirint[i][j] = false;
        
        
        boolean comlete=false;
        int nrIncercari=0;
        while(!comlete && nrIncercari<100){
            nrIncercari++;
        LinkedList<Integer> pereti=new <Integer> LinkedList();
        int linieCurenta = Plecare.getLinie();
        int coloanaCurenta = Plecare.getColoana();
        int nrClustere = 0;
        int[][] labCloneCluster = new int[this.marimeLab][this.marimeLab]; //retinr culsterele in labirint
        for(int i=0;i<this.marimeLab;i++)
            for(int j=0;j<this.marimeLab;j++)
            if(!((i==linieCurenta && j==coloanaCurenta)||(i==Destinatie.getLinie() && j==Destinatie.getColoana()))){
                    this.Labirint[i][j] = false;
                    pereti.add(this.Codder.getCodificare(i, j, this.marimeLab));
                    pereti.add(this.Codder.getCodificare(i, j, this.marimeLab));
                   // pereti.add(this.Codder.getCodificare(i, j, this.marimeLab));
                   // pereti.add(this.Codder.getCodificare(i, j, this.marimeLab));
                    labCloneCluster[i][j]=0;
            }else{
                nrClustere++;
                this.Labirint[i][j]=true;
                labCloneCluster[i][j]=nrClustere;
            }
        /*
        nrClustere++;
        this.Labirint[linieCurenta][coloanaCurenta]=true;
        this.Labirint[linieCurenta+1][coloanaCurenta]=true;
        this.Labirint[linieCurenta][coloanaCurenta+1]=true;
        labCloneCluster[linieCurenta][coloanaCurenta]=nrClustere;
        labCloneCluster[linieCurenta+1][coloanaCurenta]=nrClustere;
        labCloneCluster[linieCurenta][coloanaCurenta+1]=nrClustere;
        
        this.Labirint[linieCurenta+2][coloanaCurenta]=true;
        this.Labirint[linieCurenta][coloanaCurenta+2]=true;
        labCloneCluster[linieCurenta+2][coloanaCurenta]=nrClustere;
        labCloneCluster[linieCurenta][coloanaCurenta+2]=nrClustere;
        
        nrClustere++;        
        this.Labirint[Destinatie.getLinie()][Destinatie.getColoana()]=true;
        this.Labirint[Destinatie.getLinie()-1][Destinatie.getColoana()]=true;
        this.Labirint[Destinatie.getLinie()][Destinatie.getColoana()-1]=true;
        labCloneCluster[Destinatie.getLinie()][Destinatie.getColoana()]=nrClustere;
        labCloneCluster[Destinatie.getLinie()-1][Destinatie.getColoana()]=nrClustere;
        labCloneCluster[Destinatie.getLinie()][Destinatie.getColoana()-1]=nrClustere;
        
        this.Labirint[Destinatie.getLinie()-2][Destinatie.getColoana()]=true;
        this.Labirint[Destinatie.getLinie()][Destinatie.getColoana()-2]=true;
        labCloneCluster[Destinatie.getLinie()-2][Destinatie.getColoana()]=nrClustere;
        labCloneCluster[Destinatie.getLinie()][Destinatie.getColoana()-2]=nrClustere;
        */
        int pozitiePunctCurent,codificarePunctCurent;
        //int numarObtiuni;
   //     int obtiuni[] = new int[4];
          /*
        Codificare pbtiuni;
        0 - stanga
        1 - sus
        2 - dreapta
        3 - jos
        */
        while(!pereti.isEmpty()){
        for(int i=0;i<this.marimeLab;i++)
            for(int j=0;j<this.marimeLab;j++){
               if(labCloneCluster[i][j]!=0) {
                   setCluster(labCloneCluster,labCloneCluster[i][j],i,j);
               }
            }
            pozitiePunctCurent = (int)((Math.random()*2.0 * this.marimeLab * this.marimeLab)%pereti.size());
           // System.out.println(pozitiePunctCurent+" "+pereti.size());
            codificarePunctCurent = pereti.get(pozitiePunctCurent);
            linieCurenta = this.Codder.getLinie(codificarePunctCurent, this.marimeLab);
            coloanaCurenta = this.Codder.getColoana(codificarePunctCurent, this.marimeLab);
            pereti.remove(pozitiePunctCurent);
            
            if(!this.Labirint[linieCurenta][coloanaCurenta]){
                int rezVerificareLinie, rezVerifcareColoana;
                rezVerificareLinie = getVerificareLinie(linieCurenta,coloanaCurenta,labCloneCluster);
                rezVerifcareColoana = getVerificareColoana(linieCurenta,coloanaCurenta,labCloneCluster);
          //      System.out.println(rezVerificareLinie+" "+rezVerifcareColoana+" "+nrClustere+"++++++++");
                if(rezVerificareLinie!=1 && rezVerifcareColoana!=1){
                    if(rezVerificareLinie==2 || rezVerifcareColoana==2){
                        //2 clustere diferite
                        //this.Labirint[linieCurenta][coloanaCurenta] = true;
                        if(rezVerificareLinie==2){
                            setCluster(labCloneCluster,labCloneCluster[linieCurenta-1][coloanaCurenta],linieCurenta+1,coloanaCurenta);
                            labCloneCluster[linieCurenta][coloanaCurenta] = labCloneCluster[linieCurenta-1][coloanaCurenta];
                            this.Labirint[linieCurenta][coloanaCurenta] = true;
                        }else{
                            setCluster(labCloneCluster,labCloneCluster[linieCurenta][coloanaCurenta-1],linieCurenta,coloanaCurenta+1);
                            labCloneCluster[linieCurenta][coloanaCurenta] = labCloneCluster[linieCurenta][coloanaCurenta+1];
                            this.Labirint[linieCurenta][coloanaCurenta] = true;
                        }  
                    }else
                      /*  if((rezVerificareLinie>=3 &&rezVerifcareColoana==0) ||( rezVerifcareColoana>=3 && rezVerificareLinie==0)) {
                        if(rezVerificareLinie>=3){
                            if(rezVerificareLinie==3){
                                this.Labirint[linieCurenta][coloanaCurenta] = true;
                             //   this.Labirint[linieCurenta+1][coloanaCurenta] = true;
                                labCloneCluster[linieCurenta][coloanaCurenta] = labCloneCluster[linieCurenta-1][coloanaCurenta];
                              //  labCloneCluster[linieCurenta+1][coloanaCurenta] = labCloneCluster[linieCurenta-1][coloanaCurenta];
                            }
                           if(rezVerificareLinie==4){
                                this.Labirint[linieCurenta][coloanaCurenta] = true;
                           //  this.Labirint[linieCurenta-1][coloanaCurenta] = true;
                             labCloneCluster[linieCurenta][coloanaCurenta] = labCloneCluster[linieCurenta+1][coloanaCurenta];
                            // labCloneCluster[linieCurenta-1][coloanaCurenta] = labCloneCluster[linieCurenta+1][coloanaCurenta];
                           }
                        }else if(rezVerifcareColoana>=3){
                            if(rezVerifcareColoana==3){
                              this.Labirint[linieCurenta][coloanaCurenta] = true;
                           //   this.Labirint[linieCurenta][coloanaCurenta+1] = true;
                              labCloneCluster[linieCurenta][coloanaCurenta] = labCloneCluster[linieCurenta][coloanaCurenta-1];
                            //  labCloneCluster[linieCurenta][coloanaCurenta+1] = labCloneCluster[linieCurenta][coloanaCurenta-1];
                            }
                            if(rezVerifcareColoana==4){
                                this.Labirint[linieCurenta][coloanaCurenta] = true;
                              //  this.Labirint[linieCurenta][coloanaCurenta-1] = true;
                                labCloneCluster[linieCurenta][coloanaCurenta] = labCloneCluster[linieCurenta][coloanaCurenta+1];
                             //   labCloneCluster[linieCurenta][coloanaCurenta-1] = labCloneCluster[linieCurenta][coloanaCurenta+1];
                            }
                        }
                    
                        }else */if(rezVerificareLinie==0 && rezVerifcareColoana==0){
                        if(((int)(Math.random()*10)%2)==0){
                            this.Labirint[linieCurenta][coloanaCurenta] = true;
                            this.Labirint[linieCurenta-1][coloanaCurenta] = true;
                            this.Labirint[linieCurenta+1][coloanaCurenta] = true;
                            nrClustere++;//crearea cluster nou
                            
                            labCloneCluster[linieCurenta][coloanaCurenta] = nrClustere;
                            labCloneCluster[linieCurenta-1][coloanaCurenta] = nrClustere;
                            labCloneCluster[linieCurenta+1][coloanaCurenta] = nrClustere;
                        }else{
                            this.Labirint[linieCurenta][coloanaCurenta] = true;
                            this.Labirint[linieCurenta][coloanaCurenta-1] = true;
                            this.Labirint[linieCurenta][coloanaCurenta+1] = true;
                            nrClustere++;//crearea cluster nou
                            labCloneCluster[linieCurenta][coloanaCurenta] = nrClustere;
                            labCloneCluster[linieCurenta][coloanaCurenta-1] = nrClustere;
                            labCloneCluster[linieCurenta][coloanaCurenta+1] = nrClustere;
                        }
                    }
                }
            }
        }/*
        for(int i=0;i<this.marimeLab;i++)
            for(int j=0;j<this.marimeLab;j++){
           //     this.drawCell(i, j, g);
               if(labCloneCluster[i][j]!=0) {
                   if((i-1 >= 0 && j-1 >= 0) && Labirint[i-1][j-1] == true && labCloneCluster[i][j] != labCloneCluster[i-1][j-1]){
                       this.Labirint[i-1][j] = true;
                       labCloneCluster[i-1][j] = labCloneCluster[i][j];
                       setCluster(labCloneCluster,labCloneCluster[i][j],i-1,j-1);
                   }
         if((i+1 < this.marimeLab && j+1 < this.marimeLab) && Labirint[i+1][j+1] == true  && labCloneCluster[i][j] != labCloneCluster[i+1][j+1]){
                       this.Labirint[i+1][j] = true;
                       labCloneCluster[i+1][j] = labCloneCluster[i][j];
                       setCluster(labCloneCluster,labCloneCluster[i][j],i+1,j+1);
                   }
         if((i-1 >= 0 && j+1 < this.marimeLab) && Labirint[i-1][j+1] == true && labCloneCluster[i][j] != labCloneCluster[i-1][j+1]){
                       this.Labirint[i][j+1] = true;
                       labCloneCluster[i][j+1] = labCloneCluster[i][j];
                       setCluster(labCloneCluster,labCloneCluster[i][j],i-1,j+1);
                   }
         if((i+1 < this.marimeLab && j-1 >= 0) && Labirint[i+1][j-1] == true && labCloneCluster[i][j] != labCloneCluster[i+1][j-1]){
                       this.Labirint[i][j-1] = true;
                       labCloneCluster[i][j-1] = labCloneCluster[i][j];
                       setCluster(labCloneCluster,labCloneCluster[i][j],i+1,j-1);
                   }
             //  System.out.println(labCloneCluster[i][j]+" "+nrClustere+" i:"+i+" j:"+j);
               }
            }*/
        comlete=true;
        for(int i=0;i<this.marimeLab;i++)
            for(int j=0;j<this.marimeLab;j++)
                if(labCloneCluster[i][j]!=0 && labCloneCluster[i][j]!=labCloneCluster[Destinatie.getLinie()][Destinatie.getColoana()])comlete=false;
        }
        
        }

    public boolean[][] getLabirint() {
        return Labirint;
    }

    public void setLabirint(boolean[][] Labirint) {
        this.Labirint = Labirint;
    }


    private int[][] setCluster(int[][] labCloneCluster, int numarCluster, int linieCurenta, int coloanaCurenta) {
        /* 
       System.out.println(numarCluster+"???????????????????");
       for(int i=0;i<this.marimeLab;i++){
            for(int j=0;j<this.marimeLab;j++)
                System.out.print(labCloneCluster[i][j]+" ");
        System.out.println();}*/
        Punct Plecare = new Punct(linieCurenta,coloanaCurenta);
        ArrayList <Punct> tempTraseu = new <Punct> ArrayList();
        int lugime = 0;
        tempTraseu.add(Plecare);
        lugime ++;
        for(int i=0;i<lugime;i++){
            //Pas incercare de a vedea pe unde se mai poate duce
         if( tempTraseu.get(i).getLinie()-1 >= 0 && Labirint[tempTraseu.get(i).getLinie()-1][tempTraseu.get(i).getColoana()] == true && labCloneCluster[tempTraseu.get(i).getLinie()-1][tempTraseu.get(i).getColoana()] != numarCluster ){
             tempTraseu.add(new Punct((tempTraseu.get(i).getLinie()-1),(tempTraseu.get(i).getColoana())));
             lugime++;
             labCloneCluster[tempTraseu.get(i).getLinie()-1][tempTraseu.get(i).getColoana()] = numarCluster;
         }
         if( tempTraseu.get(i).getColoana()+1 < this.marimeLab && Labirint[tempTraseu.get(i).getLinie()][tempTraseu.get(i).getColoana()+1] == true && labCloneCluster[tempTraseu.get(i).getLinie()][tempTraseu.get(i).getColoana()+1] != numarCluster){
             tempTraseu.add(new Punct(tempTraseu.get(i).getLinie(),tempTraseu.get(i).getColoana()+1));
             lugime++;
             labCloneCluster[tempTraseu.get(i).getLinie()][tempTraseu.get(i).getColoana()+1] = numarCluster;
         }
         if( tempTraseu.get(i).getLinie()+1 < this.marimeLab && Labirint[tempTraseu.get(i).getLinie()+1][tempTraseu.get(i).getColoana()] == true && labCloneCluster[tempTraseu.get(i).getLinie()+1][tempTraseu.get(i).getColoana()] != numarCluster){
             tempTraseu.add(new Punct((tempTraseu.get(i).getLinie()+1),(tempTraseu.get(i).getColoana())));
             lugime++;
             labCloneCluster[tempTraseu.get(i).getLinie()+1][tempTraseu.get(i).getColoana()] = numarCluster;
         }
         if( tempTraseu.get(i).getColoana()-1 >= 0 && Labirint[tempTraseu.get(i).getLinie()][tempTraseu.get(i).getColoana()-1] == true && labCloneCluster[tempTraseu.get(i).getLinie()][tempTraseu.get(i).getColoana()-1] != numarCluster ){
             tempTraseu.add(new Punct((tempTraseu.get(i).getLinie()),(tempTraseu.get(i).getColoana()-1)));
             lugime++;
             labCloneCluster[tempTraseu.get(i).getLinie()][tempTraseu.get(i).getColoana()-1] = numarCluster;
         }
    }
    return labCloneCluster;
    }

    private int getVerificareLinie(int linieCurenta, int coloanaCurenta, int[][] labCloneCluster) {
        if(!(linieCurenta - 1 >= 0 && linieCurenta+1 < this.marimeLab))
            return -1;//este imposibil ca sa fie verificat
        if(!this.Labirint[linieCurenta - 1][coloanaCurenta] && !this.Labirint[linieCurenta + 1][coloanaCurenta])
            return 0;//are doar ziduri
        if(this.Labirint[linieCurenta - 1][coloanaCurenta] && this.Labirint[linieCurenta + 1][coloanaCurenta])
            if(labCloneCluster[linieCurenta - 1][coloanaCurenta] == labCloneCluster[linieCurenta + 1][coloanaCurenta])
                return 1;//are ambele casute sunt din acelasi cluster
            else return 2;//doua culstere diferite
        //doar un cluster inca doua if-ure
        if(this.Labirint[linieCurenta - 1][coloanaCurenta])
            return 3;//3 stanga
        return 4;//4 dreapta
    }

    private int getVerificareColoana(int linieCurenta, int coloanaCurenta, int[][] labCloneCluster) {
        if(!(coloanaCurenta - 1 >= 0 && coloanaCurenta+1 < this.marimeLab))
            return -1;//este imposibil ca sa fie verificat
        if(!this.Labirint[linieCurenta][coloanaCurenta - 1] && !this.Labirint[linieCurenta][coloanaCurenta + 1])
            return 0;//are doar ziduri
        if(this.Labirint[linieCurenta][coloanaCurenta - 1] && this.Labirint[linieCurenta][coloanaCurenta + 1])
            if(labCloneCluster[linieCurenta][coloanaCurenta - 1] == labCloneCluster[linieCurenta][coloanaCurenta + 1])
                return 1;//are ambele casute sunt din acelasi cluster
            else return 2;//doua culstere diferite
        //doar un cluster inca doua if-ure
        if(this.Labirint[linieCurenta][coloanaCurenta - 1])
            return 3;//3 sus
        return 4;//4 jos
    }

    
    
}
