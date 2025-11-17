package tn.company.services;

import tn.company.entities.Employe;
import tn.company.interfaces.IGestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employe> {

    private ArrayList<Employe> liste = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe e) {
        liste.add(e);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : liste) {
            if (e.getNom().equalsIgnoreCase(nom))
                return true;
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return liste.contains(e);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        liste.remove(e);
    }

    @Override
    public void displayEmploye() {
        for (Employe e : liste) {
            System.out.println(e);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(liste); // Comparable
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        liste.sort(new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int compNomDep = e1.getNomDepartement().compareToIgnoreCase(e2.getNomDepartement());
                if (compNomDep != 0) return compNomDep;

                return Integer.compare(e1.getGrade(), e2.getGrade());
            }
        });
    }
}
