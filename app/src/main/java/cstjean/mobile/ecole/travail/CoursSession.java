package cstjean.mobile.ecole.travail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoursSession implements Comparable<CoursSession> {
    private final String departement;
    private final String numero;
    private static int compteur = 0;

    private URL url;

    private final List<Travail> travaux = new ArrayList<>();

    public CoursSession(String departement, String numero) {
        if (!NumeroCoursUtil.estNumeroCoursValide(numero))
            throw new IllegalArgumentException();


        this.departement = departement;
        this.numero = numero;

        compteur++;
    }

    public String getDepartement() {
        return departement;
    }

    public String getNumero() {
        return numero;
    }

    public int getNbTravaux() {
        return travaux.size();
    }

    public void ajouterTravail(Travail travail) {
        travaux.add(travail);
    }

    public Travail getTravail(int index) {
        return travaux.get(index);
    }

    public List<Travail> getListeTravaux() { return travaux;}

    public static int getCompteur() {
        return CoursSession.compteur;
    }


    // ...
    public URL getUrl() {
        return url;
    }

    public void setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
    }


    public static void resetCompteur() {
        compteur = 0;
    }

    @Override
    public int compareTo(CoursSession o) {
        int compareDepartement = getDepartement().compareTo(o.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }
        return getNumero().compareTo(o.getNumero());
    }

    public String getDepartementNumero() {
        return departement + " " + numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursSession that = (CoursSession) o;
        return departement.equals(that.departement) && numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departement, numero);
    }
}
