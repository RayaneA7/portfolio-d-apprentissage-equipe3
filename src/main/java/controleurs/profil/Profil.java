package controleurs.profil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import java.awt.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Statistiques;
import models.Utilisateur;
import controleurs.acceuil.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class Profil implements Initializable {
    /****************** Labels ************************/
    @FXML
    private Label Nom;
    @FXML
    private Label Prenom;
    @FXML
    private Label matricule;
    @FXML
    private Label email;
    @FXML
    private Label niveau;
    @FXML
    private Label Bio;
    @FXML
    private Label Nbprojects;
    @FXML
    private ImageView image;
    @FXML
    private ImageView logout;
    @FXML
    private PieChart pieChart;
    @FXML
    private PieChart pie2;
    @FXML
    private BarChart<String,Integer> barChart;
    @FXML
    private CategoryAxis projects;
    @FXML
    private NumberAxis years;
    @FXML
    private Label pcct;
    @FXML
    private Label poucentage;
   @FXML
    private Hyperlink linkdin;
    @FXML
 void openLink (ActionEvent event ) throws URISyntaxException,IOException{
        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/feed/"));
    }
    private Hyperlink facebook;
    @FXML
    void openfacebook (ActionEvent event ) throws URISyntaxException,IOException{
        Desktop.getDesktop().browse(new URI("https://www.facebook.com"));
    }
    private Hyperlink github;
    @FXML
    void opengithub (ActionEvent event ) throws URISyntaxException,IOException{
        Desktop.getDesktop().browse(new URI("https://www.github.com"));
    }

    @FXML
    private Label lab2;

    //creer un utilisateur
    Utilisateur user = new Utilisateur();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************************************pieChart********************************/
        // le chargement des donnes
        int perso = 0;
        int peda = 0;
        int club = 0;
        //la classe statistique
        Statistiques statistiques =new Statistiques(AccueilMediateur.utilisateur.getListProjets());
        statistiques.CalculerNbprojetsType();
        perso=statistiques.getNbProjetsPersonnels();
        peda =statistiques.getNbProjetsPédagogiques();
        club = statistiques.getNbProjetsClubs();

        // le dessin
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("personnel", perso),
                        new PieChart.Data("pedagogique", peda),
                        new PieChart.Data("club", club));

        pieChart.getData().addAll(pieChartData);


        for ( final PieChart.Data data : pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,
                    (javafx.scene.input.MouseEvent e)->{
                            pcct.setTranslateX(e.getSceneX()- pcct.getLayoutX());
                            pcct.setTranslateY(e.getSceneY()- pcct.getLayoutY());
                            pcct.setText(String.valueOf((int)data.getPieValue()));
                    }
            );
        }

        /**************************pieChart soft/hard********************************/
        statistiques.CalculerTypeCompetance();
        ObservableList<PieChart.Data> pieChartData1 =
                FXCollections.observableArrayList(
                        new PieChart.Data("Soft skills",statistiques.getNbSoftsSkills()),
                        new PieChart.Data("Hard skills", statistiques.getNbHardSkills()));
        pie2.getData().addAll(pieChartData1);
        float nbcmpt = statistiques.getNbHardSkills()+ statistiques.getNbSoftsSkills();
        float pourcentagehard = (statistiques.getNbHardSkills()/ nbcmpt )*100;
        lab2.setText( (int)pourcentagehard +"%");
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
            System.out.println("annee parcouru :"+year);
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
        barChart.getData().add(series);

        /*********************donnee personnel********************/

        Nom.setText(AccueilMediateur.utilisateur.donnes.getNom());
        Prenom.setText(AccueilMediateur.utilisateur.donnes.getPrenom());
        matricule.setText(AccueilMediateur.utilisateur.donnes.getMatricule());
        email.setText(AccueilMediateur.utilisateur.donnes.getEmail());
        niveau.setText(AccueilMediateur.utilisateur.donnes.getNiveauEtude());
        Bio.setText(AccueilMediateur.utilisateur.donnes.getBioPersonnel());
        Nbprojects.setText(AccueilMediateur.utilisateur.getListProjets().size() + "");

        /*********************Image personnel********************/
        if (AccueilMediateur.image != null) {
            image.setImage(AccueilMediateur.image);
        }
        /***************************** pagination *********************/
        logout.setOnMouseClicked(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
            Scene scene = null;
            Stage stage = null;
            try {
                scene = new Scene(loader.load(), 800, 568);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
    }


    public void PreviousPage(ActionEvent actionEvent) {

        AccueilMediateur.monPagination.setCurrentPageIndex(0);
    }
}
/*******************************************************************************/



