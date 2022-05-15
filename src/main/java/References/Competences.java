package References;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Utilisateur;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Competences {
private ArrayList<Competence> listcompetences;
    Listcompetences competences;
  public Competences() throws IOException {
      String row="";
      Reader reader = null;
      Gson gson = new Gson();
      try {
          reader = Files.newBufferedReader(Paths.get("References/competencesJson.json"));
          competences  = gson.fromJson(reader, Listcompetences.class);
          this.listcompetences =competences.listcompetences;
      } catch (FileNotFoundException ex) {
          ex.printStackTrace();
      }
      finally {
          reader.close();
      }
  }
  /**********************Les fonctions de recherche**********************************************/
  public ArrayList<Competence> RecherchModule(String motclé){
     return RechModule(listcompetences,motclé);
  }
  public ArrayList<Competence> RecherchType(String motclé){
      return RechType(listcompetences,motclé);
  }
  public ArrayList<Competence> RecherchElemCompetence(String motclé){
      return RechElemCompetence(listcompetences,motclé);
  }
  public ArrayList<Competence> RecherchObjectif(String motclé){
      return RechObjectif(listcompetences,motclé);
  }
  public ArrayList<Competence> Recherche_Module_Titre_Code_Objectif(String module,String competence,String type,String objectif )
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(module!=""){
        resultat =RechModule(listcompetences,module);
        if(competence!=""){
            resultat=RechElemCompetence(resultat,competence);
            if(type!=""){
               resultat=RechType(resultat,type);
               if(objectif!=""){
                   resultat=RechObjectif(resultat,objectif);
               }
            }else {
                if(objectif!=""){
                    resultat=RechObjectif(resultat,objectif);
                }
            }
        }else{
            if(type!=""){
                System.out.println("welcome in rceh type");
                resultat=RechType(resultat,type);
                if(objectif!=""){
                    resultat=RechObjectif(resultat,objectif);
                }
            }else {
                if(objectif!=""){
                    resultat=RechObjectif(resultat,objectif);
                }
            }
        }
      }else{
          if(competence!=""){
              resultat=RechElemCompetence(listcompetences,module);
              if(type!=""){
                  resultat=RechType(resultat,type);
                  if(objectif!=""){
                      resultat=RechObjectif(resultat,objectif);
                  }
              }else {
                  if(objectif!=""){
                      resultat=RechObjectif(resultat,objectif);
                  }
              }
          }
          else{
              if(type!=""){
                  resultat=RechType(resultat,type);
                  if(objectif!=""){
                      resultat=RechObjectif(resultat,objectif);
                  }
              }else {
                  if(objectif!=""){
                      resultat=RechObjectif(resultat,objectif);
                  }
              }
          }
      }
      return resultat;
  }
  public void AjouteCompetence(String FamilleDecompetence ,String competence,String elemCompetence,String type,String module,String objectif) throws IOException {
    Competence comp =new Competence(FamilleDecompetence,competence,elemCompetence,type,module,objectif);
    listcompetences.add(comp);
    competences.listcompetences.add(comp);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Writer writer = Files.newBufferedWriter(Paths.get("References/competencesJson.json"));
    gson.toJson(competences, writer);
    writer.close();
  }


  /***************les Recherche Internes ou classe*********************/
  ArrayList<Competence> RechModule(ArrayList<Competence> listcompetences,String motclé)
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(motclé!=""&&listcompetences.size()!=0){
        for(int i=0;i<listcompetences.size();i++) {
            for(int j=0;j<listcompetences.get(i).getModules().size();j++) {
                if (listcompetences.get(i).getModules().get(j).toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))) {
                    resultat.add(listcompetences.get(i));
                }
            }
        }
      }
      return resultat;
  }
  /***************************/
  ArrayList<Competence> RechType(ArrayList<Competence> listcompetences,String motclé)
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(motclé!=""&&listcompetences.size()!=0){
         // listcompetences.sort(ComparCompetences.comparatorTitre);
          for(int i=0;i<listcompetences.size();i++) {
              System.out.println(listcompetences.get(i).getType().toString()+" VS "+motclé.toLowerCase(Locale.ROOT));
              if(listcompetences.get(i).getType().toString().toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))){
                  resultat.add(listcompetences.get(i));
              }
          }
      }
      return resultat;
  }
  /*******************************/
  ArrayList<Competence> RechElemCompetence(ArrayList<Competence> listcompetences,String motclé)
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(motclé!=""&&listcompetences.size()!=0){
          for(int i=0;i<listcompetences.size();i++) {
              if(listcompetences.get(i).getElemdeCompetence().toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))){
                  resultat.add(listcompetences.get(i));
              }
          }
      }
      return resultat;
  }
  /******************************/
  ArrayList<Competence> RechObjectif(ArrayList<Competence> listcompetences,String motclé)
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(motclé!=""&&listcompetences.size()!=0){
         // listcompetences.sort(ComparCompetences.comparatorObjectif);
          for(int i=0;i<listcompetences.size();i++) {
              if(listcompetences.get(i).getObjectifPédagogique().toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))){
                  resultat.add(listcompetences.get(i));
              }
          }
      }
      return resultat;
  }
  /***************************************************************************
  class ComparCompetences {
      public static  Comparator<Competence> comparatorModule =new Comparator<Competence>() {
          @Override
          public int compare(Competence o1, Competence o2) {
              return o1.getModule().toLowerCase(Locale.ROOT).compareTo(o2.getModule().toLowerCase(Locale.ROOT));
          }
      };
      public static  Comparator<Competence> comparatorCode =new Comparator<Competence>() {
          @Override
          public int compare(Competence o1, Competence o2) {
              return o1.getCode().toLowerCase(Locale.ROOT).compareTo(o2.getCode().toLowerCase(Locale.ROOT));
          }
      };
      public static Comparator<Competence> comparatorTitre =new Comparator<Competence>() {
          @Override
          public int compare(Competence o1, Competence o2) {
              return o1.getTitre().toLowerCase().compareTo(o2.getTitre().toLowerCase(Locale.ROOT));
          }
      };
      public static Comparator<Competence> comparatorObjectif =new Comparator<Competence>() {
          @Override
          public int compare(Competence o1, Competence o2) {
              return o1.getObjectif().toLowerCase(Locale.ROOT).compareTo(o2.getObjectif().toLowerCase(Locale.ROOT));
          }
      };
  }
/*****************************************************/
}
class Listcompetences {
    public ArrayList<Competence> listcompetences;
}