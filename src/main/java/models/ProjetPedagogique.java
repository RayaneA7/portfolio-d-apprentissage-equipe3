package models;

import java.util.Date;

public class ProjetPedagogique extends Project{
    public ProjetPedagogique(String title, String type, String[] competences, Date date, String imgPath, String docs, String description) {
        super(title, type, competences, date, imgPath, docs, description);
    }
}
