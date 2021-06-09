package com.nadi.zakat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.InputanZakatFitrah;
import model.InputanZakatProfesi;

public class listinputzakatfitrah extends AppCompatActivity {

    private ImageView imageView_ft;
    private RecyclerView recyclerview_ft;
    private ArrayList<InputanZakatFitrah> datainputzakatfitrah;
    private panggilinputzakatfitrahumum panggilfitrah;
    private FloatingActionButton floatingtambahfitrah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listinputzakatfitrah);
        initView();
        setupRecyclerView();
        addDummyData();
        setListener();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4) {
            if (resultCode == 40) {
                InputanZakatFitrah jumlahinputfitrah = data.getParcelableExtra("jumlahinputfitrah");
                datainputzakatfitrah.add(jumlahinputfitrah);
                panggilfitrah.notifyDataSetChanged();
            }
        }
    }

    private void setListener() {
        floatingtambahfitrah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentttt = new Intent(getBaseContext(), hitungzakatfitrahumum.class);
                startActivityForResult(intentttt, 4 );
            }
        });
    }

    private void addDummyData() {
        panggilfitrah.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerview_ft.setLayoutManager(manager);
        recyclerview_ft.setAdapter(panggilfitrah);
    }

    private void initView() {
        recyclerview_ft = findViewById(R.id.recyclerview_ft);
        datainputzakatfitrah = new ArrayList<InputanZakatFitrah>();
        panggilfitrah = new panggilinputzakatfitrahumum(datainputzakatfitrah);
        floatingtambahfitrah = findViewById(R.id.floatingtambahfitrah);
        imageView_ft = findViewById(R.id.imageView_ft);

        imageView_ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), MENU.class);
                startActivity(intback);
                finish();
            }
        });

    }
}