package References;

import java.util.ArrayList;

public class Competence {
    private String FamilledeCompetence;
    private String Competence;
    private String ElemdeCompetence;
    private ArrayList<String> modules;
    private TypeCompetence type;
    private String ObjectifPédagogique;
/******************************************************/
    public String getFamilledeCompetence() {
        return FamilledeCompetence;
    }
    public void setFamilledeCompetence(String familledeCompetence) {
        FamilledeCompetence = familledeCompetence;
    }
    public String getCompetence() {
        return Competence;
    }
    public void setCompetence(String competence) {
        Competence = competence;
    }
    public String getElemdeCompetence() {
        return ElemdeCompetence;
    }
    public void setElemdeCompetence(String elemdeCompetence) {
        ElemdeCompetence = elemdeCompetence;
    }
    public TypeCompetence getType() {
        return type;
    }
    public void setType(TypeCompetence type) {
        this.type = type;
    }
    public ArrayList<String> getModules() {
        return modules;
    }
    public void setModules(ArrayList<String> modules) {
        this.modules = modules;
    }
    public String getObjectifPédagogique() {
        return ObjectifPédagogique;
    }
    public void setObjectifPédagogique(String objectifPédagogique) {
        ObjectifPédagogique = objectifPédagogique;
    }
    /********************************************************************************************/
    public Competence(String FamilledeCompetence,String Competence,String ElemCompetence,String type,String modules,String objectif) {
        this.FamilledeCompetence = FamilledeCompetence;
        this.Competence=Competence;
        this.ElemdeCompetence=ElemCompetence;
        this.ObjectifPédagogique=objectif;
        /*******************/
        switch (type){
            case "MET" : this.type =TypeCompetence.MET;
            break;
            case "TEC" : this.type=TypeCompetence.TEC;
            break;
            case "OPE" : this.type=TypeCompetence.OPE;
            break;
            case "MOD" : this.type=TypeCompetence.MOD;
        }
        /**************************/
        String[] data = modules.split(" ");
        this.modules =new ArrayList<>();
        for(String module : data){
            this.modules.add(module);
        }
    }
}
