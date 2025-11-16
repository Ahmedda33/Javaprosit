package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public class Dolphin extends Aquatic {
    private float swimmingSpeed;

    public Dolphin() throws InvalidAgeException {
        super();
    }

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    public float getSwimmingSpeed() { return swimmingSpeed; }
    public void setSwimmingSpeed(float swimmingSpeed) { this.swimmingSpeed = swimmingSpeed; }

    @Override
    public void swim() {
        System.out.println(getName() + " the dolphin is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingSpeed=" + swimmingSpeed;
    }
}
