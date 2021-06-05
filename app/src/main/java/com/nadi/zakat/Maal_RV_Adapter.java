package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Maal;

public class Maal_RV_Adapter extends RecyclerView.Adapter<Maal_RV_Adapter.MaalViewHolder> {

    private ArrayList<Maal> listMaal;

    public Maal_RV_Adapter(ArrayList<Maal> listMaal) {
        this.listMaal = listMaal;
    }

    @NonNull
    @Override
    public MaalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_zakat_maal, parent, false);
        MaalViewHolder holder = new MaalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Maal_RV_Adapter.MaalViewHolder holder, int position) {
        holder.harta_maal_textView.setText(String.valueOf(listMaal.get(position).getHarta()));
        int bayar = (int) ((listMaal.get(position).getHarta())*0.025);
        holder.zakat_maal_textView.setText(String.valueOf(bayar));

    }

    @Override
    public int getItemCount() {
        return listMaal.size();
    }

    public class MaalViewHolder extends RecyclerView.ViewHolder {
        private TextView zakat_maal_textView, harta_maal_textView;
        public MaalViewHolder(@NonNull  View itemView) {
            super(itemView);
            harta_maal_textView = itemView.findViewById(R.id.harta_maal_textView);
            zakat_maal_textView = itemView.findViewById(R.id.zakat_maal_textView);
        }
    }
}
