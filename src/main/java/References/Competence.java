package References;

import java.util.ArrayList;

public class Competence {
    private String FamilledeCompetence;
    private String Competence;
    private String ElemdeCompetence;
    private ArrayList<String> modules;
    private TypeCompetence type;
    private String ObjectifsPedagogiques;
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
    public String getObjectifsPedagogiques() {
        return ObjectifsPedagogiques;
    }
    public void setObjectifsPedagogiques(String objectifsPedagogiques) {
        ObjectifsPedagogiques = objectifsPedagogiques;
    }

    /********************************************************************************************/
    public Competence(String FamilledeCompetence,String Competence,String ElemCompetence,String type,String modules,String objectif) {
        this.FamilledeCompetence = FamilledeCompetence;
        this.Competence=Competence;
        this.ElemdeCompetence=ElemCompetence;
        this.ObjectifsPedagogiques=objectif;
        /*******************/
        switch (type){
            case "Technique" : this.type =TypeCompetence.MET;
            break;
            case "Méthodologique" : this.type=TypeCompetence.TEC;
            break;
            case "Modélisation" : this.type=TypeCompetence.OPE;
            break;
            case "Opérationnel" : this.type=TypeCompetence.MOD;
            default :
                this.type=TypeCompetence.TEC;
        }
        /**************************/
        String[] data = modules.split(" ");
        this.modules =new ArrayList<>();
        for(String module : data){
            this.modules.add(module);
        }
    }
}
