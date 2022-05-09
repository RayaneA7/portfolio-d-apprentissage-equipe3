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
import de.neuland.pug4j.Pug4J;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class AccueilMediateur implements Initializable {
    @FXML
    AnchorPane monAnchorPane;
    /***********************/
   public static Pagination monPagination;
   public static String studentFolder ;
   public static Utilisateur utilisateur;
   public static ArrayList<Parent> memory;
   public static Image image;
    private Stage stage;
    private Scene scene;
    private File file;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************************/
         studentFolder = ConnectController.studentFolder;
         System.out.println("le student folder est :"+studentFolder);
         try {
            utilisateur = Utilisateur.deserialization(studentFolder);
        /****ici on cree l html ***/
             Map<String, Object> model = new HashMap<String, Object>();
             model.put("projets",utilisateur.getMesProjets());
             System.out.println(model);








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
         /****************************************/
         loader = new FXMLLoader(getClass().getResource("/views/Accueil_1View.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         /************************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_1View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /***********************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_2View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /************************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_3View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /**************************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_4View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
         /********************************************************************/
        /************************/
        loader =new FXMLLoader(getClass().getResource("/views/profile.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /***********************/
         monPagination =new Pagination();
         monPagination.setPageCount(7);
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
