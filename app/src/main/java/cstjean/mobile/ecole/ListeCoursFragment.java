package cstjean.mobile.ecole;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import cstjean.mobile.ecole.travail.SingletonEcole;

public class ListeCoursFragment extends Fragment {

    private static final String KEY_INDEXCOURANT = "indexcourant";
    private int indexCourant = 0;

    private ImageButton btnVoir;
    private ImageButton btnSuivant;
    private ImageButton btnPrecedent;
    private TextView txtDepartement;
    private ImageButton btnAjouter;


    public ListeCoursFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            indexCourant = savedInstanceState.getInt(KEY_INDEXCOURANT, 0);
        }

        View view = inflater.inflate(R.layout.fragment_liste_cours, container, false);

        btnVoir = view.findViewById(R.id.btn_voir);
        btnPrecedent = view.findViewById(R.id.btn_precedent);
        btnSuivant = view.findViewById(R.id.btn_suivant);
        txtDepartement = view.findViewById(R.id.txt_departement);
        btnAjouter = view.findViewById(R.id.btn_ajouter); // À AJOUTER DANS EXERCICE FORMATIF!!!!!!

        btnPrecedent.setOnClickListener(v -> {
            indexCourant -= 1;
            updateDepartement();
        });
        btnSuivant.setOnClickListener(v ->{
            indexCourant += 1;
            updateDepartement();
        });

        btnVoir.setOnClickListener(v -> {
            Intent intent = DetailsCoursActivity.newIntent(getActivity(), indexCourant);
            startActivity(intent);
        });

        btnAjouter.setOnClickListener(v -> {
            Intent intent = AjoutCoursActivity.newIntent(getActivity());
            startActivity(intent);
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ProjetEcole", "onSaveInstanceState");
        outState.putInt(KEY_INDEXCOURANT, indexCourant);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateDepartement();
    }

    private void updateDepartement() {
        String departement =
                SingletonEcole
                        .getInstance()
                        .getCoursSession(indexCourant)
                        .getDepartementNumero();
        txtDepartement.setText(departement);
        btnSuivant.setEnabled(indexCourant <
                (SingletonEcole
                        .getInstance()
                        .getNbCoursSession() - 1));
        btnPrecedent.setEnabled(indexCourant > 0);
    }

}