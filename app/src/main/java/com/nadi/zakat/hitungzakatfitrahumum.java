package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.InputanZakatFitrah;
import model.InputanZakatProfesi;

public class hitungzakatfitrahumum extends AppCompatActivity {

    private TextInputLayout textInputhargaberasaatini;
    private Button button_hitung_fitrah;
    int hargaberas, hasillll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungzakatfitrahumum);
        initView();
        setListener();
    }

    private void setListener() {


        button_hitung_fitrah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hargaberas = Integer.parseInt(textInputhargaberasaatini.getEditText().getText().toString().trim());

                InputanZakatFitrah tempppp = new InputanZakatFitrah(hargaberas, hasillll);
                Intent inn = new Intent();
                inn.putExtra("jumlahinputfitrah", tempppp);
                setResult(40, inn);
                finish();
                Toast.makeText(getApplicationContext(), "Zakat Fitrah Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView() {

        textInputhargaberasaatini = findViewById(R.id.textInputhargaberasaatini);
        button_hitung_fitrah = findViewById(R.id.button_hitung_fitrah);
        //  textViewhasil = findViewById(R.id.textViewhasil);
        // card_hasil = findViewById(R.id.card_hasil);


    }
}