package models;

public class Competence {
    private String competence;
    private String matiere;
    private String familleDeCompetence;
    private String elementDeCompetence;
    private String type;
    private String objectifPedagoqique;

    public Competence(String competence, String matiere, String familleDeCompetence, String elementDeCompetence, String type, String objectifPedagoqique) {
        this.setCompetence(competence);
        this.setMatiere(matiere);
        this.setFamilleDeCompetence(familleDeCompetence);
        this.setElementDeCompetence(elementDeCompetence);
        this.setType(type);
        this.setObjectifPedagoqique(objectifPedagoqique);
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getFamilleDeCompetence() {
        return familleDeCompetence;
    }

    public void setFamilleDeCompetence(String familleDeCompetence) {
        this.familleDeCompetence = familleDeCompetence;
    }

    public String getElementDeCompetence() {
        return elementDeCompetence;
    }

    public void setElementDeCompetence(String elementDeCompetence) {
        this.elementDeCompetence = elementDeCompetence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObjectifPedagoqique() {
        return objectifPedagoqique;
    }

    public void setObjectifPedagoqique(String objectifPedagoqique) {
        this.objectifPedagoqique = objectifPedagoqique;
    }
}
