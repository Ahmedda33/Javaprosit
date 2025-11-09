package main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.*;

public class Zoomanagement {
    public static void main(String[] args) {

        // Création du zoo
        Zoo zoo = new Zoo("ZooTest", "Tunis", 3);
        zoo.displayZoo();

        // Ajout d'animaux terrestres
        try {
            Animal lion = new Terrestrial("Felidae", "Lion", 5, true, 4);
            zoo.addAnimal(lion);
        } catch (InvalidAgeException e) {
            System.out.println("Erreur âge : " + e.getMessage());
        } catch (ZooFullException e) {
            System.out.println("Erreur zoo : " + e.getMessage());
        }
        System.out.println("Nombre d'animaux : " + zoo.getNbrCagesOccuped());
        zoo.displayAnimals();

        try {
            Animal tiger = new Terrestrial("Felidae", "Tiger", 3, true, 4);
            zoo.addAnimal(tiger);
        } catch (InvalidAgeException e) {
            System.out.println("Erreur âge : " + e.getMessage());
        } catch (ZooFullException e) {
            System.out.println("Erreur zoo : " + e.getMessage());
        }
        System.out.println("Nombre d'animaux : " + zoo.getNbrCagesOccuped());
        zoo.displayAnimals();

        try {
            Animal elephant = new Terrestrial("Elephantidae", "Elephant", -2, true, 4);
            zoo.addAnimal(elephant);
        } catch (InvalidAgeException e) {
            System.out.println("Erreur âge : " + e.getMessage());
        } catch (ZooFullException e) {
            System.out.println("Erreur zoo : " + e.getMessage());
        }
        System.out.println("Nombre d'animaux : " + zoo.getNbrCagesOccuped());
        zoo.displayAnimals();

        try {
            Animal giraffe = new Terrestrial("Giraffidae", "Giraffe", 7, true, 4);
            zoo.addAnimal(giraffe);
        } catch (InvalidAgeException e) {
            System.out.println("Erreur âge : " + e.getMessage());
        } catch (ZooFullException e) {
            System.out.println("Erreur zoo : " + e.getMessage());
        }
        System.out.println("Nombre d'animaux : " + zoo.getNbrCagesOccuped());
        zoo.displayAnimals();

        // Ajout d'animaux aquatiques
        try {
            Dolphin dolly = new Dolphin("Delphinidae", "Dolly", 4, true, "Ocean", 20);
            zoo.addAquaticAnimal(dolly);
        } catch (InvalidAgeException e) {
            System.out.println("Erreur âge : " + e.getMessage());
        }

        try {
            Penguin pingu = new Penguin("Spheniscidae", "Pingu", 2, false, "Antarctica", 15);
            zoo.addAquaticAnimal(pingu);
        } catch (InvalidAgeException e) {
            System.out.println("Erreur âge : " + e.getMessage());
        }

        // Affichage des aquatiques
        zoo.makeAllAquaticsSwim();
        zoo.displayNumberOfAquaticsByType();
        System.out.println("Profondeur maximale des pingouins : " + zoo.maxPenguinSwimmingDepth());
    }
}
