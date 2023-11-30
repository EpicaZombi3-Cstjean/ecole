package cstjean.mobile.ecole.travail;

import static org.junit.Assert.*;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestTravail {
    @Test
    public void testCreer() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 13);

        String nomTravail1 = "TP1";
        Travail travail1 = creerTravail(nomTravail1, dateRemise);
        assertEquals(travail1.getNom(), nomTravail1);
        assertEquals(dateRemise, travail1.getDateRemise());

        assertFalse(travail1.estTermine());

        Travail travail2 = creerTravail("TP2", dateRemise);
        String nomTravail2 = travail2.getNom();
        assertEquals("TP2", nomTravail2);
        assertEquals(dateRemise, travail2.getDateRemise());

        travail1.setEstTermine(true);

        assertTrue(travail1.estTermine());

    }


    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new Travail(nom, dateRemise);
    }


    @Test
    public void testClone() throws CloneNotSupportedException {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);
        Travail travail = creerTravail("TP1", dateRemise);
        Travail clone = (Travail) travail.clone();
        assertNotSame(travail, clone);
        assertEquals(travail.getClass(), clone.getClass());
        assertEquals(travail, clone);
    }


    @Test
    public void testEgalite() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);

        Travail travailA = creerTravail("TP1", dateRemise);
        Travail travailB = creerTravail("TP1", dateRemise);
        assertEquals(travailA, travailB);

        Travail travailC = creerTravail("TP2", dateRemise);
        assertNotEquals(travailA, travailC);

        // Réflexivité
        assertEquals(travailA, travailA);
        assertEquals(travailB, travailA);

        // Transitivité
        Travail travailD = creerTravail("TP1", dateRemise);
        assertEquals(travailB, travailD);
        assertEquals(travailA, travailD);

        // Constance
        assertEquals(travailA, travailB);

        // Comparaison à null
        // LINT : jUnit n'appelle pas le equal si on envoit null donc on veut comparer directement
        // On veut vraiment tester le null ici...
        assertFalse(travailA.equals(null));

        // Validation
        assertNotEquals("BLABLABLA", travailA);

    }

    @Test
    public void testHashCode() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);

        Travail travailA = creerTravail("TP1", dateRemise);
        Travail travailB = creerTravail("TP1", dateRemise);
        assertEquals(travailA.hashCode(), travailB.hashCode());
        assertEquals(travailA.hashCode(), travailA.hashCode());
    }
}
