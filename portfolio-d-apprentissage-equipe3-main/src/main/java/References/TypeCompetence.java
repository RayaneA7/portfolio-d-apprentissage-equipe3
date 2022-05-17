package References;

public enum TypeCompetence {
    MET("MET"),TEC("TEC"),OPE("OPE"),MOD("MOD");
    public String getSens() {
        return Sens;
    }
    public void setSens(String sens) {
        Sens = sens;
    }
    private String Sens;
    public String toString(){
        return Sens ;
    }
    TypeCompetence(String Sens){
        this.Sens=Sens;
    }
}
