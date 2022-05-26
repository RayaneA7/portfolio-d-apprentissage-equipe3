package controleurs.portfolio;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import controleurs.passage.RealiserAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Project;
import models.*;
import controleurs.acceuil.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static controleurs.portfolio.GenererHtmlPdf.*;

public class PortfolioModel1Controller implements Initializable {
    @FXML
    private AnchorPane PaneProjects;
    @FXML
    private Button SwitchButton;
    @FXML
    private Button AccueilButton;
    @FXML
    private Label AccueilLabel;
    @FXML
    private Button ProjetButton;
    @FXML
    private Label ProjetLabel;
    @FXML
    private Button PortfolioButton;
    @FXML
    private Button AideButton;
    @FXML
    private Label AideLabel;
    @FXML
    private Label PortfolioLabel;
    @FXML
    private Button ParametresButton;
    @FXML
    private Label ParametresLabel;
    @FXML
    private ImageView AccueilImage;
    @FXML
    private ImageView ProjetsImage;
    @FXML
    private ImageView PortfolioImage;
    @FXML
    private ImageView ParametresIamge;
    @FXML
    private ImageView AideImage;
    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Line line5;
    @FXML
    private ImageView logOut;
    @FXML
    private Button RetourBut;
    @FXML
    private Button ExportHTML;
    @FXML
    private Button ExportPDF;
    @FXML
    private Button EnregBut;
    @FXML
    private GridPane gridPane;
    @FXML
    private ScrollPane ScrPane;
    @FXML
    private Label LabelAlert;
    @FXML
    private Label CreateLabel;
    @FXML
    private Circle imagePersonnel ;

    private Image AccueilImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/AccueilBut.png"));
    private Image AccueilImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/AccueilBut1.png"));
    private Image PortfolioImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioBut.png"));
    private Image PortfolioImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioBut1.png"));
    private Image ProjetImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/ProjetsBut.png"));
    private Image ProjetImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/ProjetsBut1.png"));
    private Image ParametresImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/ParametresBut.png"));
    private Image ParametresImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/ParametresBut1.png"));
    private Image AideImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/AideBut.png"));
    private Image AideImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/AideBut1.png"));
    private Image IconImg = new Image(getClass().getResourceAsStream("/icons/Inscription/ProjectName.png"));

    public static List<Project> SelectedProject = new ArrayList<>();
    private MyProject myProject;
    private int dureeErreur = 3000;

    public PortfolioModel1Controller() throws ParseException, IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*********************Image personnel********************/
        if(AccueilMediateur.image!=null){
            imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
        }
        imagePersonnel.setOnMouseClicked(e-> {
            AccueilMediateur.commutateur.AllerProfile(e);
        });
        /****************************************************/
        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilLabel.setTextFill(Color.WHITE);
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });
        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilLabel.setTextFill(Color.web("#666666"));
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #d7d6d6");
        });
        AccueilButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerAcceuil(e);
        });
       /***********************************************************************************/
        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetLabel.setTextFill(Color.WHITE);
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");

        });
        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetLabel.setTextFill(Color.web("#666666"));
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #d7d6d6");
        });
        ProjetButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerProjet(event);
        });
        /****************************************************************************/
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioLabel.setTextFill(Color.WHITE);
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioLabel.setTextFill(Color.web("#666666"));
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #d7d6d6");
        });
        PortfolioButton.setOnMouseClicked(e->{
            try {
                AccueilMediateur.utilisateur=Utilisateur.deserialization(AccueilMediateur.studentFolder);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            AccueilMediateur.commutateur.AllerPortfolio();
        });

        /***********************************************************************************/
        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresLabel.setTextFill(Color.WHITE);
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });
        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresLabel.setTextFill(Color.web("#666666"));
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #d7d6d6");
        });
        ParametresButton.setOnMouseClicked(event -> {
            // AccueilMediateur.monPagination.setCurrentPageIndex(2);
            AccueilMediateur.commutateur.AllerParametres(event);
        });
        /***********************************************************************************/
        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideLabel.setTextFill(Color.WHITE);
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });
        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideLabel.setTextFill(Color.web("#666666"));
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #d7d6d6");
        });
        AideButton.setOnMouseClicked(event -> {
            try {
                AccueilMediateur.commutateur.AllerAide(event);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        logOut.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.Déconnecter(event);
        });
        /****************************/
        RetourBut.setOnMouseClicked(e -> {
           AccueilMediateur.monPagination.setCurrentPageIndex(3);
        });
        /************************************************/
        try {
            CreateListProject();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /***********************************************/
        EnregBut.setOnMouseClicked(e -> {
            if(SelectedProject.isEmpty()){
                TraiterAlert(LabelAlert);
            } else {
                try {
                    CreatePortfolio(e);
                    TraiterAlert(CreateLabel);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        /**********************************************************/
        /****ici on cree l html ***/
        ExportHTML.setOnMouseClicked(e-> {
                    DirectoryChooser directoryChooser = new DirectoryChooser();
                    File file = directoryChooser.showDialog(new Stage());
                    if (file != null) {
                        System.out.println(file.getAbsolutePath());
                        copyDirectory("./DonnesUtilisateurs/20_250/", file.getAbsolutePath());
                        saveSystem(new File(file.getAbsolutePath() + "/index.html"), genererHtml(AccueilMediateur.utilisateur));
                    }
        });
        /*****************generation pdf*********************/
        ExportPDF.setOnMouseClicked(e-> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {
                genererPdf(file, AccueilMediateur.utilisateur);
            }
        });

    }
    /********************************************************************************************/
    /********************************************************************************************/
    /**********************************************************************************************/
    public void CreateListProject() throws ParseException {
        SelectedProject.clear();
        int column = 0;
        int row = 0;
        ArrayList<Project> ListProject =  AccueilMediateur.utilisateur.getListProjets();
        myProject = new MyProject() {
            @Override
            public void mySelectedProject(Project project) {
                SelectedProject.add(project);
            }

            @Override
            public void notSelectedProject(Project project) {
                SelectedProject.remove(project);
            }
        };

        try {
            for (int i = 0; i < ListProject.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/ProjetModelView.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ProjectItemController projectItemController = fxmlLoader.getController();

                projectItemController.setData(ListProject.get(i), myProject);

                gridPane.setStyle("-fx-background-color: F5F5F5");
                gridPane.add(anchorPane, column, row++);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /**************************************************************/
    public void CreatePortfolio(MouseEvent event) throws IOException {

        if (AccueilMediateur.utilisateur.getListPortfolio().isEmpty()) { // no portfolio was created
            Portfolio portfolio = new Portfolio(1, SelectedProject, LocalDate.now().toString());
            AccueilMediateur.utilisateur.getListPortfolio().add(portfolio);
        } else {
            int num = 0;

            for (Portfolio p :AccueilMediateur.utilisateur.getListPortfolio()) {
                num = p.getNum();
            }

            Portfolio portfolio = new Portfolio(num + 1, SelectedProject, LocalDate.now().toString());
            AccueilMediateur.utilisateur.getListPortfolio().add(portfolio);
        }
        Utilisateur.serialize(AccueilMediateur.utilisateur, AccueilMediateur.studentFolder);
    }

    public void TraiterAlert(Node node)
    {
        Timer timer =new Timer();
        TimerTask task =new RealiserAlert(node, timer);
        node.setOpacity(1);
        timer.schedule(task,dureeErreur);
    }
}