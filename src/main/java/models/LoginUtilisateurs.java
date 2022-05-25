package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginUtilisateurs {
    private ArrayList<LoginUser> list ;

    public LoginUtilisateurs()  {
        Reader reader;
            File file =new File("DonnesUtilisateurs/LoginUtilisateurs.json");
            if(file.exists()) {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
                    ListLoginUtilisateur loginUtilisateurs = gson.fromJson(reader, ListLoginUtilisateur.class);
                    list = loginUtilisateurs.list;
                    reader.close();
                }catch (Exception e){
                  System.out.println("une probléme se génere à cause de fichier loginUtilisateurs ");
                }
            }
            else{
                try {
                    list =new ArrayList<>();
                    file.createNewFile();
                    Writer writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    ListLoginUtilisateur loginUtilisateur = new ListLoginUtilisateur(list);
                    gson.toJson(loginUtilisateur, writer);
                    writer.close();
                }catch (IOException e){
                  System.out.println(" probleme à cuase de nouveau fichier loginUtilisateurs ");
                }
            }
    }

    public ArrayList<LoginUser> getList() throws IOException {
        return list;
    }

    public void serializeList() throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ListLoginUtilisateur loginUtilisateur = new ListLoginUtilisateur(list);
        gson.toJson(loginUtilisateur, writer);
        writer.close();
    }

    public void ajouteUtilisateurToList(LoginUser loginUser) throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        list.add(loginUser);
        ListLoginUtilisateur loginUtilisateur = new ListLoginUtilisateur(list);
        gson.toJson(loginUtilisateur, writer);
        writer.close();
    }

    class ListLoginUtilisateur {
        public ArrayList<LoginUser> list = new ArrayList<>();

          public ListLoginUtilisateur(ArrayList<LoginUser> list) {
             this.list = list;
         }
      }
   }
