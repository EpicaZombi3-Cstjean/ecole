package cstjean.mobile.ecole.travail;

import java.util.Calendar;

public class Travail {
    private final String nom;
    private final Calendar dateRemise;

    public Travail(String nom, Calendar dateRemise) {
        this.nom = nom;
        this.dateRemise = dateRemise;
    }

    public String getNom() {
        return nom;
    }

    public Calendar getDateRemise() {
        return dateRemise;
    }

}
