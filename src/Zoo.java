public class Zoo {
    private static final int MAX_CAGES = 25;
    private Animal[] animals;
    String name;
    String city;
    int nbrCages;

    public Zoo(String name, String city, int nbrCages) {
        if (nbrCages > MAX_CAGES) nbrCages = MAX_CAGES;
        this.animals = new Animal[nbrCages];
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull() || searchAnimal(animal) != -1) return false;
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
            if (animals[i] != null && animals[i].name.equals(animal.name)) {
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
            if (animals[i] != null && animals[i].name.equals(animal.name)) {
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
