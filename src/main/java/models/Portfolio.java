package models;

import java.util.ArrayList;
import java.util.UUID;

public class Portfolio {
    private UUID id;
    private int numeroPortfolio;
    ArrayList<UUID> projets;

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
}
