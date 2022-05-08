package controleurs.portfolio;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
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
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import modele.Portfolio;
import modele.PortfoliosBag;
import modele.Project;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
    private ImageView DeconnexionBut;
    @FXML
    private ImageView RetourBut;
    @FXML
    private ImageView ExportHTML;
    @FXML
    private ImageView ExportPDF;
    @FXML
    private GridPane gridPane;
    @FXML
    private ScrollPane ScrPane;

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

    List<Project> SelectedProject = new ArrayList<>();
    private MyProject myProject;
    PortfoliosBag port;

    public PortfolioModel1Controller() throws ParseException, IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

        RetourBut.setOnMouseClicked(e->{
            try{
                ShowModels(e);
            } catch(Exception exception){
                exception.printStackTrace();
            }
        });

        try {
            CreateListProject();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ExportHTML.setOnMouseClicked(e->{
            try {
                CreatePortfolio(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void SwtichScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Portfolio12View.fxml"));
        Stage stage = (Stage)SwitchButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.getIcons().addAll(IconImg);
    }

    public void GoToPortfolio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/PortfolioShowPage.fxml"));
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

    public void ShowModels(MouseEvent event) throws IOException{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/Portfolio1View.fxml"));
        Scene scene = new Scene(loader.load(),850,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(IconImg);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Project project1 = new Project("Projet 2CP","Personnel",null,dateFormat.parse("2019-3-20"),null,null,null);
    Project project2 = new Project("title","Club",null,dateFormat.parse("2021-2-15"),null,null,null);
    Project project3 = new Project("title","Club",null,dateFormat.parse("2021-3-17"),null,null,null);
    Project project4 = new Project("title","Pédagogique",null,dateFormat.parse("2021-3-17"),null,null,null);

    List<Project> ListProject = new ArrayList<>();

    public void CreateListProject() throws ParseException {
        ListProject.add(project1); ListProject.add(project2); ListProject.add(project3); ListProject.add(project4);
        int column = 0;
        int row = 0;

        myProject = new MyProject() {
            @Override
            public void mySelectedProject(Project project) {
                SelectedProject.add(project);
            }

            @Override
            public void notSelectedProject(Project project){
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
                gridPane.add(anchorPane,column,row++);
                GridPane.setMargin(anchorPane, new Insets(10));

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void CreatePortfolio(MouseEvent event) throws IOException {
       /* List<Portfolio> list = new ArrayList<>();
        /************************** Read JSON file *********************************
        try {
            Reader reader = Files.newBufferedReader(Paths.get("DonnesUtilisateur/portfolios.json"));
            list = new Gson().fromJson(reader, new TypeToken<List<Portfolio>>() {}.getType());
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        ***********************************************************/

        if(PortfoliosBag.isEmptyBag()){ // no portfolio was created
            Portfolio portfolio = new Portfolio(1 , SelectedProject);
            //port = new PortfoliosBag();
            PortfoliosBag.addPortfolio(portfolio);
        } else {
            int num = 0;

            for (Portfolio p : PortfoliosBag.getPortfolios()){
                num = p.getId();
            }

            Portfolio portfolio = new Portfolio(num + 1, SelectedProject);
            PortfoliosBag.addPortfolio(portfolio);
        }
    }
}
