package controleurs.acceuil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.LoginUtilisateurs;
import models.Statistiques;
import models.Utilisateur;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {
    @FXML
    Button AccueilButton;
    @FXML
    Label AccueilLabel;
    @FXML
    Button ProjetButton;
    @FXML
    Label ProjetLabel;
    @FXML
    Button PortfolioButton;
    @FXML
    private PieChart softhardpie;
    @FXML
    private Label labstat;
    @FXML
    private BarChart<String, Integer> barCharta;
    @FXML
    Button AideButton;
    @FXML
    Label AideLabel;
    @FXML
    Label PortfolioLabel;
    @FXML
    Button ParametresButton;
    @FXML
    Label ParametresLabel;
    @FXML
    Label WelcomeLabel;
    /****************** ImageViews *************************/
    @FXML
    ImageView AccueilImage;
    @FXML
    ImageView ProjetsImage;
    @FXML
    ImageView PortfolioImage;
    @FXML
    ImageView ParametresIamge;
    @FXML
    ImageView AideImage;
    @FXML
    ImageView logOut ;
    @FXML
    Circle imagePersonnel ;
    @FXML
    ImageView imageTest;
    @FXML
    private Button AjProButton ;
    @FXML
    private Button AjPorButton ;
    /*******************les lignes **********************/
    @FXML
    Line line1;
    @FXML
    Line line2;
    @FXML
    Line line3;
    @FXML
    Line line4;
    @FXML
    Line line5;
    /****************************************************************/
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
    Stage stage ;
    /*******************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /********************************** statistique ******************************************************/
        //la classe statistique
        Statistiques statistiques =new Statistiques(AccueilMediateur.utilisateur.getListProjets());
        statistiques.CalculerNbprojetsType();
        try {
            statistiques.CalculerTypeCompetance();
        }catch (Exception e){
            System.out.println("Erreur se génere lors de calcul des competences");
        }
        /**************************pieChart soft/hard********************************/
        statistiques.CalculerTypeCompetance();
        ObservableList<PieChart.Data> pieChartData1 =
                FXCollections.observableArrayList(
                        new PieChart.Data("Soft skills",statistiques.getNbSoftsSkills()),
                        new PieChart.Data("Hard skills", statistiques.getNbHardSkills()));
        softhardpie.getData().addAll(pieChartData1);
        float nbcmpt = statistiques.getNbHardSkills()+ statistiques.getNbSoftsSkills();
        float pourcentagehard = (statistiques.getNbHardSkills()/ nbcmpt )*100;
        labstat.setText( (int)pourcentagehard +"%");
        /************************barChart ********************************/
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("project");
        int projets2022 = 0;
        int projets2021 = 0;
        int projets2020 = 0;
        int projets2019 = 0;
        int projets2018 = 0;
        int projets2016 = 0;
        int projets2017 = 0;
        int projets2023 = 0;
        int projets2024 = 0;
        int projets2025 = 0;
        int projets2026 = 0;
        for (int j = 0; j < AccueilMediateur.utilisateur.getListProjets().size(); j++) {
            String input = String.valueOf(AccueilMediateur.utilisateur.getListProjets().get(j).getDate());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(input, formatter);
            int year = localDate.getYear();
            switch (year){
                case 2026 :
                    projets2026 ++;
                    break;
                case 2025 :
                    projets2025 ++;
                    break;
                case 2024 :
                    projets2024 ++;
                    break;
                case 2023 :
                    projets2023 ++;
                    break;
                case 2022 :
                    projets2022 ++;
                    break;
                case 2021 :
                    projets2021++;
                    break;
                case 2020 :
                    projets2020++;
                    break;
                case 2019 :
                    projets2019++;
                    break;
                case 2018 :
                    projets2018++;
                    break;
                case 2017 :
                    projets2017++;
                    break;
                case 2016 :
                    projets2016++;
                    break;
            }
        }
        series.getData().add(new XYChart.Data<>("2016", projets2016));
        series.getData().add(new XYChart.Data<>("2017", projets2017));
        series.getData().add(new XYChart.Data<>("2018", projets2018));
        series.getData().add(new XYChart.Data<>("2019", projets2019));
        series.getData().add(new XYChart.Data<>("2020", projets2020));
        series.getData().add(new XYChart.Data<>("2021", projets2021));
        series.getData().add(new XYChart.Data<>("2022",projets2022));
        series.getData().add(new XYChart.Data<>("2023",projets2023));
        series.getData().add(new XYChart.Data<>("2024",projets2024));
        series.getData().add(new XYChart.Data<>("2025",projets2025));
        series.getData().add(new XYChart.Data<>("2026",projets2026));
        barCharta.getData().add(series);
        /*********************Image personnel********************/
            if(AccueilMediateur.image!=null){
                imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
            }
            imagePersonnel.setOnMouseClicked(e-> {
                        AccueilMediateur.commutateur.AllerProfile(e);
                    });
            imagePersonnel.setOnMouseClicked(e->{
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
            //AccueilMediateur.monPagination.setCurrentPageIndex(6);
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
        /***********************************************************************************/
        AjPorButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerAddPortfolio(e);
        });
        AjProButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerAddProjet(e);
        });
        /*********************************************************************************
        WelcomeLabel.setText("Bonjour ,"+AccueilMediateur.utilisateur.donnes.getNom()+" "+ AccueilMediateur.utilisateur.donnes.getPrenom());
        SwitchButton.setOnAction(e->{
            AccueilMediateur.monPagination.setCurrentPageIndex(1);
        });
        /************************************************************************************/
        WelcomeLabel.setText("Bonjour ,"+AccueilMediateur.utilisateur.donnes.getPrenom());

        /***********************************************************/
        logOut.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.Déconnecter(event);
        });
    }
    /***
    public void SwtichScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/views/Accueil_1View.fxml"));
        stage = (Stage) SwitchButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.setTitle("Ecareer");
    }
     /*******/
}
