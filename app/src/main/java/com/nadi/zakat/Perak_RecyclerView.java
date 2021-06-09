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

import model.Perak;

public class Perak_RecyclerView extends AppCompatActivity {
    private RecyclerView perak_RecyclerView;
    private ArrayList<Perak> dataPerak;
    private Perak_RV_Adapter adapter;
    private FloatingActionButton perak_floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perak_recycler_view);

        getSupportActionBar().hide();
        
        initView();
        setupRecyclerView();
        clickListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 9966){
                if (resultCode == 500){
                    Perak perakBaru = data.getParcelableExtra("perakBaru");
                    dataPerak.add(perakBaru);
                    adapter.notifyDataSetChanged();

                }
            }
    }

    private void clickListener() {
        perak_floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), zakat_perak.class);
                startActivityForResult(intent, 9966);
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        perak_RecyclerView.setLayoutManager(manager);
        perak_RecyclerView.setAdapter(adapter);
    }

    private void initView() {
        perak_RecyclerView = findViewById(R.id.perak_RecyclerView);
        dataPerak = new ArrayList<Perak>();
        adapter = new Perak_RV_Adapter(dataPerak);
        perak_floatingActionButton = findViewById(R.id.perak_floatingActionButton);
    }

}