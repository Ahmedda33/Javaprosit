package tn.company.main;
import tn.company.entities.Employe;
import tn.company.entities.Departement;
import tn.company.services.AffectationHashMap;
import tn.company.services.SocieteArrayList;
import tn.company.services.DepartementHashSet;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        AffectationHashMap affectation = new AffectationHashMap();

        Departement d1 = new Departement(1, "IT", 10);
        Departement d2 = new Departement(2, "HR", 5);

        Employe e1 = new Employe(101, "Alice", "Dupont", d1.getNomDepartement(), 3);
        Employe e2 = new Employe(102, "Bob", "Martin", d2.getNomDepartement(), 2);

        // Assign employees
        affectation.ajouterEmployeDepartement(e1, d1);
        affectation.ajouterEmployeDepartement(e2, d2);

        // Try assigning the same employee to another department
        affectation.ajouterEmployeDepartement(e1, d2); // Will update department

        // Display assignments
        affectation.afficherEmployesEtDepartements();

        // Remove employee
        affectation.supprimerEmploye(e2);
        affectation.afficherEmployesEtDepartements();

        // Display sorted TreeMap
        System.out.println("Sorted map:");
        TreeMap<Employe, Departement> sorted = affectation.trierMap();
        sorted.forEach((emp, dep) -> System.out.println(emp + " -> " + dep));
    }
}
