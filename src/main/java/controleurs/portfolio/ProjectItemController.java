package controleurs.portfolio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modele.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectItemController implements Initializable {
    @FXML
    private AnchorPane PaneProject;

    @FXML
    private ImageView TypeImage;

    @FXML
    private Label TitleLabel;

    @FXML
    private Label DateLabel;

    @FXML
    public CheckBox checkButton;

    @FXML
    private void click(ActionEvent event) {
        if(checkButton.isSelected()){
            myProject.mySelectedProject(project);
        } else{
            myProject.notSelectedProject(project);
        }
    }

    private Project project;
    private MyProject myProject;
    private Image PedImage = new Image("/icons/Portfolio/Pédagogique.png");
    private Image ClubImage = new Image("/icons/Portfolio/Club.png");
    private Image PersoImage = new Image("/icons/Portfolio/Personnel.png");

    public void setData(Project project, MyProject myProject) {
        this.project = project;
        this.myProject = myProject;
        TitleLabel.setText(project.getTitle());
        DateLabel.setText(project.getDate().toString());
        if(project.getType().equals("pédagogique")){
            TypeImage.setImage(PedImage);
        }
        if(project.getType().equals("Club")){
            TypeImage.setImage(ClubImage);
        }
        if(project.getType().equals("Personnel")){
            TypeImage.setImage(PersoImage);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkButton.setOnAction(e->{
            if(checkButton.isSelected()) {
                PaneProject.setStyle("-fx-background-color : #f1c53c;");
                click(e);
                System.out.println(project.getId());
            } else{
                PaneProject.setStyle("-fx-background-color : #ffffff;");
                click(e);
                System.out.println(project.getId());
            }
        });
    }
}