package controleurs.acceuil;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;
//import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import controleurs.authentification.ConnectController;
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
import jdk.jshell.execution.Util;
import models.Utilisateur;
import de.neuland.pug4j.Pug4J;
import org.apache.commons.io.FileUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.helper.W3CDom;
import org.w3c.dom.Document;
import com.itextpdf.styledxmlparser.jsoup.Jsoup;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.itextpdf.html2pdf.HtmlConverter.convertToPdf;

public class AccueilMediateur implements Initializable {
    @FXML
    AnchorPane monAnchorPane;
    /***********************/
   public static Pagination monPagination;
   public static String studentFolder ;
   public static Utilisateur utilisateur;
   public static ArrayList<Parent> memory;
   public static Image image;
    private Stage stage;
    private Scene scene;
    private File file;
//    public void genererHtml(Utilisateur utilisateur) {
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("projets",utilisateur.getMesProjets());
//        model.put("pageName","Ecareer");
//        model.put("info",utilisateur.getDonnes());
//        model.put("contact",utilisateur.getContacts());
//        Writer writer=null;
//        try {
//
//            String html = Pug4J.render("./index.pug", model);
//            System.out.println("hhhhhhhhhhhhhhhhhhhhhhh");
//            System.out.println(html);
//            writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/" + utilisateur.donnes.getMatricule()+"/index.html"));
//            writer.write(html);
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String genererHtml(Utilisateur utilisateur) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("projets", utilisateur.getMesProjets());
        model.put("pageName", "Ecareer");
        model.put("info", utilisateur.getDonnes());
        model.put("contact", utilisateur.getContacts());
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
//    }

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

    public void copyDirectory(String sourcePath, String destinationPath) {
        File srcDir = new File(sourcePath);
        File destDir = new File(destinationPath);

        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************************/
         studentFolder = ConnectController.studentFolder;
         System.out.println("le student folder est :"+studentFolder);
         try {
            utilisateur = Utilisateur.deserialization(studentFolder);
        /****ici on cree l html ***/

//             DirectoryChooser directoryChooser = new DirectoryChooser();
//             File file = directoryChooser.showDialog(new Stage());
//             if(file!= null) {
//                 System.out.println(file.getAbsolutePath());
//                 copyDirectory("./DonnesUtilisateurs/314123423/",file.getAbsolutePath());
//                 saveSystem(new File(file.getAbsolutePath()+"/index.html"), genererHtml(utilisateur));
//             }

             /*****************generation pdf*********************/
             FileChooser fileChooser = new FileChooser();
             FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
             fileChooser.getExtensionFilters().add(extFilter);
             File file = fileChooser.showSaveDialog(new Stage());
             if (file!=null)  {
                 genererPdf(file, utilisateur);
             }



         } catch (IOException e) {
            e.printStackTrace();
            System.out.println("un probleme se génere lors de la désirialisation des données de l'utilisateur");
         }


         /*****************photo personnel*********************/
        try {
            System.out.println("wel");
            file = new File("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/ImagePersonnel.png");
            image = new Image(String.valueOf(file.toURI().toURL()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("probleme se génere losrs de chargement de l'image");
        }
         catch (Exception e){
            e.printStackTrace();
            System.out.println("probleme se génere losrs de chargement de l'image");
         }
         /***********************************/
         memory = new ArrayList<>();
         FXMLLoader loader = new FXMLLoader();
         loader = new FXMLLoader(getClass().getResource("/views/AccueilView.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         /****************************************/
         loader = new FXMLLoader(getClass().getResource("/views/Accueil_1View.fxml"));
         try {
         memory.add(loader.load());
         } catch (IOException e) {
         e.printStackTrace();
         }
         /************************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_1View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /***********************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_2View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /************************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_3View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /**************************/
        loader =new FXMLLoader(getClass().getResource("/views/Parametre_4View.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
         /********************************************************************/
        /************************/
        loader =new FXMLLoader(getClass().getResource("/views/profile.fxml"));
        try {
            memory.add(loader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        /***********************/
         monPagination =new Pagination();
         monPagination.setPageCount(7);
         monPagination.setCurrentPageIndex(0);
         monPagination.setMaxPageIndicatorCount(1);
         monPagination.setPageFactory(new Callback<Integer, Node>() {
         @Override
           public Node call(Integer pageIndex) {
           System.out.println("welcome in acceuil mediateur hhhhshsh");
           return memory.get(pageIndex);
         }
         });
        monAnchorPane.getChildren().addAll(monPagination);
    }
}
