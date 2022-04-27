package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Utilisateur {
  private DonnesPersonnels donnes;
  private Contacts contacts;

  public static void serialize(Utilisateur user) {

    Writer writer = null;
    try {
      writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateur/user.json"));
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(user, writer);

//            System.out.println(gson.toJson(user, writer));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static Utilisateur deserialization() {

    Utilisateur user = null;
    try {
      Gson gson = new Gson();

      Reader reader = Files.newBufferedReader(Paths.get("/home/rayane/Documents/projet2cp/code/portfolio-d-apprentissage-equipe3/DonnesUtilisateur/user.json"));

      user = gson.fromJson(reader, Utilisateur.class);

//      System.out.println(user.donnes.Datenaissance);
      reader.close();
      return user;

    } catch (Exception ex) {
      ex.printStackTrace();
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