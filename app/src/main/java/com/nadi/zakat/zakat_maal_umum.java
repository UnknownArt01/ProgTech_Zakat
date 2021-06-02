package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class zakat_maal_umum extends AppCompatActivity {
    private TextInputLayout harta_maal_umum_textInputLayout;
    private Button hitung_maal_umum_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_maal_umum);

        harta_maal_umum_textInputLayout = findViewById(R.id.harta_maal_umum_textInputLayout);
        hitung_maal_umum_button = findViewById(R.id.hitung_emas_button);
    }
}