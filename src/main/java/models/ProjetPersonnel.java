package models;

import java.util.Date;

public class ProjetPersonnel extends Project{
    public ProjetPersonnel(String title, String type, String[] competences, Date date, String imgPath, String docs, String description) {
        super(title, type, competences, date, imgPath, docs, description);
    }
}
