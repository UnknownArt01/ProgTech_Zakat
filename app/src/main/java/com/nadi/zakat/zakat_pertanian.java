package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;

public class zakat_pertanian extends AppCompatActivity {
    private TextInputLayout hasil_panen_textInputLayout;
    private RadioButton tanpa_biaya_radioButton, dengan_biaya_radioButton;
    private Button hitung_pertanian_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_pertanian);

        hasil_panen_textInputLayout = findViewById(R.id.hasil_panen_textInputLayout);
        tanpa_biaya_radioButton = findViewById(R.id.tanpa_biaya_radioButton);
        dengan_biaya_radioButton = findViewById(R.id.dengan_biaya_radioButton);
        hitung_pertanian_button = findViewById(R.id.hitung_pertanian_button);
    }
}