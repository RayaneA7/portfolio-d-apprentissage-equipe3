package controleurs.parametre;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public  class CustomDialog extends Stage {
    public Button buttonOk;
    public  Button buttonCancel;
    //  private ScaleTransition scale1 = new ScaleTransition();
    //  private ScaleTransition scale2 = new ScaleTransition();

    //  private SequentialTransition anim = new SequentialTransition(scale1, scale2);

    CustomDialog(String header, String content) {
        Pane root = new Pane();
        initStyle(StageStyle.TRANSPARENT);
        initModality(Modality.APPLICATION_MODAL);
        Image image =new Image(getClass().getResourceAsStream("/icons/Inscription/Ecareer2.png"));
        ImageView view =new ImageView(image);
        view.setFitWidth(30);
        view.setFitHeight(30);
        Label headerText = new Label(header);
        headerText.setStyle("-fx-text-fill : white ;-fx-font-size : 16;-fx-font-weight :bold ; -fx-font-family : Open Sans");
        HBox hbox =new HBox(10,view,headerText);
        hbox.setPadding(new Insets(5,5,5,5));
        hbox.setPrefWidth(378);
        hbox.setMaxWidth(378);
        hbox.setPrefHeight(30);
        hbox.setStyle("-fx-background-color :#f1c53c");
        hbox.setAlignment(Pos.CENTER_LEFT);
        /*************************************/
        Label contentText = new Label(content);
        contentText.setMaxWidth(375);
        contentText.setMaxHeight(50);
        contentText.setWrapText(true);
        contentText.setStyle("-fx-font-size : 14 ;-fx-font-family : Open sans");
        HBox box2 =new HBox(contentText);
        box2.setPadding(new Insets(5));
        /**********************************************************/
        VBox box = new VBox(10,
                hbox,
                box2
        );
        box.setPadding(new Insets(0.8));
        /************************/
        Rectangle bg = new Rectangle(380, 180, Color.WHITESMOKE);
        bg.setStroke(Color.BLACK);
       // bg.setStrokeWidth(1.5);
        /***************************les buttons******************************************/
        buttonOk = new Button("Ok");
        buttonOk.setPrefSize(80,35);
        buttonOk.setStyle("-fx-background-color: #184173; -fx-font-size: 16; -fx-text-fill:white; -fx-font-weight: bold;-fx-background-radius: 5");
        buttonCancel =new Button("Cancel");
        buttonCancel.setStyle("-fx-background-color: white; -fx-font-size: 16; -fx-text-fill: #184173; -fx-font-weight: bold;-fx-background-radius: 5");
        buttonCancel.setPrefSize(80,35);
        buttonOk.setOnAction(e -> closeDialog());
        root.getChildren().addAll(bg, box, buttonOk,buttonCancel);
        buttonOk.setLayoutX(250);
        buttonOk.setLayoutY(120);
        buttonCancel.setLayoutY(120);
        buttonCancel.setLayoutX(170);
        //   buttonOk.setLayoutX(310);
        setScene(new Scene(root, null));
    }

    public void openDialog() {
        show();

        //  anim.play();
    }

    public void closeDialog() {
        close();
        // anim.setOnFinished(e -> close());
        //anim.setAutoReverse(true);
        //anim.setCycleCount(2);
        //anim.playFrom(Duration.seconds(0.66));
    }
}
