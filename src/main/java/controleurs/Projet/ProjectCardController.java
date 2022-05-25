package controleurs.Projet;

import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import models.Project;
import models.Utilisateur;

import java.io.*;
import java.util.UUID;

public class ProjectCardController {

    @FXML
    private ImageView editBtnImage;


    @FXML
    private ImageView deleteBtnImg;



    @FXML
    private AnchorPane myCard;

    @FXML
    private ImageView myCardImg;

    @FXML
    private Label myProjectTitle;

    @FXML
    private Label myProjectType;

    @FXML
    private Label myProjectDate;

    @FXML
    private VBox myProjectComp;

    @FXML
    private Label MyProjectDesc;

    @FXML
    private Button editProjectBtn;

    @FXML
    private Button DeleteProjectBtn;

    CustomDialog customDialog ;

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    /***********************************************/
    private Project project;


    public void setData(Project project) throws FileNotFoundException {
    myProjectTitle.setText(project.getTitle());
    myProjectDate.setText("["+project.getDate()+"]");
    if(project.getType().toString().equals("Club")){
        myProjectType.setText(project.getType().toString()+" "+ project.getClubName());
    }else if( project.getType().toString().equals("Pédagogique")) {
        String module = " ";
        for(int i = 0 ; i<project.getModuleArray().size() ; i++){
            module+= project.getModuleArray().get(i)+",";
        }
        myProjectType.setText(project.getType().toString() + module);
    }else {
        myProjectType.setText(project.getType().toString());
    }
    MyProjectDesc.setText(project.getDescription());
    FileInputStream input ;
   try {
       File file = new File("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath()+".png");
      // System.out.println("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath());
       if (file != null) {
           input = new FileInputStream(file);
           Image image = new Image(input);
           myCardImg.setImage(image);
       }
   }catch(IOException e){
       System.out.println("image de projet introuvable ");
   }
    /****************************************************/
     for(int i = 0 ; i<project.getCompetences().size() ; i++){
        Label compL =new Label("-" + project.getCompetences().get(i).getElemdeCompetence());
        compL.setWrapText(true);
        compL.setPrefHeight(Region.USE_COMPUTED_SIZE);
        compL.setTextFill(Color.BLACK);
        compL.setFont(new Font(12));
       // System.out.println(project.getCompetences().get(i).getElemdeCompetence());
        myProjectComp.getChildren().add(compL);
    }

     myProjectTitle.setTextFill(Color.BLACK);
     myProjectDate.setTextFill(Color.BLACK);
     myProjectType.setTextFill(Color.BLACK);
     MyProjectDesc.setTextFill(Color.WHITE);


//     editProjectBtn.setOpacity(1);
//     DeleteProjectBtn.setOpacity(1);

     Image yellowEdit = new Image("icons/Project/yellowEdit.png");
     Image blueEdit = new Image("icons/Project/blueEdit.png");
     Image blueDelete = new Image("icons/Project/yellowDelete.png");
     Image yellowDelete = new Image("icons/Project/BlueDelete.png");


//    editProjectBtn.setOnMouseEntered(event -> {
//        editBtnImage.setImage(yellowEdit);
//        editProjectBtn.setCursor(Cursor.OPEN_HAND);
//    });
//
//    editProjectBtn.setOnMouseExited(event -> {
//        editBtnImage.setImage(blueEdit);
//    });
//
//
//    DeleteProjectBtn.setOnMouseEntered(event -> {
//        deleteBtnImg.setImage(yellowDelete);
//        DeleteProjectBtn.setCursor(Cursor.OPEN_HAND);
//    });
//
//    DeleteProjectBtn.setOnMouseExited(event ->{
//        deleteBtnImg.setImage(blueDelete);
//    } );



     editProjectBtn.setOnMouseClicked(event -> {
         editBtnImage.setImage(yellowEdit);
        editProjectController.project = this.project;
        AccueilMediateur.commutateur.AllerModificationProjet(event);
     });

     DeleteProjectBtn.setOnMouseClicked(event -> {
         deleteBtnImg.setImage(yellowDelete);

         System.out.println("Dlete Btn clicked");
         customDialog = new CustomDialog("Confirmation ", "Clicker sur OK pour suprimer le projet ");
         customDialog.show();
         customDialog.buttonOk.setOnAction(event1 -> {
             for(int i= 0 ; i<AccueilMediateur.utilisateur.listProjets.size() ; i++){
                 if(AccueilMediateur.utilisateur.listProjets.get(i).getId() == this.project.getId()){
                     ProjetController.cardLayout.getChildren().remove(i);
                     AccueilMediateur.utilisateur.listProjets.remove(i);
                     ProjetController.projectToDelete = this.project;

                     Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);
                 }
             }
             customDialog.closeDialog();
         });
         customDialog.buttonCancel.setOnMouseClicked(event1 -> {
             customDialog.closeDialog();
         });

     });

    }
}
