package models;

public class Competence {
    private String Competence;
    private String modules[];
    private String FamilledeCompetence;
    private String ElemdeCompetence;
    private String type;

    public String getCompetence() {
        return Competence;
    }

    public void setCompetence(String competence) {
        Competence = competence;
    }

    public String[] getModules() {
        return modules;
    }

    public void setModules(String[] modules) {
        this.modules = modules;
    }

    public String getFamilledeCompetence() {
        return FamilledeCompetence;
    }

    public void setFamilledeCompetence(String familledeCompetence) {
        FamilledeCompetence = familledeCompetence;
    }

    public String getElemdeCompetence() {
        return ElemdeCompetence;
    }

    public void setElemdeCompetence(String elemdeCompetence) {
        ElemdeCompetence = elemdeCompetence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObjectifPédagogique() {
        return ObjectifPédagogique;
    }

    public void setObjectifPédagogique(String objectifPédagogique) {
        ObjectifPédagogique = objectifPédagogique;
    }

    private String ObjectifPédagogique;



}
