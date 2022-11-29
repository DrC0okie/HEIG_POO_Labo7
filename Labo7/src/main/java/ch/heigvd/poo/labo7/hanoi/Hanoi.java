package ch.heigvd.poo.labo7.hanoi;

import ch.heigvd.poo.labo7.stack.Stack;

public class Hanoi {
    Stack tower1, tower2, tower3;

    int turn = 0;

    //public Hanoi(int disks, HanoiDisplayer displayer){
    //    tower1 = new Stack(disks);
    //}

    public Hanoi(int disks){
        tower1 = new Stack(disks);
        tower2 = new Stack(disks);
        tower2.clear();
        tower3 = new Stack(disks);
        tower3.clear();
    }

    public void solve(){

    }

    public int[][] status(){
        return null; //à éditer
        //Méthode qui récupère le tableau pour chaque stack qu'on ajoute à un tableau ici ?
    }

    public boolean finished(){
        return true; //à éditer
        //garder la taille max de la tour initiale et comparer la taille de la 3ème tour ?
    }

    public int turn(){
        return turn;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}