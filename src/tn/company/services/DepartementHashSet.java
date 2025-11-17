package tn.company.services;

import tn.company.entities.Departement;
import tn.company.interfaces.IDepartement;

import java.util.HashSet;
import java.util.TreeSet;

public class DepartementHashSet implements IDepartement<Departement> {

    private HashSet<Departement> liste = new HashSet<>();

    @Override
    public void ajouterDepartement(Departement d) {
        liste.add(d);
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        for (Departement d : liste) {
            if (d.getNomDepartement().equalsIgnoreCase(nom))
                return true;
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return liste.contains(d);
    }

    @Override
    public void supprimerDepartement(Departement d) {
        liste.remove(d);
    }

    @Override
    public void displayDepartement() {
        for (Departement d : liste) {
            System.out.println(d);
        }
    }

    @Override
    public TreeSet<Departement> trierDepartementById() {
        TreeSet<Departement> ts = new TreeSet<>(
                (d1, d2) -> Integer.compare(d1.getId(), d2.getId()) // Comparator Lambda
        );
        ts.addAll(liste);
        return ts;
    }
}
