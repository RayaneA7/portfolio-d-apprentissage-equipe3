package models;

import java.util.List;
import java.util.UUID;

public class Portfolio {
    /*private UUID uuid;
    public int numPort;
    //private List<UUID> projects;
    private List<Project> ListProject;

    public Portfolio(int num , List<Project> listProject) {
        this.uuid = UUID.randomUUID();
        this.numPort = num;
        this.ListProject = listProject;
    }

    public int getNumPort() {
        return this.numPort;
    }

    public void setId(int numPort) {this.numPort = numPort; }

    public List<Project> getListProject() {
        return ListProject;
    }

    public void setListProject(List<Project> listProject) {
        ListProject = listProject;
    }
    */
    private UUID uuid;
    private int numero;
    private String date;
    private List<Project> ListProject;

    public Portfolio(int num , List<Project> listProject, String date) {
        this.uuid = UUID.randomUUID();
        this.numero = num;
        this.ListProject = listProject;
        this.date = date;

    }

    public int getNum() {
        return this.numero;
    }

    public void setNum(int num) {this.numero = num; }

    public List<Project> getListProject() {
        return ListProject;
    }

    public void setListProject(List<Project> listProject) {
        ListProject = listProject;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}