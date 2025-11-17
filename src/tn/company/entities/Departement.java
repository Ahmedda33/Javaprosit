package tn.company.entities;

import java.util.Objects;

public class Departement {

    private int id;
    private String nomDepartement;
    private int nbEmployes;

    // Constructeur sans paramètre
    public Departement() {}

    // Constructeur avec paramètres
    public Departement(int id, String nomDepartement, int nbEmployes) {
        this.id = id;
        this.nomDepartement = nomDepartement;
        this.nbEmployes = nbEmployes;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }

    public int getNbEmployes() { return nbEmployes; }
    public void setNbEmployes(int nbEmployes) { this.nbEmployes = nbEmployes; }

    // equals(): id + nom
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement)) return false;
        Departement d = (Departement) o;
        return id == d.id &&
                Objects.equals(nomDepartement, d.nomDepartement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomDepartement);
    }

    // toString
    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nom='" + nomDepartement + '\'' +
                ", nbEmployes=" + nbEmployes +
                '}';
    }
}
