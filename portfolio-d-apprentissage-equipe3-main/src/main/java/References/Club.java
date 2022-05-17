package References;

public class Club {
    private String nomClub;
    private String abbreviation ;

    public Club(String nomClub ,String abbreviation){
        this.abbreviation=abbreviation;
        this.nomClub=nomClub;
    }

    public String getNomClub() {
        return nomClub;
    }
    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
