package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Perak;

public class Perak_RV_Adapter extends RecyclerView.Adapter<Perak_RV_Adapter.PerakViewHolder> {

    private ArrayList<Perak> listPerak;

    public Perak_RV_Adapter(ArrayList<Perak> listPerak) {
        this.listPerak = listPerak;
    }

    @NonNull
    @Override
    public PerakViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_zakat_perak, parent, false);
        PerakViewHolder holder = new PerakViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  Perak_RV_Adapter.PerakViewHolder holder, int position) {
        holder.perak_textView.setText(String.valueOf(listPerak.get(position).getPerak()));
        holder.harga_perak_textView.setText(String.valueOf(listPerak.get(position).getHarga_perak()));
        int bayar = (int)((listPerak.get(position).getHarga_perak()*listPerak.get(position).getPerak())*0.025);
        holder.zakat_perak_textView.setText(String.valueOf(bayar));

    }

    @Override
    public int getItemCount() {
        return listPerak.size();
    }

    public class PerakViewHolder extends RecyclerView.ViewHolder {
        private TextView perak_textView,harga_perak_textView,zakat_perak_textView;
        public PerakViewHolder(@NonNull  View itemView) {
            super(itemView);
            perak_textView = itemView.findViewById(R.id.perak_textView);
            harga_perak_textView = itemView.findViewById(R.id.harga_perak_textView);
            zakat_perak_textView = itemView.findViewById(R.id.zakat_perak_textView);
        }
    }
}
