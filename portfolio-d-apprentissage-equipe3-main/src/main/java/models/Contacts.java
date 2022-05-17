package models;

public class Contacts {
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
