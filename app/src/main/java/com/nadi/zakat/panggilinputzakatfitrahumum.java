package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.InputanZakatFitrah;
import model.InputanZakatProfesi;

public class panggilinputzakatfitrahumum extends RecyclerView.Adapter<panggilinputzakatfitrahumum.inputanViewHolder> {

    ArrayList<InputanZakatFitrah> inputanZakatfitrahum;

    public panggilinputzakatfitrahumum(ArrayList<InputanZakatFitrah> inputanZakatfitrahum) {
        this.inputanZakatfitrahum = inputanZakatfitrahum;
    }

    @NonNull
    @Override
    public panggilinputzakatfitrahumum.inputanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inpzakatftr = layoutInflater.inflate(R.layout.tampilan_zakat_fitrah, parent, false);
        return new panggilinputzakatfitrahumum.inputanViewHolder(inpzakatftr);

    }

    @Override
    public void onBindViewHolder(@NonNull panggilinputzakatfitrahumum.inputanViewHolder holder, int position) {
        holder.card_hargaberas.setText(String.valueOf(inputanZakatfitrahum.get(position).getHargaberas()));

        int  hasillll = (int)(inputanZakatfitrahum.get(position).getHargaberas() * 3.5);
        holder.card_hasillll.setText(String.valueOf(hasillll));



    }

    @Override
    public int getItemCount() {
        return inputanZakatfitrahum.size();
    }

    public class inputanViewHolder extends RecyclerView.ViewHolder {
        private ImageView card_image;
        private TextView card_hargaberas, card_hasillll;
        public inputanViewHolder(@NonNull View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            card_hargaberas = itemView.findViewById(R.id.card_hargaberas);
            card_hasillll = itemView.findViewById(R.id.card_hasillll);



        }
    }
}
