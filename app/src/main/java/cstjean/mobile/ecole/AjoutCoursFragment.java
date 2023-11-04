package cstjean.mobile.ecole;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class AjoutCoursFragment extends Fragment {

    Button btnAjouter;

    TextInputEditText inputDepartement;
    TextInputEditText inputNumero;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ajout_cours, container, false) ;

        btnAjouter = view.findViewById(R.id.btn_ajouter);
        inputDepartement = view.findViewById(R.id.input_departement);
        inputNumero = view.findViewById(R.id.input_numero);

        btnAjouter.setOnClickListener(v -> {

            CoursSession coursSession = new CoursSession(inputDepartement.getText().toString(),
                    inputNumero.getText().toString());

            Log.d("bruh", "fuck");
            SingletonEcole.getInstance().ajouterCoursSession(coursSession);

            getActivity().finish();
        });

        return view;
    }


}