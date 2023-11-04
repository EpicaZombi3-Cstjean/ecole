package cstjean.mobile.ecole.travail;


import cstjean.mobile.ecole.travail.rapport.TestRapportCours;
import cstjean.mobile.ecole.travail.rapport.TestRapportTravaux;
import junit.framework.TestSuite;


import org.junit.runners.Suite;
import org.junit.runner.RunWith;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestTravail.class,
        TestCoursSession.class,
        TestRapportTravaux.class,
        TestRapportCours.class,
        TestTravailEquipe.class,

        TestNumeroCoursUtil.class,
})

public class TestComplet {

}
