package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Perdagangan;

public class Perdagangan_RV_Adapter extends RecyclerView.Adapter<Perdagangan_RV_Adapter.PerdaganganViewHolder> {

    private ArrayList<Perdagangan> listPerdagangan;

    public Perdagangan_RV_Adapter(ArrayList<Perdagangan> listPerdagangan) {
        this.listPerdagangan = listPerdagangan;
    }

    @NonNull
    @Override
    public PerdaganganViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_zakat_perdagangan, parent, false);
        Perdagangan_RV_Adapter.PerdaganganViewHolder holder = new Perdagangan_RV_Adapter.PerdaganganViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  Perdagangan_RV_Adapter.PerdaganganViewHolder holder, int position) {
        int harta = listPerdagangan.get(position).getModal() + listPerdagangan.get(position).getKeuntungan() + listPerdagangan.get(position).getPiutang();
        holder.harta_textView.setText(String.valueOf(harta));
        int kerugian = listPerdagangan.get(position).getKerugian() + listPerdagangan.get(position).getHutang();
        holder.kerugian_textView.setText(String.valueOf(kerugian));
        int bayar = (int) ((harta - kerugian) * 0.025);
        holder.zakat_perdagangan_textView.setText(String.valueOf(bayar));
    }

    @Override
    public int getItemCount() {
        return listPerdagangan.size();
    }

    public class PerdaganganViewHolder extends RecyclerView.ViewHolder {
        private TextView harta_textView, kerugian_textView, zakat_perdagangan_textView;
        public PerdaganganViewHolder(@NonNull  View itemView) {
            super(itemView);
            harta_textView = itemView.findViewById(R.id.harta_textView);
            kerugian_textView = itemView.findViewById(R.id.kerugian_textView);
            zakat_perdagangan_textView = itemView.findViewById(R.id.zakat_perdagangan_textView);
        }
    }
}
