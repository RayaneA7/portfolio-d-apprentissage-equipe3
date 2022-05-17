package controleurs.portfolio;

import controleurs.acceuil.AccueilMediateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Portfolio1Controller implements Initializable {
    @FXML
    Pagination pagination;
    @FXML
    private AnchorPane PanePort;
    /************************ Buttons *******************************/
    @FXML
    private Button SwitchButton;
    @FXML
    private Button AccueilButton;
    @FXML
    private Button ProjetButton;
    @FXML
    private Button PortfolioButton;
    @FXML
    private Button AideButton;
    @FXML
    private Button ParametresButton;
    @FXML
    private Button DeconnexionBut;
    /************************ Labels *******************************/
    @FXML
    private Label AccueilLabel;
    @FXML
    private Label ProjetLabel;
    @FXML
    private Label AideLabel;
    @FXML
    private Label PortfolioLabel;
    @FXML
    private Label ParametresLabel;
    /************************ Image Views *******************************/
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
    private ImageView Mod1;
    @FXML
    private ImageView Mod2;
    @FXML
    private ImageView PortModel1;
    @FXML
    private ImageView PortModel2;
    @FXML
    private ImageView Next;
    @FXML
    private ImageView Previous;

    /************************ Lines *******************************/
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
    private int nbrPag = 3;
    static int Currentpag = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CreatePag();
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
        ProjetButton.setOnMouseClicked(e -> {
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
            AccueilMediateur.commutateur.AllerPortfolio(e);
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
        AideButton.setOnMouseClicked(e -> {
            try {
                AccueilMediateur.commutateur.AllerAide(e);
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        /*********************************************************************************
         SwitchButton.setOnAction(e->{
         try {
         SwtichScene(e);
         } catch (IOException ex) {
         ex.printStackTrace();
         }
         });
         /***********************************************************************************
         AccueilButton.setOnAction(e->{
         try{
         GoToAccueil(e);
         } catch(Exception ex){
         ex.printStackTrace();
         }
         });
         /***************************************************************************************
         PortfolioButton.setOnAction(e->{
         try{
         GoToPortfolio(e);
         }
         catch (IOException ex){
         ex.printStackTrace();
         }
         });
         /***************************************************************************************/
        Next.setOnMouseClicked(e -> {
            NextPag();
        });

        Previous.setOnMouseClicked(e -> {
            PreviousPag();
        });

        PortModel1.setOnMouseClicked(e -> {
            try {
                Preview(e, pagination.getCurrentPageIndex());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Mod1.setOnMouseClicked(e -> {
            try {
                Preview(e, pagination.getCurrentPageIndex());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        DeconnexionBut.setOnMouseClicked(e -> {
            try {
               AccueilMediateur.commutateur.Déconnecter(e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Currentpag = pagination.getCurrentPageIndex();
    }

    public AnchorPane CreatePage(int pageIndex) {
        AnchorPane pane = new AnchorPane();
        if (pageIndex == 0) {
            Mod1.setImage(ModelProf1);
            Mod2.setImage(ModelAnim1);
            Mod1.setLayoutX(35);
            Mod1.setLayoutY(46);
            Mod2.setLayoutX(275);
            Mod2.setLayoutY(46);
            PortModel1.setLayoutX(0);
            PortModel1.setLayoutY(20);
            PortModel2.setLayoutX(238);
            PortModel2.setLayoutY(20);
            pane.getChildren().addAll(PortModel1, PortModel2);
            pane.getChildren().addAll(Mod1, Mod2);
            return pane;
        }
        if (pageIndex == 1) {
            Mod1.setImage(ModelAnim1);
            Mod2.setImage(ModelAnim1);
            Mod1.setLayoutX(35);
            Mod1.setLayoutY(46);
            Mod2.setLayoutX(275);
            Mod2.setLayoutY(46);
            PortModel1.setLayoutX(0);
            PortModel1.setLayoutY(20);
            PortModel2.setLayoutX(238);
            PortModel2.setLayoutY(20);
            pane.getChildren().addAll(PortModel1, PortModel2);
            pane.getChildren().add(Mod1);
            pane.getChildren().add(Mod2);
            return pane;
        }
        if (pageIndex == 2) {
            Mod1.setImage(ModelProf1);
            Mod2.setImage(ModelAnim1);
            Mod1.setLayoutX(35);
            Mod1.setLayoutY(46);
            Mod2.setLayoutX(275);
            Mod2.setLayoutY(46);
            PortModel1.setLayoutX(0);
            PortModel1.setLayoutY(20);
            PortModel2.setLayoutX(238);
            PortModel2.setLayoutY(20);
            pane.getChildren().addAll(PortModel1, PortModel2);
            pane.getChildren().addAll(Mod1, Mod2);
            return pane;
        }
        return null;
    }

    public void CreatePag() {
        pagination.setPageCount(nbrPag);
        pagination.setCurrentPageIndex(Currentpag);
        pagination.setPageFactory((Integer pageIndex) -> CreatePage(pageIndex));
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
       // pagination.getStylesheets().add("/css/PortfolioPag.css");
    }

    public void NextPag() {
        pagination.setCurrentPageIndex((pagination.getCurrentPageIndex() + 1) % nbrPag);
    }

    public void PreviousPag() {
        pagination.setCurrentPageIndex((pagination.getCurrentPageIndex() + 1) % nbrPag);
    }

    public void Preview(MouseEvent event, int numPag) throws IOException {
        //faire une mise à jour pour la liste
        AccueilMediateur.utilisateur= Utilisateur.deserialization(AccueilMediateur.studentFolder);
        FXMLLoader loader = null;
        if (numPag == 0) {
            loader = new FXMLLoader(getClass().getResource("/views/PortfolioModel1View.fxml"));
            try {
                if(AccueilMediateur.memory.get(5)!=null) {
                    AccueilMediateur.memory.remove(5);
                }
                AccueilMediateur.memory.add(5,loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            AccueilMediateur.monPagination.setCurrentPageIndex(5);
        }
        /***************A realiser *********************/
        /************************************************/
        /*********************************************
        if (numPag == 1) {
            loader = new FXMLLoader(getClass().getResource("/views/PortfolioModel2View.fxml"));
            AccueilMediateur.monPagination.setCurrentPageIndex(6);
        }
        if (numPag == 2) {
            loader = new FXMLLoader(getClass().getResource("/views/PortfolioModel3View.fxml"));
            AccueilMediateur.monPagination.setCurrentPageIndex(7);
        }
        /************************************************/
    }
}
/*195 80 gridPane ScrPane*/