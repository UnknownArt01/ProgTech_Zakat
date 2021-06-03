package com.nadi.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.maal;

public class Maal_RV_Adapter extends RecyclerView.Adapter<Maal_RV_Adapter.MaalViewHolder>{
    private ArrayList<maal> zakat_maal;

    public Maal_RV_Adapter(ArrayList<maal> zakat_maal) {
        this.zakat_maal = zakat_maal;
    }

    @NonNull
    @Override
    public MaalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.maal_output, parent, false);
        return new MaalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Maal_RV_Adapter.MaalViewHolder holder, int position) {
        holder.Harta_EditText.setText(zakat_maal.get(position).getHarta());
        holder.jumlah_maal_TextView.setText(zakat_maal.get(position).getJumlah_mall());
    }

    @Override
    public int getItemCount() {
        return zakat_maal.size();
    }

    public class MaalViewHolder extends RecyclerView.ViewHolder {
        private EditText Harta_EditText;
        private TextView jumlah_maal_TextView;
        public MaalViewHolder(@NonNull View itemView) {
            super(itemView);
            Harta_EditText = itemView.findViewById(R.id.Harta_EditText);
            jumlah_maal_TextView = itemView.findViewById(R.id.jumlah_maal_TextView);
        }
    }

}
