package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class zakat_emas extends AppCompatActivity {
    private TextInputLayout emas_mentah_textInputLayout, emas_pakai_textInputLayout, harga_emas_textInputLayout;
    private Button hitung_emas_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_emas);

        emas_mentah_textInputLayout = findViewById(R.id.emas_mentah_textInputLayout);
        emas_pakai_textInputLayout = findViewById(R.id.emas_pakai_textInputLayout);
        harga_emas_textInputLayout = findViewById(R.id.harga_emas_textInputLayout);
        hitung_emas_button = findViewById(R.id.hitung_emas_button);
    }
}