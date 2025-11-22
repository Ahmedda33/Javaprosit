package tn.company.services;

import tn.company.entities.Employe;
import tn.company.entities.Departement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class AffectationHashMap {

    // Instruction 1: HashMap to store Employee -> Department
    private HashMap<Employe, Departement> affectations = new HashMap<>();

    // Instruction 2: Assign an employee to a department
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d); // If employee exists, department will be updated
    }

    // Instruction 3: Display all employees and their departments
    public void afficherEmployesEtDepartements() {
        System.out.println("Liste des affectations Employé -> Département :");
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Instruction 4: Remove an employee
    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }

    // Instruction 5: Remove an employee only if assigned to a specific department
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
        }
    }

    // Instruction 6: Display all employees
    public void afficherEmployes() {
        System.out.println("Liste des employés :");
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    // Instruction 7: Display all departments
    public void afficherDepartements() {
        System.out.println("Liste des départements :");
        HashSet<Departement> deps = new HashSet<>(affectations.values());
        for (Departement d : deps) {
            System.out.println(d);
        }
    }

    // Instruction 8: Search for an employee
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    // Instruction 9: Search for a department
    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    // Instruction 10: Return a TreeMap sorted by Employee ID
    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> sortedMap = new TreeMap<>();
        sortedMap.putAll(affectations); // TreeMap will use Employe.compareTo() (by ID)
        return sortedMap;
    }
}
