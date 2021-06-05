package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.InputanZakatSimpanan;

public class hitungzakatsimpanan extends AppCompatActivity {

    private TextInputLayout textInputzakatsaldo, textInputbunga;
    private Button button_simpanan;
    int saldoakhir, hasilll;
    double bunga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungzakatsimpanan);

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
                finish();
                Toast.makeText(getApplicationContext(), "Zakat Tabungan Berhasil Dihitung ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        textInputzakatsaldo = findViewById(R.id.textInputzakatsaldo);
        textInputbunga = findViewById(R.id.textInputbunga);
        button_simpanan = findViewById(R.id.button_simpanan);
    }


}