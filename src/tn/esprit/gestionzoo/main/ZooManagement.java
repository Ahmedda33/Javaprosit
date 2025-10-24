package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

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

        Dolphin d1 = new Dolphin();
        Penguin p1 = new Penguin();
        Terrestrial t1 = new Terrestrial();

        Dolphin d2 = new Dolphin("Delphinidae", "Dolly", 8, true, "Ocean", 25.5f);
        Penguin p2 = new Penguin("Spheniscidae", "Pingo", 3, false, "Antarctica", 50.0f);
        Penguin p3 = new Penguin("Spheniscidae", "PingoDeep", 4, false, "Antarctica", 75.0f);
        Terrestrial t2 = new Terrestrial("Canidae", "Fox", 4, true, 4);

        System.out.println("\n=== Display new animals ===");
        System.out.println(d2);
        System.out.println(p2);
        System.out.println(t2);

        System.out.println("\n=== Adding aquatic animals to zoo1 ===");
        zoo1.addAquaticAnimal(d2);
        zoo1.addAquaticAnimal(p2);
        zoo1.addAquaticAnimal(p3);

        Penguin duplicateP = new Penguin("Spheniscidae", "Pingo", 3, false, "Antarctica", 50.0f);
        System.out.println("Adding duplicate penguin (should fail): " + zoo1.addAquaticAnimal(duplicateP));

        System.out.println("\n=== Swim tests (all aquatics) ===");
        zoo1.makeAllAquaticsSwim();

        Aquatic aquaticRef = d2;
        System.out.print("Aquatic ref calling swim(): ");
        aquaticRef.swim();

        System.out.println("\nMax penguin swimming depth in zoo1: " + zoo1.maxPenguinSwimmingDepth());

        System.out.println();
        zoo1.displayNumberOfAquaticsByType();

        System.out.println("\nEquality checks:");
        System.out.println("p2.equals(duplicateP): " + p2.equals(duplicateP));
        System.out.println("p2.equals(p3): " + p2.equals(p3));
    }
}
