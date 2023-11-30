package cstjean.mobile.ecole.travail;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
public class SingletonEcole {
    private static SingletonEcole instance = null;
    private final List<CoursSession> listeCoursSession = new ArrayList<>();
    private SingletonEcole() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 10);
        // Données de tests
        CoursSession cours = new CoursSession("Philo", "101");
        cours.ajouterTravail(new Travail("TP1", dateRemise));
        listeCoursSession.add(cours);
        listeCoursSession.add(new CoursSession("Philo", "210"));
        listeCoursSession.add(new CoursSession("Math", "101"));
        listeCoursSession.add(new CoursSession("Français", "101"));
    }
    public static SingletonEcole getInstance() {
        if (instance == null) {
            instance = new SingletonEcole();
        }
        return instance;
    }
    public CoursSession getCoursSession(int index) {
        return listeCoursSession.get(index);
    }

    public void ajouterCoursSession(CoursSession coursSession) {
        listeCoursSession.add(coursSession);
    }

    public List<CoursSession> getListeCoursSession() {
        return listeCoursSession;
    }
    public int getNbCoursSession() {
        return listeCoursSession.size();
    }

    public void reset() {
        listeCoursSession.clear();
    }



}