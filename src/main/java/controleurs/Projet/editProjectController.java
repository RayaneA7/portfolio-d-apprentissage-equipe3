package controleurs.Projet;

import References.Club;
import References.Clubs;
import References.Competence;
import References.Modules;
import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Project;
import models.TypeProjet;
import models.Utilisateur;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editProjectController implements Initializable {

    public static boolean onEditAction;
    public static boolean Addcustomcompetence=true ;
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
    private Button editBtn;
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


    /*********************************Declaration*******************************/
    public static Project project = new Project("", TypeProjet.PERSONEL,new ArrayList<Competence>(),"",new ArrayList<String>(),"") ;
    String new_img_path = project.getId().toString();
    ArrayList<String> moduleChoisis = new ArrayList<>();
    ArrayList<String> projectDocs = new ArrayList<>();
    private FXMLLoader loader ;
    private File file;
    private  Boolean moduleExists ;
    public static ArrayList<Competence> projectComp = new ArrayList<>() ;
    /******************Initializa()***********************************/
    private String Typeprecedent =" ";
    public static boolean comp_added;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titlewarning.setVisible(false);
        dateWarning.setVisible(false);
        compWarning.setVisible(false);
        descWarning.setVisible(false);
        typeWarning.setVisible(false);
        SearchResultVbox.setVisible(false);
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
        Tooltip tooltipProfile = new Tooltip("Profile Utilisateur");
        Tooltip tooltipLogOut = new Tooltip("Log Out de Ecareer");
        titleInput.setTooltip(tooltipTitle);
        descriptionInput.setTooltip(tooltipDescription);
        dateInput.setTooltip(tooltipDate);
        competenceInput.setTooltip(tooltipCompetence);
        docsInput.setTooltip(tooltipDocs1);
        docsList.setTooltip(tooltipDocs2);
        typeInput.setTooltip(tooltipType1);
        typeListView.setTooltip(tooltipTypeList);
        //logOut.setTooltip
        /*****************************************************/


        /*********************Image personnel********************/
        if(AccueilMediateur.image!=null) {
            imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
        }
        imagePersonnel.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerProfile(e);
        });
        logOut.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.Déconnecter(event);
        });
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
            AccueilLabel.setTextFill(Color.web("#666666"));
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
            ProjetLabel.setTextFill(Color.web("#666666"));
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
            PortfolioLabel.setTextFill(Color.web("#666666"));
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
            ParametresLabel.setTextFill(Color.web("#666666"));
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
            AideLabel.setTextFill(Color.web("#666666"));
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

        /******************************************************************************/
        /****************************Initialization***********************************/
        /*****************************************************************************/
        WelcomeLabel.setText("Modifier "+project.getTitle());
        ajouteDoneLabel.setVisible(false);
        titleInput.setText(project.getTitle());
        if(project.getDate()!="") {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(project.getDate(), formatter);
            dateInput.setValue(localDate);
        }
        descriptionInput.setText(project.getDescription());
        projectComp = project.getCompetences();
        if(projectComp.size() !=0){
            competenceImage.setImage(greenComp);
            notification.setVisible(true);
            notification.setText(projectComp.size()+"");
            System.out.println("Greeen Screen");
        }else {
            competenceImage.setImage(grayComp);
            notification.setVisible(false);
            System.out.println("Greay screeen");
        }
        //project.setClubName(editProjectController.project.getClubName());
        docListLabel.setVisible(true);
        if(project.getDocs().size()==0){
            docListLabel.setVisible(false);
        }else {
            docListLabel.setVisible(true);
        }
        /*************************************************************/
        /**********************l'ajoute de ******/
        /************************************************************/
        try {
            File file =new File(AccueilMediateur.StudentDirectory+"DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath()+".png");
            if(file!=null) {
                InputStream input =new FileInputStream(file);
                System.out.println(input + " is there ");
                Image image = new Image(input);
                myImage.setImage(image);
                System.out.println(myImage.getImage().getUrl()+ " is the url of the image we added ----->>");
            }
        } catch (FileNotFoundException e) {
            System.out.println("fichier image de projet introuvable");
        }
        if(project.getDocs().size()==0) {
            docsList.getItems().clear();
            docListLabel.setVisible(false);
        }else {
            docListLabel.setVisible(true);
        }
        for(int i = 0 ; i<project.getDocs().size() ; i++){
            docsList.getItems().add(project.getDocs().get(i));
        }
        typeInput.setText(project.getType().toString());
        searchTextField.setVisible(true);
        searchTypeBtn.setVisible(true);
        typeInput.setDisable(true);
        moduleChoisiListView.setVisible(false);
        afterChoosingTypeLabel.setVisible(false);

        if(project.getType().equals(TypeProjet.CLUB)){
            searchTextField.setPromptText("Rechercher Club");
            SearchVBox.setVisible(true);
            afterChoosingTypeLabel.setVisible(true);
            afterChoosingTypeLabel.setText("Le Club Choisi est "+ project.getClubName());
        }else if(project.getType().equals(TypeProjet.PEDAGOGIQUE)){
            SearchVBox.setVisible(true);
            searchTextField.setPromptText("Rechercher Module");
            afterChoosingTypeLabel.setVisible(true);
            afterChoosingTypeLabel.setText("Les Modules Choisis sont:");
            moduleChoisiListView.setVisible(true);
            for(int i = 0 ; i<project.getModuleArray().size() ; i++){
                moduleChoisiListView.getItems().add(project.getModuleArray().get(i));
            }
        }else if(project.getType().equals(TypeProjet.PERSONEL)){
            SearchVBox.setVisible(false);

        }

        /********************************Retour Vers Page Projet Btn****************************/

        RetourBtn.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerProjet(event);
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
                System.out.println("IOEXCeption when clicking the link maybe not corrce");
            } catch (URISyntaxException e) {
                System.out.println("URL exception");
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


        /********************************Choisir Type Projet************************************/

        typeInput.setOnMouseClicked(event -> {
            for(int i = 0 ; i<typeInput.getItems().size() ; i++){
                MenuItem item  = typeInput.getItems().get(i);

                item.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        SearchVBox.setVisible(true);
                        if(!Typeprecedent.equals(item.getText())){
                            typeInput.setText(item.getText());
                            Typeprecedent=typeInput.getText();
                            afterChoosingTypeLabel.setVisible(true);

                            if(item.getText().equals("Club")){
                                searchTextField.setVisible(true);
                                searchTextField.setPromptText("Rechercher Club");
                                searchTypeBtn.setVisible(true);
                                SearchResultVbox.setVisible(false);
                                afterChoosingTypeLabel.setVisible(false);
                                moduleChoisiListView.setVisible(false);
                            }else if(item.getText().equals("Pedagogique")){
                                searchTextField.setVisible(true);
                                searchTextField.setPromptText("Rechercher Module");
                                searchTypeBtn.setVisible(true);
                                SearchResultVbox.setVisible(false);
                                afterChoosingTypeLabel.setVisible(false);
                                moduleChoisiListView.setVisible(false);
                            }else {
                                searchTextField.setVisible(false);
                                searchTypeBtn.setVisible(false);
                                SearchResultVbox.setVisible(false);
                                afterChoosingTypeLabel.setVisible(false);
                                moduleChoisiListView.setVisible(false);
                            }
                        }
                    }
                });
            }
        });

        /***************************************************************************************/
        addImageBtn.setOnMouseClicked(event -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choisir une photo de profile");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
            file = chooser.showOpenDialog(null);
            FileInputStream input = null;
            /*******************************/
            try {
                input = new FileInputStream(file);
                Image image = new Image(input);
                myImage.setImage(image);
            } catch (NullPointerException e) {System.out.println("NullPoint Exception in addImgeBtn");}
            catch (Exception e) {System.out.println("Exception catched in addImgBtn");}
            finally {
                try {
                    input.close();
                } catch (Exception e) {System.out.println("IOException in addImgBtnFinnaly");}
            }

            /***************************************************/
            OutputStream output = null;
            try {
                output = new BufferedOutputStream(new FileOutputStream(AccueilMediateur.StudentDirectory+"DonnesUtilisateurs/"
                        +AccueilMediateur.studentFolder + "/"+project.getImgPath()+".png"));
            } catch (FileNotFoundException ex2) {
            System.out.println("FleNotFound Second Exception ");
            }
            try {
                Files.copy(Path.of(file.getPath()), output);
            } catch (Exception ex1) {
                System.out.println("Il est preferable d'ajouter une photo XD");
            }
            try {
                output.close();
            } catch (IOException ex) {
                System.out.println("FleNotFound Second Exception 2 ");
            }
            /***************************************************/

        });

        /********************************Recherche Club/Module**********************************/


        if(project.getType().equals(TypeProjet.CLUB)){
            searchTextField.setPromptText("Rechercher Club");
        }else if(project.getType().equals(TypeProjet.PEDAGOGIQUE)){
            searchTextField.setPromptText("Rechercher Module");
        }else if(project.getType().equals(TypeProjet.PERSONEL)){
            System.out.println("personal ");
        }

        searchTypeBtn.setOnMouseClicked(event -> {
            ArrayList<Club> foundClub = new ArrayList<>();
            foundClub.clear();
            ArrayList<String> foundModule = new ArrayList<>();
            foundModule.clear();
            SearchResultVbox.setVisible(true);

            SearchVBox.getChildren().remove(SearchResultVbox);
            if(!searchTextField.getText().equals("")){
                SearchVBox.getChildren().add(1,SearchResultVbox);
            }
            if(searchTextField.getPromptText().equals("Rechercher Club")){
                Clubs  clubs = null;
                try {
                    clubs = new Clubs();
                } catch (IOException e) {
                    System.out.println("list club Null");
                }
                typeListView.getItems().clear();
                foundClub = clubs.RechercheClub(searchTextField.getText());

                for (int i =0 ; i<foundClub.size() ; i++){

                    typeListView.getItems().add("{"+foundClub.get(i).getAbbreviation()+"}");

                }
                foundTypeLabel.setText("Les Clubs trouves : ");
            }
            else if (searchTextField.getPromptText().equals("Rechercher Module")){
                Modules modules  = null;
                try {
                    modules = new Modules();
                } catch (IOException e) {
                    System.out.println("List moduels vide");
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

        typeListView.setOnMouseClicked(event -> {
            if(project.getType().equals(TypeProjet.PEDAGOGIQUE)){//Cas Module
                moduleExists = false;

                for(int i = 0 ; i<moduleChoisis.size() ; i++){
                    if(moduleChoisis.get(i).equals(typeListView.getSelectionModel().getSelectedItem()))moduleExists = true;
                }


                if((typeListView.getSelectionModel().getSelectedItem() != null)&&(!moduleExists)){//Le module clicke n'est pas null
                    moduleChoisis.add(typeListView.getSelectionModel().getSelectedItem());
                    moduleChoisiListView.getItems().add(typeListView.getSelectionModel().getSelectedItem());

                    afterChoosingTypeLabel.setVisible(true);
                    afterChoosingTypeLabel.setText("Les Modules Choisis sont:");

                    moduleChoisiListView.setVisible(true);
                }
            }else if(project.getType().equals(TypeProjet.CLUB)){//Cas d'un Club
                afterChoosingTypeLabel.setVisible(true);
                if(!typeListView.getSelectionModel().getSelectedItem().equals(null)){
                    project.setClubName(typeListView.getSelectionModel().getSelectedItem());
                    afterChoosingTypeLabel.setText("Le Club choisi est "+typeListView.getSelectionModel().getSelectedItem());
                }
            }
        });
        /********************************Supprimer List Choisies*********************************/

        moduleChoisiListView.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.BACK_SPACE){
                    moduleChoisiListView.getItems().remove(moduleChoisiListView.getSelectionModel().getSelectedItem());
                    project.getModuleArray().remove(moduleChoisiListView.getSelectionModel().getSelectedItem());
                    if(moduleChoisiListView.getItems().size() == 0){
                        moduleChoisiListView.setVisible(false);
                    }else {
                        moduleChoisiListView.setVisible(true);
                    }
                }

            }
        });

        /********************************Ajouter Competence Btn*************************************/

        competenceInput.setOnMouseClicked(event1 -> {
            comp_added = false;
            loader =new FXMLLoader(getClass().getResource("/views/editCompetencesView.fxml"));
            try {
                Scene scene = new Scene(loader.load());
                stage= new Stage();
                stage.setTitle("Modifier Competences");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
            } catch (IOException e) {
                System.out.println("An error is here");
            }
            if(comp_added){
                competenceImage.setImage(greenComp);
                notification.setVisible(true);
                notification.setText(projectComp.size()+"");
                System.out.println("Greeen Screen");
            }else {
                competenceImage.setImage(grayComp);
                notification.setVisible(false);
                System.out.println("Greay screeen");
            }
        });

        editBtn.setOnAction(e -> {
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

            CustomDialog customDialog = new CustomDialog("Confirmation",
                    "Confimer les modifications sur " + titleInput.getText() + " .");
            if(allFieldNotEmpty()){
                customDialog.show();
            }
            customDialog.buttonOk.setOnAction(event -> {
                if (allFieldNotEmpty()) {
                    /*************************************************************************/
                    project.setTitle(titleInput.getText());
                    project.setDescription(descriptionInput.getText());
                    project.setDate(dateInput.getValue().toString());
                    project.setDocs(projectDocs);
                    moduleChoisis.clear();
                    for(int i = 0 ; i<moduleChoisiListView.getItems().size() ; i++){
                        moduleChoisis.add(moduleChoisiListView.getItems().get(i));
                    }
                    project.setModuleArray(moduleChoisis);
                    if(typeListView.getSelectionModel().getSelectedItem()!=null){
                        project.setClubName(typeListView.getSelectionModel().getSelectedItem());
                    }
                    projectDocs.clear();
                    for(int i= 0 ; i<docsList.getItems().size() ; i++){
                        projectDocs.add(docsList.getItems().get(i));
                    }
                    project.setCompetences(projectComp);

                    int i= 0 ;
                    try {
                        while(AccueilMediateur.utilisateur.listProjets.get(i).getId() != project.getId() ){
                            i++;
                        }
                        AccueilMediateur.utilisateur.listProjets.set(i,project);
                    }catch (IndexOutOfBoundsException indexOutOfBoundsException){
                        System.out.println("Index out of bound");
                    }

                    Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);
                    /************************************************************************/
                    customDialog.closeDialog();
                    ajouteDoneLabel.setVisible(true);

                }else {
                    System.out.println("create projet till you enter all field required");
                }

            });
            customDialog.buttonCancel.setOnAction(event -> {
                customDialog.closeDialog();
            });

        });

    }

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
    public boolean isURL(String url) throws IOException {

        (new java.net.URL(url)).openStream().close();
        return true;

    }
}

