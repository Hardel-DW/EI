package com.company;

import com.company.Person.Eleves;
import com.company.Person.Enseignant;
import com.company.Person.FactoryEleves;
import com.company.Person.TypeEleve;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("/_\\ Bienvenue sur 3IL manager!");

        // Create Class

        Promotion M1 = new Promotion("M1", Eleves.createListRandomEleve(10));
        Promotion M2 = new Promotion("M2", Eleves.createListRandomEleve(15));
        M2.getEleves().add(FactoryEleves.create(TypeEleve.FORT, NamesGenerator.generateNames().getFirstName(), NamesGenerator.generateNames().getLastName()));
        M1.getEleves().add(FactoryEleves.create(TypeEleve.FAIBLE, NamesGenerator.generateNames().getFirstName(), NamesGenerator.generateNames().getLastName()));
        M2.getEleves().add(FactoryEleves.create(TypeEleve.MOYEN, NamesGenerator.generateNames().getFirstName(), NamesGenerator.generateNames().getLastName()));

        List<Promotion> promotions = new ArrayList<>();
        promotions.add(M1);
        promotions.add(M2);

        new Enseignant(NamesGenerator.generateNames().getFirstName(), NamesGenerator.generateNames().getLastName(), "3IL", promotions);
        new Enseignant(NamesGenerator.generateNames().getFirstName(), NamesGenerator.generateNames().getLastName(), "Erudo", promotions);
        new Enseignant(NamesGenerator.generateNames().getFirstName(), NamesGenerator.generateNames().getLastName(), "YeahLand", promotions);
        new Enseignant("Tuphe","Theo", "Emakina", promotions);

        Console console = new Console();
        int functionToRun = -1;
        do {
            System.out.println("Qu'est-ce que tu veux faire?");
            System.out.println("1 - Lister les élèves");
            System.out.println("2 - Lister les enseignants");
            System.out.println("3 - Donner un cours");
            System.out.println("4 - J'ai fini");

            functionToRun = console.captureInt(1, 4);

            switch(functionToRun) {
                case 1:
                    listStudent();
                    System.out.println("Voici la liste des élèves");
                    break;
                case 2:
                    listEnseignant();
                    System.out.println("Voici la liste des enseignants");
                    break;
                case 3:
                    donnerCours();
                    System.out.println("C'est parti pour un cours!");
                    break;
                case 4:
                    System.out.println("A la prochaine!");
                default:
                    System.err.println("Saisie invalide... tu dois choisir entre 1 et 4");
            }
            System.out.println("###################################################");

        } while(functionToRun != 4);
    }

    public static void listStudent() {
        Console console = new Console();

        System.out.println("Liste des élèves :");
        for (Promotion promotion: Promotion.getPromotionList()) {
            System.out.println("# Promotion " + promotion.getName());
            for (Eleves eleve: promotion.getEleves()) {
                eleve.displayEleves();
                eleve.displayCompetences();
            }

            System.out.println("\n");
        }
    }

    public static void listEnseignant() {
        System.out.println("Liste des enseignants :");

        for (Enseignant enseignant: Enseignant.getEnseignantList()) {
            System.out.println("#" + enseignant.getFirstName() + " " + enseignant.getLastName() + " (" + enseignant.getBoite() + ")");
            for (Promotion promotion: enseignant.getPromotions()) {
                System.out.println("\t- " + promotion.getName());
            }

            System.out.println("\n");
        }
    }

    public static void donnerCours() {
        Enseignant enseignant;
        Promotion promotion;
        Console console = new Console();

        System.out.println("Quel enseignant donne un cours ?");
        for (int i = 1; i < Enseignant.getEnseignantList().size() + 1; i++) {
            Enseignant element = Enseignant.getEnseignantList().get(i -1);
            System.out.println(i + " - " + element.getFirstName() + " " + element.getLastName());
        }

        int enseignantIndex = console.captureInt(0, Enseignant.getEnseignantList().size() + 1);
        enseignant = Enseignant.getEnseignantList().get(enseignantIndex - 1);
        System.out.println("Ok, " + enseignant.getLastName() + " Va donner le cours !");

        System.out.println("A quelle promotion?");
        for (int i = 1; i < enseignant.getPromotions().size() + 1; i++) {
            Promotion element = enseignant.getPromotions().get(i - 1);
            System.out.println(i + " - " + element.getName());
        }

        int promotionsIndex = console.captureInt(0, enseignant.getPromotions().size() + 1);
        promotion = enseignant.getPromotions().get(promotionsIndex - 1);
        System.out.println("Ok la promotion " + promotion.getName() + " va avoir cours !");

        System.out.println("Quel est l’intitulé du cours?");
        String cours = console.captureString();
        for (Eleves eleve: promotion.getEleves()) {
            eleve.addCompetences(new Competences(cours));
        }

        System.out.println("GG, les élèves deviennent meilleurs chaque jour et ont appris " + cours + "!\n");
    }
}
