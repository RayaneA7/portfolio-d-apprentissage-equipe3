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
import java.util.Map;

public class Utilisateur {
  public DonnesPersonnels donnes;
  public Contacts contacts;

  ArrayList<Projet> mesProjets;

  public void setMesProjets(ArrayList<Projet> mesProjets) {
    if (this.mesProjets == null) {
      this.mesProjets = new ArrayList<Projet>();
    }else {
    this.mesProjets = mesProjets;}
  }


  public static void serialize(Utilisateur user) {

    Writer writer = null;
    try {
      writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateur/user.json"));
//      RuntimeTypeAdapterFactory<Projet> parameterAdapterFactory = RuntimeTypeAdapterFactory.of(Projet.class, "type");
//      parameterAdapterFactory.registerSubtype(ProjetClub.class, "ProjetClub");
//      parameterAdapterFactory.registerSubtype(PasswordParameter.class, "PasswordParameter");
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

  public void ajouterProjet(Projet projet) {
    setMesProjets(mesProjets);
    mesProjets.add(projet);

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


