package controleurs.acceuil;

import controleurs.authentification.ConnectController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Utilisateur;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccueilMediateur implements Initializable {
    @FXML
    AnchorPane monAnchorPane;
    /***********************/
    static Pagination monPagination;
    static String studentFolder ;
    static Utilisateur utilisateur;
    static ArrayList<Parent> memory;
    private File file;
    static  Image image;
    private Stage stage;
    private Scene scene;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************************/
         studentFolder = ConnectController.studentFolder;
         System.out.println("le student folder est :"+studentFolder);
         try {
            utilisateur = Utilisateur.deserialization(studentFolder);
         } catch (IOException e) {
            e.printStackTrace();
            System.out.println("un probleme se génere lors de la désirialisation des données de l'utilisateur");
         }
         /*****************photo personnel*********************/
        try {
            System.out.println("wel");
            file = new File("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/ImagePersonnel.png");
            image = new Image(String.valueOf(file.toURI().toURL()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("probleme se génere losrs de chargement de l'image");
        }
         catch (Exception e){
            e.printStackTrace();
            System.out.println("probleme se génere losrs de chargement de l'image");
         }
         /***********************************/
         memory = new ArrayList<>();
         FXMLLoader loader = new FXMLLoader();
         loader = new FXMLLoader(getClass().getResource("/views/AccueilView.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         loader = new FXMLLoader(getClass().getResource("/views/Accueil_1View.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         monPagination =new Pagination();
         monPagination.setPageCount(2);
         monPagination.setCurrentPageIndex(0);
         monPagination.setMaxPageIndicatorCount(1);
         monPagination.setPageFactory(new Callback<Integer, Node>() {
         @Override
           public Node call(Integer pageIndex) {
           System.out.println("welcome in acceuil mediateur hhhhshsh");
           return memory.get(pageIndex);
         }
         });
        monAnchorPane.getChildren().addAll(monPagination);
    }
}
