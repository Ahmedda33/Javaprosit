package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {
    protected String habitat;

    public Aquatic() {
        super("", "", 0, false);
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Instruction 28: force subclasses to override swim()
    public abstract void swim();

    // Instruction 31: two aquatics are equal if same name, same age, same habitat
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Aquatic other = (Aquatic) obj;
        // guard against null names/habitats
        String thisName = this.getName() == null ? "" : this.getName();
        String otherName = other.getName() == null ? "" : other.getName();
        String thisHabitat = this.habitat == null ? "" : this.habitat;
        String otherHabitat = other.habitat == null ? "" : other.habitat;

        return thisName.equals(otherName)
                && this.getAge() == other.getAge()
                && thisHabitat.equals(otherHabitat);
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + "'";
    }
}
