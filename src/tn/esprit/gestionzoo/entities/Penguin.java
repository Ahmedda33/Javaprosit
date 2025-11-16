package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public class Penguin extends Aquatic {
    private float swimmingDepth;

    public Penguin() throws InvalidAgeException {
        super();
    }

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() { return swimmingDepth; }
    public void setSwimmingDepth(float swimmingDepth) { this.swimmingDepth = swimmingDepth; }

    @Override
    public void swim() {
        System.out.println(getName() + " the penguin is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingDepth=" + swimmingDepth;
    }
}
