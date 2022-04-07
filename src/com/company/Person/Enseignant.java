package com.company.Person;

import com.company.Promotion;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Person {

    private static List<Enseignant> enseignantList = new ArrayList<>();
    private List<Promotion> promotions;
    private String boite;

    public Enseignant(String firstName, String lastName, String boite, List<Promotion> promotions) {
        super(firstName, lastName);
        this.promotions = promotions;
        this.boite = boite;
        enseignantList.add(this);
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public static List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public static void setEnseignantList(List<Enseignant> enseignantList) {
        Enseignant.enseignantList = enseignantList;
    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite = boite;
    }
}
