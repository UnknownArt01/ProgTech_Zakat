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

import model.InputanZakatProfesi;

public class listinputzakatprofesi extends AppCompatActivity {

    private ImageView imageView_pr;
    private RecyclerView recyclerview_recyclerview;
    private ArrayList<InputanZakatProfesi> datainputzakat;
    private panggilinputzakatprofesi panggilI;
    private FloatingActionButton floatingtambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listinputzakatprofesi);

        initView();
        setupRecyclerView();
        addDummyData();
        setListener();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == 200) {
                InputanZakatProfesi jumlahinput = data.getParcelableExtra("jumlahinput");
                datainputzakat.add(jumlahinput);
                panggilI.notifyDataSetChanged();
            }
        }
    }

    private void setListener() {
        floatingtambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), hitungzakatprofesi.class);
                startActivityForResult(intent, 1 );
            }
        });
    }

    private void addDummyData() {
        panggilI.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerview_recyclerview.setLayoutManager(manager);
        recyclerview_recyclerview.setAdapter(panggilI);
    }

    private void initView() {
        recyclerview_recyclerview = findViewById(R.id.recyclerview_recyclerview);
        datainputzakat = new ArrayList<InputanZakatProfesi>();
        panggilI = new panggilinputzakatprofesi(datainputzakat);
        floatingtambah = findViewById(R.id.floatingtambah);
        imageView_pr = findViewById(R.id.imageView_pr);

        imageView_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), tampilanawal.class);
                startActivity(intback);
                finish();
            }
        });

    }
}