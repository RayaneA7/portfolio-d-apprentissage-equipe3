package models;

import References.Competence;

import java.util.ArrayList;
import java.util.Date;

public class ProjetClub extends Project{
    private String club;


    //Project(titleInput.getText(),tempType,tempComp,date,tempImg,tempDocs,descriptionInput.getText());
    public ProjetClub(String title, String type, ArrayList<Competence> competences, Date date, String imgPath, ArrayList<String> docs, String description) {
        super(title, type, competences, date, imgPath, docs, description);
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
