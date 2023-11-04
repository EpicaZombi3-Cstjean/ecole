package cstjean.mobile.ecole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;
import cstjean.mobile.ecole.travail.rapport.RapportTravaux;

public class DetailsCoursActivity extends AppCompatActivity
        implements DetailsCoursFragment.Callbacks {

    private static final String EXTRA_INDEXCOURANT = "indexcourant";

    private TextView txtDepartement;
    private TextView txtNumero;
    private TextView txtTravaux;
    private int indexCourant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_cours);
    }

    public static Intent newIntent(Context packageContext, int indexCourant) {
        Intent intent = new Intent(packageContext, DetailsCoursActivity.class);
        intent.putExtra(EXTRA_INDEXCOURANT, indexCourant);
        return intent;
    }

    @Override
    public int getIndexCourant() {
        return indexCourant;
    }
}