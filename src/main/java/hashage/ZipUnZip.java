package hashage;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import java.io.File;
import java.io.IOException;

public class ZipUnZip {
    public static void SerialiseFile(String studentFolder) throws IOException {
        ZipFile zipFile = new ZipFile("compressed.zip", "password".toCharArray());
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
        FileHeader header =new FileHeader() ;
        /******************************/
        header.setFileName(studentFolder+"/");
        if(zipFile.getFileHeaders().contains(header)) {
            zipFile.removeFile(header);
        }
        /**************************/
        File file =new File("DonnesUtilisateurs/"+studentFolder);
        zipFile.addFolder(file,zipParameters);
        if(file.isDirectory()){
            for(File fil :file.listFiles()){
                if(fil.isFile()){
                    fil.delete();
                }
            }
        }
        zipFile.close();
        /****************/
    }
    public static  void ExtractFile(String StudentFolder) throws ZipException {
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
