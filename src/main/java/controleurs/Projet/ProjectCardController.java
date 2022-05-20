package controleurs.Projet;

import controleurs.acceuil.AccueilMediateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Project;

import java.io.*;

public class ProjectCardController {

    @FXML
    private VBox myCard;

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




    public void setData(Project project) throws FileNotFoundException {

        myProjectTitle.setText(project.getTitle());
        myProjectDate.setText(project.getDate().toString());
        myProjectType.setText(project.getType().toString());
        MyProjectDesc.setText(project.getDescription());
        FileInputStream input ;
       try {
           File file = new File("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath()+".png");
           System.out.println("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/" + project.getImgPath());
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
            Label compL =new Label(project.getCompetences().get(i).getElemdeCompetence());
            compL.setFont(new Font(12));
            compL.setWrapText(true);
            System.out.println(project.getCompetences().get(i).getElemdeCompetence());
            //compL.setMaxWidth(myProjectComp.getPrefWidth());
            //compL.setPrefHeight(25);
            myProjectComp.getChildren().add(compL);

        }



    }

}
