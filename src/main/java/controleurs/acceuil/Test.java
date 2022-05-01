package controleurs.acceuil;

import controleurs.authentification.ConnectController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Test {
}
/**
package controleurs.acceuil;

        import controleurs.authentification.*;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.Pagination;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;
        import javafx.util.Callback;
        import models.Utilisateur;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.ResourceBundle;
/*****
public class AccueilMediateur implements Initializable {
    @FXML
    Pagination monPagination;
    static String studentFolder ;
    static Utilisateur utilisateur;
    static ArrayList<Parent> memory;
    private Stage stage;
    private Scene scene;
    public  AccueilMediateur(String studentFolder) throws IOException {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************************
        System.out.println("well");
        studentFolder = ConnectController.studentFolder;
        System.out.println("well1");
        /**************************************
        memory = new ArrayList<>();
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/views/AccueilView.fxml"));
        try {
            memory.add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader = new FXMLLoader(getClass().getResource("/views/Accueil_1View.fxml"));
        try {
            memory.add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        monPagination.setPageCount(2);
        monPagination.setCurrentPageIndex(0);
        monPagination.setMaxPageIndicatorCount(1);
        monPagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                System.out.println("welcome in acceuil mediateur hhhhshsh");
                return memory.get(pageIndex);
            }
        });

        try {
            utilisateur = Utilisateur.deserialization(studentFolder);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("un probleme se génere lors de la désirialisation des données de l'utilisateur");
        }
    }
}
/***************/