package models;

public class LoginUser {
    private String matricule;
    private String motPasse;
    private String email;

    public String getFolderPath() {
        return FolderPath;
    }

    public void setFolderPath(String folderPath) {
        FolderPath = folderPath;
    }

    private String FolderPath ;
    public String getMotPasse() {
        return motPasse;
    }
    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    public LoginUser(String motPasse, String email, String matricule) {
        this.motPasse = motPasse;
        this.email = email;
        this.matricule = matricule;
    }
    public boolean equals(Object user){
      return ((LoginUser)user).getEmail().equals(this.email);
    }
}
