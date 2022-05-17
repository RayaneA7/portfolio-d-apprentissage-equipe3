package models;

import java.util.List;

public class Portfolio {
    public int id;
    private List<Project> ListProject;
    private static int numPort;

    public Portfolio(int num , List<Project> listProject) {
        this.id = num;
        this.ListProject = listProject;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {this.id = id; }

    public List<Project> getListProject() {
        return ListProject;
    }

    public void setListProject(List<Project> listProject) {
        ListProject = listProject;
    }

    public int nbrPersoProjects(){
        int cpt = 0;
        for(Project p : this.ListProject){
            if (p.getType().equals("Personnel")) cpt++;
        }
        return cpt;
    }

    public int nbrClubProjects(){
        int cpt = 0;
        for(Project p : this.ListProject){
            if (p.getType().equals("Club")) cpt++;
        }
        return cpt;
    }

    public int nbrPedagProjects(){
        int cpt = 0;
        for(Project p : this.ListProject){
            if (p.getType().equals("Pédagogique")) cpt++;
        }
        return cpt;
    }


}