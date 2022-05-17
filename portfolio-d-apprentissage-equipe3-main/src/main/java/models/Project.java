package models;

import References.Competence;

import java.util.ArrayList;
import java.util.Date;

public class Project {


    private String title;
    private int id;
    private String type;
    private ArrayList<Competence> competences = new ArrayList<>();
    private Date date;
    private String imgPath;
    private ArrayList<String> docs;
    private String description;
    private static int numPrj = 0;

    public Project(int i, String text, String text1, Date date, String text2) {
    }

    //Project(titleInput.getText(),tempType,tempComp,date,tempImg,tempDocs,descriptionInput.getText());
    public Project(String title, String type, ArrayList<Competence> competences, Date date, String imgpath, ArrayList<String> docs, String descreption) {
        this.title = title;
        this.type = type;
        //System.out.println(title+ " has the competnce  of size () " + competences.size());
        this.competences = competences;
        this.date = date;
        this.imgPath = imgpath;
        this.docs = docs;
        this.description= descreption;
        this.id = numPrj;
        numPrj++;

    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(ArrayList<Competence> competences) {
        this.competences = competences;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> etDocs() {
        return docs;
    }

    public void setDocs(ArrayList<String> docs) {
        this.docs = docs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId(){return this.id; }





}
