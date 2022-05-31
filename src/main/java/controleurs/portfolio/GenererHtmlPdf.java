package controleurs.portfolio;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import controleurs.acceuil.AccueilMediateur;
import de.neuland.pug4j.Pug4J;
import models.Portfolio;
import models.Project;
import models.Utilisateur;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.itextpdf.html2pdf.HtmlConverter.convertToPdf;

public class GenererHtmlPdf {
    /***************generation de HTML******************************/
    /***************************************************************/
    public static String genererHtml(Portfolio portfolio) {
        Map<String, Object> model = new HashMap<String, Object>();
        ArrayList<Project> listProjets =new ArrayList<>();
        /********************************/
        System.out.println("la taille : "+portfolio.getListProjUUid().size());
        for(int i=0;i<portfolio.getListProjUUid().size();i++){
            int j=0;
            int stop=0;
            while(j<AccueilMediateur.utilisateur.getListProjets().size()&&stop!=1) {
                if (AccueilMediateur.utilisateur.getListProjets().get(j).getId().equals(portfolio.getListProjUUid().get(i))) {
                    listProjets.add(AccueilMediateur.utilisateur.getListProjets().get(j));
                    stop=1;
                }
                j++;
            }
        }
        model.put("projets",listProjets);
        model.put("pageName", "Ecareer");
        model.put("info", AccueilMediateur.utilisateur.getDonnes());
        model.put("contact", AccueilMediateur.utilisateur.getContacts());
        model.put("modeleNum",String.valueOf(portfolio.getNbModel()));
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
    public static void genererPdf(File pdfFile,Portfolio portfolio) {
        String tmpLocation = System.getProperty("user.name")+"/AppData/Local/Temp/"+ AccueilMediateur.studentFolder;
        File file = new File(tmpLocation);
        copyDirectory(AccueilMediateur.StudentDirectory+"DonnesUtilisateurs/"+AccueilMediateur.studentFolder,tmpLocation);
        saveSystem(new File(file.getAbsolutePath()+"/index.html"),genererHtml(portfolio));
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
    public static void saveSystem(File file, String content) {
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
    public static void copyDirectory(String sourcePath, String destinationPath) {
        File srcDir = new File(sourcePath);
        File destDir = new File(destinationPath);

        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*********************************************************************************/

}
