package controleurs.Projet;

import References.Club;
import References.Clubs;
import References.Competence;
import References.Modules;
import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Project;
import models.TypeProjet;
import models.Utilisateur;
import org.bouncycastle.crypto.io.SignerOutputStream;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddProjectController implements Initializable {

    /********************************Les Declaration Var*************************************/
    public static ArrayList<Competence> projectComp = new ArrayList<>() ;
    public static boolean comp_added = false;
    private FXMLLoader loader ;
    private File file =null;
    ArrayList<String> moduleChoisis = new ArrayList<>();
    ArrayList<String> projectDocs = new ArrayList<>();
//les FXMl
    /********************************Les Elements FXML *************************************/

    @FXML
    private Label titlewarning;

    @FXML
    private Label dateWarning;

    @FXML
    private Label descWarning;

    @FXML
    private Label docListLabel;

    @FXML
    private Label compWarning;

    @FXML
    private Label typeWarning;

    public static  Stage stage ;
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
    private Label WelcomeLabel;
    @FXML
    private Button AccueilButton;
    @FXML
    private ImageView AccueilImage;
    @FXML
    private Label AccueilLabel;
    @FXML
    private ImageView logOut;
    @FXML
    private Line line3;
    @FXML
    private Line line5;
    @FXML
    private Line line4;
    @FXML
    private Circle imagePersonnel;
    @FXML
    private Button RetourBtn;
    @FXML
    private Button AjouterBtn;
    @FXML
    private Line line2;
    @FXML
    private Line line1;
    @FXML
    private TextField titleInput;
    @FXML
    private VBox displayNoneVbox;//Pour faire Display : none ; au DocList dans docListVbox
    @FXML
    private ListView<String> moduleChoisiListView;
    @FXML
    private TextArea descriptionInput;
    @FXML
    private DatePicker dateInput;
    @FXML
    private Button addImageBtn;
    @FXML
    private ImageView myImage;
    @FXML
    private Button competenceInput;
    @FXML
    private TextField docsInput;
    @FXML
    private Button addDocBtn;
    @FXML
    private VBox docListVbox;//qui contient docList
    @FXML
    private ListView<String> docsList;
    @FXML
    private HBox typeContainer;//toute l'operation de choisir type est la
    @FXML
    private MenuButton typeInput;
    @FXML
    private VBox SearchResultVbox;
    @FXML
    private Label foundTypeLabel;
    @FXML
    private MenuItem clubItem;
    @FXML
    private MenuItem PedaItem;
    @FXML
    private MenuItem PersoItem;
    @FXML
    private Label notification;

    @FXML
    private Label afterChoosingTypeLabel;
    @FXML
    private Label ajouteDoneLabel;
    @FXML
    private HBox TypeHbox;
    @FXML
    private VBox SearchVBox;
    @FXML
    private TextField searchTextField;
    @FXML
    private Button searchTypeBtn;
    @FXML
    private ListView<String> typeListView;
    @FXML
    private ImageView competenceImage;
    /********************************Les Images*************************************/
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
    Image greenComp = new Image(getClass().getResourceAsStream("/icons/Project/VectorGreen.png"));
    Image grayComp = new Image(getClass().getResourceAsStream("/icons/Project/Vector.png"));

    /***********************************************************************************/
    public static Boolean onAddAction = false;
    private  Boolean moduleExists ;
    private String Typeprecedent =" ";
    public static boolean Addcustomcompetence =true;
    CustomDialog customDialog;
    /******************************** Initialize  *************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titlewarning.setVisible(false);
        dateWarning.setVisible(false);
        compWarning.setOpacity(0);
        descWarning.setVisible(false);
        typeWarning.setVisible(false);
        docListLabel.setVisible(false);
        ajouteDoneLabel.setVisible(false);
        notification.setVisible(false);
        /***************************tooltips****************************/
        Tooltip tooltipTitle = new Tooltip("Donner le nom du projet ");
        Tooltip tooltipDate = new Tooltip("Cliquez sur Ok si vous voulez modifier la date par clavier");
        Tooltip tooltipDescription = new Tooltip("Donner la description du projet");
        Tooltip tooltipImage = new Tooltip("Choisir une image descriptive du projet ");
        Tooltip tooltipCompetence = new Tooltip("Choisir la liste des competences du projet");
        Tooltip tooltipDocs1 = new Tooltip("Donner un lien valide ( Github / Drive / Behance )");
        Tooltip tooltipDocs2 = new Tooltip("La liste des documents attestans le projet");
        Tooltip tooltipType1 = new Tooltip("Choisir le type du projet ");
        Tooltip tooltipTypeList = new Tooltip("La liste des modules choisis");
        titleInput.setTooltip(tooltipTitle);
        descriptionInput.setTooltip(tooltipDescription);
        dateInput.setTooltip(tooltipDate);
        competenceInput.setTooltip(tooltipCompetence);
        docsInput.setTooltip(tooltipDocs1);
        docsList.setTooltip(tooltipDocs2);
        typeInput.setTooltip(tooltipType1);
        typeListView.setTooltip(tooltipTypeList);

        /*****************************************************/

        titleInput.setText("");
        descriptionInput.setText("");
        dateInput.getEditor().setText("");
        docsList.getItems().clear();
        afterChoosingTypeLabel.setVisible(false);

        /*********************Image personnel********************/
        imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));

        /***************************************************************************************/
        /********************************Les Buttons Fixes *************************************/
        /***************************************************************************************/

        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilLabel.setTextFill(Color.WHITE);
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });
        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilLabel.setTextFill(Color.BLACK);
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #b7b5b5");
        });
        AccueilButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerAcceuil(event);
        });

        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetLabel.setTextFill(Color.WHITE);
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");

        });
        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetLabel.setTextFill(Color.BLACK);
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #b7b5b5");
        });
        ProjetButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerProjet(event);
        });

        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioLabel.setTextFill(Color.WHITE);
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioLabel.setTextFill(Color.BLACK);
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #b7b5b5");
        });
        PortfolioButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerPortfolio();
        });

        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresLabel.setTextFill(Color.WHITE);
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });
        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresLabel.setTextFill(Color.BLACK);
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #b7b5b5");
        });
        ParametresButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerParametres(event);
        });


        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideLabel.setTextFill(Color.WHITE);
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });
        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideLabel.setTextFill(Color.BLACK);
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #b7b5b5");
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

        /***************************************************************************************/
        /********************************Les Btns Variables*************************************/
        /***************************************************************************************/

        /********************************Ajouter Projet BTN*************************************/


        AjouterBtn.setOnAction(e -> {
            if(titleInput.getText().equals("")){
                titlewarning.setVisible(true);
            }else titlewarning.setVisible(false);
            if(dateInput.getEditor().getText().equals("")){
                dateWarning.setVisible(true);
            }else dateWarning.setVisible(false);
            if(descriptionInput.getText().equals("")){
                descWarning.setVisible(true);
            }else descWarning.setVisible(false);
            if(typeInput.getText().equals("Type du Projet")){
                typeWarning.setVisible(true);
            }else typeWarning.setVisible(false);
            if(projectComp.size()==0){
                compWarning.setVisible(true);
            }else compWarning.setVisible(false);

            customDialog = new CustomDialog("Confirmation",
                    "Confimer d'ajouter "+ titleInput.getText()+" à la liste des projets .");
            if(allFieldNotEmpty()){
                customDialog.show();
            }
            customDialog.buttonOk.setOnAction(event -> {
                try {
                    if (allFieldNotEmpty()) {
                        CreateProjet(e);
                        customDialog.closeDialog();
                        ajouteDoneLabel.setVisible(true);
                    }else {
                        System.out.println("create projet till you enter all field required");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            });
            customDialog.buttonCancel.setOnAction(event -> {
                customDialog.closeDialog();
            });
        });

        /********************************Ajouter Image BTN *************************************/


        addImageBtn.setOnMouseClicked(event -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choisir une photo de profile");
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG Files", "*.png")
            );
            file = chooser.showOpenDialog(null);
            addImageBtn.setDisable(true);
            FileInputStream input = null;
            /*******************************/
            if(file!=null) {
                try {
                    input = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    System.out.println("Class AddProjectController");
                    System.out.println("probleme se genere lors de chargement de l'mage de projet");
                }
                Image image = new Image(input);
                myImage.setImage(image);
            }
        });

        /********************************Retour Vers Page Projet Btn****************************/

        RetourBtn.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerProjet(event);
            ajouteDoneLabel.setVisible(false);
        });

        if(docsList.getItems().size() == 0 ){
            displayNoneVbox.getChildren().remove(0);
        }

        /********************************Ajouter Docs Btn **************************************/

        docsList.setCellFactory(cell -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        try {
                            if( isURL(item)){
                                setText(item);
                                setUnderline(true);
                                setTextFill(Color.BLUE);
                            }
                        } catch (IOException e) {
                            setText(item);
                            setUnderline(true);
                            setTextFill(Color.RED);
                        }
                    }
                }
            };
        }) ;

        addDocBtn.setOnMouseClicked(event -> {
            try {
                if(!docsInput.getText().equals("") && isURL(docsInput.getText())){
                    docsList.getItems().add(docsInput.getText());
                    projectDocs.add(docsInput.getText());
                }
            } catch (IOException e) {
                docsList.getItems().add(docsInput.getText());
                projectDocs.add(docsInput.getText());
            }
            if(docsList.getItems().size() == 1  && docsInput.getText().length()!=0) {
                displayNoneVbox.getChildren().add(0,docListVbox);
                docListLabel.setVisible(true);
            }
            docsInput.setText("");
        });
        docsList.setOnMouseClicked(event -> {
            try {
                Desktop.getDesktop().browse(new URI(docsList.getSelectionModel().getSelectedItem()));
            } catch (IOException e) {
                System.out.println("class AddProjectControler");
                System.out.println("probléme de connexion se génere ");
            } catch (URISyntaxException e) {
                System.out.println("class AddProjectControler");
                System.out.println("probléme de connexion se génere ");
            }

        });

        /********************************La Liste de Docs Choisis*******************************/

        docsList.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.BACK_SPACE){
                    docsList.getItems().remove(docsList.getSelectionModel().getSelectedItem());
                    projectDocs.remove(docsList.getSelectionModel().getSelectedItem());
                    if(docsList.getItems().size() == 0){
                        displayNoneVbox.getChildren().remove(0);
                        docListLabel.setVisible(false);
                    }
                }

            }
        });


        /***************************************************************************************/

        SearchVBox.setVisible(false);


        /********************************Choisir Type Projet************************************/

        typeInput.setOnMouseClicked(event -> {
            for(int i = 0 ; i<typeInput.getItems().size() ; i++){
                MenuItem item  = typeInput.getItems().get(i);

                item.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        if(!Typeprecedent.equals(item.getText())){
                        typeInput.setText(item.getText());
                        typeWarning.setVisible(false);
                        Typeprecedent=typeInput.getText();
                       // afterChoosingTypeLabel.setVisible(true);

                        if(typeInput.getText().equals("Club")){
                            Addcustomcompetence=true;
                            SearchVBox.setVisible(true);
                            searchTextField.setVisible(true);
                             searchTextField.setPromptText("Rechercher Club");
                             searchTypeBtn.setVisible(true);
                             SearchResultVbox.setVisible(false);
                            // afterChoosingTypeLabel.setVisible(false);
                             moduleChoisiListView.setVisible(false);
                        }else if(item.getText().equals("Pedagogique")){
                            Addcustomcompetence=false;
                            SearchVBox.setVisible(true);
                            searchTextField.setVisible(true);
                            searchTextField.setPromptText("Rechercher Module");
                            searchTypeBtn.setVisible(true);
                            SearchResultVbox.setVisible(false);
                            //afterChoosingTypeLabel.setVisible(false);
                            moduleChoisiListView.setVisible(false);
                        }else {
                            Addcustomcompetence=true;
                            SearchVBox.setVisible(false);
                            searchTextField.setVisible(false);
                            searchTypeBtn.setVisible(false);
                            SearchResultVbox.setVisible(false);
                           // afterChoosingTypeLabel.setVisible(false);
                            moduleChoisiListView.setVisible(false);
                        }
                        }
                    }
                });
            }
        });


        /********************************Recherche Club/Module**********************************/

        searchTypeBtn.setOnMouseClicked(event -> {
            foundTypeLabel.setVisible(true);
            ArrayList<Club> foundClub = new ArrayList<>();
            foundClub.clear();
            ArrayList<String> foundModule = new ArrayList<>();
            foundModule.clear();


            if(!searchTextField.getText().equals("")){
                SearchResultVbox.setVisible(true);
                typeListView.setVisible(true);
            }
            if(Typeprecedent.equals("Club")){
                Clubs  clubs = null;
                try {
                    clubs = new Clubs();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                typeListView.getItems().clear();
                foundClub = clubs.RechercheClub(searchTextField.getText());
               // afterChoosingTypeLabel.setVisible(true);

                for (int i =0 ; i<foundClub.size() ; i++){
                    typeListView.getItems().add("{"+foundClub.get(i).getAbbreviation()+"}");
                }
                foundTypeLabel.setText("Les Clubs trouves : ");
            }
            else if (Typeprecedent.equals("Pedagogique")){
                if(moduleChoisiListView.getItems().size() == 0 ){
                    moduleChoisiListView.setVisible(false);
                    afterChoosingTypeLabel.setVisible(false);
                }else {
                    moduleChoisiListView.setVisible(true);
                    afterChoosingTypeLabel.setVisible(true);
                }
                Modules modules  = null;
                try {
                    modules = new Modules();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                typeListView.getItems().clear();
                foundModule = modules.RecherchModules(searchTextField.getText());
                for (int i =0 ; i<foundModule.size() ; i++){
                    typeListView.getItems().add("{"+foundModule.get(i)+"}");
                }
                foundTypeLabel.setText("Les Modules trouves : ");
            }
        });

        /********************************Resultat Recherche*************************************/
        //first the list of module is hidden until you choose un module
        moduleChoisiListView.setVisible(false);
        moduleChoisiListView.getItems().clear();

        typeListView.setOnMouseClicked(event -> {
            if(searchTextField.getPromptText().equals("Rechercher Module")){//Cas Module
                moduleExists = false;

                typeListView.setVisible(true);
                for(int i = 0 ; i<moduleChoisis.size() ; i++){
                    if(moduleChoisis.get(i).equals(typeListView.getSelectionModel().getSelectedItem()))moduleExists = true;
                }


                if((typeListView.getSelectionModel().getSelectedItem() != null)&&(!moduleExists)){//Le module clicke n'est pas null
                    moduleChoisis.add("{"+typeListView.getSelectionModel().getSelectedItem()+"}");
                    moduleChoisiListView.getItems().add(typeListView.getSelectionModel().getSelectedItem());

                    afterChoosingTypeLabel.setVisible(true);
                    afterChoosingTypeLabel.setText("Les Modules Choisis sont:");

                    moduleChoisiListView.setVisible(true);
                }
            }else if(searchTextField.getPromptText().equals("Rechercher Club")){//Cas d'un Club
                typeListView.setVisible(true);
                afterChoosingTypeLabel.setVisible(true);
                afterChoosingTypeLabel.setText("Le Club choisi est "+typeListView.getSelectionModel().getSelectedItem());

            }
            searchTextField.setText("");
        });


        //Real Time warning System for obligatory fields
        titleInput.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(titleInput.getText().length() == 0){
                    titlewarning.setVisible(true);
                }else {
                    titlewarning.setVisible(false);
                }
            }
        });
        dateInput.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent>() {
            @Override
            public void handle(InputMethodEvent event) {
                if(dateInput.getEditor().getText().length() == 0){
                    dateWarning.setVisible(true);
                }else {
                    dateWarning.setVisible(false);
                }
            }
        });
        descriptionInput.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(descriptionInput.getText().length() == 0){
                    descWarning.setVisible(true);
                }else {
                    descWarning.setVisible(false);
                }
            }
        });
        typeInput.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                if(typeInput.getText().equals("Type du Projet")){
                    typeWarning.setVisible(true);
                }
                else {
                    typeWarning.setVisible(false);
                }
            }
        });


        /********************************Supprimer List Choisies*********************************/

        moduleChoisiListView.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.BACK_SPACE){
                    moduleChoisiListView.getItems().remove(moduleChoisiListView.getSelectionModel().getSelectedItem());
                    moduleChoisis.remove(moduleChoisiListView.getSelectionModel().getSelectedItem());

                    if(moduleChoisiListView.getItems().size() == 0){
                       moduleChoisiListView.setVisible(false);
                    }else moduleChoisiListView.setVisible(true);
                }

            }
        });

        /********************************Ajouter Competence Btn*************************************/

        competenceInput.setOnMouseClicked(event1 -> {
            comp_added = false;
            onAddAction = true;
            if(!typeInput.getText().equals("Type du Projet")) {
                loader = new FXMLLoader(getClass().getResource("/views/addCompetencesView.fxml"));
                try {
                    Scene scene = new Scene(loader.load());
                    stage = new Stage();
                    stage.setTitle("Ajouter des competences");
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    Image icon = new Image((getClass().getResourceAsStream("/icons/Inscription/Ecareer2.png")));
                    if (icon != null) {
                        System.out.printf("icon is not  null");
                        stage.getIcons().add(icon);
                    }
                    stage.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (comp_added) {
                    competenceImage.setImage(greenComp);
                    notification.setVisible(true);
                    notification.setText(projectComp.size() + "");
                    System.out.println("Greeen Screen");
                } else {
                    competenceImage.setImage(grayComp);
                    notification.setVisible(false);
                    System.out.println("Greay screeen");
                }
            }
            else{
                System.out.println("type projet non choisi !");
                compWarning.setText("Choisir le type Du projet D'abord");
                AccueilMediateur.commutateur.TraiterAlert(compWarning);
            }
        });

    }




    public boolean isURL(String url) throws IOException {

            (new java.net.URL(url)).openStream().close();
            return true;

    }
    /********************************Les Chemps Obligatoire*************************************/

    private boolean allFieldNotEmpty() {
        if(titleInput.getText().equals("")
                || descriptionInput.getText().equals("")
                || dateInput.getEditor().getText().equals("")
                || typeInput.getText().equals("Type du Projet")
                || projectComp.size() == 0 ){
            return false;
        }else {
            return true;
        }
    }

    /****************************************************************************/
    public void CreateProjet(ActionEvent event) throws IOException {

        int num=AccueilMediateur.utilisateur.listProjets.size();
        String tempType =typeInput.getText();
       // System.out.println(typeInput.getText() +  " *************************** ");
        TypeProjet typeProjet = TypeProjet.PEDAGOGIQUE ;
        switch(tempType){
            case "Pedagogique" :  typeProjet = TypeProjet.PEDAGOGIQUE;
            break;
            case "Club" : typeProjet =TypeProjet.CLUB;
            break;
            case "Personnel" : typeProjet =TypeProjet.PERSONEL;
        }


        Project projet = new Project(titleInput.getText(),typeProjet,projectComp,
                dateInput.getValue().toString(),projectDocs,descriptionInput.getText());
        afterChoosingTypeLabel.setVisible(true);
        if(!typeProjet.equals(TypeProjet.PERSONEL)){
            if(!typeListView.getSelectionModel().getSelectedItem().equals(null)){
                projet.setClubName(typeListView.getSelectionModel().getSelectedItem());
            }
        }

        ArrayList<String> modules = new ArrayList<>();
        for(int i = 0 ; i <moduleChoisiListView.getItems().size() ; i++){
            modules.add(moduleChoisiListView.getItems().get(i));
        }
        projet.setModuleArray(modules);
        AccueilMediateur.utilisateur.listProjets.add(projet);
        Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);
        /***************************************************/
        OutputStream output = null;
        if(file!=null) {
            try {
                output = new BufferedOutputStream(new FileOutputStream(AccueilMediateur.StudentDirectory + "DonnesUtilisateurs/"
                        + AccueilMediateur.studentFolder + "/" + projet.getImgPath() + ".png"));
                try {
                    Files.copy(Path.of(file.getPath()), output);
                } catch (IOException ex1) {
                    System.out.println("Il est preferable d'ajouter une photo XD");
                }
            } catch (FileNotFoundException ex2) {
                System.out.println("une probléme concrene le chmin d'image de projet ou elle sera copié ");
            }
            try {
                output.close();
            } catch (IOException ex) {
                // ex.printStackTrace();
            }
        }else {
            myImage.setImage(new Image("/icons/Inscription/ImagePersonnel.png"));
        }
        /***************************************************/

        competenceImage.setImage(grayComp);
        notification.setVisible(false);
        projectComp.clear();
        projectDocs.clear();
        SearchVBox.setVisible(false);
        typeInput.setText("Type du Projet");

        //reInitatilsation des chemps
        titleInput.setText("");
        descriptionInput.setText("");
        dateInput.getEditor().setText("");
        docsList.getItems().clear();
        docsInput.setText("");
        if(displayNoneVbox.getChildren().size()==2){
            displayNoneVbox.getChildren().remove(0);
            docListLabel.setVisible(false);
        }
        docsList.getItems().clear();
        afterChoosingTypeLabel.setVisible(false);
        typeListView.setVisible(false);
        searchTextField.setVisible(false);
        searchTypeBtn.setVisible(false);
        foundTypeLabel.setVisible(false);
        moduleChoisiListView.setVisible(false);
    }
}
