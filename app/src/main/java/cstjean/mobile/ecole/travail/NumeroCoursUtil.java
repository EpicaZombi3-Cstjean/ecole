package cstjean.mobile.ecole.travail;

public class NumeroCoursUtil {

    public static boolean estNumeroCoursValide(String numero) {

        return numero.matches("[0-9][0-9A-Z][0-9]");

    }

}
