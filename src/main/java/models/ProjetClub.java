package models;

import java.util.Date;

public class ProjetClub extends Project{
    private String club;

    public ProjetClub(String title, String type, String[] competences, Date date, String imgPath, String docs, String description) {
        super(title, type, competences, date, imgPath, docs, description);
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
