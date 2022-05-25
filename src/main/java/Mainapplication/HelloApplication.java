package Mainapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        /**/
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 568);
        stage.setScene(scene);
        Image icon = new Image((getClass().getResourceAsStream("/icons/Inscription/Ecareer2.png")));
        if(icon!=null)
        {
            System.out.printf("icon is not  null");
            stage.getIcons().add(icon);
        }
        stage.setResizable(false);
        stage.show();
         /*******************
        VBox box =new VBox();
      //  JFXDatePicker picker =new JFXDatePicker();
       // picker.setDefaultColor(Paint.valueOf("#19C62A"));
       // picker.setPrefSize(150,30);
        TextField pass ;
        pass =new JFXPasswordField();
        pass.setPrefSize(200,30);
        pass.setPrefSize(300,300);
      //  JFXAlert akert =new JFXAlert();
      /*  JFXCheckBox checkbox =new JFXCheckBox();
        checkbox.setCheckedColor(Paint.valueOf("red"));
        checkbox.setUnCheckedColor(Paint.valueOf("blue"));
        checkbox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(checkbox.isSelected()){
                   // akert.hideWithAnimation();
                   // akert.setSize(300,300);
                   // akert.show();

                }
            }
        });
        box.setPrefSize(400,600);
        box.setSpacing(30);
        box.getChildren().addAll(pass);
        Scene scene =new Scene(box);
        stage.setScene(scene);
        stage.show();
         /*****************************/
    }
}
