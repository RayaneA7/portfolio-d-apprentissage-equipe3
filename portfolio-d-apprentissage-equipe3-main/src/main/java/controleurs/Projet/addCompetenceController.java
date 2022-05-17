package controleurs.Projet;

import References.Competence;
import References.Competences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Project;

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
    private ListView<String> availableCompetenceList;
    private ArrayList<Competence> availableCompetenceArray = new ArrayList<>();
    @FXML
    private ListView<String> myProjectCompetenceList;

    private ArrayList<Competence> listeCompetence =new ArrayList<>() ;
    private ArrayList<Competence> myProjectArrayList = new ArrayList<>();

    Competences competences = new Competences();

    public addCompetenceController() throws IOException {
    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {



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
            System.out.println("the number of items : " + listeCompetence.size());
        });

        availableCompetenceList.setOnMouseClicked(event -> {
            //ObservableList<String> myCompNames = FXCollections.observableArrayList();
            Boolean existesDeja = false;
            for(int i = 0 ; i<myProjectCompetenceList.getItems().size() ; i++){
                if(myProjectCompetenceList.getItems().get(i).equals(availableCompetenceList.getSelectionModel().getSelectedItem() )){
                    existesDeja = true;
                }
            }
            if(!existesDeja){
                myProjectCompetenceList.getItems().add(availableCompetenceList.getSelectionModel().getSelectedItem());
                for (int i = 0 ; i<listeCompetence.size();i++){
                    if (listeCompetence.get(i).getElemdeCompetence().equals(availableCompetenceList.getSelectionModel().getSelectedItem())){
                        myProjectArrayList.add(listeCompetence.get(i));
                    }
                }
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
                Competence competence = new Competence("","",customCompField.getText(),".","","");
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
                    System.out.println(toDelete + " To delete ");
                    for (int i = 0 ; i<myProjectArrayList.size() ; i++){
                        if(myProjectArrayList.get(i).getElemdeCompetence().equals(toDelete)){
                            myProjectArrayList.remove(myProjectArrayList.get(i));
                            myProjectCompetenceList.getItems().remove(i);
                        }
                    }
                }
            }
        });

        validerBtn.setOnMouseClicked(event -> {
            //if(myProjectArrayList.size()!=0) {
            System.out.println(" size myProjectArrayList : ( add competence ) " + myProjectArrayList.size());
                AddProjectController.projectComp = myProjectArrayList;
           // }
            AddProjectController.stage.close();

        });

        retourBtn.setOnMouseClicked(event -> {
            AddProjectController.stage.close();
        });
    }
}
