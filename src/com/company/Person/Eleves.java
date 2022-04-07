package com.company.Person;

import com.company.Competences;
import com.company.NamesGenerator;

import java.util.ArrayList;
import java.util.List;

public class Eleves extends Person {

    private List<Competences> competencesList;
    private Integer moyenne;

    public Eleves(String firstName, String lastName) {
        super(firstName, lastName);
        competencesList = new ArrayList<>();
    }

    public Eleves(String firstName, String lastName, int moyenne) {
        this(firstName, lastName);
        this.moyenne = moyenne;
    }


    public static List<Eleves> createListRandomEleve(int count) {
        List<Eleves> eleves = new ArrayList<Eleves>();

        for (int i = 0; i < count; i++) {
            NamesGenerator.Names name = NamesGenerator.generateNames();
            eleves.add(new Eleves(name.getFirstName(), name.getLastName()));
        }

        return eleves;
    }

    public List<Competences> getCompetencesList() {
        return competencesList;
    }

    public void setCompetencesList(List<Competences> competencesList) {
        this.competencesList = competencesList;
    }

    public void addCompetences(Competences competencesList) {
        this.competencesList.add(competencesList);
    }

    public Integer getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Integer moyenne) {
        this.moyenne = moyenne;
    }

    public void displayCompetences() {
        if (competencesList == null || competencesList.size() == 0) {
            System.out.println("\t\t Compétences : aucune");
        } else {
            System.out.print("\t\t Compétences: ");

            for (Competences competence: getCompetencesList()) {
                System.out.print(competence.getName() + ", ");
            }
            System.out.println("");
        }
    }

    public void displayEleves() {
        if (moyenne == null) {
            System.out.println("\t-\t" + getFirstName() + " " + getLastName() + " " + " (aucune moyenne) ");
        } else {
            System.out.println("\t-\t" + getFirstName() + " " + getLastName() + " " + "(" + getMoyenne() + "/20)");
        }
    }
}
