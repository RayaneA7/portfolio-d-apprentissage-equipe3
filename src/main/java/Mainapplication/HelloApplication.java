package Mainapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/SignUp2V.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 568);
        stage.setScene(scene);
        Image icon = new Image((getClass().getResourceAsStream("/icons/Inscription/ProjectName.png")));
        if(icon!=null)
        {
            System.out.printf("icon is not  null");
            stage.getIcons().add(icon);
        }
        stage.setResizable(false);
        stage.show();
    }
}
