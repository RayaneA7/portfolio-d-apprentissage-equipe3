package controleurs.profil;

import controleurs.acceuil.AccueilController;
import controleurs.authentification.ConnectController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import models.Utilisateur;
import controleurs.acceuil.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import models.Utilisateur;


public class Profil implements Initializable {
    /****************** Labels ************************/
    @FXML
    private Label Nom;
    @FXML
    private Label  Prenom;
    @FXML
    private Label  matricule;
    @FXML
    private Label  email;
    @FXML
    private Label  niveau ;
    @FXML
    private Label  Bio ;
    @FXML
    private Label  Nbprojects ;
    @FXML
    private ImageView image ;
    Utilisateur user = new Utilisateur();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************Image personnel********************/

       Nom.setText(AccueilMediateur.utilisateur.donnes.getNom());
        Prenom.setText(AccueilMediateur.utilisateur.donnes.getPrenom());
        matricule.setText(AccueilMediateur.utilisateur.donnes.getMatricule());
        email.setText(AccueilMediateur.utilisateur.donnes.getEmail());
        niveau.setText(AccueilMediateur.utilisateur.donnes.getNiveauEtude());
        Bio.setText(AccueilMediateur.utilisateur.donnes.getBioPersonnel());
        Nbprojects.setText("15");
       /*********************Image personnel********************/
       if(AccueilMediateur.image!=null){
            image.setImage(AccueilMediateur.image);
           }
       /**************************************************/
    }
    public void PreviousPage(ActionEvent actionEvent) {
        AccueilMediateur.monPagination.setCurrentPageIndex(0);
    }
}



