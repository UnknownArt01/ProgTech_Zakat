package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.InputanZakatTemuan;

public class panggilinputzakatrikaz extends RecyclerView.Adapter<panggilinputzakatrikaz.inputanViewHolder> {

    private ArrayList<InputanZakatTemuan> inputanZakatemuan;


    public panggilinputzakatrikaz(ArrayList<InputanZakatTemuan> inputanZakatemuan) {
        this.inputanZakatemuan = inputanZakatemuan;
    }

    @NonNull
    @Override
    public panggilinputzakatrikaz.inputanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inpzakatrikazz = layoutInflater.inflate(R.layout.tampilan_zakat_temuan, parent, false);
        return new inputanViewHolder(inpzakatrikazz);
    }

    @Override
    public void onBindViewHolder(@NonNull panggilinputzakatrikaz.inputanViewHolder holder, int position) {
        holder.card_harga.setText(String.valueOf(inputanZakatemuan.get(position).getPerkiraanharga()));

        int  hasil = (int)(( inputanZakatemuan.get(position).getPerkiraanharga()*0.2 ));
        holder.card_hasilhitungrikaz.setText(String.valueOf(hasil));


    }

    @Override
    public int getItemCount() {
        return inputanZakatemuan.size();
    }

    public class inputanViewHolder extends RecyclerView.ViewHolder {
        private ImageView card_imageView;
        private TextView card_harga, card_hasilhitungrikaz;
        public inputanViewHolder(@NonNull View itemView) {
            super(itemView);
            card_imageView = itemView.findViewById(R.id.card_imageView);
            card_harga = itemView.findViewById(R.id.card_harga);
            card_hasilhitungrikaz = itemView.findViewById(R.id.card_hasilhitungrikaz);
        }
    }

}
