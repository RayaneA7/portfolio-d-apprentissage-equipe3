package controleurs.portfolio;

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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Portfolio1Controller implements Initializable {
    @FXML
    AnchorPane pane;
    @FXML
     Pagination pagination;
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
    Button PortfolioButton;
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
    private Label WelcomeLabel;
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
    private Button DeconnexionBut;
    @FXML
    private AnchorPane PanePort;
    @FXML
    private ImageView PortModel1;
    @FXML
    private ImageView PortModel2;
    @FXML
    private ImageView Next;
    @FXML
    private ImageView Previous;

    private String user = null;
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
    private int nbrPag = 3;
    static int Currentpag = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CreatePag();

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
            line1.setStyle("-fx-stroke: #b7b5b5");
        });

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
            line2.setStyle("-fx-stroke: #b7b5b5");
        });

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
            line3.setStyle("-fx-stroke: #b7b5b5");
        });

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
            line4.setStyle("-fx-stroke: #b7b5b5");
        });

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
            line5.setStyle("-fx-stroke: #b7b5b5");
        });


        SwitchButton.setOnAction(e->{
            try {
                SwtichScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        AccueilButton.setOnAction(e->{
            try{
                GoToAccueil(e);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        PortfolioButton.setOnAction(e->{
            try{
                GoToPortfolio(e);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        });

        Next.setOnMouseClicked(e->{
            NextPag();
        });

        Previous.setOnMouseClicked(e->{
            PreviousPag();
        });

        DeconnexionBut.setOnMouseClicked(event -> {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load(),800,568);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });

        Currentpag = pagination.getCurrentPageIndex();
    }

    public void SwtichScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Portfolio12View.fxml"));
        Stage stage = (Stage)SwitchButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.getIcons().addAll(IconImg);
    }

    public void GoToPortfolio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Portfolio1View.fxml"));
        Stage stage = (Stage)PortfolioButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.getIcons().addAll(IconImg);
    }

    public void GoToAccueil(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/views/AccueilView.fxml"));
        Stage stage = (Stage)AccueilButton.getScene().getWindow();
        stage.setScene(new Scene(root,850,600));
        stage.getIcons().add(IconImg);
    }

    public AnchorPane CreatePage(int pageIndex){
        AnchorPane Pane = new AnchorPane();
        if(pageIndex == 0 || pageIndex == 1 || pageIndex == 2) return PanePort;
        else return Pane;
    }


    public void CreatePag(){
        pagination.setPageCount(nbrPag);
        pagination.setCurrentPageIndex(Currentpag);
        pagination.setPageFactory((Integer pageIndex) -> CreatePage(pageIndex));
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        pagination.getStylesheets().add("/css/PortfolioPag.css");
    }

    public void NextPag(){
        pagination.setCurrentPageIndex((pagination.getCurrentPageIndex()+1)%nbrPag);
    }
    public void PreviousPag(){
        pagination.setCurrentPageIndex((pagination.getCurrentPageIndex()+1)%nbrPag);
    }





}
