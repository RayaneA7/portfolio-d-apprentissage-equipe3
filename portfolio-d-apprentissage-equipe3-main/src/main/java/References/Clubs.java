package References;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.LoginUtilisateurs;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;

public class Clubs {
    private ArrayList<Club> list;
    public Clubs() throws IOException {
        /******
        list =new ArrayList<>();
        Club club =new Club("Google Developer Groups","GDG Algiers");
        list.add(club);
        club=new Club("Sourire à l'innocence","");
        list.add(club);
        Writer writer;
        Clubs clubs =new Clubs();
        clubs.list=list;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        writer =Files.newBufferedWriter(Paths.get("References/Clubs.json"));
        gson.toJson(clubs, writer);
        writer.close();
       /********/
        Reader reader ;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            reader = Files.newBufferedReader(Paths.get("References/Clubs.json"));
            ListClubs clubs = gson.fromJson(reader, ListClubs.class);
            reader.close();
            this.list =clubs.list;
        }catch(IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        /******/
    }
    public void AjouterClub(Club club) throws IOException {
        Reader reader ;
        Writer writer ;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        reader = Files.newBufferedReader(Paths.get("References/Clubs.json"));
        ListClubs clubs = gson.fromJson(reader,ListClubs.class);
        reader.close();
        clubs.list.add(club);
        list.add(club);
        /*****************************/
        writer =Files.newBufferedWriter(Paths.get("References/Clubs.json"));
        gson.toJson(clubs, writer);
        writer.close();
    }
    public ArrayList<Club> RechercheClub(String Motcle){
        ArrayList<Club> resultat = new ArrayList<>();
        if(Motcle!="") {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getNomClub().toLowerCase(Locale.ROOT).contains(Motcle.toLowerCase(Locale.ROOT))
                        || list.get(i).getAbbreviation().toLowerCase(Locale.ROOT).contains(Motcle.toLowerCase(Locale.ROOT))) {
                    resultat.add(list.get(i));
                }
            }
        }
      return  resultat;
    }
}
 class  ListClubs {
   public ArrayList<Club> list ;
 }
