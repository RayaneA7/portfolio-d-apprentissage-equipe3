package controleurs.Projet;

import References.Club;
import References.Clubs;
import References.Competence;
import References.Modules;
import controleurs.acceuil.AccueilMediateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editProjectController implements Initializable {

    public static boolean onEditAction;

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
    private VBox displayNoneVbox;
    @FXML
    private VBox docListVbox;
    @FXML
    private ListView<String> docsList;
    @FXML
    private HBox typeContainer;
    @FXML
    private MenuButton typeInput;
    @FXML
    private MenuItem clubItem;
    @FXML
    private MenuItem PedaItem;
    @FXML
    private MenuItem PersoItem;
    @FXML
    private Label afterChoosingTypeLabel;
    @FXML
    private ListView<String> moduleChoisiListView;
    @FXML
    private VBox SearchVBox;
    @FXML
    private TextField searchTextField;
    @FXML
    private Button searchTypeBtn;
    @FXML
    private VBox SearchResultVbox;
    @FXML
    private Label foundTypeLabel;
    @FXML
    private ListView<String> typeListView;

    /*********************************Declaration*******************************/
    public static Project project = new Project(" ", TypeProjet.CLUB,new ArrayList<Competence>()," ",new ArrayList<String>()," ") ;
    ArrayList<String> moduleChoisis = new ArrayList<>();
    ArrayList<String> projectDocs = new ArrayList<>();
    private FXMLLoader loader ;
    private File file;
    public static  Stage stage ;
    private  Boolean moduleExists ;
    public static ArrayList<Competence> projectComp = new ArrayList<>() ;
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
    /******************Initializa()***********************************/
    private String Typeprecedent =" ";
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

        /******************************************************************************/
        /****************************Initialization***********************************/
        /*****************************************************************************/
        titleInput.setText(project.getTitle());
        dateInput.getEditor().setText(project.getDate());
        descriptionInput.setText(project.getDescription());
        projectComp = project.getCompetences();
        try {
            File file =new File("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath());
             if(file!=null) {
                 InputStream input =new FileInputStream(file);
                 Image image = new Image(input);
                 myImage.setImage(image);
             }
        } catch (FileNotFoundException e) {
            System.out.println("fichier image de projet introuvable");
        }
        if(!docsList.getItems().isEmpty()) {
            docsList.getItems().clear();
        }
        for(int i = 0 ; i<project.getDocs().size() ; i++){
            docsList.getItems().add(project.getDocs().get(i));
        }
        typeInput.setText(project.getType().toString());
        SearchVBox.setVisible(false);
        afterChoosingTypeLabel.setVisible(false);
        typeInput.setDisable(true);

        if(typeInput.getText().equals("Club")){
            moduleChoisiListView.setVisible(true);
            searchTextField.setPromptText("Rechercher Club");
            SearchVBox.setVisible(true);
            afterChoosingTypeLabel.setVisible(true);
            afterChoosingTypeLabel.setText("Le Club Choisi est "+ project.getClubName());
        }else if(typeInput.getText().equals("Pédagogique")){
            SearchVBox.setVisible(true);
            searchTextField.setPromptText("Rechercher Module");
            afterChoosingTypeLabel.setVisible(true);
            afterChoosingTypeLabel.setText("Les Modules Choisis sont:");
            moduleChoisiListView.setVisible(true);
            for(int i = 0 ; i<project.getModuleArray().size() ; i++){
                moduleChoisiListView.getItems().add(project.getModuleArray().get(i));
            }
        }else if(typeInput.getText().equals("Personnel")){
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

        addDocBtn.setOnMouseClicked(event -> {
            if(!docsInput.getText().equals("")){
                docsList.getItems().add(docsInput.getText());
            }
            projectDocs.add(docsInput.getText());
            if(docsList.getItems().size() == 1 ) {
                displayNoneVbox.getChildren().add(0,docListVbox);
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

        /********************************Recherche Club/Module**********************************/

        System.out.println(project.getType().toString()+ " * ** * * * * * * * ");

        if(project.getType().toString().equals("Club")){
            searchTextField.setPromptText("Rechercher Club");
        }else if(project.getType().toString().equals("Pedagogique")){
            searchTextField.setPromptText("Rechercher Module");
        }else if(project.getType().toString().equals("Personnel")){
            System.out.println("personal ");
        }

        searchTypeBtn.setOnMouseClicked(event -> {
            ArrayList<Club> foundClub = new ArrayList<>();
            foundClub.clear();
            ArrayList<String> foundModule = new ArrayList<>();
            foundModule.clear();

            SearchVBox.getChildren().remove(SearchResultVbox);
            if(!searchTextField.getText().equals("")){
                SearchVBox.getChildren().add(1,SearchResultVbox);
            }
            if(searchTextField.getPromptText().equals("Rechercher Club")){
                Clubs  clubs = null;
                try {
                    clubs = new Clubs();
                } catch (IOException e) {
                    e.printStackTrace();
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

        moduleChoisiListView.setVisible(false);


        typeListView.setOnMouseClicked(event -> {
            if(searchTextField.getPromptText().equals("Rechercher Module")){//Cas Module
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
            }else if(searchTextField.getPromptText().equals("Rechercher Club")){//Cas d'un Club
                afterChoosingTypeLabel.setVisible(true);
                project.setClubName(typeListView.getSelectionModel().getSelectedItem());
                afterChoosingTypeLabel.setText("Le Club choisi est "+typeListView.getSelectionModel().getSelectedItem());
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
            onEditAction = true;
            loader =new FXMLLoader(getClass().getResource("/views/editCompetencesView.fxml"));
            //editCompetenceController.comProject = projectComp;
            try {
                Scene scene = new Scene(loader.load());
                stage= new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        editBtn.setOnMouseClicked(event -> {
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

                    projectDocs.clear();

                    project.setTitle(titleInput.getText());
                    project.setDescription(descriptionInput.getText());
                    project.setDate(dateInput.getEditor().getText());
                    project.setDocs(projectDocs);
                    project.setModuleArray(moduleChoisis);
                    project.setClubName(typeListView.getSelectionModel().getSelectedItem());
                    for(int i= 0 ; i<docsList.getItems().size() ; i++){
                        projectDocs.add(docsList.getItems().get(i));
                    }
                    project.setCompetences(projectComp);
                    int i= 0 ;
                    while(AccueilMediateur.utilisateur.listProjets.get(i).getId() != project.getId() ){
                        i++;
                    }
                    System.out.println("L'ordre du projet est "+i);
                    AccueilMediateur.utilisateur.listProjets.set(i,project);
                    Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);

//                    //reInitatilsation des chemps
//                    titleInput.setText("");
//                    descriptionInput.setText("");
//                    dateInput.getEditor().setText("");
//                    docsInput.setText("");
//                    if(docsList.getItems().size() == 0  && displayNoneVbox.getChildren().size()==2){
//                        displayNoneVbox.getChildren().remove(0);
//                        docListLabel.setVisible(false);
//                    }
                }else {
                    System.out.println("create projet till you enter all field required");
                }
            } finally {
//                if (allFieldNotEmpty()){
//                    SearchVBox.setVisible(false);
//                    afterChoosingTypeLabel.setVisible(false);
//                    //docsList.getItems().clear();
//                    if(displayNoneVbox.getChildren().size()==2){
//                        displayNoneVbox.getChildren().remove(0);
//                    }
//                    moduleChoisiListView.setVisible(false);
//                }
            }

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

}

