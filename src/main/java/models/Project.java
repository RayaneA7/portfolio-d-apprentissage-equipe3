package models;

import java.util.Date;

public class Project {

    private String title;
    private int id;
    private String type;
    private String[] competences;
    private Date date;
    private String imgPath;
    private String docs;
    private String description;
    private static int numPrj = 0;

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

    public String[] getCompetences() {
        return competences;
    }

    public void setCompetences(String[] competences) {
        this.competences = competences;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId(){return this.id; }


    public Project(String title, String type, String[] competences, Date date, String imgPath, String docs, String description) {
        this.title = title;
        this.type = type;
        this.competences = competences;
        this.date = date;
        this.imgPath = imgPath;
        this.docs = docs;
        this.description = description;
        this.id = numPrj;
        numPrj++;
    }


}
