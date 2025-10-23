package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

        // --- Tests existants ---
        Animal lion = new Animal("Félidé", "Lion", 5, true);
        Animal elephant = new Animal("Éléphantidé", "Éléphant", 10, true);
        Animal crocodile = new Animal("Crocodylidé", "Crocodile", 7, false);
        Animal lion2 = new Animal("Félidé", "Lion", 6, true);

        Zoo zoo1 = new Zoo("MonSuperZoo", "Tunis", 25);
        Zoo zoo2 = new Zoo("ZooTropique", "Sousse", 20);

        zoo1.addAnimal(lion);
        zoo1.addAnimal(elephant);
        zoo1.addAnimal(crocodile);

        zoo2.addAnimal(lion2);

        zoo1.displayZoo();
        zoo1.displayAnimals();

        System.out.println("Rechercher Lion dans zoo1: index = " + zoo1.searchAnimal(lion));
        System.out.println("Rechercher Lion2 dans zoo1: index = " + zoo1.searchAnimal(lion2));

        System.out.println("Suppression Lion: " + zoo1.removeAnimal(lion));
        zoo1.displayAnimals();

        System.out.println("Zoo plein? " + zoo1.isZooFull());

        Zoo biggerZoo = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("Le zoo avec le plus d'animaux est: " + biggerZoo.getName());

        // --- Instruction 21 : instances par défaut ---
        Dolphin d1 = new Dolphin();
        Penguin p1 = new Penguin();
        Terrestrial t1 = new Terrestrial();

        // --- Instruction 22 : constructeurs paramétrés ---
        Dolphin d2 = new Dolphin("Delphinidae", "Dolly", 8, true, "Ocean", 25.5f);
        Penguin p2 = new Penguin("Spheniscidae", "Pingo", 3, false, "Antarctica", 50.0f);
        Terrestrial t2 = new Terrestrial("Canidae", "Fox", 4, true, 4);

        // --- Instruction 23 : affichage toString ---
        System.out.println("\n=== Display new animals ===");
        System.out.println(d2);
        System.out.println(p2);
        System.out.println(t2);

        // --- Instruction 24 : méthode swim() ---
        System.out.println("\n=== Swim tests ===");
        Aquatic a1 = new Aquatic("Generic", "Fish", 1, false, "Lake");
        a1.swim();
        d2.swim();
        p2.swim();
    }
}
