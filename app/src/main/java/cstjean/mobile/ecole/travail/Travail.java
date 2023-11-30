package cstjean.mobile.ecole.travail;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Objects;

public class Travail implements Cloneable{
    private final String nom;
    private Calendar dateRemise;

    private boolean estTermine = false;
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

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Travail clone = (Travail) super.clone();
        clone.dateRemise = (Calendar) dateRemise.clone();
        return clone;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travail travail = (Travail) o;
        return nom.equals(travail.nom) && dateRemise.equals(travail.dateRemise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, dateRemise);
    }


    public boolean estTermine() {
        return estTermine;
    }

    public void setEstTermine(boolean estTermine) {
        this.estTermine = estTermine;
    }
}
