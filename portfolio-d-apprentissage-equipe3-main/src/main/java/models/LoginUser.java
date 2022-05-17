package models;

public class LoginUser {
    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    private String motPasse;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    private String matricule;

    public LoginUser(String motPasse, String email, String matricule) {
        this.motPasse = motPasse;
        this.email = email;
        this.matricule = matricule;
    }
    public boolean equals(Object user){
      return ((LoginUser)user).getEmail().equals(this.email);
    }
}
