package controleurs.authentification;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.Sex;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;


public class SignUpController implements Initializable {
    @FXML
    TextField monNom;
    @FXML
    TextField monPrenom;
    @FXML
    MenuButton monSexe ;
    @FXML
    DatePicker monDateNaissance;
    @FXML
    MenuButton monNiveauEtude;
    @FXML
    TextField monMatricule;
    @FXML
    ImageView myHelp ;

    /*************les lignes ******************/
    @FXML
    Line monLigneNom ;
    @FXML
    Line monLignePrenom ;
    @FXML
    Line monLigneMatricule ;

    /*****les Anchorpanes***************************/
    @FXML
    AnchorPane monAnchorpane ;
    @FXML
    AnchorPane monAnchorpane1 ;

    /*****************les erreurs*********************/
    @FXML
    Label erreurNom;
    @FXML
    Label erreurPrenom;
    @FXML
    Label erreurMatricule;
    @FXML
    Label erreurNiveauEtude ;
    @FXML
    Label erreurSexe ;
    @FXML
    Label erreurDateNaissance;
    @FXML
    TextField newNiveauEtude ;

    /**********les constants *********************/
    private Parent root;
    private Stage stage;
    private Event event ;
    private int ageMinimal=18;
    private int dureeErreur=3000;//en ms
    /****************************************************************************************/
    /********************************Logique D'affichage ************************************/
    /****************************************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**************************************/
        monDateNaissance.setTooltip(new Tooltip("Cliquez sur Ok si vous voulez modifier la date par clavier"));
        /*************************************/
        EventHandler<MouseEvent > event =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               myHelp.setOpacity(1);
            }
        };
        myHelp.setOnMouseEntered(event);
        EventHandler<MouseEvent > event1 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myHelp.setOpacity(0.5);
            }
        };
        myHelp.setOnMouseExited(event1);
        myHelp.setOnMouseClicked(event2->{
            try {
                ConnectController.commutateur.AllerAide(event2);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        /*************traitement des actions*************************/
        EventHandler<MouseEvent> event2 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(int i=0;i<3;i++)
                {
                    MenuItem item= monNiveauEtude.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                         monNiveauEtude.setText(item.getText());
                        }
                    });
                }
                Menu menu = (Menu) monNiveauEtude.getItems().get(3);
                for(int i=0;i<menu.getItems().size();i++)
                {
                   MenuItem item =menu.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                            monNiveauEtude.setText(item.getText());
                        }
                    });
                }
                Menu menu1 = (Menu) monNiveauEtude.getItems().get(4);
                for(int i=0;i<menu1.getItems().size();i++)
                {
                    MenuItem item =menu1.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                            monNiveauEtude.setText(item.getText());
                        }
                    });
                }
                MenuItem item= monNiveauEtude.getItems().get(5);
                item.setOnAction(event32 -> {
                 monNiveauEtude.setText(newNiveauEtude.getText());
                });
            }
        };
        monNiveauEtude.setOnMouseClicked(event2);
        /****************************/
        EventHandler<MouseEvent> event3 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(int i=0;i<monSexe.getItems().size();i++)
                {
                    MenuItem item= monSexe.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                            monSexe.setText(item.getText());
                        }
                    });
                }
            }
        };
        monSexe.setOnMouseClicked(event3);

        String typeB="-fx-stroke:#F1C53C ;-fx-stroke-width:3 ";
        String typeA="-fx-stroke:#b7b5b5 ;-fx-stroke-width:3 ";
        monAnchorpane.setOnMouseEntered(event4 -> {
            monNom.setOnMouseClicked(event5->{
                monLigneNom.setStyle(typeB);
                monLignePrenom.setStyle(typeA);
            });
            monPrenom.setOnMouseClicked(event6->{
                monLigneNom.setStyle(typeA);
                monLignePrenom.setStyle(typeB);
            });
        });
        monAnchorpane.setOnMouseExited(event4 -> {
            monLigneNom.setStyle(typeA);
            monLignePrenom.setStyle(typeA);
        });
        monAnchorpane1.setOnMouseEntered(event5-> monMatricule.setOnMouseClicked(event4-> monLigneMatricule.setStyle(typeB)));
        monAnchorpane1.setOnMouseExited(event4 -> monLigneMatricule.setStyle(typeA));
    }
     /***************************************************************************************/
    /*********************************Logique de fonctionnemnt*******************************/
    /****************************************************************************************/
    public int VerifierDate(){
        int result=0;
        if(monDateNaissance.getEditor().getText().length()!=0) {

            char ch='0' ;
            String Annee="";
            LocalDate date1 =monDateNaissance.getValue();
            String date =date1.toString();
           // System.out.println("année naissance est :"+Annee);
            int AnneeNaissance = date1.getYear();
            LocalDateTime now = LocalDateTime.now();

            int AnneeActuel = now.getYear();
            if ((AnneeActuel - AnneeNaissance) >= ageMinimal) {
                result = 1;
            }
        }
        else
        {
            ConnectController.commutateur.TraiterAlert(erreurDateNaissance);
        }
      return result;
    }
    /***********************/
    public int VerifierNom(){
        if(monNom.getText()=="")
        {
            ConnectController.commutateur.TraiterAlert(erreurNom);
            return 0;
        }
        else
        {
          return 1 ;
        }
    }
    public int VerifierPreNom(){
        if(monPrenom.getText()=="")
            {
                ConnectController.commutateur.TraiterAlert(erreurPrenom);
                return 0;
            }
            else
            {
                return 1 ;
        }
    }
    public int VerifierMatricule(){
        int resultat = 1;
        if(Pattern.matches("\\d{2}[/]\\d{4}",monMatricule.getText())) {
            LocalDate date =LocalDate.now();
             int AnneeActuel = date.getYear()%100;
             int AnneeMatricule = Integer.parseInt(monMatricule.getText().substring(0,2));
             System.out.println("le matricule : "+AnneeMatricule+" "+AnneeActuel);
             if(AnneeMatricule<=AnneeActuel) {
                 int i = 0;
                 int stop = 0;
                 while (i < ConnectController.listLogins.size() && stop != 1) {
                     if (ConnectController.listLogins.get(i).getMatricule().equals(monMatricule.getText())) {
                         stop = 1;
                         resultat = 0;
                         erreurMatricule.setText("Ce matricule appartient déja à un étudiant !");
                     }
                     i++;
                 }
             }else{
                 erreurMatricule.setText(" Matricule incorrect !");
                 resultat=0;
             }
        } else if(monMatricule.getText().equals("")) {
        erreurMatricule.setText("Ce champ ne doit pas étre vide !");
        resultat = 0;
        }
        else{
            erreurMatricule.setText(" Matricule incorrect !");
            resultat=0;
        }
        if(resultat==0){ConnectController.commutateur.TraiterAlert(erreurMatricule);}
        return resultat;
    }
    public int VerifierSexe(){
        if(monSexe.getText().equals("Sexe"))
        {
          ConnectController.commutateur.TraiterAlert(erreurSexe);
          return 0;
        }
        else
        {
            return 1;
        }
    }
    public int VerifierNiveauEtude(){
        if(monNiveauEtude.getText().equals("Niveau d'étude"))
        {
            ConnectController.commutateur.TraiterAlert(erreurNiveauEtude);
            return 0;
        }
        else
        {
            return 1;
        }
    }
    public void NextPage(ActionEvent event) throws IOException {
        //afficher();
        /**********************************/
        /***vérification de la validité de nom,prenom,matricule,date de naissance niveau d'étude*******/
        /*****************************/

        if(VerifierDate()+VerifierPreNom()+VerifierNom()+VerifierMatricule()+VerifierNiveauEtude()+VerifierSexe()==6)
        {
            ConnectController.user.donnes.setPrenom(monPrenom.getText());
            ConnectController.user.donnes.setNom(monNom.getText());
            ConnectController.user.donnes.setMatricule(monMatricule.getText());
            Sex sex ;
            if(monSexe.getText().equalsIgnoreCase("Male"))
            {
                sex=Sex.MALE;
            }
            else{
                sex= Sex.FEMELLE;
            }
            ConnectController.user.donnes.setSex(sex);
            ConnectController.user.donnes.setDatenaissance(monDateNaissance.getValue().toString());
            ConnectController.user.donnes.setNiveauEtude(monNiveauEtude.getText());
            ConnectController.pagination.setCurrentPageIndex(ConnectController.pagination.getCurrentPageIndex()+1);
        }
    }
    public void PreviousPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setResizable(false);
        stage.show();
       // Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex()-1);
       // System.out.println("welcome in controller 0 return");
    }
}

