package controleurs.profil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import models.Utilisateur;
import controleurs.acceuil.*;

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
    private Label poucentage;
   @FXML
    private Hyperlink linkdin;
    @FXML
 void openLink (ActionEvent event ) throws URISyntaxException,IOException{
        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/feed/"));
    }

    @FXML
    private Label lab2;

    Utilisateur user = new Utilisateur();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**************************pieChart********************************/
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("A", 80),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Grapes", 50));

        pieChart.getData().addAll(pieChartData);
        /**************************pieChart********************************/
        ObservableList<PieChart.Data> pieChartData1 =
                FXCollections.observableArrayList(
                        new PieChart.Data("A", 30),
                        new PieChart.Data("Grapes", 50));

        pie2.getData().addAll(pieChartData1);
        /**************************pieChart POURCENTAGE********************************
        poucentage.setTextFill(Color.BLACK);
        poucentage.setStyle("-fx-font: 15 arial;");
         for (final PieChart.Data data :pieChart.getData()){
             data.getNode().addEventHandler(MouseEv,
                     new EventHandler<Event>() {
                         @Override
                         public void handle(MouseEvent e) {
                             System.out.println("pie chart click");
                             poucentage.setTranslateX(e.getSceneX()- poucentage.getLayoutX());
                             poucentage.setTranslateX(e.getSceneY()- poucentage.getLayoutY());
                             poucentage.setText(String.valueOf((data.getPieValue())+"%");

                         }
                     });
         }
        /************************barChart********************************/
        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        series.setName("project");
        series.getData().add(new XYChart.Data<>("2018",15));
        series.getData().add(new XYChart.Data<>("2019",29));
        series.getData().add(new XYChart.Data<>("2020",17));
        series.getData().add(new XYChart.Data<>("2021",24));
        series.getData().add(new XYChart.Data<>("2022",70));

        barChart.getData().add(series);
        /*********************Image personnel********************/

        Nom.setText(AccueilMediateur.utilisateur.donnes.getNom());
        Prenom.setText(AccueilMediateur.utilisateur.donnes.getPrenom());
        matricule.setText(AccueilMediateur.utilisateur.donnes.getMatricule());
        email.setText(AccueilMediateur.utilisateur.donnes.getEmail());
        niveau.setText(AccueilMediateur.utilisateur.donnes.getNiveauEtude());
        Bio.setText(AccueilMediateur.utilisateur.donnes.getBioPersonnel());
        Nbprojects.setText("80");
        lab2.setText("40%");

        /*********************Image personnel********************/
        if (AccueilMediateur.image != null) {
            image.setImage(AccueilMediateur.image);
        }
        /**************************************************/
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



