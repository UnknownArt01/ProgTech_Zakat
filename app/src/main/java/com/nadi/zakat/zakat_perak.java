package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import model.Perak;

public class zakat_perak extends AppCompatActivity {
    private TextInputLayout perak_mentah_textInputLayout, harga_perak_textInputLayout;
    private Button hitung_perak_button;
    private int hasil = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_perak);

        initView();
        setListener();
    }

    private void setListener() {
        hitung_perak_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int perak = Integer.parseInt(perak_mentah_textInputLayout.getEditText().getText().toString().trim());
                int harga = Integer.parseInt(harga_perak_textInputLayout.getEditText().getText().toString().trim());
                Perak temp = new Perak(perak, harga, hasil);
                Intent intent = new Intent();
                intent.putExtra("perakBaru", temp);
                setResult(500, intent);
                finish();
            }
        });
    }

    private void initView() {
        perak_mentah_textInputLayout = findViewById(R.id.perak_mentah_textInputLayout);
        harga_perak_textInputLayout = findViewById(R.id.harga_perak_textInputLayout);
        hitung_perak_button = findViewById(R.id.hitung_perak_button);
    }
}