package cstjean.mobile.ecole.travail.rapport;

import static org.junit.Assert.*;

import org.junit.Test;

import cstjean.mobile.ecole.travail.*;
import cstjean.mobile.ecole.travail.rapport.*;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestRapportTravaux {
    @Test
    public void testRapportTravaux() {

        CoursSession coursSession = new CoursSession("Philo", "101");
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 15);

        Travail travail1 = new Travail("TP1", dateRemise);
        Travail travail2 = new Travail("TP2", dateRemise);

        coursSession.ajouterTravail(travail1);
        coursSession.ajouterTravail(travail2);

        String rapportTravaux = RapportTravaux.getRapportTravaux(coursSession);

        assertEquals(RapportTravaux.ENTETE_RAPPORT_TRAVAUX +
                "TP1 - 2023-09-15" + RapportTravaux.SAUT_LIGNE +
                "TP2 - 2023-09-15" + RapportTravaux.SAUT_LIGNE +
                "Total : 2" +
                RapportTravaux.PIEDPAGE_RAPPORT_TRAVAUX, rapportTravaux);
    }

}
