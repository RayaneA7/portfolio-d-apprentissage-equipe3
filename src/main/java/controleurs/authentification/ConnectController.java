package controleurs.authentification;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controleurs.passage.Commutateur;
import controleurs.passage.RealiserAlert;
import hashage.GenererHashage;
import hashage.ZipUnZip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Callback;
//import modele.Contacts;
//import modele.DonnesPersonnels;
//import modele.Utilisateur;
import models.*;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ConnectController implements Initializable {
    static Pagination pagination;
    public static Utilisateur user ;
    static ArrayList<LoginUser> listLogins ;
    static Stage stage ;
    static Scene scene;
    static Commutateur commutateur;
    private ArrayList<Parent> memory;
    @FXML
    private ImageView myHelp;
    @FXML
    private TextField monEmail ;
    @FXML
    private PasswordField monMotDePasse ;
    @FXML
    private Pane myPane ;
    /****************les lignes***************************/
    @FXML
    private Line monLigneEmail ;
    @FXML
    private Line monLigneMotPasse;
    /*************les erreurs **************************/
    @FXML
    private Label alertEmail ;
    @FXML
    private Label alertMotPasse;
    /*************************Variables de classe********/
    public static String studentFolder ;
    private int dureeErreur=3000;
    /*********************Logique d'affichage************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        commutateur =new Commutateur();
        /*****************chargement de la liste des utilisateurs ******************************/
        LoginUtilisateurs loginUtilisateurs =new LoginUtilisateurs();
        try {
            listLogins=loginUtilisateurs.getList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**********************l'Aide en ligne *************************/
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
        myHelp.setOnMouseClicked(event2->{
            try {
                ConnectController.commutateur.AllerAide(event2);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        /*****************traitment des actions********************/
        myHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        String typeB="-fx-stroke:#F1C53C ;-fx-stroke-width:3 ";
        String typeA="-fx-stroke:#b7b5b5 ;-fx-stroke-width:3 ";
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

    /********************Logique de fonctionnement************************/

    static void create(Utilisateur user ) throws IOException {

        Writer writer = null;
        File file =null;
         try{
             file =new File("DonnesUtilisateurs/" + studentFolder);
             file.mkdirs();
             file =new File("DonnesUtilisateurs/" + studentFolder+"/user.json");
             file.createNewFile();
         }catch (IOException e){
             System.out.println("erreur se genre lors de la creation de fichier des donnes personnels");
         }
        try {
            writer = Files. newBufferedWriter(Paths.get("DonnesUtilisateurs/" + studentFolder+"/user.json"));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(user, writer);
        } catch (IOException e) {
            System.out.println("la classe ConnectController ");
            System.out.println("un probleme se genere lors de la sérialisation des données personnels");
        }
        finally {
            writer.close();
        }
    }
    public void procedureRecupération(ActionEvent actionEvent) {
    }

    /**************************************************************************************************/
    /************voici l'operation d'extraction de fichier des donnes personnels se passe***************/
    /***********************************************************************************************/

    public void allerPageAcceuil(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        int index =vérifierLogin(listLogins,monEmail.getText(),monMotDePasse.getText());
        switch (index)
        {
            case 0:
                alertEmail.setText("Email inexistant !");
                TraiterAlert(alertEmail);
                break;
            case 1:
                alertMotPasse.setText("mot de passeincorrect!");
                TraiterAlert(alertMotPasse);
                break;
            case 2:
                /************passage à l'acceuil*******************/
               ZipUnZip.ExtractFile(studentFolder);
               accedreAcceuil(event);
               /*****************************************************/
        }
    }
    /*************************************************************************/

    public  int vérifierLogin(ArrayList<LoginUser> list, String email, String motPasse) throws NoSuchAlgorithmException {
        int validation =0 ,stop=0;
        int i=0;
        while (i < list.size() && stop !=1) {
            if (list.get(i).getEmail().equals(email)) {
                GenererHashage hashage =new GenererHashage(motPasse);
                if (list.get(i).getMotPasse().equals(hashage.RécupereHashage())) {
                    validation= 2;
                    /******************************************/
                    /********************formattage de l'email *********************/
                    studentFolder=list.get(i).getMatricule().replace('/','_');
                } else {
                    validation= 1;
                }
                stop=1;
            } else {
                validation= 0;
            }
            i++;
        }
        return validation;
    }
    public void TraiterAlert(Node node)
    {
        Timer timer =new Timer();
        TimerTask task =new RealiserAlert(node, timer);
        node.setOpacity(1);
        timer.schedule(task,dureeErreur);
    }
    public void inscription(ActionEvent event) throws IOException {
        /*********Creation d'un nouveau Utilisatur****************/
        user =new Utilisateur();
        user.contacts =new Contacts();
        user.donnes =new DonnesPersonnels();
        user.listPortfolio =new ArrayList<>();
        user.listProjets =new ArrayList<>();
        /*************************/
        pagination= new Pagination();
        pagination.setPageCount(3);
        pagination.setCurrentPageIndex(0);
        pagination.setMaxPageIndicatorCount(1);
        memory = new ArrayList<>();
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/views/SignUpView.fxml"));
        memory.add(loader.load());
        loader = new FXMLLoader(getClass().getResource("/views/SignUp1View.fxml"));
        memory.add(loader.load());
        loader = new FXMLLoader(getClass().getResource("/views/SignUp2View.fxml"));
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
    static void accedreAcceuil(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(ConnectController.class.getResource("/views/AccueilMediateurView.fxml"));
        if(loader!=null) {
            scene = new Scene(loader.load());
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setWidth(830);
            stage.setHeight(630);
            stage.setResizable(false);
            stage.show();
        }
    }
}
