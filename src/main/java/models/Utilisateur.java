package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Utilisateur {
  public DonnesPersonnels donnes;
  public Contacts contacts;
  public ArrayList<Project> listProjets ;
  public ArrayList<Portfolio> listPortfolio;


  public static void serialize(Utilisateur user,String studentFolder) {

    Writer writer = null;
    try {
      writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/"+studentFolder+"/user.json"));
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(user, writer);

//            System.out.println(gson.toJson(user, writer));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  public static Utilisateur deserialization(String studentFolder) throws IOException {

    Utilisateur user = null;
    Gson gson = new Gson();
    Reader reader =null;
    try {
      reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/"+studentFolder+"/user.json"));
      user = gson.fromJson(reader, Utilisateur.class);

    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
      reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/Etudiant/user.json"));
      user = gson.fromJson(reader, Utilisateur.class);
    }
    finally {
      reader.close();
    }
    return user;
  }

  public DonnesPersonnels getDonnes() {
    return donnes;
  }

  public void setDonnes(DonnesPersonnels donnes) {
    this.donnes = donnes;
  }

  public Contacts getContacts() {
    return contacts;
  }

  public void setContacts(Contacts contacts) {
    this.contacts = contacts;
  }
}