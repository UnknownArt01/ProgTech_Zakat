package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MENU extends AppCompatActivity {
    private ImageButton fitrah_imageButton, emas_imageButton, perdagangan_imageButton, perak_imageButton, maal_imageButton, profesi_imageButton, tabungan_imageButton,temuan_imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();

        initView();
        clickListener();
    }

    private void clickListener() {
        emas_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentprof = new Intent(getBaseContext(), Emas_RecyclerView.class);
                startActivity(intentprof);

            }
        });
        perak_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentprof = new Intent(getBaseContext(), Perak_RecyclerView.class);
                startActivity(intentprof);

            }
        });
        perdagangan_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentprof = new Intent(getBaseContext(), Perdagangan_RecyclerView.class);
                startActivity(intentprof);

            }
        });
        maal_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentprof = new Intent(getBaseContext(), Maal_RecyclerView.class);
                startActivity(intentprof);

            }
        });
        profesi_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentprof = new Intent(getBaseContext(), listinputzakatprofesi.class);
                startActivity(intentprof);

            }
        });

        temuan_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentemuan = new Intent(getBaseContext(), listinputzakatrikaz.class);
                startActivity(intentemuan);

            }
        });

        tabungan_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsimpanan = new Intent(getBaseContext(), listinputzakatsimpanan.class);
                startActivity(intentsimpanan);

            }
        });
        fitrah_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsimpanan = new Intent(getBaseContext(), listinputzakatfitrah.class);
                startActivity(intentsimpanan);

            }
        });
    }

    private void initView() {
        emas_imageButton = findViewById(R.id.emas_imageButton);
        perdagangan_imageButton = findViewById(R.id.perdagangan_imageButton);
        perak_imageButton = findViewById(R.id.perak_imageButton);
        maal_imageButton = findViewById(R.id.maal_imageButton);
        profesi_imageButton = findViewById(R.id.profesi_imageButton);
        tabungan_imageButton = findViewById(R.id.tabungan_imageButton);
        temuan_imageButton = findViewById(R.id.temuan_imageButton);
        fitrah_imageButton = findViewById(R.id.fitrah_imageButton);
    }
}