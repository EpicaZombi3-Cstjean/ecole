package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.google.android.material.badge.BadgeDrawable;

import org.junit.Before;
import org.junit.Test;
public class TestSingletonEcole {

    private SingletonEcole singleton;

    @Before
    public void setUp() {
        singleton = SingletonEcole.getInstance();
        singleton.reset();
    }
    @Test
    public void testInstance() {
        SingletonEcole singleton1 = SingletonEcole.getInstance();
        SingletonEcole singleton2 = SingletonEcole.getInstance();
        assertSame(singleton1, singleton2);
    }

    @Test
    public void testAjoutCours() {
        CoursSession cours1 = new CoursSession("Philo", "101");
        singleton.ajouterCoursSession(cours1);
        assertEquals(1, singleton.getNbCoursSession());
        assertEquals(cours1, singleton.getCoursSession(0));

        CoursSession cours2 = new CoursSession("Philo", "101");
        singleton.ajouterCoursSession(cours2);
        assertEquals(2, singleton.getListeCoursSession().size());
        assertEquals(cours1, singleton.getCoursSession(0));
        assertEquals(cours2, singleton.getCoursSession(1));
    }
}

