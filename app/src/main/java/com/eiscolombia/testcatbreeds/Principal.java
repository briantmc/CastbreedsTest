package com.eiscolombia.testcatbreeds;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.eiscolombia.testcatbreeds.adapter.CatAdapter;
import com.eiscolombia.testcatbreeds.classcat.Cat;
import com.eiscolombia.testcatbreeds.classcat.DummyCat;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements SearchView.OnQueryTextListener{

    SearchView searchCat;
    RecyclerView recyclerView;
    CatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        initRecyclerView();
        initSearchView();


    }

    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.listCat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CatAdapter(DummyCat.listCat);
        recyclerView.setAdapter(adapter);
    }

    private void initSearchView(){
        searchCat = findViewById(R.id.searchCat);
        searchCat.setOnQueryTextListener(this);
        searchCat.setQueryHint("Buscar");
        searchCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCat.setIconified(false);
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}