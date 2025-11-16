package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

/**
 * Aquatic implements Carnivore<Food>
 */
public abstract class Aquatic extends Animal implements Carnivore<Food> {
    protected String habitat;

    public Aquatic() throws InvalidAgeException {
        super("", "", 0, false);
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() { return habitat; }
    public void setHabitat(String habitat) { this.habitat = habitat; }

    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(getName() + " mange de la viande.");
        } else {
            System.out.println(getName() + " ne mange pas ce type de nourriture.");
        }
    }

    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Aquatic other = (Aquatic) obj;
        String thisName = this.getName() == null ? "" : this.getName();
        String otherName = other.getName() == null ? "" : other.getName();
        String thisHabitat = this.habitat == null ? "" : this.habitat;
        String otherHabitat = other.habitat == null ? "" : other.habitat;

        return thisName.equals(otherName) &&
                this.getAge() == other.getAge() &&
                thisHabitat.equals(otherHabitat);
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + "'";
    }
}
