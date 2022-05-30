package controleurs.Projet;

import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import models.Project;
import models.Utilisateur;

import java.io.*;
import java.util.UUID;

import static controleurs.Projet.ProjetController.projectToDelete;

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

    @FXML
    private ImageView verifiedImg;

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
        myProjectType.setText(project.getType().toString()+" "+ project.getClubName()+" .");
    }else if( project.getType().toString().equals("Pédagogique")) {
        String module = " ";
        for(int i = 0 ; i<project.getModuleArray().size() ; i++){
            if(i==project.getModuleArray().size()-1){
                module+= project.getModuleArray().get(i)+".";
            }else {
                module+= project.getModuleArray().get(i)+",";
            }
        }
        myProjectType.setText(project.getType().toString() + module);
        myProjectType.setTooltip(new Tooltip(project.getType().toString() + module));
    }else {
        myProjectType.setText(project.getType().toString());
    }
    MyProjectDesc.setText(project.getDescription());
    FileInputStream input ;
   try {
       System.out.println("le chemin d'image : "+AccueilMediateur.StudentDirectory+"DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath()+".png");
       File file = new File(AccueilMediateur.StudentDirectory+"DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath()+".png");
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
        compL.setTooltip(new Tooltip(compL.getText()));
        compL.setWrapText(true);
        compL.setMaxWidth(300);
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

     if(project.getDocs().size()!=0){
         verifiedImg.setVisible(true);
     }else {
         verifiedImg.setVisible(false);
     }

     Image yellowEdit = new Image("icons/Project/yellowEdit.png");
     Image blueEdit = new Image("icons/Project/blueEdit.png");
     Image blueDelete = new Image("icons/Project/yellowDelete.png");
     Image yellowDelete = new Image("icons/Project/BlueDelete.png");




     myCard.setOnMouseEntered(event -> {
         myCard.setStyle("-fx-background-image: url('icons/Project/Card2023.png');" +
                 "-fx-background-size: 100% 100%;-fx-padding:0;");
     });
     myCard.setOnMouseExited(event -> {
         myCard.setStyle("-fx-background-image: url('icons/Project/Card2022.png');" +
                 "-fx-background-size: 100% 100%;-fx-padding:0;");
     });
     myCard.setOnMouseClicked(event -> {
         editProjectController.project = this.project;
         AccueilMediateur.commutateur.AllerModificationProjet(event);
     });

     editProjectBtn.setOnMouseClicked(event -> {
         editBtnImage.setImage(yellowEdit);
        editProjectController.project = this.project;
        AccueilMediateur.commutateur.AllerModificationProjet(event);
     });

        editProjectBtn.setOnMouseEntered(event -> {
            editProjectBtn.setStyle("-fx-background-color:#F1C53C;-fx-border-radius:20;-fx-background-radius: 20;");
        });
        editProjectBtn.setOnMouseExited(event -> {
            editProjectBtn.setStyle("-fx-background-color:transparent;");
        });

        DeleteProjectBtn.setOnMouseEntered(event -> {
            DeleteProjectBtn.setStyle("-fx-background-color:#F1C53C;-fx-border-radius:20;-fx-background-radius: 20;");
        });
        DeleteProjectBtn.setOnMouseExited(event -> {
            DeleteProjectBtn.setStyle("-fx-background-color:tranparent;");
        });

     DeleteProjectBtn.setOnMouseClicked(event -> {
         //deleteBtnImg.setImage(yellowDelete);

         System.out.println("Dlete Btn clicked");
         customDialog = new CustomDialog("Confirmation ", "Clicker sur OK pour suprimer le projet ");
         customDialog.show();
         customDialog.buttonOk.setOnAction(event1 -> {
//             /************Supression d'image projtet***********/
//             File file = new File("DonnesUtilisateurs/"+AccueilMediateur.studentFolder +"/"+projectToDelete.getId()+".png") ;
//             System.out.println("DonnesUtilisateurs/"+AccueilMediateur.studentFolder +"/"+projectToDelete.getId()+".png");
//             file.delete();
//             System.out.println(file.delete()+ " resultat de suprission image . danas ProjectCardControoler");
             /**********************************************/
             for(int i= 0 ; i<AccueilMediateur.utilisateur.listProjets.size() ; i++){
                 if(AccueilMediateur.utilisateur.listProjets.get(i).getId() == this.project.getId()){
                     ProjetController.cardLayout.getChildren().remove(i);
                     AccueilMediateur.utilisateur.listProjets.remove(i);
                     projectToDelete = this.project;
                     Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);
                 }
             }
             if(AccueilMediateur.utilisateur.listProjets.size() == 0){
                 ProjetController.cardLayout.getChildren().add(ProjetController.label);
             }else {
                 System.out.println("Happy life ! ");
             }
             customDialog.closeDialog();
         });
         customDialog.buttonCancel.setOnMouseClicked(event1 -> {
             customDialog.closeDialog();
         });

     });

    }
}
