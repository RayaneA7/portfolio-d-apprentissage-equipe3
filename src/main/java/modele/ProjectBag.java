package modele;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProjectBag {
    private static ArrayList<Project> ProjetBag = new ArrayList<>();

    public static boolean isEmptyBag(){
        File file = new File("DonnesUtilisateur/projets.json");
        if(file.length() == 0) return true;
        return  false;
    }

    public static void addProjet(Project projet){
        if(!isEmptyBag()){
            try{
                Reader reader = Files.newBufferedReader(Paths.get("DonnesUtilisateur/projets.json"));
                ProjetBag = new Gson().fromJson(reader,new TypeToken<List<Project>>(){}.getType());
                reader.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
        ProjetBag.add(projet);
        try{
            Writer writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateur/projets.json"));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(ProjetBag,writer);
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public  static  List<Project> getProjets(){
        try{
            Reader reader = Files.newBufferedReader(Paths.get("DonnesUtilisateur/projets.json"));
            ProjetBag = new Gson().fromJson(reader,new TypeToken<List<Project>>(){}.getType());
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return ProjetBag;
    }


}
