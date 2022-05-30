package controleurs.Projet;

import References.Competence;
import References.Competences;
import controleurs.acceuil.AccueilMediateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Project;
import models.TypeProjet;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class addCompetenceController implements Initializable {
    @FXML
    private TextField competenceSearchField;
    @FXML
    private TextField typeSearchField;
    @FXML
    private TextField matiereSearchField;
    @FXML
    private TextField objectifSearchField;

    @FXML
    private MenuButton customTypeMenu;


    @FXML
    private TextField customCompField;
    @FXML
    private Button addCustomBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private Button retourBtn;
    @FXML
    private Button validerBtn;
    @FXML
    private HBox CustomCompHbox ;
    //les competences issus de la recherche
    @FXML
    private ListView<String> availableCompetenceList;
    private ArrayList<Competence> availableCompetenceArray = new ArrayList<>();

    //les competences choisi pour le projet
    @FXML
    private ListView<String> myProjectCompetenceList;

    private ArrayList<Competence> listeCompetence =new ArrayList<>() ;
    private ArrayList<Competence> myProjectArrayList = new ArrayList<>();

    Competences competences = new Competences();
    public static Project comProject = new Project("",
            TypeProjet.CLUB,new ArrayList<Competence>(),"",new ArrayList<String>(),"");

    public addCompetenceController() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(AddProjectController.Addcustomcompetence==false){
            CustomCompHbox.setDisable(true);
        }else{
            CustomCompHbox.setDisable(false);
        }
        for(int i = 0 ; i<AddProjectController.projectComp.size() ; i++){
            myProjectCompetenceList.getItems().add(AddProjectController.projectComp.get(i).getElemdeCompetence());
            myProjectArrayList.add(AddProjectController.projectComp.get(i));
        }

        searchBtn.setOnMouseClicked(event -> {
            availableCompetenceList.getItems().clear();

            /**List with search result**/
            listeCompetence = competences.Recherche_Module_Titre_Code_Objectif(
                    matiereSearchField.getText(),competenceSearchField.getText(),
                    typeSearchField.getText(),objectifSearchField.getText()   );
            /***********************************************/
            ObservableList<String> availableCompNames = FXCollections.observableArrayList();
            for (int i = 0 ; i<listeCompetence.size() ; i++){
                availableCompNames.add(listeCompetence.get(i).getElemdeCompetence());
            }
            availableCompetenceList.getItems().addAll(availableCompNames);
           // System.out.println("the number of items : " + listeCompetence.size());

        });

        availableCompetenceList.setOnMouseClicked(event -> {
            if(availableCompetenceList.getSelectionModel().getSelectedItem() != null){
            //ObservableList<String> myCompNames = FXCollections.observableArrayList();
            Boolean existesDeja = false;
            for (int i = 0; i < myProjectCompetenceList.getItems().size(); i++) {
                if (myProjectCompetenceList.getItems().get(i).equals(availableCompetenceList.getSelectionModel().getSelectedItem())) {
                    existesDeja = true;
                }
            }
            if (!existesDeja) {
                myProjectCompetenceList.getItems().add(availableCompetenceList.getSelectionModel().getSelectedItem());
                for (int i = 0; i < listeCompetence.size(); i++) {
                    if (listeCompetence.get(i).getElemdeCompetence().equals(availableCompetenceList.getSelectionModel().getSelectedItem())) {
                        myProjectArrayList.add(listeCompetence.get(i));
                    }
                }
            }
        }
        });
        addCustomBtn.setDisable(true);

        customTypeMenu.setOnMouseClicked(event -> {
            for(int i = 0 ; i<customTypeMenu.getItems().size() ; i++){
                MenuItem item  = customTypeMenu.getItems().get(i);

                item.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        customTypeMenu.setText(item.getText());
                        addCustomBtn.setDisable(false);
                    }
                });
            }
        });

        addCustomBtn.setOnMouseClicked(event -> {
            Boolean existesDeja = false;
            for(int i = 0 ; i<myProjectCompetenceList.getItems().size() ; i++){
                if(myProjectCompetenceList.getItems().get(i).equals(customCompField.getText())){
                    existesDeja = true;
                }
            }
            if(!existesDeja){
                myProjectCompetenceList.getItems().add(customCompField.getText());
                Competence competence = new Competence("","",customCompField.getText(),customTypeMenu.getText(),"","");
                myProjectArrayList.add(competence);
            }
            customCompField.setText("");
        });


        /**Supprimer competences **/
        myProjectCompetenceList.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.BACK_SPACE){
                    String toDelete = myProjectCompetenceList.getSelectionModel().getSelectedItem();
                   // System.out.println(toDelete + " To delete ");
                    for (int i = 0 ; i<myProjectArrayList.size() ; i++){
                        if(myProjectArrayList.get(i).getElemdeCompetence().equals(toDelete)){
                            myProjectArrayList.remove(myProjectArrayList.get(i));
                            myProjectCompetenceList.getItems().remove(i);
                        }
                    }
                }
            }
        });
        /**Valider et Retour **/
        validerBtn.setOnMouseClicked(event -> {

            AddProjectController.projectComp = myProjectArrayList;
            if(myProjectArrayList.size()!=0){
                AddProjectController.comp_added = true;
            }else {
                AddProjectController.comp_added = false;
            }

            AddProjectController.stage.close();

        });
        retourBtn.setOnMouseClicked(event -> {
            AddProjectController.stage.close();
        });

        AddProjectController.projectComp = myProjectArrayList;
        if(myProjectArrayList.size()!=0){
            AddProjectController.comp_added = true;
        }else {
            AddProjectController.comp_added = false;
        }
    }
}
