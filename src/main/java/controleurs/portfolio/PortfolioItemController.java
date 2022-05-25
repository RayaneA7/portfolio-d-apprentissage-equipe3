package controleurs.portfolio;

import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Ordre;
import models.Portfolio;
import models.Statistiques;

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
    private Button delete;

    @FXML
    private Button export;

    @FXML
    private Button modify;

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
    public static double monScrollXPosition ;
    CustomDialog customDialog;
    Tooltip toolTip1 = new Tooltip("Supprimer");
    Tooltip toolTip2 = new Tooltip("Exporter");
    Tooltip tooltip3 = new Tooltip("Modifier");
    /*********************************************************************/

    @FXML
    private void clickRemove(){
        System.out.println("la suppression  de portfolio");
        myPortfolio.removePortfolio(portfolio);
    }

    @FXML
    private void clickModify(){myPortfolio.modifyPortfolio(portfolio);};

    public void setData(Portfolio portfolio, MyPortfolio myPortfolio){
        this.portfolio = portfolio;
        this.myPortfolio = myPortfolio;
        /********************************/
        System.out.println("statistiques sur le projet !!!!!!!!!!!!");
        Statistiques statistiques =new Statistiques(portfolio.getListProject());
        System.out.println(statistiques.getNbProjetsPersonnels()+" "+statistiques.getNbProjetsClubs()+" "+statistiques.getNbProjetsPédagogiques());
        statistiques.CalculerNbprojetsType();
        /******************************/
        System.out.println(statistiques.getNbProjetsPersonnels()+" "+statistiques.getNbProjetsClubs()+" "+statistiques.getNbProjetsPédagogiques());
        /*****************************/
        titleLabel.setText(StringNumber(portfolio.getNum())+" portfolio");
        dateLabel.setText(portfolio.getDate());
        nbrPersoProjects.setText(statistiques.getNbProjetsPersonnels() + " personnels");
        nbrClubProjects.setText(statistiques.getNbProjetsClubs() + " Clubs");
        nbrPedaProjects.setText(statistiques.getNbProjetsPédagogiques()+ " pédagogiques");
        LabelSum.setText(portfolio.getListProject().size() + " projets");
        if(portfolio.getNum() % 2 == 0) {
            PaneColor.setStyle("-fx-background-color : #caede3; -fx-background-radius : 20px;");
        } else {
            PaneColor.setStyle("-fx-background-color : #eddeca; -fx-background-radius : 20px;");
        }
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
        else return (Integer.toString(id) + "ième");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        delete.setTooltip(toolTip1); delete.setCursor(Cursor.HAND);
        export.setTooltip(toolTip2); export.setCursor(Cursor.HAND);
        modify.setTooltip(tooltip3); modify.setCursor(Cursor.HAND);
        /******************************************************************/
        delete.setOnMouseClicked(event->{
            /*******************************/
           monScrollXPosition=PortfolioShowController.MonScrollPane.getHvalue();
           /**********************************************/
            customDialog = new CustomDialog("Confirmer la supression du portfolio","Si vous voulez vraiment supprimer le portflio, cliquez sur Ok, sinon sur Canel");
            customDialog.show();
            customDialog.buttonOk.setOnAction(e->{
                clickRemove();
                customDialog.closeDialog();
                AccueilMediateur.commutateur.AllerPortfolio();
                /**********************************
                FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/PortfolioShowPage.fxml"));
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
                PortfolioShowController.MonScrollPane.setHvalue(PortfolioItemController.monScrollXPosition);
                /*********************************/
            });

            customDialog.buttonCancel.setOnAction(e->{
                customDialog.closeDialog();
            });
        });
        /********************************************************/
        modify.setOnMouseClicked(event->{
            clickModify();
        });
    }

}
