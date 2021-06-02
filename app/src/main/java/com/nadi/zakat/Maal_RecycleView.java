package com.nadi.zakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import model.maal;

public class Maal_RecycleView extends AppCompatActivity {

    private RecyclerView maal_recyclerView;
    private ArrayList<maal> zakatMaal = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maal_recycle_view);
    }
}