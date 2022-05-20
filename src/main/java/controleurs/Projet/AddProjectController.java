package controleurs.Projet;

import References.Competence;
import controleurs.acceuil.AccueilMediateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Project;
import models.TypeProjet;
import models.Utilisateur;
import org.bouncycastle.crypto.io.SignerOutputStream;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddProjectController implements Initializable {


    public static ArrayList<Competence> projectComp = new ArrayList<>() ;

    @FXML
    Button SwitchButton;
    @FXML
    ImageView BarreImage;
    @FXML
    Button ProjetButton;
    @FXML
    ImageView ProjetsImage;
    @FXML
    Label ProjetLabel;
    @FXML
    Button PortfolioButton;
    @FXML
    ImageView PortfolioImage;
    @FXML
    Label PortfolioLabel;
    @FXML
    Button AideButton;
    @FXML
    ImageView AideImage;
    @FXML
    Label AideLabel;
    @FXML
    Button ParametresButton;
    @FXML
    ImageView ParametresIamge;
    @FXML
    Label ParametresLabel;
    @FXML
    Label WelcomeLabel;
    @FXML
    Button AccueilButton;
    @FXML
    ImageView AccueilImage;
    @FXML
    Label AccueilLabel;
    @FXML
    ImageView logOut;
    @FXML
    Line line3;
    @FXML
    Line line5;
    @FXML
    Line line4;
    @FXML
    Circle imagePersonnel;
    @FXML
    Line line2;
    @FXML
    Line line1;


    /*******/
    @FXML
    private TextField titleInput;



    @FXML
    private DatePicker dateInput;

    @FXML
    private TextField descriptionInput;

    @FXML
    private Button addDocumentsInput;

    @FXML
    private Button competenceInput;

    @FXML
    private Button RetourBtn;

    @FXML
    private Button AjouterBtn;


    @FXML
    private MenuButton typeInput;

    public static  Stage stage ;

    @FXML
    private Button addImageBtn;
    @FXML
    private ImageView myImage;

    /******/

    Image AccueilImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/AccueilBut.png"));
    Image AccueilImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/AccueilBut1.png"));
    Image PortfolioImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/PortfolioBut.png"));
    Image PortfolioImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/PortfolioBut1.png"));
    Image ProjetImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/ProjetsBut.png"));
    Image ProjetImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/ProjetsBut1.png"));
    Image ParametresImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/ParametresBut.png"));
    Image ParametresImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/ParametresBut1.png"));
    Image AideImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/AideBut.png"));
    Image AideImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/AideBut1.png"));

     /******************************/
     private FXMLLoader loader ;
     private File file;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************Image personnel********************/
        imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
        /****************************************************/

        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilLabel.setTextFill(Color.WHITE);
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });

        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilLabel.setTextFill(Color.BLACK);
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #b7b5b5");
        });

        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetLabel.setTextFill(Color.WHITE);
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");

        });

        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetLabel.setTextFill(Color.BLACK);
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #b7b5b5");
        });

        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioLabel.setTextFill(Color.WHITE);
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });

        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioLabel.setTextFill(Color.BLACK);
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #b7b5b5");
        });

        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresLabel.setTextFill(Color.WHITE);
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });

        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresLabel.setTextFill(Color.BLACK);
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #b7b5b5");
        });

        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideLabel.setTextFill(Color.WHITE);
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });

        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideLabel.setTextFill(Color.BLACK);
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #b7b5b5");
        });
        /*******************************************************************************************/
        /*******************************************************************************************/
        AjouterBtn.setOnAction(e -> {
            try {
                if (!(titleInput.getText().isEmpty() && descriptionInput.getText().isEmpty() )) {
                    System.out.println("Create Projet ..... ");
                    CreateProjet(e);
                }
                titleInput.setText("");
                descriptionInput.setText("");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
         /********************************************************************/
        addImageBtn.setOnMouseClicked(event -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choisir une photo de profile");
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG Files", "*.png")
                    , new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg")
                    , new FileChooser.ExtensionFilter("GIF Files", "*.gif")
                    , new FileChooser.ExtensionFilter("BMP Files", "*.bmp")
            );
            file = chooser.showOpenDialog(null);
            System.out.println(getClass());
            FileInputStream input = null;
            /*******************************/
            try {
                input = new FileInputStream(file);
                Image image = new Image(input);
                myImage.setImage(image);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        /*****************************************************************************/
        RetourBtn.setOnMouseClicked(event -> {
             /************************
            ProjetController.cardLayout.getChildren().clear();
            System.out.println("taille de liste ees projets :" + AccueilMediateur.utilisateur.listProjets.size());
            if (AccueilMediateur.utilisateur.listProjets.size() > 0) {
                for (int i = 0; i < AccueilMediateur.utilisateur.listProjets.size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/views/ProjectCard.fxml"));

                    VBox vBox = null;
                    try {
                        vBox = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ProjectCardController projectCardController = fxmlLoader.getController();
                    System.out.println("erreur ici==>");
                    System.out.println(AccueilMediateur.utilisateur.listProjets.get(i).getCompetences().size());
                    projectCardController.setData(AccueilMediateur.utilisateur.listProjets.get(i));
                    ProjetController.cardLayout.setStyle("-fx-spacing:20;");
                    ProjetController.cardLayout.getChildren().add(vBox);
                }
            }
        });
        /*****************************************************/
              AccueilMediateur.commutateur.AllerProjet(event);
                    /*************/
        });
        /*******************************************************/
        typeInput.setOnMouseClicked(e -> {
            for (int i = 0; i < typeInput.getItems().size(); i++) {
                MenuItem item = typeInput.getItems().get(i);
                item.setOnAction(new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        typeInput.setText(item.getText());
                    }
                });
            }
        });
        /*****************************************************/
        competenceInput.setOnMouseClicked(event1 -> {

             loader =new FXMLLoader(getClass().getResource("/views/addCompetencesView.fxml"));
            ArrayList<Competence> projectCompetences ;
            try {
                Scene scene = new Scene(loader.load());
                stage= new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    /****************************************************************************/
    public void CreateProjet(ActionEvent event) throws IOException {

        int num=AccueilMediateur.utilisateur.listProjets.size();
        String tempType =typeInput.getText();
        TypeProjet typeProjet = TypeProjet.PEDAGOGIQUE ;
        switch(tempType){
            case "Pédagogique" :  typeProjet = TypeProjet.PEDAGOGIQUE;
            break;
            case "Club" : typeProjet =TypeProjet.CLUB;
            break;
            case "Personnel" : typeProjet =TypeProjet.PERSONEL;
        }
        ArrayList<String> tempDocs = new ArrayList<String>();

        Project projet = new Project(titleInput.getText(),typeProjet,projectComp,
                dateInput.getValue().toString(),tempDocs,descriptionInput.getText());
        AccueilMediateur.utilisateur.listProjets.add(projet);
        Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);
        /***************************************************/
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(new FileOutputStream("DonnesUtilisateurs/"
                    +AccueilMediateur.studentFolder + "/"+projet.getImgPath()+".png"));
        } catch (FileNotFoundException ex2) {
            ex2.printStackTrace();
        }
        try {
            Files.copy(Path.of(file.getPath()), output);
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        try {
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /***************************************************/

        projectComp.clear();
    }
}
