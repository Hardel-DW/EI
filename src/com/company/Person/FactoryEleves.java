package com.company.Person;

public class FactoryEleves {

    public static Eleves create(TypeEleve typeEleve, String firstName, String lastName) {
        switch (typeEleve) {
            case FORT -> {
                return new Eleves(firstName, lastName, 20);
            }
            case MOYEN -> {
                return new Eleves(firstName, lastName, 12);
            }
            case FAIBLE -> {
                return new Eleves(firstName, lastName, 5);
            }
            default -> {
                return null;
            }
        }
    }

}
