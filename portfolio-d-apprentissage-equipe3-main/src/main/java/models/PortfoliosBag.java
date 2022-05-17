package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controleurs.acceuil.AccueilMediateur;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PortfoliosBag  {
    private static ArrayList<Portfolio> PrtfBag = new ArrayList<>();

    public static boolean isEmptyBag(){
        File file = new File("DonnesUtilisateurs/"+AccueilMediateur.studentFolder+"/portfolios.json");
        if (file.length() == 0) return true;
        return false;
    }

    public static void addPortfolio(Portfolio portfolio) {
        if(!isEmptyBag()) {
            try {
                Reader reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/"+ AccueilMediateur.studentFolder +"/portfolios.json"));
                PrtfBag = new Gson().fromJson(reader, new TypeToken<List<Portfolio>>() {}.getType());
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            PrtfBag.add(portfolio);
            /********************************************************/
            try{
            Writer writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/"+AccueilMediateur.studentFolder+"/portfolios.json"));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(PrtfBag, writer);
            writer.close();
            } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Portfolio> getPortfolios() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/"+AccueilMediateur.studentFolder+"/portfolios.json"));
            PrtfBag = new Gson().fromJson(reader, new TypeToken<List<Portfolio>>() {
            }.getType());
            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PrtfBag;
    }

    public static void removePortfolio(Portfolio portfolio){
        List<Portfolio> newListPrtf = new ArrayList<>();
        int i = 1;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("DonnesUtilisateurs/"+AccueilMediateur.studentFolder+"/portfolios.json"));
            PrtfBag = new Gson().fromJson(reader, new TypeToken<List<Portfolio>>() {
            }.getType());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Portfolio p : PrtfBag){
            if (p.getId() != portfolio.getId()){
                p.setId(i);
                i++;
                newListPrtf.add(p);
            }
        }

        try{
            Writer writer = Files.newBufferedWriter(Paths.get("DonnesUtilisateurs/"+AccueilMediateur.studentFolder+"/portfolios.json"));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(newListPrtf, writer);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
