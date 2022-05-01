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
    public ArrayList<LoginUser> getList() throws IOException {
        Reader reader ;
        Writer writer ;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
        LoginUtilisateurs loginUtilisateurs = gson.fromJson(reader,LoginUtilisateurs.class);
        return loginUtilisateurs.list;
    }

    public void ajouteUtilisateurToList(LoginUser loginUser) throws IOException {
        Reader reader ;
        Writer writer ;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
        LoginUtilisateurs loginUtilisateurs = gson.fromJson(reader,LoginUtilisateurs.class);
        reader.close();
        loginUtilisateurs.list.add(loginUser);
        /*****************************/
        writer =Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/LoginUtilisateurs.json"));
        gson.toJson(loginUtilisateurs, writer);
        writer.close();
    }

    private  ArrayList<LoginUser> list =new ArrayList<>();
}
