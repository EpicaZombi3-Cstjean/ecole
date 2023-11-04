package cstjean.mobile.ecole.travail;

import static org.junit.Assert.*;

import org.junit.*;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import cstjean.mobile.ecole.travail.*;

public class TestCoursSession {

    private CoursSession coursSession;
    @Before
    public  void setUp() {
        coursSession = new CoursSession("Philo", "101");
    }
    @Test
    public void testCreer() {
        assertEquals("Philo", coursSession.getDepartement());
        assertEquals("101", coursSession.getNumero());
        assertEquals("Philo 101", coursSession.getDepartementNumero());
        assertEquals(0, coursSession.getNbTravaux());
    }
    @Test
    public void testAjoutTravail() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 13);

        Travail travail1 = new Travail("TP1", dateRemise);
        coursSession.ajouterTravail(travail1);
        assertEquals(1, coursSession.getNbTravaux());
        assertEquals(travail1, coursSession.getTravail(0));

        Travail travail2 = new Travail("TP2", dateRemise);
        coursSession.ajouterTravail(travail2);
        assertEquals(2, coursSession.getNbTravaux());
        assertEquals(travail1, coursSession.getTravail(0));
        assertEquals(travail2, coursSession.getTravail(1));
    }
    @Test
    public void testCompteur() {
        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(1, CoursSession.getCompteur());

        new CoursSession("Anglais", "103");
        assertEquals(2, CoursSession.getCompteur());

        new CoursSession("Anglais", "101");
        assertEquals(3, CoursSession.getCompteur());

        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());

    }

    @Test
    public void testCompare() {
        assertEquals(0, coursSession.compareTo(new CoursSession("Philo", "101")));
        assertTrue(coursSession.compareTo(new CoursSession("Philo", "201")) < 0);
        assertTrue(coursSession.compareTo(new CoursSession("Maths", "101")) > 0);

    }

    @Test
    public void testURL() throws MalformedURLException {
        final String url = "https://www.cstjean.qc.ca/philo101";
        coursSession.setUrl(url);
        assertEquals(url, coursSession.getUrl().toString());
    }

    @Test
    public void testURLInvalidejUnit3() {
        final String url = "://www.cstjean.qc.ca/philo101";
        try {
            coursSession.setUrl(url);
            fail("Devrait avoir une exception");
        } catch (MalformedURLException e) {
            // Succès inattendu...
        }
    }
    @Test(expected = MalformedURLException.class)
    public void testURLInvalidejUnit4() throws MalformedURLException{
        final String url = "://www.cstjean.qc.ca/philo101\"";
        coursSession.setUrl(url);
    }

    @Test
    public void testNumeroCours() { // devrait maybe être changé
        CoursSession nouveauCours1 = new CoursSession("Anglais", "1A3");
        CoursSession nouveauCours2 = new CoursSession("Anglais", "113");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumeroCoursInvalide() {
        CoursSession nouveauCours3 = new CoursSession("Anglais", "1AA");
    }
}
