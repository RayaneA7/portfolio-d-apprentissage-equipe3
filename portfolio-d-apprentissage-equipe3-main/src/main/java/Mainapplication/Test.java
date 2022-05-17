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
import java.util.Date;
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
/*************************************************
package models;

        import java.util.Date;

public class Project {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;
    private String type;
    private String[] competences;
    private Date date;
    private String imgpath;
    private String docs;
    private static int numPrj = 0;

    public Project() {
    }

    public Project(int id, String title, String descreption,Date date,String type) {
        this.id = id;
        this.title = title;
        this.descreption = descreption;
        this.date=date;
        this.type = type;
    }


    public Project(String title, String type, String[] competences, Date date, String imgpath, String docs, String descreption) {
        this.title = title;
        this.type = type;
        this.competences = competences;
        this.date = date;
        this.imgpath = imgpath;
        this.docs = docs;
        this.descreption = descreption;
        this.id = numPrj;
        numPrj++;
    }

    private String descreption;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getCompetences() {
        return competences;
    }

    public void setCompetences(String[] competences) {
        this.competences = competences;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

}
/*****************************************/