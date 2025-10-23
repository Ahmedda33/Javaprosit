package tn.esprit.gestionzoo.entities;

public class Zoo {
    private static final int MAX_CAGES = 25;
    private Animal[] animals;
    private String name;
    private String city;
    private int nbrCages;

    public Zoo(String name, String city, int nbrCages) {
        setName(name); // validation
        this.city = city;
        if (nbrCages > MAX_CAGES) nbrCages = MAX_CAGES;
        this.animals = new Animal[nbrCages];
        this.nbrCages = nbrCages;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne peut pas être vide");
        }
        this.name = name;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getNbrCages() { return nbrCages; }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Impossible d'ajouter : zoo plein.");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("Cet animal existe déjà.");
            return false;
        }
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                return true;
            }
        }
        return false;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                animals[i] = null;
                return true;
            }
        }
        return false;
    }

    public void displayZoo() {
        System.out.println("Zoo: " + name + " situé à " + city + " avec " + nbrCages + " cages.");
    }

    public void displayAnimals() {
        System.out.println("Animaux dans le zoo " + name + ":");
        for (Animal animal : animals) {
            if (animal != null) {
                System.out.println(" - " + animal);
            }
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean isZooFull() {
        for (Animal animal : animals) {
            if (animal == null) return false;
        }
        return true;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        int count1 = 0, count2 = 0;
        for (Animal a : z1.animals) if (a != null) count1++;
        for (Animal a : z2.animals) if (a != null) count2++;
        return count1 >= count2 ? z1 : z2;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + nbrCages +
                '}';
    }
}
