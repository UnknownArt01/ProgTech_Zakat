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

import model.InputanZakatTemuan;

public class listinputzakatrikaz extends AppCompatActivity {

    private ImageView imageView_backr;
    private RecyclerView recyclerView_rc;
    private ArrayList<InputanZakatTemuan> datainputzakatrikaz;
    private panggilinputzakatrikaz panggilInrikaz;
    private FloatingActionButton floatingActionButton_rc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listinputzakatrikaz);
        initView();
        setupRecyclerView();
        addDummyData();
        setListener();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            if (resultCode == 100) {
                InputanZakatTemuan jumlahinputrikaz = data.getParcelableExtra("jumlahinputrikaz");
                datainputzakatrikaz.add(jumlahinputrikaz);
                panggilInrikaz.notifyDataSetChanged();
            }
        }
    }

    private void setListener() {
        floatingActionButton_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intn = new Intent(getBaseContext(), hitungzakatrikaz.class);
                startActivityForResult(intn, 2);
            }
        });
    }

    private void addDummyData() {
        panggilInrikaz.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerView_rc.setLayoutManager(manager);
        recyclerView_rc.setAdapter(panggilInrikaz);
    }

    private void initView() {
        recyclerView_rc = findViewById(R.id.recyclerView_rc);
        datainputzakatrikaz = new ArrayList<InputanZakatTemuan>();
        panggilInrikaz = new panggilinputzakatrikaz(datainputzakatrikaz);
        floatingActionButton_rc = findViewById(R.id.floatingActionButton_rc);
        imageView_backr = findViewById(R.id.imageView_backr);

        imageView_backr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intback = new Intent(getBaseContext(), tampilanawal.class);
                startActivity(intback);
                finish();
            }
        });
    }
}