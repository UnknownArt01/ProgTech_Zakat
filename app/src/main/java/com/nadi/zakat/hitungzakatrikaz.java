package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.InputanZakatTemuan;
import model.Loading;

public class hitungzakatrikaz extends AppCompatActivity {

    private TextInputLayout textInputhargabarangtemuan;
    private Button button_hitung_Rikaz;
    int hargabarangtemuan,hasill;
    private Loading loading = new Loading(hitungzakatrikaz.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungzakatrikaz);

        initView();
        setListener();

    }
    private void setListener() {
        button_hitung_Rikaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hargabarangtemuan = Integer.parseInt(textInputhargabarangtemuan.getEditText().getText().toString().trim());

                InputanZakatTemuan tempp = new InputanZakatTemuan(hargabarangtemuan, hasill);
                Intent intenss = new Intent();
                intenss.putExtra("jumlahinputrikaz", tempp);
                setResult(100, intenss);
                loading.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismiss();
                        finish();
                    }
                },1000);
                Toast.makeText(getApplicationContext(), "Zakat Temuan Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        textInputhargabarangtemuan = findViewById(R.id.textInputhargabarangtemuan);
        button_hitung_Rikaz = findViewById(R.id.button_hitung_Rikaz);
    }

}