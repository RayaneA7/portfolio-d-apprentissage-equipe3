package controleurs.portfolio;


import javafx.event.ActionEvent;
import models.Portfolio;

public interface MyPortfolio {
    void removePortfolio(Portfolio portfolio);
    void modifyPortfolio(Portfolio portfolio);
    void exportPortfolio(Portfolio portfolio);
}
