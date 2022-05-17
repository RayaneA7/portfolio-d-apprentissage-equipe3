package models;

import References.Competence;

import java.util.ArrayList;
import java.util.Date;

public class ProjetPedagogique extends Project{
    public ProjetPedagogique(String title, String type, ArrayList<Competence> competences, Date date, String imgPath, ArrayList<String> docs, String description) {
        super(title, type, competences, date, imgPath, docs, description);
    }
}
