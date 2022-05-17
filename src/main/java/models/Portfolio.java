package models;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Portfolio {
    private UUID id;
    private int numeroPortfolio;
    private ArrayList<UUID> projets;


    public void ajouterProjet(Projet projet) {
        setProjets(projets);
        projets.add(projet.getId());

    }

    public boolean supprimerProjet(Projet projet) {

        for (int s = 0; s < projets.size(); s++) {
            if(projets.get(s).equals(projet.getId())) {
                return true;
            }
        }
        return false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumeroPortfolio() {
        return numeroPortfolio;
    }

    public void setNumeroPortfolio(int numeroPortfolio) {
        this.numeroPortfolio = numeroPortfolio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return id.equals(portfolio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public ArrayList<UUID> getProjets() {
        return projets;
    }

    public void setProjets(ArrayList<UUID> projets) {
        if (this.projets == null) {
            this.projets = new ArrayList<UUID>();
        }else {
            this.projets = projets;}
    }
}
