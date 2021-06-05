package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.InputanZakatSimpanan;

public class panggilinputzakatsimpanan extends RecyclerView.Adapter<panggilinputzakatsimpanan.inputanViewHolder> {

    private ArrayList<InputanZakatSimpanan> inputanZakatsimpanan;


    public panggilinputzakatsimpanan(ArrayList<InputanZakatSimpanan> inputanZakatsimpanan) {
        this.inputanZakatsimpanan = inputanZakatsimpanan;
    }

    @NonNull
    @Override
    public inputanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inpzakatSimpanan = layoutInflater.inflate(R.layout.tampilan_zakat_simpanan, parent, false);
        return new inputanViewHolder(inpzakatSimpanan);
    }

    @Override
    public void onBindViewHolder(@NonNull inputanViewHolder holder, int position) {
        holder.card_jmlsaldo.setText(String.valueOf(inputanZakatsimpanan.get(position).getJsaldo()));
        holder.card_bunga.setText(String.valueOf(inputanZakatsimpanan.get(position).getBungaa()));

        int  hasil = (int)((inputanZakatsimpanan.get(position).getJsaldo() + (inputanZakatsimpanan.get(position).getJsaldo() * inputanZakatsimpanan.get(position).getBungaa()))*0.025 );
        holder.card_hasilZakattabungan.setText(String.valueOf(hasil));



    }

    @Override
    public int getItemCount() {
        return inputanZakatsimpanan.size();
    }

    public class inputanViewHolder extends RecyclerView.ViewHolder {
        private ImageView card_iview;
        private TextView card_jmlsaldo, card_bunga,  card_hasilZakattabungan;
        public inputanViewHolder(@NonNull View itemView) {
            super(itemView);
            card_iview = itemView.findViewById(R.id.card_iview);
            card_jmlsaldo = itemView.findViewById(R.id.card_jmlsaldo);
            card_bunga = itemView.findViewById(R.id.card_bunga);
            card_hasilZakattabungan = itemView.findViewById(R.id.card_hasilZakattabungan);
        }
    }

}
