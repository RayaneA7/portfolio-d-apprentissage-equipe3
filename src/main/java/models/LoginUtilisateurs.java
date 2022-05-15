package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginUtilisateurs {
    private ArrayList<LoginUser> list = new ArrayList<>();

    public LoginUtilisateurs() {
        Reader reader;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
            ListLoginUtilisateur loginUtilisateurs = gson.fromJson(reader, ListLoginUtilisateur.class);
            list = loginUtilisateurs.list;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("une probléme se génere à cuase de fichier loginUtilisateurs ");
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
