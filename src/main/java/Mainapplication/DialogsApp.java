package Mainapplication;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.collections.SetChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

import java.util.function.UnaryOperator;


public class DialogsApp extends Application {

    private static final Interpolator EXP_IN = new Interpolator() {
        @Override
        protected double curve(double t) {
            return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t);
        }
    };

    private static final Interpolator EXP_OUT = new Interpolator() {
        @Override
        protected double curve(double t) {
            return (t == 0.0) ? 0.0 : Math.pow(2.0, 10 * (t - 1));
        }
    };

    private Parent createContent() {
        VBox box = new VBox();
        box.setPrefSize(800, 600);
        Button btn1 = new Button("Open JavaFX dialog");
        btn1.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Header");
            alert.setContentText("Content");
            alert.show();
        });

        Button btn2 = new Button("Open Custom dialog");
        btn2.setOnAction(e -> {
            CustomDialog dialog = new CustomDialog("Confiramtion et autres choses", "cliquez sur ok pour confirmer votre inscription qcscqfx gqsctqdt hqsgcgcsc jqbsvqvs hqvsctstdzdst ");
            dialog.openDialog();
        });

        box.getChildren().addAll(btn1, btn2);

        return box;
    }

    public static class CustomDialog extends Stage {
          public  Button buttonOk;
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
            hbox.setMaxWidth(378);
            hbox.setPrefHeight(30);
            hbox.setStyle("-fx-background-color :#f1c53c");
            hbox.setAlignment(Pos.CENTER_LEFT);
            Label contentText = new Label(content);
            contentText.setMaxWidth(375);
            contentText.setMaxHeight(50);
            contentText.setWrapText(true);
            contentText.setStyle("-fx-font-size : 14 ;-fx-font-family : Open sans");
            HBox box2 =new HBox(contentText);
            box2.setPadding(new Insets(5));
            VBox box = new VBox(10,
                    hbox,
                    box2
            );
            box.setPadding(new Insets(0.8));
            /************************/
            Rectangle bg = new Rectangle(380, 180, Color.WHITESMOKE);
            bg.setStroke(Color.BLACK);
            bg.setStrokeWidth(1.5);
            /***************************les buttons******************************************/
            buttonOk = new Button("Ok");
            buttonOk.setPrefSize(90,35);
            buttonOk.setStyle("-fx-background-color: #184173; -fx-font-size: 16; -fx-text-fill:white; -fx-font-weight: bold;-fx-background-radius: 5");
            buttonCancel =new Button("Cancel");
            buttonCancel.setStyle("-fx-background-color: white; -fx-font-size: 16; -fx-text-fill: #184173; -fx-font-weight: bold;-fx-background-radius: 5");
            buttonCancel.setPrefSize(90,35);
            buttonOk.setOnAction(e -> closeDialog());
            root.getChildren().addAll(bg, box, buttonOk,buttonCancel);
            buttonOk.setLayoutX(270);
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
           // anim.setOnFinished(e -> c3=se());
            //anim.setAutoReverse(true);
            //anim.setCycleCount(2);
            //anim.playFrom(Duration.seconds(0.66));
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box =new VBox();
        TextField text =new TextField();
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String input = change.getText();
            if (input.matches("[0-9]*")){
                return change;
            }
            return null;
        };
        text.setTextFormatter(new TextFormatter<String>(integerFilter));
        /******************************************************************************/
        UnaryOperator<TextFormatter.Change> integerFilter1 = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };
       text.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
        box.getChildren().add(text);
        stage.setScene(new Scene(box));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
