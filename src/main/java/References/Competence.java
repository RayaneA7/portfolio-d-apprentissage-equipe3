package References;

public class Competence {

    private String intitule;//vision général sur le module
    private String objectif;
    private String code;  //le code de compétence EX : C11
    private String module;//l'abréviation du nom de module EX: ANAL1
    private String titre; //le nom de module EX: Analyse1

    public String getModule() {
        return module;
    }
    public String getCode() {
        return code;
    }
    public String getTitre() {
        return titre;
    }
    public String getIntitule() {
        return intitule;
    }
    public String getObjectif() {
        return objectif;
    }

    public Competence(String module,String code,String titre,String intitule,String objectif) {
        this.module = module;
        this.code=code;
        this.titre=titre;
        this.intitule=intitule;
        this.objectif=objectif;
    }
}
