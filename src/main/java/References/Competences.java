package References;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class Competences {
private ArrayList<Competence> listcompetences;
  public Competences() throws IOException {
      String row="";
      listcompetences =new ArrayList<>();
      File file =new File("References/competences.csv");
      BufferedReader csvReader = new BufferedReader(new FileReader(file));
      while ((row = csvReader.readLine()) != null) {
          if(row!="") {
              String[] data = row.split(",");
              listcompetences.add(new Competence(data[0], data[2], data[1], data[3], data[4]));
          }
      }
      csvReader.close();
  }
  /***********************Les fonctions de recherche**********************************************/
  public ArrayList<Competence> RecherchModule(String motclé){
     return RechModule(listcompetences,motclé);
  }
  public ArrayList<Competence> RecherchTitre(String motclé){
      return RechTitre(listcompetences,motclé);
  }
  public ArrayList<Competence> RecherchCode(String motclé){
      return RechCode(listcompetences,motclé);
  }
  public ArrayList<Competence> RecherchObjectif(String motclé){
      return RechObjectif(listcompetences,motclé);
  }
  public ArrayList<Competence> Recherche_Module_Titre_Code_Objectif(String module,String titre,String code,String objectif )
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(module!=""){
        resultat =RechModule(listcompetences,module);
        if(titre!=""){
            resultat=RechTitre(resultat,titre);
            if(code!=""){
               resultat=RechCode(resultat,code);
               if(objectif!=""){
                   resultat=RechObjectif(resultat,objectif);
               }
            }else {
                if(objectif!=""){
                    resultat=RechObjectif(resultat,objectif);
                }
            }
        }else{
            if(code!=""){
                resultat=RechCode(resultat,code);
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
          if(titre!=""){
              resultat=RechTitre(listcompetences,titre);
              if(code!=""){
                  resultat=RechCode(resultat,code);
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
              if(code!=""){
                  resultat=RechCode(resultat,code);
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
  public void AjouteCompetence(String module,String titre,String intitule,String objectif) throws IOException {
    Competence comp =new Competence(module,"",titre,intitule,objectif);
    listcompetences.add(comp);
      File file =new File("References/competences.csv");
      Writer writer =new FileWriter(file,true);
      writer.append('\n'+module+","+titre+","+""+","+intitule+","+objectif);
      writer.close();
  }


  /***************les Recherche Internes ou classe*********************/
  ArrayList<Competence> RechModule(ArrayList<Competence> listcompetences,String motclé)
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(motclé!=""&&listcompetences.size()!=0){
        listcompetences.sort(ComparCompetences.comparatorModule);
        for(int i=0;i<listcompetences.size();i++) {
          if(listcompetences.get(i).getModule().toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))){
            resultat.add(listcompetences.get(i));
          }
        }
      }
      return resultat;
  }
  /***************************/
  ArrayList<Competence> RechTitre(ArrayList<Competence> listcompetences,String motclé)
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(motclé!=""&&listcompetences.size()!=0){
          listcompetences.sort(ComparCompetences.comparatorTitre);
          for(int i=0;i<listcompetences.size();i++) {
              if(listcompetences.get(i).getTitre().toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))){
                  resultat.add(listcompetences.get(i));
              }
          }
      }
      return resultat;
  }
  /*******************************/
  ArrayList<Competence> RechCode(ArrayList<Competence> listcompetences,String motclé)
  {
      ArrayList<Competence> resultat =new ArrayList<>();
      if(motclé!=""&&listcompetences.size()!=0){
          listcompetences.sort(ComparCompetences.comparatorCode);
          for(int i=0;i<listcompetences.size();i++) {
              if(listcompetences.get(i).getCode().toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))){
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
          listcompetences.sort(ComparCompetences.comparatorObjectif);
          for(int i=0;i<listcompetences.size();i++) {
              if(listcompetences.get(i).getObjectif().toLowerCase(Locale.ROOT).contains(motclé.toLowerCase(Locale.ROOT))){
                  resultat.add(listcompetences.get(i));
              }
          }
      }
      return resultat;
  }
  /***************************************************************************/
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

}
