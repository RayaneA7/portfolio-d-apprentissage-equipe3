package controleurs.acceuil;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import controleurs.authentification.ConnectController;
import controleurs.parametre.CustomDialog;
import controleurs.passage.Commutateur;
import de.neuland.pug4j.Pug4J;
import hashage.ZipUnZip;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import models.Utilisateur;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import java.util.concurrent.SynchronousQueue;

import static com.itextpdf.html2pdf.HtmlConverter.convertToPdf;

public class AccueilMediateur implements Initializable {
    @FXML
    AnchorPane monAnchorPane;
    /***********************/
   public static Pagination monPagination;
   public static String studentFolder ;
   public static Utilisateur utilisateur;
   public static ArrayList<Parent> memory;
   public static Image image =null;
   public static Timeline timeLine1 =null;
   public static Commutateur commutateur=null;
    private Stage stage=null;
    private Scene scene=null;
    private File file=null;
    FXMLLoader loader1;

    /***************generation de HTML******************************/
    /***************************************************************/
    public String genererHtml(Utilisateur utilisateur) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("projets", utilisateur.listProjets);
        model.put("pageName", "Ecareer");
        model.put("info", utilisateur.getDonnes());
        model.put("contact", utilisateur.getContacts());
//        System.out.println(utilisateur.getMe.................sProjets());
//        utilisateur.getMesProjets().forEach(project -> {
//            project.competences.
//        });
//        model.put("competences", utilisateur.getMesProjets());
        String html;
        try {

            html = Pug4J.render("./index.pug", model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return html;
    }
//    public void genererPdf(File pdfFile, Utilisateur utilisateur) {
//        String tmpLocation = System.getProperty("user.name")+"/AppData/Local/Temp/"+studentFolder;
//        File file = new File(tmpLocation);
//        copyDirectory("./DonnesUtilisateurs/314123423/",tmpLocation);
//        saveSystem(new File(file.getAbsolutePath()+"/index.html"),genererHtml(utilisateur));
//        try {
//            // Source HTML file
//            String inputHTML = file.getAbsolutePath()+"/index.html";
//            // Generated PDF file name
//            String outputPdf = pdfFile.getAbsolutePath();
//            htmlToPdf(inputHTML, outputPdf);
//            System.out.println("pdf generation ");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    /********************************************************************/
    /****************generation de pdf***********************************/
    /*******************************************************************/
    public void genererPdf(File pdfFile, Utilisateur utilisateur) {
        String tmpLocation = System.getProperty("user.name")+"/AppData/Local/Temp/"+studentFolder;
        File file = new File(tmpLocation);
        copyDirectory("./DonnesUtilisateurs/314123423/",tmpLocation);
        saveSystem(new File(file.getAbsolutePath()+"/index.html"),genererHtml(utilisateur));
        // Source HTML file
        String inputHTML = file.getAbsolutePath()+"/index.html";
        // Generated PDF file name
        String outputPdf = pdfFile.getAbsolutePath();
        PdfWriter writer = null;
        try {
            writer = new PdfWriter("./ehxexhe.pdf");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ConverterProperties properties = new ConverterProperties();
        FontProvider fontProvider = new DefaultFontProvider(false, false, false);
        fontProvider.addDirectory("./Cairo,Open_Sans,Roboto/Open_Sans/OpenSans-VariableFont_wdth,wght.ttf");
        properties.setFontProvider(fontProvider);

        PdfDocument pdf = new PdfDocument(writer);
//        convertToPdf(content, writer );
//            File file = new File("./output1.pdf");
        try {
            convertToPdf(new File( file.getAbsolutePath()+ "/index.html"), pdfFile );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("pdf generation ");
    }
//    public static Document html5ParseDocument(String inputHTML) throws IOException{
//        org.jsoup.nodes.Document doc;
//        System.out.println("parsing ...");
//        doc = Jsoup.parse(new File(inputHTML), "UTF-8");
//        System.out.println("parsing done ..." + doc);
//        return new W3CDom().fromJsoup(doc);
//    }
//
//    public static void htmlToPdf(String inputHTML, String outputPdf) throws IOException {
//        Document doc = html5ParseDocument(inputHTML);
//        String baseUri = FileSystems.getDefault()
//                .getPath(".")
//                .toUri()
//                .toString();
//        OutputStream os = new FileOutputStream(outputPdf);
//        PdfRendererBuilder builder = new PdfRendererBuilder();
//        builder.withUri(outputPdf);
//        builder.toStream(os);
//        // using absolute path here
////        builder.useFont(new File("F:\\knpcode\\Java\\Java Programs\\PDF using Java\\PDFBox\\Gabriola.ttf"),
////                "Gabriola");
//        builder.withW3cDocument(doc, baseUri);
//        //builder.useUriResolver(new MyResolver());
//        builder.run();
//        System.out.println("PDF generation complxeted");
//        os.close();
//
    /*******************************************************/
    public void saveSystem(File file, String content) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            System.out.println(content);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    /*****************************************************************************/
    /*****************************************************************************/
    public void copyDirectory(String sourcePath, String destinationPath) {
        File srcDir = new File(sourcePath);
        File destDir = new File(destinationPath);

        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*********************************************************************************/




    /************************************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************************/
         studentFolder = ConnectController.studentFolder;
         System.out.println("le student folder est :"+studentFolder);
         try {
            utilisateur = Utilisateur.deserialization(studentFolder);
         } catch (IOException e) {
            System.out.println("un probleme se génere lors de la désirialisation des données de l'utilisateur");
         }
         /*****************photo personnel*********************/
        try {
            System.out.println("wel");
            file = new File("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/ImagePersonnel.png");
            if(file.exists()) {
                image = new Image(String.valueOf(file.toURI().toURL()));
            }
        } catch (MalformedURLException e) {
           System.out.println("fichier de l'image personnel introuvable");
        }
        catch (IOException e) {
            System.out.println("probleme se génere losrs de chargement de l'image");
        }
         catch (Exception e){
            System.out.println("probleme se génere lors de chargement de l'image");
         }
         /*********************0**************/
         memory = new ArrayList<>(10);
         FXMLLoader loader = new FXMLLoader();
         loader = new FXMLLoader(getClass().getResource("/views/AccueilView.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         /**********************1******************
         loader = new FXMLLoader(getClass().getResource("/views/Accueil_1View.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         /**********************************************************************************/
         /**********************************************************************************/
         timeLine1 = new Timeline(new KeyFrame(Duration.seconds(0.1), event4 -> {
            System.out.println("welcome in our application****************************");
            /******************1**********************/
            loader1 = new FXMLLoader(getClass().getResource("/views/Parametre_View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /***********************2******************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioShowPage.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /***********************3***********************/
            loader1 = new FXMLLoader(getClass().getResource("/views/Portfolio1View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*********************************4*********************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioModel1View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /************************5*****************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioModel2View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /**********************6*******************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/PortfolioModel3View.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /**************************7*************************************/
            loader1 = new FXMLLoader(getClass().getResource("/views/ModifyPortfolio.fxml"));
            try {
                memory.add(loader1.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
             /**************************8*************************************/
             loader1 = new FXMLLoader(getClass().getResource("/views/profile.fxml"));
             try {
                 memory.add(loader1.load());
             } catch (IOException e) {
                 e.printStackTrace();
             }
            /************************9****************************************/
             loader1 = new FXMLLoader(getClass().getResource("/views/Project1View.fxml"));
             try {
                 memory.add(loader1.load());
             } catch (IOException e) {
                 e.printStackTrace();
             }
             /************************10****************************************/
             loader1 = new FXMLLoader(getClass().getResource("/views/AddProjectView.fxml"));
             try {
                 memory.add(loader1.load());
             } catch (IOException e) {
                 System.out.println("erreur se genere lors de charegement de la page ajouter projet");
             }
             /*****************************11******************************************/
             loader1 = new FXMLLoader(getClass().getResource("/views/EditProjectView.fxml"));
             try {
                 memory.add(loader1.load());
             } catch (IOException e) {
                 e.printStackTrace();
             }
             /*******************/
        }));
         timeLine1.setRate(1);
         timeLine1.setDelay(Duration.seconds(0.2));
         timeLine1.setCycleCount(1);
         timeLine1.play();
        /********************************************************************/
         monPagination =new Pagination();
         monPagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
         monPagination.setStyle(" -fx-arrows-visible : false ; -fx-page-information-visible : false");
         monPagination.setPageCount(13);
         monPagination.setCurrentPageIndex(0);
         monPagination.setMaxPageIndicatorCount(1);
         monPagination.setPageFactory(new Callback<Integer, Node>() {
         @Override
           public Node call(Integer pageIndex) {
           System.out.println("la page courant est :"+pageIndex);
           return memory.get(pageIndex);
         }
         });
        monAnchorPane.getChildren().add(monPagination);
        /***********************************************/
        commutateur =new Commutateur();
        /*************************************************************************************************/
        /************la compression des info personnels à la fin de la séance**********************************/
        /*************************************************************************************************/
        monAnchorPane.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                // scene is set for the first time. Now its the time to listen stage changes.
                newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                    if (oldWindow == null && newWindow != null) {
                                // stage is set. now is the right time to do whatever we need to the stage in the controller.
                        stage = (Stage) newWindow;
                        stage.setOnCloseRequest(event -> {
                            event.consume();
                            CustomDialog dialog =new CustomDialog("Confiramtion","Cliquez sur Ok " +
                                    "si voulez sortir");
                            dialog.show();
                            dialog.buttonOk.setOnAction(e-> {
                                try {
                                    System.out.println("sérialisation des donnes à la fin de la séance");
                                    ZipUnZip.SerialiseFile(studentFolder);
                                    System.out.println("fermeture de séance");
                                    dialog.closeDialog();
                                    stage.close();
                                } catch (IOException ex) {
                                    System.out.println("probléme en page ZipUnZip");
                                    System.out.println("une probléme se genere lors de la sérialisation des info personnels");
                                }
                            });
                            dialog.buttonCancel.setOnAction(e->{
                                dialog.closeDialog();
                            });
                        });
                    }
                });
            }
        });
        /********************************************************/
    }
}
