package controleurs.Projet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modele.Project;

public class ProjectCardController {

    @FXML
    private VBox myCard;

    @FXML
    private ImageView myCardImg;

    @FXML
    private Label myProjectTitle;

    @FXML
    private Label myProjectDate;

    @FXML
    private Label MyProjectDesc;

    @FXML
    private Label myProjectType;

    private String[] colors = {"B9E5FF","A23311","776622"};


    public void setData(Project project){
       // Image image = new Image(getClass().getResourceAsStream(project.getImgpath()));
        //myCardImg.setImage(image);

        myProjectTitle.setText(project.getTitle());

        myProjectDate.setText(project.getDate());

        myProjectType.setText(project.getType());

        MyProjectDesc.setText(project.getDescreption());



    }

}
