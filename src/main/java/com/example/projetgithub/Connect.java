package com.example.projetgithub;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Connect implements Initializable {
    static Pagination pagination;
    static Utilisateur user ;
    private Stage stage ;
    private Scene scene;
    private ArrayList<Parent> memory;
    @FXML
    private Line monLigneEmail ;
    @FXML
    private Line monLigneMotPasse;
    @FXML
    private ImageView myHelp;
    @FXML
    private TextField monEmail ;
    @FXML
    private PasswordField monMotDePasse ;
    @FXML
    private Pane myPane ;
    @FXML
    private Label erreurEmail ;
    @FXML
    private Label erreurMotPasse ;

    /*********************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler<MouseEvent> event =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myHelp.setOpacity(1);
            }
        };
        myHelp.setOnMouseEntered(event);
        EventHandler<MouseEvent > event1 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myHelp.setOpacity(0.5);
            }
        };
        myHelp.setOnMouseExited(event1);
        /*****************traitment des actions********************/
        myHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        String typeB="-fx-stroke:#F1C53C ;-fx-stroke-width:3 ";
        String typeA="-fx-stroke:#666666 ;-fx-stroke-width:3 ";
     /*   EventHandler<MouseEvent> event3 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               monLigneEmail.setStyle(typeB);
            }
        };*/
        myPane.setOnMouseEntered(event2 -> {
                monEmail.setOnMouseClicked(event3 -> {
                    monLigneEmail.setStyle(typeB);
                    monLigneMotPasse.setStyle(typeA);
                });
                monMotDePasse.setOnMouseClicked(event3 -> {
                    monLigneEmail.setStyle(typeA);
                    monLigneMotPasse.setStyle(typeB);
                });
        });
        myPane.setOnMouseExited(event2 -> {
            monLigneEmail.setStyle(typeA);
            monLigneMotPasse.setStyle(typeA);
        });
     /*   myPane.setOnMouseEntered(event2 -> {
          for(int i=0;i<myPane.getChildren().size();i++)
        });*/
        }
    public void procedureRecupération(ActionEvent actionEvent) {
    }

    public void allerPageAcceuil(ActionEvent actionEvent) {
    }

    public void inscription(ActionEvent event) throws IOException {
        /*********Creation d'un nouveau Utilisatur****************/
        user =new Utilisateur();
        user.contacts =new Contacts();
        user.donnes =new DonnesPersonnels();
        /*************************/
        pagination= new Pagination();
        pagination.setPageCount(3);
        pagination.setCurrentPageIndex(0);
        pagination.setMaxPageIndicatorCount(1);
        memory = new ArrayList<>();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        memory.add(loader.load());
        loader = new FXMLLoader(getClass().getResource("SignUp1.fxml"));
        memory.add(loader.load());
        loader = new FXMLLoader(getClass().getResource("SignUp2.fxml"));
        memory.add(loader.load());
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                System.out.println("la page courant est :"+pagination.getCurrentPageIndex());
                return memory.get(pageIndex);
            }
        });
        AnchorPane pane = new AnchorPane(pagination);
        Scene scene = new Scene(pane);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.show();
    }

}
