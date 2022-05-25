package controleurs.passage;

import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import controleurs.portfolio.ModifyPortfolioController;
import controleurs.portfolio.PortfolioItemController;
import controleurs.portfolio.PortfolioShowController;
import hashage.ZipUnZip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Portfolio;
import models.Utilisateur;

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
    private FXMLLoader loader ;
    public void AllerProjet(MouseEvent event){
        loader = new FXMLLoader(getClass().getResource("/views/Project1View.fxml"));
        try {
            /********/
            if(AccueilMediateur.memory.get(9)!=null) {
                AccueilMediateur.memory.remove(9);
            }
            /******************/
            AccueilMediateur.memory.add(9,loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AccueilMediateur.monPagination.setCurrentPageIndex(9);
    }
    public void AllerPortfolio() {
        loader = new FXMLLoader(getClass().getResource("/views/PortfolioShowPage.fxml"));
        try {
            /****/
            if(AccueilMediateur.memory.get(2)!=null) {
                AccueilMediateur.memory.remove(2);
            }
             /********/
            AccueilMediateur.memory.add(2,loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PortfolioShowController.MonScrollPane.setHvalue(PortfolioItemController.monScrollXPosition);
        AccueilMediateur.monPagination.setCurrentPageIndex(2);
    }
    public void AllerParametres(MouseEvent event){
        loader = new FXMLLoader(getClass().getResource("/views/Parametre_View.fxml"));
        try {
            /***/
            if(AccueilMediateur.memory.get(1)!=null) {
                AccueilMediateur.memory.remove(1);
            }
             /**********/
            AccueilMediateur.memory.add(1, loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AccueilMediateur.monPagination.setCurrentPageIndex(1);
    }
    public void AllerProfile(MouseEvent event){
        loader = new FXMLLoader(getClass().getResource("/views/profile.fxml"));
        try {
            /***/
            if(AccueilMediateur.memory.get(8)!=null) {
                AccueilMediateur.memory.remove(8);
            }
             /*********/
            AccueilMediateur.memory.add(8,loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AccueilMediateur.monPagination.setCurrentPageIndex(8);
    }
    public void AllerAcceuil(MouseEvent event){
        loader = new FXMLLoader(getClass().getResource("/views/AccueilView.fxml"));
        try {
            /*******/
            if(AccueilMediateur.memory.get(0)!=null) {
                AccueilMediateur.memory.remove(0);
            }
             /***********/
            AccueilMediateur.memory.add(0,loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
      AccueilMediateur.monPagination.setCurrentPageIndex(0);
    }
    public void AllerAide(MouseEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://ecareer-documentation.netlify.app/"));
    }
    public void AllerModificationPortfolio(Portfolio portfolio) throws IOException {
        AccueilMediateur.utilisateur=Utilisateur.deserialization(AccueilMediateur.studentFolder);
        loader = new FXMLLoader(getClass().getResource("/views/ModifyPortfolio.fxml"));
        try {
            /********/
            if(AccueilMediateur.memory.get(7)!=null) {
                AccueilMediateur.memory.remove(7);
            }
             /***************/
            AccueilMediateur.memory.add(7,loader.load());
            ModifyPortfolioController modifyPortfolioController = loader.getController();
            modifyPortfolioController.SelectedProjects(portfolio);

        } catch (IOException e) {
            e.printStackTrace();
        }
        AccueilMediateur.monPagination.setCurrentPageIndex(7);
    }
    public void Déconnecter(MouseEvent event){
           CustomDialog dialog =new CustomDialog("Confiramtion","Cliquez sur Ok " +
                "si vous voulez déconnecter ");
           dialog.show();
           dialog.buttonOk.setOnAction(e-> {
            try {
                System.out.println("sérialisation des donnes à la déconnexion ");
                ZipUnZip.SerialiseFile(AccueilMediateur.studentFolder);
                System.out.println("fermeture de séance");
                dialog.closeDialog();
            } catch (IOException ex) {
                System.out.println("probléme en page ZipUnZip");
                System.out.println("une probléme se genere lors de la sérialisation des info personnels");
            }
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
            try {
                scene = new Scene(loader.load());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setWidth(800);
            stage.setHeight(598);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
           });
           dialog.buttonCancel.setOnAction(e->{
               dialog.closeDialog();
           });
    }
    public void AllerModificationProjet(MouseEvent event){
        loader = new FXMLLoader(getClass().getResource("/views/EditProjectView.fxml"));
        try {
            if(AccueilMediateur.memory.get(11)!=null) {
                AccueilMediateur.memory.remove(11);
            }
            AccueilMediateur.memory.add(11,loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AccueilMediateur.monPagination.setCurrentPageIndex(11);
    }
    public void TraiterAlert(Node node)
    {
        Timer timer =new Timer();
        TimerTask task =new RealiserAlert(node, timer);
        node.setOpacity(1);
        timer.schedule(task,dureeErreur);
    }
}
