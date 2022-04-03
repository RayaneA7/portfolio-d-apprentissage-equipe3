package com.example.projetgithub;
  public class Utilisateur{
  public DonnesPersonnels donnes ;
  public Contacts contacts ;
  }
 class DonnesPersonnels {
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    private String matricule;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom;

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

    private String prenom;
    private String Datenaissance ;
    private Sex sex ;

    public String getMotdePasse() {
        return motdePasse;
    }

    public void setMotdePasse(String motdePasse) {
        this.motdePasse = motdePasse;
    }

    private String motdePasse;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email ;

     public String getNiveauEtude() {
         return niveauEtude;
     }

     public void setNiveauEtude(String niveauEtude) {
         this.niveauEtude = niveauEtude;
     }

     private String niveauEtude ;


}
class Contacts {
    public long getNbTelephone() {
        return nbTelephone;
    }

    public void setNbTelephone(long nbTelephone) {
        this.nbTelephone = nbTelephone;
    }

    private long nbTelephone;

    public String getCountFacebook() {
        return countFacebook;
    }

    public void setCountFacebook(String countFacebook) {
        this.countFacebook = countFacebook;
    }

    private String countFacebook;

    public String getCountGithub() {
        return countGithub;
    }

    public void setCountGithub(String countGithub) {
        this.countGithub = countGithub;
    }

    private String countGithub;

    public String getCountLinkedln() {
        return countLinkedln;
    }

    public void setCountLinkedln(String countLinkedln) {
        this.countLinkedln = countLinkedln;
    }

    private String countLinkedln;

}
 enum Sex {
        MALE,FEMELLE ;
        }