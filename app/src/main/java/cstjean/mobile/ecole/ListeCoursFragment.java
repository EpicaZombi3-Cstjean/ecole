package cstjean.mobile.ecole;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.TextView;

import java.util.List;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class ListeCoursFragment extends Fragment {

    private ImageButton btnAjouter;

    private RecyclerView recyclerViewCours;

    private CoursSessionListAdapter adapterCoursSession;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_liste_cours, container, false);

        recyclerViewCours = view.findViewById(R.id.recycler_view_cours);
        recyclerViewCours.setLayoutManager(new LinearLayoutManager(getActivity()));


        btnAjouter = view.findViewById(R.id.btn_ajouter); // À AJOUTER DANS EXERCICE FORMATIF!!!!!!

        btnAjouter.setOnClickListener(v -> {
            Intent intent = AjoutCoursActivity.newIntent(getActivity());
            startActivity(intent);
        });

        SingletonEcole singletonEcole = SingletonEcole.getInstance();
        List<CoursSession> listeCoursSession = singletonEcole.getListeCoursSession();

        adapterCoursSession = new CoursSessionListAdapter(listeCoursSession);
        recyclerViewCours.setAdapter(adapterCoursSession);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ProjetEcole", "onSaveInstanceState");
    }

    @Override
    public void onResume() {
        super.onResume();
        SingletonEcole singletonEcole = SingletonEcole.getInstance();
        List<CoursSession> listeCoursSession = singletonEcole.getListeCoursSession();
        adapterCoursSession = new CoursSessionListAdapter(listeCoursSession);
        recyclerViewCours.setAdapter(adapterCoursSession);
    }
}