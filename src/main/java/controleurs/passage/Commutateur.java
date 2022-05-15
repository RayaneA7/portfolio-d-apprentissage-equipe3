package controleurs.passage;

import controleurs.acceuil.AccueilMediateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class Commutateur {
    private Stage stage ;
    private Scene scene ;
    private int dureeErreur=3000;
    public void AllerProjet(MouseEvent event){
        AccueilMediateur.monPagination.setCurrentPageIndex(2);
    }
    public void AllerPortfolio(MouseEvent event){
        AccueilMediateur.monPagination.setCurrentPageIndex(3);
    }
    public void AllerParametres(MouseEvent event){
        AccueilMediateur.monPagination.setCurrentPageIndex(2);
    }
    public void AllerProfile(MouseEvent event){
        AccueilMediateur.monPagination.setCurrentPageIndex(8);
    }
    public void AllerAcceuil(MouseEvent event){
      AccueilMediateur.monPagination.setCurrentPageIndex(0);
    }
    public void AllerAide(MouseEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://ecareer-documentation.netlify.app/"));
    }
    public void Déconnecter(MouseEvent event){
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setWidth(800);
            stage.setHeight(598);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }
    public void TraiterAlert(Node node)
    {
        Timer timer =new Timer();
        TimerTask task =new RealiserAlert(node, timer);
        node.setOpacity(1);
        timer.schedule(task,dureeErreur);
    }
}
