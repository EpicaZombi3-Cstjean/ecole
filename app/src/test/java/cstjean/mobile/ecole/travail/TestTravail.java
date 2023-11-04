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

        Travail travail2 = creerTravail("TP2", dateRemise);
        String nomTravail2 = travail2.getNom();
        assertEquals("TP2", nomTravail2);
        assertEquals(dateRemise, travail2.getDateRemise());

    }


    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new Travail(nom, dateRemise);
    }
}
