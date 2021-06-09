package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Emas;

public class Emas_RV_Adapter extends RecyclerView.Adapter<Emas_RV_Adapter.EmasViewHolder> {

    private ArrayList<Emas> listEmas;

    public Emas_RV_Adapter(ArrayList<Emas> listEmas) {
        this.listEmas = listEmas;
    }

    @NonNull
    @Override
    public EmasViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_zakat_emas, parent, false);
        EmasViewHolder holder = new EmasViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  Emas_RV_Adapter.EmasViewHolder holder, int position) {
        holder.total_emas_textView.setText(String.valueOf(listEmas.get(position).getEmas_mentah()));
        holder.harga_emas_textView.setText(String.valueOf(listEmas.get(position).getEmas_harga()));
        int bayar = (int) ((listEmas.get(position).getEmas_mentah() - listEmas.get(position).getEmas_pakai())*0.025);
        holder.zakat_emas_textView.setText(String.valueOf(bayar));
    }

    @Override
    public int getItemCount() {
        return listEmas.size();
    }

    public class EmasViewHolder extends RecyclerView.ViewHolder {
        private TextView total_emas_textView,harga_emas_textView,zakat_emas_textView;
        public EmasViewHolder(@NonNull  View itemView) {
            super(itemView);
            total_emas_textView = itemView.findViewById(R.id.total_emas_textView);
            harga_emas_textView = itemView.findViewById(R.id.harga_emas_textView);
            zakat_emas_textView = itemView.findViewById(R.id.zakat_emas_textView);
        }
    }
}
