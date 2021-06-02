package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class zakat_perdagangan extends AppCompatActivity {
    private TextInputLayout modal_textInputLayout,keuntungan_textInputLayout,piutang_textInputLayout,hutang_textInputLayout,kerugian_textInputLayout;
    private Button hitung_perdangangan_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_perdagangan);

        modal_textInputLayout = findViewById(R.id.modal_textInputLayout);
        keuntungan_textInputLayout = findViewById(R.id.keuntungan_textInputLayout);
        piutang_textInputLayout = findViewById(R.id.piutang_textInputLayout);
        hutang_textInputLayout = findViewById(R.id.hutang_textInputLayout);
        kerugian_textInputLayout = findViewById(R.id.kerugian_textInputLayout);
        hitung_perdangangan_button = findViewById(R.id.hitung_perdangangan_button);
    }
}