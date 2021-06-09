package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.Fitrah_Guide;
import model.InputanZakatFitrah;
import model.InputanZakatProfesi;
import model.Loading;

public class hitungzakatfitrahumum extends AppCompatActivity {

    private TextInputLayout textInputhargaberasaatini;
    private Button button_hitung_fitrah;
    int hargaberas, hasillll;
    private ImageView back_fitrah_imageView, question_fitrah_imageView;
    private Loading loading = new Loading(hitungzakatfitrahumum.this);
    private Fitrah_Guide fitrah_guide = new Fitrah_Guide(hitungzakatfitrahumum.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungzakatfitrahumum);

        getSupportActionBar().hide();

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
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat Fitrah Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
        back_fitrah_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), listinputzakatfitrah.class);
                startActivity(intback);
                finish();
            }
        });
        question_fitrah_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fitrah_guide.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fitrah_guide.dismiss();
                    }
                },5000);
            }
        });
    }
    private void initView() {

        textInputhargaberasaatini = findViewById(R.id.textInputhargaberasaatini);
        button_hitung_fitrah = findViewById(R.id.button_hitung_fitrah);
        back_fitrah_imageView = findViewById(R.id.back_fitrah_imageView);
        question_fitrah_imageView = findViewById(R.id.question_fitrah_imageView);
        //  textViewhasil = findViewById(R.id.textViewhasil);
        // card_hasil = findViewById(R.id.card_hasil);


    }
}