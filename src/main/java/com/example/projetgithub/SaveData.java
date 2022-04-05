package com.example.projetgithub;

import java.io.Serializable;
import java.util.HashMap;

public class SaveData implements Serializable {
    HashMap<String,String> emailPasswords =new HashMap<>();
    HashMap<String,Utilisateur> emailUtilisaterus =new HashMap<>();
    public static void main(String args[])
    {
        SaveData datebase =new SaveData();
    }
}
