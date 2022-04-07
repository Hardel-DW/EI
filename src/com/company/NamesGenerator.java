package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class NamesGenerator {

    private static List<Names> names = new ArrayList<>(Arrays.asList(
            new Names("Roméo", "Frigo"),
            new Names("Sam", "Gratte"),
            new Names("Marie", "Vière"),
            new Names("Matéo", "Porte"),
            new Names("Jo", "Bar"),
            new Names("Jacques", "Ouzi"),
            new Names("Guy", "Tar"),
            new Names("Gilles", "Parbal"),
            new Names("Sarah", "Croche"),
            new Names("Eva", "Sion"),
            new Names("Elvire", "Orouge"),
            new Names("Elsa", "Dorsa"),
            new Names("Edgard", "Atéfesse"),
            new Names("Edith", "Orial"),
            new Names("Annie", "Mal"),
            new Names("Adam", "Troijours"),
            new Names("Alex", "Térieur"),
            new Names("Alonzo", "Balmaské"),
            new Names("Aude", "Javel"),
            new Names("Barrack", "Afritt"),
            new Names("Berthe", "Alors")
    ));

    /**
     * Retourne une paire de nom et prénom dans un objet.
     * @return un objet Names contenant un nom et un prénom
     */
    public static Names generateNames() {
        return names.get(new Random().nextInt(names.size()));
    }

    public static class Names {
        private String lastName;
        private String firstName;

        public Names(String firstName, String lastName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        @Override
        public String toString() {
            return "Names{" +
                    "lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    '}';
        }
    }
}