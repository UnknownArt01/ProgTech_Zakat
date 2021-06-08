package com.nadi.zakat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.Perdagangan;

public class Perdagangan_RecyclerView extends AppCompatActivity {
    private RecyclerView perdagangan_recyclerView;
    private ArrayList<Perdagangan> dataPerdagangan;
    private Perdagangan_RV_Adapter adapter;
    private FloatingActionButton perdagangan_floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perdagangan_recycler_view);

        getSupportActionBar().hide();

        initView();
        setupRecyclerView();
        clickListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 6699){
            if (resultCode == 600){
                Perdagangan perdaganganBaru = data.getParcelableExtra("perdaganganBaru");
                dataPerdagangan.add(perdaganganBaru);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void clickListener() {
        perdagangan_floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), zakat_perdagangan.class);
                startActivityForResult(intent,6699);
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        perdagangan_recyclerView.setLayoutManager(manager);
        perdagangan_recyclerView.setAdapter(adapter);
    }

    private void initView() {
        perdagangan_recyclerView = findViewById(R.id.perdagangan_recyclerView);
        dataPerdagangan = new ArrayList<Perdagangan>();
        adapter = new Perdagangan_RV_Adapter(dataPerdagangan);
        perdagangan_floatingActionButton = findViewById(R.id.perdagangan_floatingActionButton);
    }
}