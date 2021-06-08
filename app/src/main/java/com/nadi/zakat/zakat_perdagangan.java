package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import model.Perdagangan;

public class zakat_perdagangan extends AppCompatActivity {
    private TextInputLayout modal_textInputLayout,keuntungan_textInputLayout,piutang_textInputLayout,hutang_textInputLayout,kerugian_textInputLayout;
    private Button hitung_perdangangan_button;
    private int hasil = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zakat_perdagangan);

        initView();
        setListener();
    }

    private void setListener() {
        hitung_perdangangan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int modal = Integer.parseInt(modal_textInputLayout.getEditText().getText().toString().trim());
                int keuntungan = Integer.parseInt(keuntungan_textInputLayout.getEditText().getText().toString().trim());
                int piutang = Integer.parseInt(piutang_textInputLayout.getEditText().getText().toString().trim());
                int hutang = Integer.parseInt(hutang_textInputLayout.getEditText().getText().toString().trim());
                int kerugian = Integer.parseInt(kerugian_textInputLayout.getEditText().getText().toString().trim());
                Perdagangan temp = new Perdagangan(modal, keuntungan, piutang, hutang, kerugian, hasil);
                Intent intent = new Intent();
                intent.putExtra("perdaganganBaru", temp);
                setResult(600, intent);
                finish();
            }
        });
    }

    private void initView() {
        modal_textInputLayout = findViewById(R.id.modal_textInputLayout);
        keuntungan_textInputLayout = findViewById(R.id.keuntungan_textInputLayout);
        piutang_textInputLayout = findViewById(R.id.piutang_textInputLayout);
        hutang_textInputLayout = findViewById(R.id.hutang_textInputLayout);
        kerugian_textInputLayout = findViewById(R.id.kerugian_textInputLayout);
        hitung_perdangangan_button = findViewById(R.id.hitung_perdangangan_button);
    }
}