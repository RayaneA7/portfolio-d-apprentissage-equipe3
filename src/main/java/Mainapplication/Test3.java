package Mainapplication;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import models.Utilisateur;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Test3 {

    public static void main(String[] args) throws IOException {
        /***************************************************
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
        ZipFile zipfile = new ZipFile("compressed.zip", "password".toCharArray());
        zipfile.addFolder(new File("DonnesUtilisateurs"), zipParameters);
        /*******************************/
        /*******************************/
        //System.out.println(Pattern.matches("[/]","/"));
        //System.out.println(Pattern.matches("\\d\\d","20"));
    }
    static void SerialiseFile(String studentFolder) throws IOException {
        ZipFile zipFile = new ZipFile("compressed.zip", "password".toCharArray());
        FileHeader header =new FileHeader() ;
        header.setFileName(studentFolder+"/");
        System.out.println(zipFile.getFileHeaders());
        if(zipFile.getFileHeaders().contains(header)) {
            System.out.println("welcome in supppression ");
            zipFile.removeFile(header);
        }
        /**************************/
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
        File file =new File("DonnesUtilisateurs/"+studentFolder);
        zipFile.addFolder(file,zipParameters);
        if(file.isDirectory()){
           for(File fil :file.listFiles()){
               if(fil.isFile()){
                   fil.delete();
               }
           }
        }
        System.out.println("la resultata de suppressuon de fichier :"+file.delete());
        zipFile.close();
        /****************/
    }
    static void ExtractFile(String StudentFolder) throws ZipException {
        ZipFile zipFile = new ZipFile("compressed.zip", "password".toCharArray());
        FileHeader header = new FileHeader();
         /********a chaque fois on effectue une lecture on doit supprimer la version zippé*******/
        File file = new File("DonnesUtilisateurs/" + StudentFolder);
        file.mkdirs();
        for (int i = 0; i < zipFile.getFileHeaders().size(); i++) {
            if ((!zipFile.getFileHeaders().get(i).isDirectory()) &&
                    zipFile.getFileHeaders().get(i).toString().contains(StudentFolder)) {
                int nb = zipFile.getFileHeaders().get(i).getFileName().lastIndexOf('/');
                String fileName = zipFile.getFileHeaders().get(i).getFileName().substring(nb + 1);
                zipFile.extractFile(zipFile.getFileHeaders().get(i), "DonnesUtilisateurs/" + StudentFolder, fileName);
            }
        }
    }


}