package controleurs.portfolio;

import controleurs.acceuil.AccueilMediateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.Portfolio;
import models.Project;
import models.Utilisateur;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PortfolioShowController implements Initializable {
    @FXML
    private Button SwitchButton;

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
    private Button addPort;
    @FXML
    public  AnchorPane monAnchorpane ;

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

    public static GridPane gridPane;
    public static ScrollPane MonScrollPane;
    private MyPortfolio myPortfolio;
    private Tooltip tooltip1 = new Tooltip("Créer un portfolio");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**********************************************/
        MonScrollPane =new ScrollPane();
        gridPane =new GridPane();
        MonScrollPane.setContent(gridPane);
        monAnchorpane.getChildren().add(MonScrollPane);
        MonScrollPane.setPrefSize(530,385);
        MonScrollPane.setLayoutX(226);
        MonScrollPane.setLayoutY(172);
        /**********************************************/
        addPort.setTooltip(tooltip1);
        addPort.setCursor(Cursor.HAND);
        /*********************************************/
        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilLabel.setTextFill(Color.WHITE);
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });
        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilLabel.setTextFill(Color.BLACK);
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #666666");
        });
        AccueilButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerAcceuil(e);
        });
        /*****************************************************************************/
        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetLabel.setTextFill(Color.WHITE);
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");

        });
        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetLabel.setTextFill(Color.BLACK);
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #666666");
        });
        ProjetButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerProjet(e);
        });
        /****************************************************************************************/
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioLabel.setTextFill(Color.WHITE);
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioLabel.setTextFill(Color.BLACK);
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #666666");
        });
        PortfolioButton.setOnMouseClicked(e->{
           AccueilMediateur.commutateur.AllerPortfolio();
        });
        /*****************************************************************************************/
        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresLabel.setTextFill(Color.WHITE);
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });
        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresLabel.setTextFill(Color.BLACK);
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #666666");
        });
        ParametresButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerParametres(e);
        });
        /*****************************************************/
        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideLabel.setTextFill(Color.WHITE);
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });
        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideLabel.setTextFill(Color.BLACK);
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #666666");
        });
        /*******************************************************/
        /********************************************************/
        addPort.setOnMouseClicked(event->{
            AccueilMediateur.monPagination.setCurrentPageIndex(3);
        });
        /*******************************************************/
        /*****************************************************/
        CreateListPortfolio();
    }


    public void CreateListPortfolio() {
        if (!AccueilMediateur.utilisateur.getListPortfolio().isEmpty()) {
            myPortfolio = new MyPortfolio() {
                @Override
                public void removePortfolio(Portfolio portfolio) {
                    int i = 1;
                    ArrayList<Portfolio> PrtfBag =new ArrayList<>();
                    for (Portfolio p : AccueilMediateur.utilisateur.getListPortfolio()){
                        if (p.getNum() != portfolio.getNum()){
                            p.setNum(i);
                            i++;
                            PrtfBag.add(p);
                        }
                    }
                    AccueilMediateur.utilisateur.setListPortfolio(PrtfBag);
                    Utilisateur.serialize(AccueilMediateur.utilisateur, AccueilMediateur.studentFolder);
                }

                @Override
                public void modifyPortfolio(Portfolio portfolio) {
                    try {
                        Portfolio portfolio1 = null;
                        for(Portfolio p : AccueilMediateur.utilisateur.getListPortfolio()){
                            if (p.getNum() == portfolio.getNum()){
                                portfolio1 = p;
                            }
                        }
                        AccueilMediateur.commutateur.AllerModificationPortfolio(portfolio1);
                        /******************************************
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ModifyPortfolio.fxml"));
                        Parent root = (Parent) loader.load();
                        ModifyPortfolioController modifyPortfolioController = loader.getController();
                        modifyPortfolioController.SelectedProjects(portfolio1);
                        Stage stage = (Stage)PortfolioButton.getScene().getWindow();
                        stage.setScene(new Scene(root, 850,600));
                        stage.getIcons().addAll(IconImg);
                        /********************************************************/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void exportPortfolio(Portfolio portfolio) {

                }
            };
            int column = 1;
            int row = 0;
            /************************************************************************************/
            /*******************L'affichage des portfolios*************************************/
            /*************************************************************************************/
            Portfolio po;
            try {
                System.out.println("remplissage de la liste des portfolios dans la listedes" +
                        "portfolios");
                AccueilMediateur.utilisateur =Utilisateur.deserialization(AccueilMediateur.studentFolder);
                for (int i = 0; i < AccueilMediateur.utilisateur.getListPortfolio().size(); i++) {
                    po =  AccueilMediateur.utilisateur.getListPortfolio().get(i);
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/views/PortfolioModelView.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    PortfolioItemController portfolioItemController = fxmlLoader.getController();
                    portfolioItemController.setData(po, myPortfolio);

                    gridPane.add(anchorPane, column++, row);
                    GridPane.setMargin(anchorPane, new Insets(15, 15, 1, 10));
                    gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                    gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    gridPane.setMaxWidth(Region.USE_PREF_SIZE);

                    gridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                    gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    gridPane.setMaxHeight(Region.USE_PREF_SIZE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
