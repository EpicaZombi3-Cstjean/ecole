package cstjean.mobile.ecole.travail;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class TravailEquipe extends Travail{

    private final Map<Integer, String> coequipiers = new LinkedHashMap<>();
    public TravailEquipe(String nom, Calendar dateRemise) {
        super(nom, dateRemise);
    }

    void ajouterCoequipier(int da, String nomCoequipier) {
        coequipiers.put(da, nomCoequipier);
    }

    String getCoequipier(int da) {
        return coequipiers.get(da);
    }
}
