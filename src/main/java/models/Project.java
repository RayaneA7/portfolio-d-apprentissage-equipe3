package models;

import References.Competence;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Project {


    private String title;
    private String ClubName;
    private ArrayList<String> ModuleArray;

    public String getClubName() {
        return ClubName;
    }
    public void setClubName(String clubName) {
        ClubName = clubName;
    }

    public ArrayList<String> getModuleArray() {
        return ModuleArray;
    }
    public void setModuleArray(ArrayList<String> moduleArray) {
        ModuleArray = moduleArray;
    }

    public Project(String s, String personnel, Object o, Date parse, Object o1, Object o2, Object o3) {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    public TypeProjet getType() {
        return type;
    }

    public void setType(TypeProjet type) {
        this.type = type;
    }

    private TypeProjet type;
    private ArrayList<Competence> competences = new ArrayList<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;
    private String imgPath;
    private ArrayList<String> docs;
    private String description;

    public Project(int i, String text, String text1, Date date, String text2) {
    }

    //Project(titleInput.getText(),tempType,tempComp,date,tempImg,tempDocs,descriptionInput.getText());
    public Project(String title,TypeProjet type, ArrayList<Competence> competences, String date, ArrayList<String> docs, String descreption) {
        this.title = title;
        this.type = type;
        //System.out.println(title+ " has the competnce  of size () " + competences.size());
        this.competences = competences;
        this.date = date;
        this.docs = docs;
        this.description= descreption;
        this.id = UUID.randomUUID();
        this.imgPath = id.toString();


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

    public ArrayList<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(ArrayList<Competence> competences) {
        this.competences = competences;
    }


    public ArrayList<String> getDocs() {
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






}
