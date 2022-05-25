package controleurs.Projet;

import References.Club;
import References.Clubs;
import References.Competence;
import References.Modules;
import controleurs.acceuil.AccueilMediateur;
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
import javafx.stage.Stage;
import models.Project;
import models.TypeProjet;
import models.Utilisateur;
import org.bouncycastle.crypto.io.SignerOutputStream;

import java.io.*;
import java.net.MalformedURLException;
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
    private FXMLLoader loader ;
    private File file;
    ArrayList<String> moduleChoisis = new ArrayList<>();
    ArrayList<String> projectDocs = new ArrayList<>();

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
    private Label afterChoosingTypeLabel;
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

    /***********************************************************************************/
    public static Boolean onAddAction = false;
    private  Boolean moduleExists ;
    private String Typeprecedent =" ";
    /******************************** Initialize  *************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titlewarning.setVisible(false);
        dateWarning.setVisible(false);
        compWarning.setVisible(false);
        descWarning.setVisible(false);
        typeWarning.setVisible(false);
        docListLabel.setVisible(false);
        /***************************tooltips****************************/
        Tooltip tooltipTitle = new Tooltip("Donner le nom du projet ");
        Tooltip tooltipDate = new Tooltip("Donner la date du creation du projet ");
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

            try {
                if (allFieldNotEmpty()) {
                    System.out.println("the boolean value is "+ allFieldNotEmpty());
                    CreateProjet(e);
                    //reInitatilsation des chemps
                    titleInput.setText("");
                    descriptionInput.setText("");
                    dateInput.getEditor().setText("");
                    docsInput.setText("");
                    if(docsList.getItems().size() == 0  && displayNoneVbox.getChildren().size()==2){
                        displayNoneVbox.getChildren().remove(0);
                        docListLabel.setVisible(false);
                    }
                }else {
                    System.out.println("create projet till you enter all field required");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (allFieldNotEmpty()){
                    SearchVBox.setVisible(false);
                    afterChoosingTypeLabel.setVisible(false);
                    docsList.getItems().clear();
                    if(displayNoneVbox.getChildren().size()==2){
                        displayNoneVbox.getChildren().remove(0);
                    }
                    moduleChoisiListView.setVisible(false);
                }
            }
        });

        /********************************Ajouter Image BTN *************************************/


        addImageBtn.setOnMouseClicked(event -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choisir une photo de profile");
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG Files", "*.png")
                   // , new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg")
                   // , new FileChooser.ExtensionFilter("GIF Files", "*.gif")
                   // , new FileChooser.ExtensionFilter("BMP Files", "*.bmp")
                   // ,new FileChooser.ExtensionFilter("JPG Files","*.jpg")
            );
            file = chooser.showOpenDialog(null);
           // System.out.println(getClass());
            FileInputStream input = null;
            /*******************************/
            try {
                input = new FileInputStream(file);
                Image image = new Image(input);
                myImage.setImage(image);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        /********************************Retour Vers Page Projet Btn****************************/

        RetourBtn.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerProjet(event);
        });

        if(docsList.getItems().size() == 0 ){
            displayNoneVbox.getChildren().remove(0);
        }

        /********************************Ajouter Docs Btn **************************************/

        addDocBtn.setOnMouseClicked(event -> {
            if(!docsInput.getText().equals("")){
                docsList.getItems().add(docsInput.getText());
            }
            projectDocs.add(docsInput.getText());
            if(docsList.getItems().size() == 1 ) {
                displayNoneVbox.getChildren().add(0,docListVbox);
                docListLabel.setVisible(true);
            }
            docsInput.setText("");
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
                        SearchVBox.setVisible(true);
                        if(!Typeprecedent.equals(item.getText())){
                        typeInput.setText(item.getText());
                        typeWarning.setVisible(false);
                        Typeprecedent=typeInput.getText();
                       // afterChoosingTypeLabel.setVisible(true);

                        if(typeInput.getText().equals("Club")){
                            searchTextField.setVisible(true);
                             searchTextField.setPromptText("Rechercher Club");
                             searchTypeBtn.setVisible(true);
                             SearchResultVbox.setVisible(false);
                            // afterChoosingTypeLabel.setVisible(false);
                             moduleChoisiListView.setVisible(false);
                        }else if(item.getText().equals("Pedagogique")){
                            searchTextField.setVisible(true);
                            searchTextField.setPromptText("Rechercher Module");
                            searchTypeBtn.setVisible(true);
                            SearchResultVbox.setVisible(false);
                            //afterChoosingTypeLabel.setVisible(false);
                            moduleChoisiListView.setVisible(false);
                        }else {
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
            ArrayList<Club> foundClub = new ArrayList<>();
            foundClub.clear();
            ArrayList<String> foundModule = new ArrayList<>();
            foundModule.clear();


            if(!searchTextField.getText().equals("")){
                SearchResultVbox.setVisible(true);
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
                afterChoosingTypeLabel.setVisible(true);
                afterChoosingTypeLabel.setText("Le Club choisi est "+typeListView.getSelectionModel().getSelectedItem());
            }
            searchTextField.setText("");
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
            onAddAction = true;
            loader =new FXMLLoader(getClass().getResource("/views/addCompetencesView.fxml"));
            try {
                Scene scene = new Scene(loader.load());
                stage= new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
                dateInput.getEditor().getText(),projectDocs,descriptionInput.getText());
        projet.setClubName(typeListView.getSelectionModel().getSelectedItem());
        ArrayList<String> modules = new ArrayList<>();
        for(int i = 0 ; i <moduleChoisiListView.getItems().size() ; i++){
            modules.add(moduleChoisiListView.getItems().get(i));
        }
        projet.setModuleArray(modules);
        AccueilMediateur.utilisateur.listProjets.add(projet);
        Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);
        /***************************************************/
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(new FileOutputStream("DonnesUtilisateurs/"
                    +AccueilMediateur.studentFolder + "/"+projet.getImgPath()+".png"));
        } catch (FileNotFoundException ex2) {
            ex2.printStackTrace();
        }
        try {
            Files.copy(Path.of(file.getPath()), output);
        } catch (IOException ex1) {
            System.out.println("Il est preferable d'ajouter une photo XD");
        }
        try {
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /***************************************************/

        myImage.setImage(new Image("/icons/Inscription/ImagePersonnel.png"));
        projectComp.clear();
        projectDocs.clear();
    }
}
