package Mainapplication;

import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Test implements Initializable {
    @FXML
    public ScrollPane myScrollPane ;
    @FXML
    public  VBox container;
    public    AnchorPane projet ;
    @FXML
    public VBox monVbox ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        container.setPrefWidth(200);
        container.setSpacing(30);
        container.setAlignment(Pos.CENTER);
        Button button;
        for (int i=0;i<10;i++)
        {
            projet = new AnchorPane();
            projet.setPrefSize(200,100);
            projet.setMinSize(200,100);
            projet.setStyle("-fx-background-color:blue");
            button =new Button("projet"+i);
            projet.getChildren().add(button);
            container.getChildren().add(projet);
        }
        myScrollPane.getContent().autosize();
        JFXPasswordField field = new JFXPasswordField();
        field.setPromptText("seaze your password");
        field.setPrefSize(50,100);
        monVbox.getChildren().add(field);
    }
}
