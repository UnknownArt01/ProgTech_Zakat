package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tampilanawal extends AppCompatActivity {

    private Button buttonhitprof, buttonhitemu, buttonhitab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilanawal);
        buttonhitprof = findViewById(R.id.buttonhitprof);
        buttonhitemu = findViewById(R.id.buttonhitemu);
        buttonhitab = findViewById(R.id.buttonhitab);




        buttonhitprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentprof = new Intent(getBaseContext(), listinputzakatprofesi.class);
                startActivity(intentprof);
                finish();
            }
        });

        buttonhitemu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentemuan = new Intent(getBaseContext(), listinputzakatrikaz.class);
                startActivity(intentemuan);
                finish();
            }
        });

        buttonhitab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsimpanan = new Intent(getBaseContext(), listinputzakatsimpanan.class);
                startActivity(intentsimpanan);
                finish();
            }
        });
    }
}