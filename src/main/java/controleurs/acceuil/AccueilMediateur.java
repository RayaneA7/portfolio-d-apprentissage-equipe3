package controleurs.acceuil;

import controleurs.authentification.ConnectController;
import controleurs.passage.Commutateur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;
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
   public static Pagination monPagination;
   public static String studentFolder ;
   public static Utilisateur utilisateur;
   public static ArrayList<Parent> memory;
   public static Image image;
   public static Timeline timeLine1;
   public static Commutateur commutateur;
    private Stage stage;
    private Scene scene;
    private File file;
    FXMLLoader loader1;
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
         /*********************0**************/
         memory = new ArrayList<>(10);
         FXMLLoader loader = new FXMLLoader();
         loader = new FXMLLoader(getClass().getResource("/views/AccueilView.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         /**********************1******************/
         loader = new FXMLLoader(getClass().getResource("/views/Accueil_1View.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         /**********************************************************************************/
         /**********************************************************************************/
         timeLine1 = new Timeline(new KeyFrame(Duration.seconds(0.1), event4 -> {
            System.out.println("welcome in our application****************************");
            /******************2**********************/
            loader1 = new FXMLLoader(getClass().getResource("/views/Parametre_View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /***********************3******************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioShowPage.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /***********************4***********************/
            loader1 = new FXMLLoader(getClass().getResource("/views/Portfolio1View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*********************************5*********************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioModel1View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /************************6*****************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioModel2View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /**********************7*******************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioModel3View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /**************************8*************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/ModifyPortfolio.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
             /**************************9*************************************/
             loader1 = new FXMLLoader(getClass().getResource("/views/profile.fxml"));
             try {
                 memory.add(loader1.load());
             } catch (IOException e) {
                 e.printStackTrace();
             }
            /************************10****************************************/
             loader1 = new FXMLLoader(getClass().getResource("/views/Project1View.fxml"));
             try {
                 memory.add(loader1.load());
             } catch (IOException e) {
                 e.printStackTrace();
             }
             /************************11****************************************/
             loader1 = new FXMLLoader(getClass().getResource("/views/AddProjectView.fxml"));
             try {
                 memory.add(loader1.load());
             } catch (IOException e) {
                 e.printStackTrace();
             }
        }));
        timeLine1.setRate(1);
        timeLine1.setDelay(Duration.seconds(0.2));
        timeLine1.setCycleCount(1);
        timeLine1.play();
        /********************************************************************/
         monPagination =new Pagination();
         monPagination.setStyle(" -fx-arrows-visible : false ; -fx-page-information-visible : false");
         monPagination.setPageCount(12);
         monPagination.setCurrentPageIndex(0);
         monPagination.setMaxPageIndicatorCount(1);
         monPagination.setPageFactory(new Callback<Integer, Node>() {
         @Override
           public Node call(Integer pageIndex) {
           System.out.println("la page courant est :"+pageIndex);
           return memory.get(pageIndex);
         }
         });
        monAnchorPane.getChildren().addAll(monPagination);
        /***********************************************/
        commutateur =new Commutateur();
        /***********************************************/
    }
}
