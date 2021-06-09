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

import model.InputanZakatSimpanan;
import model.Loading;
import model.Rikaz_Guide;
import model.Simpanan_Guide;

public class hitungzakatsimpanan extends AppCompatActivity {

    private TextInputLayout textInputzakatsaldo, textInputbunga;
    private Button button_simpanan;
    int saldoakhir, hasilll;
    double bunga;
    private ImageView back_simpanan_imageView, question_simpanan_imageView;
    private Loading loading = new Loading(hitungzakatsimpanan.this);
    private Simpanan_Guide simpanan_guide= new Simpanan_Guide(hitungzakatsimpanan.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungzakatsimpanan);

        getSupportActionBar().hide();

        initView();
        setListener();

    }
    private void setListener() {
        button_simpanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saldoakhir = Integer.parseInt(textInputzakatsaldo.getEditText().getText().toString().trim());
                bunga = Double.parseDouble(textInputbunga.getEditText().getText().toString().trim());

                InputanZakatSimpanan temppp = new InputanZakatSimpanan(saldoakhir, bunga, hasilll);
                Intent intensss = new Intent();
                intensss.putExtra("jumlahinputsimpanan", temppp);
                setResult(80, intensss);
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat Tabungan Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
        back_simpanan_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), listinputzakatsimpanan.class);
                startActivity(intback);
                finish();
            }
        });
        question_simpanan_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanan_guide.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simpanan_guide.dismiss();
                    }
                },5000);
            }
        });
    }

    private void initView() {
        textInputzakatsaldo = findViewById(R.id.textInputzakatsaldo);
        textInputbunga = findViewById(R.id.textInputbunga);
        button_simpanan = findViewById(R.id.button_simpanan);
        back_simpanan_imageView = findViewById(R.id.back_simpanan_imageView);
    }


}