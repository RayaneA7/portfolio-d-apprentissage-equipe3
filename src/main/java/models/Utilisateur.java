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
  private ArrayList<Portfolio> mesPortfolios;



  public void setMesProjets(ArrayList<Projet> mesProjets) {
    if (this.mesProjets == null) {
      this.mesProjets = new ArrayList<Projet>();
    }else {
    this.mesProjets = mesProjets;}
  }

  public ArrayList<Projet> getMesProjets() {
    return mesProjets;
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

  public boolean supprimerProjet(Projet projet) {

    for (int s = 0; s < mesProjets.size(); s++) {
      if(mesProjets.get(s).equals(projet)) {
        return true;
      }
    }
    return false;
  }

  public void ajouterPortfolio(Portfolio portfolio) {
    setMesPortfolios(mesPortfolios);
    mesPortfolios.add(portfolio);

  }

  public boolean supprimerPortfolio(Portfolio portfolio) {

    for (int s = 0; s < mesPortfolios.size(); s++) {
      if(mesPortfolios.get(s).equals(portfolio)) {
        return true;
      }
    }
    return false;
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

  public ArrayList<Portfolio> getMesPortfolios() {
    return mesPortfolios;
  }

  public void setMesPortfolios(ArrayList<Portfolio> mesPortfolios) {
    if (this.mesPortfolios == null) {
      this.mesPortfolios = new ArrayList<Portfolio>();
    }else {
      this.mesPortfolios = mesPortfolios;}
  }
}


