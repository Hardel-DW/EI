package com.company;

import com.company.Person.Eleves;

import java.util.ArrayList;
import java.util.List;

public class Promotion {

    private String name;
    private List<Eleves> eleves = new ArrayList<>();
    private static List<Promotion> promotionList = new ArrayList<>();

    public Promotion(String name, List<Eleves> promotions) {
        this.name = name;
        this.eleves = promotions;
        promotionList.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Eleves> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleves> eleves) {
        this.eleves = eleves;
    }

    public void addPromotions(Eleves eleve) {
        this.eleves.add(eleve);
    }

    public static List<Promotion> getPromotionList() {
        return promotionList;
    }

    public static void setPromotionList(List<Promotion> promotionList) {
        Promotion.promotionList = promotionList;
    }
}
