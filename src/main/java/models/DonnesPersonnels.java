package models;

public class DonnesPersonnels {
    private String matricule;
    private String nom;
    private String prenom;
    private String Datenaissance;
    private Sex sex;
    private String motdePasse;
    private String Email;
    private String niveauEtude;
    private String bioPersonnel;

    public String getBioPersonnel() {
        return bioPersonnel;
    }
    public void setBioPersonnel(String bioPersonnel) {
        this.bioPersonnel = bioPersonnel;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getDatenaissance() {
        return Datenaissance;
    }
    public void setDatenaissance(String datenaissance) {
        Datenaissance = datenaissance;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public String getMotdePasse() {
        return motdePasse;
    }
    public void setMotdePasse(String motdePasse) {
        this.motdePasse = motdePasse;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getNiveauEtude() {
        return niveauEtude;
    }
    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

}
