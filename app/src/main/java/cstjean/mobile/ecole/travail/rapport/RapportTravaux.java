package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;

import java.text.SimpleDateFormat;

public class RapportTravaux extends Rapport{
    public static final String ENTETE_RAPPORT_TRAVAUX = "---------- Travaux ----------" + SAUT_LIGNE;
    public static final String PIEDPAGE_RAPPORT_TRAVAUX = SAUT_LIGNE + "------------------------------";

    public static String getRapportTravaux(CoursSession coursSession) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

        StringBuilder builder = new StringBuilder();

        builder.append(ENTETE_RAPPORT_TRAVAUX);

        for(int i = 0; i < coursSession.getNbTravaux(); i++) {
            Travail travail = coursSession.getTravail(i);


            builder.append(travail.getNom())
                    .append(" - ")
                    .append(formatDate.format(travail.getDateRemise().getTime()))
                    .append(SAUT_LIGNE);

        }
        builder.append("Total : ")
                .append(coursSession.getNbTravaux())
                .append(PIEDPAGE_RAPPORT_TRAVAUX);

        return builder.toString();
    }
}
