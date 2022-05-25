package controleurs.portfolio;

import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import controleurs.passage.RealiserAlert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import models.Ordre;
import models.Portfolio;
import models.Project;
import models.Utilisateur;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class ModifyPortfolioController implements Initializable {

    @FXML
    private AnchorPane anchorePane;

    @FXML
    private ImageView BarreImage;

    @FXML
    private Button ProjetButton;

    @FXML
    private ImageView ProjetsImage;

    @FXML
    private Label ProjetLabel;

    @FXML
    private Button PortfolioButton;

    @FXML
    private ImageView PortfolioImage;

    @FXML
    private Label PortfolioLabel;

    @FXML
    private Button AideButton;

    @FXML
    private ImageView AideImage;

    @FXML
    private Label AideLabel;

    @FXML
    private Button ParametresButton;

    @FXML
    private ImageView ParametresIamge;

    @FXML
    private Label ParametresLabel;

    @FXML
    private Label NbrPoerfolio;

    @FXML
    private Button AccueilButton;

    @FXML
    private ImageView AccueilImage;

    @FXML
    private Label AccueilLabel;

    @FXML
    private ImageView logOut;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line5;

    @FXML
    private Line line4;

    @FXML
    private Circle imagePersonnel;

    @FXML
    private ScrollPane ScrPane1;

    @FXML
    private GridPane gridPane1;

    @FXML
    private ScrollPane ScrPane2;

    @FXML
    private GridPane gridPane2;

    @FXML
    private Button RetourBut;

    @FXML
    private Button ModifyBut;

    @FXML
    private Label ModifierLabel;

    @FXML
    private Label ErreurLabel;

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
    private Image ModelProf1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/Mod1.png"));
    private Image ModelAnim1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/Mod2.png"));
    private Image PortMod1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioModel.png"));
    private Image PortMo2 = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioModel2.png"));

    MyProject myProject = null;
    private Portfolio portfolio;
    private int dureeErreur = 4000;
    public CustomDialog customDialog;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*****************************************************************************/
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
            line1.setStyle("-fx-stroke: #666666");
        });
        AccueilButton.setOnMouseClicked(e -> {
            AccueilMediateur.commutateur.AllerAcceuil(e);
        });
        /******************************************************************************/
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
            line2.setStyle("-fx-stroke: #666666");
        });
        ProjetButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerProjet(e);
        });
        /******************************************************************************/
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
            line3.setStyle("-fx-stroke: #666666");
        });
        PortfolioButton.setOnMouseClicked(e -> {
            AccueilMediateur.commutateur.AllerPortfolio();
        });
        /*******************************************************************************/
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
            line4.setStyle("-fx-stroke: #666666");
        });
        ParametresButton.setOnMouseClicked(e -> {
            AccueilMediateur.commutateur.AllerParametres(e);
        });
        /************************************************************************************/
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
            line5.setStyle("-fx-stroke: #666666");
        });
        AideButton.setOnMouseClicked(e->{
            try {
                AccueilMediateur.commutateur.AllerAide(e);
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        /********************************************************************/
        /********************************************************************/
        ModifyBut.setOnAction(e->{
            customDialog = new CustomDialog("Confirmer Modification","Si vous voulez vraiment modifier le portfolio, cliquez sur OK, sinon Csur Canel");
            customDialog.show();
            customDialog.buttonOk.setOnAction(event->{
                /*if(AccueilMediateur.utilisateur.getListPortfolio(){
                TraiterAlert(ErreurLabel);
            } else{*/
                Utilisateur.serialize(AccueilMediateur.utilisateur, AccueilMediateur.studentFolder);
                TraiterAlert(ModifierLabel);/*}*/
                customDialog.closeDialog();
            });
            customDialog.buttonCancel.setOnAction(event->{
                customDialog.closeDialog();
            });

        });
        RetourBut.setOnMouseClicked(e->{
            try {
                AccueilMediateur.utilisateur =Utilisateur.deserialization(AccueilMediateur.studentFolder);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            AccueilMediateur.commutateur.AllerPortfolio();
        });
    }


    public void SelectedProjects(Portfolio portfolio) {
        int column1 = 0;
        int column2 = 0;
        int row1 = 0;
        int row2 = 0;
        int id  = portfolio.getNum();

        //*********************//
        if(id == 1) NbrPoerfolio.setText(Ordre.Premier.toString() + "Portfolio");
        else if(id == 2) NbrPoerfolio.setText(Ordre.Deuxième.toString() + "Portfolio");
        else if(id == 3) NbrPoerfolio.setText(Ordre.Troisième.toString() + "Portfolio");
        else if(id == 4) NbrPoerfolio.setText(Ordre.Quatrième.toString() + "Portfolio");
        else if(id == 5) NbrPoerfolio.setText(Ordre.Cinquième.toString() + "Portfolio");
        else if(id == 6) NbrPoerfolio.setText(Ordre.Sixième.toString() + "Portfolio");
        else if(id == 7) NbrPoerfolio.setText(Ordre.Septième.toString() + "Portfolio");
        else if(id == 8) NbrPoerfolio.setText(Ordre.Huitième.toString() + "Portfolio");
        else if(id == 9) NbrPoerfolio.setText(Ordre.Neuvième.toString() + "Portfolio");
        else if(id == 10) NbrPoerfolio.setText(Ordre.Dixième.toString() + "Portfolio");
        else NbrPoerfolio.setText("Portfolio numéro " + id);
        //********************//
        myProject = new MyProject() {
            @Override
            public void mySelectedProject(Project project) {
                AccueilMediateur.utilisateur.listPortfolio.get(id - 1).getListProject().add(project);
            }

            @Override
            public void notSelectedProject(Project project) {
                int i = 0;
                List<Project> newList = new ArrayList();
                for(Project p : AccueilMediateur.utilisateur.listPortfolio.get(id - 1).getListProject()){
                   if(!p.getId().equals(project.getId())){
                       newList.add(p);
                   }
                }
                AccueilMediateur.utilisateur.listPortfolio.get(id - 1).setListProject(newList);
            }
        };

        try {
            // AccueilMediateur.utilisateur=Utilisateur.deserialization(AccueilMediateur.studentFolder);
            System.out.println("la taille de la liste des projets de portfolio : "+AccueilMediateur.utilisateur.listProjets.size());
            for (int i = 0; i < AccueilMediateur.utilisateur.listProjets.size(); i++) {
                boolean trouv = false;
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/ProjetModelView.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ProjectItemController projectItemController = fxmlLoader.getController();
                projectItemController.setData(AccueilMediateur.utilisateur.listProjets.get(i), myProject);

                for(Project p : portfolio.getListProject()){
                     System.out.println("utilisateur :"+AccueilMediateur.utilisateur.listProjets.get(i).getId()+"  portfolio :"+p.getId());
                    if (AccueilMediateur.utilisateur.listProjets.get(i).getId().equals(p.getId())) trouv = true;

                }
                if (trouv) {
                    anchorPane.setStyle("-fx-background-color : #f1c53c");
                    projectItemController.checkButton.setSelected(true);
                    gridPane1.setStyle("-fx-background-color: F5F5F5");
                    gridPane1.add(anchorPane, column1, row1++);
                    GridPane.setMargin(anchorPane, new Insets(15));
                } else {
                    anchorPane.setStyle("-fx-background-color : #fffff");
                    gridPane2.setStyle("-fx-background-color: F5F5F5");
                    gridPane2.add(anchorPane, column2, row2++);
                    GridPane.setMargin(anchorPane, new Insets(15));
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void TraiterAlert(Node node)
    {
        Timer timer =new Timer();
        TimerTask task =new RealiserAlert(node, timer);
        node.setOpacity(1);
        timer.schedule(task,dureeErreur);
    }

}
