package cstjean.mobile.ecole;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import cstjean.mobile.ecole.travail.Travail;

public class TravailListAdapter extends RecyclerView.Adapter<TravailViewHolder> {
    private final List<Travail> travaux;

    public TravailListAdapter(List<Travail> travaux) {
        this.travaux = travaux;
    }

    @NonNull
    @Override
    public TravailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_liste_travaux, parent, false);
        return new TravailViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TravailViewHolder holder, int position) {
        holder.bindTravail(travaux.get(position));
    }

    @Override
    public int getItemCount() {
        return travaux.size();
    }
}

class TravailViewHolder extends RecyclerView.ViewHolder {
    private final CheckBox chkComplete;
    private final TextView nomTravail;
    private final TextView dateRemise;
    private Travail travail;

    public TravailViewHolder(@NonNull View itemView) {
        super(itemView);
        chkComplete = itemView.findViewById(R.id.checkbox_termine);
        nomTravail = itemView.findViewById(R.id.txt_nom);
        dateRemise = itemView.findViewById(R.id.txt_date);

        // chkComplete.setActivated(travail.estTermine());
        chkComplete.setOnClickListener(view -> {
            this.travail.setEstTermine(chkComplete.isChecked());
        });
    }

    void bindTravail(Travail travail) {
        this.travail = travail;
        // ???
        nomTravail.setText(travail.getNom());
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        dateRemise.setText(formatDate.format(travail.getDateRemise().getTime()));
    }
}