package cstjean.mobile.ecole;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cstjean.mobile.ecole.travail.CoursSession;

public class CoursSessionListAdapter extends RecyclerView.Adapter<CoursSessionViewHolder> {
    private final List<CoursSession> listeCoursSession;
    public CoursSessionListAdapter(List<CoursSession> listeCoursSession) {
        this.listeCoursSession = listeCoursSession;
    }
    @NonNull
    @Override
    public CoursSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_liste_cours, parent, false);

        return new CoursSessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursSessionViewHolder holder, int position) {
        holder.bindCoursSession(listeCoursSession.get(position), position);
    }
    @Override
    public int getItemCount() {
        return listeCoursSession.size();
    }
}

class CoursSessionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView departement;
    private final TextView numero;

    private int indexCourant;

    CoursSessionViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        departement = itemView.findViewById(R.id.item_txt_departement);
        numero = itemView.findViewById(R.id.item_txt_numero);
    }

    void bindCoursSession(CoursSession coursSession, int position) {
        indexCourant = position;
        departement.setText(coursSession.getDepartement());
        numero.setText(coursSession.getNumero());
    }

    @Override
    public void onClick(View v) {
        Intent intent = DetailsCoursActivity.newIntent(v.getContext(), indexCourant);
        v.getContext().startActivity(intent);
    }

}