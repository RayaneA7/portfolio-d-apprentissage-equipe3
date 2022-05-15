package controleurs.portfolio;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Ordre;
import models.Portfolio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PortfolioItemController implements Initializable {
    @FXML
    private ImageView color;

    @FXML
    private ImageView portfimg;

    @FXML
    private Label titleLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private ImageView star;

    @FXML
    private ImageView delete;

    @FXML
    private ImageView export;

    @FXML
    private ImageView modify;

    @FXML
    private Label nbrPersoProjects;

    @FXML
    private Label nbrClubProjects;

    @FXML
    private Label nbrPedaProjects;

    @FXML
    private Label LabelSum;

    @FXML
    private AnchorPane PaneColor;

    private Portfolio portfolio;
    private MyPortfolio myPortfolio;
    private double monScrollXPosition ;
    /*********************************************************************/

    @FXML
    private void click(MouseEvent e){
        myPortfolio.removePortfolio(portfolio);
    }

    public void setData(Portfolio portfolio, MyPortfolio myPortfolio){
        this.portfolio = portfolio;
        this.myPortfolio = myPortfolio;
        titleLabel.setText(StringNumber(portfolio.getId())+" portfolio");
        //dateLabel.setText();
        nbrPersoProjects.setText(portfolio.nbrPersoProjects() + " personnels");
        nbrClubProjects.setText(portfolio.nbrClubProjects() + " Clubs");
        nbrPedaProjects.setText(portfolio.nbrPedagProjects() + " pédagogiques");
        if(portfolio.getId() % 2 == 0) {
            PaneColor.setStyle("-fx-background-color : #caede3; -fx-background-radius : 20px;");
        } else {
            PaneColor.setStyle("-fx-background-color : #eddeca; -fx-background-radius : 20px;");
        }
        LabelSum.setText(portfolio.nbrPedagProjects() + portfolio.nbrClubProjects() + portfolio.nbrPedagProjects() + " projets");
    }

    private String StringNumber(int id) {
        if(id == 1) return Ordre.Premier.toString();
        if (id == 2) return Ordre.Deuxième.toString();
        if(id == 3) return  Ordre.Troisième.toString();
        if(id == 4) return Ordre.Quatrième.toString();
        if(id == 5) return Ordre.Cinquième.toString();
        if(id == 6) return Ordre.Sixième.toString();
        if(id == 7) return Ordre.Septième.toString();
        if(id == 8) return Ordre.Huitième.toString();
        if(id == 9) return Ordre.Neuvième.toString();
        if(id == 10) return Ordre.Dixième.toString();
        else return Integer.toString(id);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        delete.setOnMouseClicked(event->{
            /*******************************/
           monScrollXPosition=PortfolioShowController.MonScrollPane.getHvalue();
                   /**********************************************/
            click(event);
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/PortfolioShowPage.fxml"));
            System.out.println("une suppresio*n se passe");
            Scene scene = null;
            try {
                scene = new Scene(loader.load(),850,600);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            PortfolioShowController.MonScrollPane.setHvalue(monScrollXPosition);
        });

    }
}
