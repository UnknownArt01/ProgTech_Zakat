package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.InputanZakatProfesi;

public class panggilinputzakatprofesi extends RecyclerView.Adapter<panggilinputzakatprofesi.inputanViewHolder>{

    private ArrayList<InputanZakatProfesi> inputanZakatProfesi;

    public panggilinputzakatprofesi(ArrayList<InputanZakatProfesi> inputanZakatProfesi) {
        this.inputanZakatProfesi = inputanZakatProfesi;
    }

    @NonNull
    @Override
    public panggilinputzakatprofesi.inputanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inpzakatprof = layoutInflater.inflate(R.layout.tampilan_zakat_profesi, parent, false);
        return new inputanViewHolder(inpzakatprof);

    }

    @Override
    public void onBindViewHolder(@NonNull panggilinputzakatprofesi.inputanViewHolder holder, int position) {
        holder.card_penghasilanperbulan.setText(String.valueOf(inputanZakatProfesi.get(position).getPenghasilanperbulan()));
        holder.card_penghasilantambahan.setText(String.valueOf(inputanZakatProfesi.get(position).getPenghasilantambahan()));
        holder.card_cicilandanpokok.setText(String.valueOf(inputanZakatProfesi.get(position).getCicilandanpokok()));

        int  hasil = (int)((inputanZakatProfesi.get(position).getPenghasilanperbulan() + inputanZakatProfesi.get(position).getPenghasilantambahan() - inputanZakatProfesi.get(position).getCicilandanpokok() )* 0.025);
        holder.card_hasil.setText(String.valueOf(hasil));



    }

    @Override
    public int getItemCount() {
        return inputanZakatProfesi.size();
    }

    public class inputanViewHolder extends RecyclerView.ViewHolder {
        private ImageView card_image;
        private TextView card_penghasilanperbulan, card_penghasilantambahan, card_cicilandanpokok, card_hasil;
        public inputanViewHolder(@NonNull View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            card_penghasilanperbulan = itemView.findViewById(R.id.card_penghasilanperbulan);
            card_penghasilantambahan = itemView.findViewById(R.id.card_penghasilantambahan);
            card_cicilandanpokok = itemView.findViewById(R.id.card_cicilandanpokok);
            card_hasil = itemView.findViewById(R.id.card_hasil);



        }
    }
}
