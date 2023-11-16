package cstjean.mobile.ecole.travail;

import static org.junit.Assert.*;
import static org.junit.Test.*;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestTravailEquipe extends TestTravail {
    @Test
    public void testAjoutCoequipiers() {
        TravailEquipe travail = (TravailEquipe) creerTravail("TP1",
                new GregorianCalendar(2023, Calendar.SEPTEMBER, 20));

        int da1 = 123456;
        String nomCoequipier1 = "Coéquipier 1";
        travail.ajouterCoequipier(da1, nomCoequipier1);
        assertEquals(nomCoequipier1, travail.getCoequipier(da1));

        int da2 = 789011;
        String nomCoequipier2 = "Coéquipier 1";
        travail.ajouterCoequipier(da2, nomCoequipier2);
        assertEquals(nomCoequipier2, travail.getCoequipier(da2));

        assertEquals(nomCoequipier1, travail.getCoequipier(da1));

    }

    @Override
    protected Travail creerTravail(String nom, Calendar dateRemise) {
        TravailEquipe travail = new TravailEquipe(nom, dateRemise);
        travail.ajouterCoequipier(12345, "Alex");
        return travail;
    }

}
