package Mainapplication;

import References.Competence;
import References.Competences;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

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
         /*************************************/
         ArrayList<String> lists =new ArrayList<>(8);
         lists.add("bingbang");
         if(lists.get(4)==null){
             lists.add(4,"hbdshdvh");
         }
        Competences comp =new Competences();
        /*******/
        ArrayList<Competence> result;
        int i=1;
        String row="";
        Competences competences =new Competences();
        System.out.println("*********************Test1***************");
        result=competences.RecherchType("");
        Afficher(result);
        System.out.println("****************Test2*************");
        result=competences.RecherchModule("ANA");
        Afficher(result);
        System.out.println("****************Test3*************");
        result=competences.RecherchObjectif("signal");
        Afficher(result);
        System.out.println("****************Test4*************");
        result=competences.Recherche_Module_Titre_Code_Objectif("AN","","","");
        Afficher(result);
        System.out.println("****************Test5*************");
        result=competences.Recherche_Module_Titre_Code_Objectif("poo","realise","TEC","");
        Afficher(result);
        /*********************
        competences.AjouteCompetence("","","realiser des interfaces graphiques avec javafx","TEC","POO","apprendre le dev en graphique");
       /**********************/
    }
    /****************************/
    static void Afficher(ArrayList<Competence> list){
        if(list.size()!=0) {
            for (Competence comp : list) {
                System.out.println(comp.getModules().toString()+"<->"+comp.getType()+"<->"+comp.getElemdeCompetence()+"<->"+comp.getObjectifPédagogique());
            }
        }else{System.out.println("la liste est vide ");}
    }
   /******************************************/
}
