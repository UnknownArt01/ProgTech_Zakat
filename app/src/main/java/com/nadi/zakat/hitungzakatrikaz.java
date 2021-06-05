package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.InputanZakatTemuan;

public class hitungzakatrikaz extends AppCompatActivity {

    private TextInputLayout textInputhargabarangtemuan;
    private Button button_hitung_Rikaz;
    int hargabarangtemuan,hasill;

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
                finish();
                Toast.makeText(getApplicationContext(), "Zakat Temuan Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        textInputhargabarangtemuan = findViewById(R.id.textInputhargabarangtemuan);
        button_hitung_Rikaz = findViewById(R.id.button_hitung_Rikaz);
    }

}