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
        System.out.println("Le zoo avec le plus d'animaux est: " + biggerZoo.name);
    }
}
