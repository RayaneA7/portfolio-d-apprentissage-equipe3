package Mainapplication;

import References.Competence;
import References.Competences;
import References.Modules;

import java.io.*;
import java.util.*;

public class Test2 {
    public Test2() throws IOException {
    }

    public static void printAll(SortedSet<String> tree){
        for(String s: tree){
            System.out.println(s);
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException {
        String motcle;
        /*******
        ArrayList<Competence> result;
        int i=1;
        String row="";
        Competences competences =new Competences();
        System.out.println("*********************Test1***************");
        result=competences.RecherchCode("C11.1");
        Afficher(result);
        System.out.println("****************Test2*************");
        result=competences.RecherchModule("ANA");
        Afficher(result);
        System.out.println("****************Test3*************");
        result=competences.RecherchTitre("signal");
        Afficher(result);
        System.out.println("****************Test4*************");
        result=competences.Recherche_Module_Titre_Code_Objectif("Ana","","c2","");
        Afficher(result);
        System.out.println("****************Test5*************");
        result=competences.Recherche_Module_Titre_Code_Objectif("tsg","traitement","c2","");
        Afficher(result);
        /*********************/
    }
    /*******************
    static void Afficher(ArrayList<Competence> list){
        if(list.size()!=0) {
            for (Competence comp : list) {
                System.out.println(comp.getModule()+" "+comp.getCode()+" "+comp.getTitre()+" "+comp.getObjectif());
            }
        }else{System.out.println("la liste est vide ");}
    }
     /*******************/

}
