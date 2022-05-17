package models;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {

    public int getNbProjetsPédagogiques() {
        return NbProjetsPédagogiques;
    }

    private int NbSoftsSkills ;
    private int NbHardSkills ;
    private int NbProjetsClubs=0 ;
    private int NbProjetsPersonnels=0 ;
    private int NbProjetsPédagogiques=0 ;
    private List<Project> listProjects;

    public int getNbProjetsPersonnels() {
        return NbProjetsPersonnels;
    }
    public List<Project> getListProjects() {
        return listProjects;
    }
    public int getNbProjetsClubs() {
        return NbProjetsClubs;
    }
    public int getNbSoftsSkills() {
        return NbSoftsSkills;
    }
    public int getNbHardSkills() {
        return NbHardSkills;
    }
    public List<Project> getListProject() {
        return listProjects;
    }
    public void setListProject(ArrayList<Project> listProject) {
        this.listProjects = listProject;
    }

    public Statistiques(List<Project> listProjects){
        this.listProjects=listProjects;
    }
    public void  CalculerNbprojetsType(){
        System.out.println("le nombre des projets en statisques est :"+listProjects.size());
      for(int i=0;i<listProjects.size();i++){
          TypeProjet type =listProjects.get(i).getType();
          switch (type){
              case CLUB :
                  NbProjetsClubs++;
                  System.out.println("club");
              break;
              case PEDAGOGIQUE:
                  NbProjetsPédagogiques++;
                  System.out.println("pedagigique");
              break;
              case PERSONEL:
                  NbProjetsPersonnels++;
                  System.out.println("personnel");
          }
      }
    }
}
