package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class Zoo {
    private static final int MAX_CAGES = 25;
    private Animal[] animals;
    private String name;
    private String city;
    private int nbrCages;

    private static final int MAX_AQUATICS = 10;
    private Aquatic[] aquaticAnimals;
    private int aquaticCount;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;

        if (nbrCages > MAX_CAGES) nbrCages = MAX_CAGES;
        this.animals = new Animal[nbrCages];
        this.nbrCages = nbrCages;

        this.aquaticAnimals = new Aquatic[MAX_AQUATICS];
        this.aquaticCount = 0;
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

    public void displayZoo() {
        System.out.println("Zoo: " + name + " situé à " + city + " avec " + nbrCages + " cages.");
    }

    public boolean addAnimal(Animal animal) throws ZooFullException {
        if (animal == null) return false;

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

        throw new ZooFullException("Impossible d'ajouter : zoo plein.");
    }

    // ✅ FIXED METHOD
    public int getNbrCagesOccuped() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal != null) count++;
        }
        return count;
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

    // ---------------- AQUATIC METHODS ----------------

    public boolean addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null) return false;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] != null && aquaticAnimals[i].equals(aquatic)) {
                System.out.println("Cet animal aquatique existe déjà.");
                return false;
            }
        }

        if (aquaticCount >= aquaticAnimals.length) {
            System.out.println("Impossible d'ajouter : nombre maximal d'animaux aquatiques atteint.");
            return false;
        }

        aquaticAnimals[aquaticCount++] = aquatic;
        return true;
    }

    public void makeAllAquaticsSwim() {
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] != null) {
                aquaticAnimals[i].swim();
            }
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > maxDepth) {
                    maxDepth = p.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("Nombre de Dauphins: " + dolphinCount);
        System.out.println("Nombre de Pingouins: " + penguinCount);
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
