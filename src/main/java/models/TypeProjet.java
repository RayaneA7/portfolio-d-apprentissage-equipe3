package models;

public enum TypeProjet {
    CLUB("Club"), PEDAGOGIQUE("Pédagogique"), PERSONEL("Personnel");

    public String getTypeProjet() {
        return typeProjet;
    }
    public String toString(){
       return typeProjet;
    }
    /********************
    public boolean equals(Object o){
        TypeProjet type =(TypeProjet) o;
        return typeProjet.equals(type.getTypeProjet());
    }
     /******************/
    private String typeProjet ;
    TypeProjet(String typeProjet){
        this.typeProjet=typeProjet;
    }
}
