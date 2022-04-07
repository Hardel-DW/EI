package com.company;

import java.util.Scanner;

/**
 * Cette classe permet de faciliter la récupération de valeur depuis la console.
 * Lisez la doc et enjoy :-)
 * <p>
 * Utilisation :
 * Créez un objet de la classe Console :
 * Console maConsole = new Console();
 * <p>
 * Ensuite pour récupérer une valeur entière entre 1 et 10 :
 * int maValeur = maConsole.captureInt(1, 10);
 * <p>
 * ou pour récupérer une chaine de caractères saisie par l'utilisateur
 * Sting maValeur = maConsole.captureString();
 *
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class Console {

    private Scanner scan = new Scanner(System.in);

    /**
     * Attends une saisie de l'utilisateur entre min et max
     * Tant que l'on n'a pas de saisie dans les bornes demandées, on continue d'attendre une saisie
     *
     * Utilisation pour un nombre entre 3 et 5
     *
     * Console maConsole = new Console();
     * int maValeur = maConsole.captureInt(3, 5);
     *
     * @param min la borne minimale (inclue)
     * @param max la borne maximale (inclue)
     * @return la valeure saisie par l'utilisateur
     */
    public int captureInt(int min, int max) {
        if (min > max) {
            throw new RuntimeException("Min ne peut être supérieur à max mon coco");
        }

        do {
            if (scan.hasNextInt()) { // controle si la saisie est bien un chiffre
                int capture = scan.nextInt();
                // contrôle de la saisie
                if (capture < min || capture > max) {
                    System.err.println("Saisie invalide... tu dois choisir entre 1 et 4");
                } else {
                    reset();
                    return capture;
                }
            } else {
                System.err.println("Saisie invalide... saisie une valeur entre " + min + " et " + max);
                reset();
            }
            System.out.println("Nouvelle saisie");

        } while (true);
    }

    /**
     * Attends une saisie utilisateur non vide
     *
     * Utilisation :
     * Console maConsole = new Console();
     * String maValeur = maConsole.captureString();
     *
     * @return retourne la chaine de caractères saisie par l'utilisateur
     */
    public String captureString() {
        String capture = "";

        do {
            capture = scan.nextLine();

            if (capture.equals("")) {
                System.err.println("Hey mec, saisie une valeur stp!");
                reset();
            } else {
                reset();
                return capture;
            }
        } while (true);
    }


    /**
     * Remet a zéro le buffer pour être tranquille
     */
    private void reset() {
        scan = new Scanner(System.in);// on reset le scanner
    }
}