package controleurs.parametre;

import controleurs.acceuil.AccueilMediateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Callback;
import models.LoginUtilisateurs;
import models.Utilisateur;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Parametre_Controller implements Initializable {
    @FXML
    private ImageView BarreImage;

    @FXML
    private Button RetourButton;

    @FXML
    private Button ProjetButton;

    @FXML
    private ImageView ProjetsImage;

    @FXML
    private Label ProjetLabel;

    @FXML
    private Button PortfolioButton;

    @FXML
    private ImageView PortfolioImage;

    @FXML
    private Label PortfolioLabel;

    @FXML
    private Button AideButton;

    @FXML
    private ImageView AideImage;

    @FXML
    private Label AideLabel;

    @FXML
    private Button ParametresButton;

    @FXML
    private ImageView ParametresIamge;

    @FXML
    private Label ParametresLabel;

    @FXML
    private Button AccueilButton;

    @FXML
    private ImageView AccueilImage;

    @FXML
    private Label AccueilLabel;

    @FXML
    private Button info_Button;

    @FXML
    private Label AccueilLabel1;

    @FXML
    private Button passe_Button;

    @FXML
    private Label AccueilLabel11;

    @FXML
    private Button Adress_Button;

    @FXML
    private Label AccueilLabel12;

    @FXML
    private Button contact_Button;

    @FXML
    private Label AccueilLabel111;

    @FXML
    private ImageView ModificationButton;

    @FXML
    private Line monlignePassword;

    @FXML
    private Line line1;

    @FXML
    private Line monligneInfo;

    @FXML
    private Line monligneEmail;

    @FXML
    private Line monligneContacts;

    @FXML
    private Line line2;

    @FXML
    private Line line4;

    @FXML
    private Line line3;

    @FXML
    private Line line5;
    @FXML
    private AnchorPane monAnchorpane;
    @FXML
    private AnchorPane monAnchorpane1;
    @FXML
     private ImageView logOut ;
    @FXML
     private Circle  imagePersonnel ;
    /**********************************les images ************************************************/
    Image AccueilImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/AccueilBut.png"));
    Image AccueilImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/AccueilBut1.png"));
    Image PortfolioImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/PortfolioBut.png"));
    Image PortfolioImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/PortfolioBut1.png"));
    Image ProjetImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/ProjetsBut.png"));
    Image ProjetImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/ProjetsBut1.png"));
    Image ParametresImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/ParametresBut.png"));
    Image ParametresImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/ParametresBut1.png"));
    Image AideImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/AideBut.png"));
    Image AideImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/AideBut1.png"));
    /**********************************************************************************************/
    public static Pagination monPagination ;
    public static Button ModifierButton;
    private ArrayList<Parent> memory ;
    public static LoginUtilisateurs loginUtilisateurs =new LoginUtilisateurs();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /****************l'ajoute du button de modification*****************/
        /***********************Chargement de photo Personnel**************************************************/
        if(AccueilMediateur.image!=null) {
            imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
        }
        imagePersonnel.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerProfile(e);
        });
        ModifierButton =new Button("Modifier");
        ModifierButton.setStyle("-fx-bacground-color : white ; -fx-background-radius :10;-fx-border-radius :10 ;" + "-fx-font-size : 14");
        ModifierButton.setPrefSize(90,35);
        ModifierButton.setLayoutY(530);
        ModifierButton.setLayoutX(630);
        monAnchorpane1.getChildren().add(ModifierButton);
        /***********************Pagination entre les parametres*********************/
        /**************0************/
        FXMLLoader loader1 ;
        memory =new ArrayList<>();
        loader1 = new FXMLLoader(getClass().getResource("/views/Parametre_1View.fxml"));
        try {
            memory.add(loader1.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /********************1********************/
        loader1 = new FXMLLoader(getClass().getResource("/views/Parametre_2View.fxml"));
        try {
            memory.add(loader1.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /******************2************************/
        loader1 = new FXMLLoader(getClass().getResource("/views/Parametre_3View.fxml"));
        try {
            memory.add(loader1.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*****************3**********************/
        loader1= new FXMLLoader(getClass().getResource("/views/Parametre_4View.fxml"));
        try {
            memory.add(loader1.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        /********************************************************************/
        monPagination =new Pagination();
        monPagination.setPrefSize(560,330);
        monPagination.setMaxSize(560,330);
        monPagination.setPageCount(4);
        monPagination.setCurrentPageIndex(0);
        monPagination.setMaxPageIndicatorCount(1);
        monPagination.setStyle(" -fx-arrows-visible : false ; -fx-page-information-visible : false");
        monPagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                System.out.println("la page courant est :"+pageIndex);
                return memory.get(pageIndex);
            }
        });
        monAnchorpane.getChildren().addAll(monPagination);
        /***********************************************************************/
        ModifierButton.setOnMouseClicked(e-> {
                    boolean result = false;
                    int Nb = monPagination.getCurrentPageIndex();
                    switch (Nb) {
                        case 0:
                            Parametre_1Controller.ModifierInfo();
                            break;
                        case 1:
                            try {
                                Parametre_2Controller.ModifierEmail();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                Parametre_3Controller.ModifierPassword();
                            } catch (NoSuchAlgorithmException ex) {
                                ex.printStackTrace();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case 3:
                            Parametre_4Controller.ModifierContacts();
                            break;
                    }
        });
        /************************************************************************/
        RetourButton.setOnMouseClicked(e->{
        });
        info_Button.setOnMouseClicked(e->{
            monPagination.setCurrentPageIndex(0);
            monligneInfo.setOpacity(1);
            monligneEmail.setOpacity(0);
            monlignePassword.setOpacity(0);
            monligneContacts.setOpacity(0);
        });
        Adress_Button.setOnMouseClicked(e->{
            monPagination.setCurrentPageIndex(1);
            monligneInfo.setOpacity(0);
            monligneEmail.setOpacity(1);
            monlignePassword.setOpacity(0);
            monligneContacts.setOpacity(0);
        });
        passe_Button.setOnMouseClicked(e->{
            monPagination.setCurrentPageIndex(2);
            monligneInfo.setOpacity(0);
            monligneEmail.setOpacity(0);
            monlignePassword.setOpacity(1);
            monligneContacts.setOpacity(0);
        });
        contact_Button.setOnMouseClicked(e->{
            monPagination.setCurrentPageIndex(3);
            monligneInfo.setOpacity(0);
            monligneEmail.setOpacity(0);
            monlignePassword.setOpacity(0);
            monligneContacts.setOpacity(1);
        });
        /*****************************************************************************************************/
        /**************************************************************************************************/
        /**************************************************/
        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });

        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #b7b5b5");
        });
        AccueilButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerAcceuil(e);
        });
        /***********************************************************************************/
        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");
        });
        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #b7b5b5");
        });
        ProjetButton.setOnMouseClicked(event->{
            AccueilMediateur.commutateur.AllerProjet(event);
        });
        /*******************************************************************************************/
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #b7b5b5");
        });
        PortfolioButton.setOnMouseClicked(event->{
            AccueilMediateur.commutateur.AllerPortfolio(event);
        });
        /******************************************************************************************/
        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });
        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #b7b5b5");
        });
        /******************************************************************/
        imagePersonnel.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerProfile(event);
        });
        /*****************************************************************************************/
        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });
        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #b7b5b5");
        });
        /*********/
        AideButton.setOnMouseClicked(event -> {
            try {
                AccueilMediateur.commutateur.AllerAide(event);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        /*******************************************************************************/
        logOut.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.Déconnecter(event);
        });
        /*************************Aller au profile personnel**********************************/

    }
    static  void ModifierInformations(){
        System.out.println("sérialization des donnes de l'utilisateur");
        try {
            Utilisateur.serialize(AccueilMediateur.utilisateur,AccueilMediateur.studentFolder);
            Parametre_Controller.loginUtilisateurs.serializeList();

        } catch (IOException ex) {
            System.out.println("un probléme ce génere à cause de fichier de loginUtilisateurs");
            ex.printStackTrace();
        }
    }

}

