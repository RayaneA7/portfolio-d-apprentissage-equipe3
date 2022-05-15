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
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Portfolio12Controller implements Initializable {
    @FXML
    private Pagination pagination;
    @FXML
    private Button SwitchButton;
    @FXML
    private Button AccueilButton;
    @FXML
    private Button ProjetButton;
    @FXML
    private Button PortfolioButton;
    @FXML
    private Button ParametresButton;
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
    private Button AideButton;
    @FXML
    private ImageView AideImage;
    @FXML
    private Label AideLabel;
    @FXML
    private Button DeconnexionButton;
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
    private String user = null;
    private int nbrProjets = 0;
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
    static int Currentpag;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });

        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #b7b5b5");
        });

        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");
        });

        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #b7b5b5");
        });

        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });

        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #b7b5b5");
        });

        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });

        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #b7b5b5");
        });

        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });

        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: F5F5F5");
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

        PortfolioButton.setOnAction(e->{
            try{
                GoToPortfolio(e);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        });

        DeconnexionButton.setOnMouseClicked(event -> {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load(),850,600);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });

        AccueilButton.setOnAction(e->{
            try{
                GoToAccueil(e);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        CreatePag();
        Currentpag = pagination.getCurrentPageIndex();

    }
    public void SwtichScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Portfolio1View.fxml"));
        Stage stage = (Stage)SwitchButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.getIcons().add(IconImg);
    }

    public void GoToPortfolio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Portfolio12View.fxml"));
        Stage stage = (Stage)PortfolioButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.getIcons().add(IconImg);
    }

    public void GoToAccueil(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/views/Accueil_1View.fxml"));
        Stage stage = (Stage)AccueilButton.getScene().getWindow();
        stage.setScene(new Scene(root,850,600));
        stage.getIcons().add(IconImg);
    }

    public int getNumberOfPages() {
        return nbrProjets;
    }

    public HBox CreatePage(int numberOfPage){
        HBox hbox = new HBox();
        // à implémenter
        return hbox;
    }

    public void CreatePag(){
        pagination.setPageCount(getNumberOfPages());
        pagination.setPageFactory((Integer pageIndex) -> CreatePage(pageIndex));
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        pagination.getStylesheets().add("/css/PortfolioPag.css");
        pagination.setCurrentPageIndex(Currentpag);
    }

}
