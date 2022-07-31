package com.eiscolombia.testcatbreeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eiscolombia.testcatbreeds.classcat.Cat;

import java.util.Objects;

public class DetailCat extends AppCompatActivity {

    TextView textViewDescription;
    TextView textViewInformation;
    ImageView imageView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Cat cat = (Cat) getIntent().getSerializableExtra("CAT");
        toolbar.setTitle(cat.getNamerace());

        textViewDescription = findViewById(R.id.textViewDescription);
        textViewInformation = findViewById(R.id.textViewInformation);
        imageView = findViewById(R.id.imageViewCatDetail);

        textViewDescription.setText(cat.getDescription());
        textViewInformation.setText("País de origen: " +cat.getOrigin()
                        + "\nInteligencia: " +cat.getIntelligence()
                        + "\nAdaptabilidad: " +cat.getAdaptability()
                        + "\nEsperanza de vida: " +cat.getLife_span());

        if(cat.getImage_url()!=null) {
            Glide.with(imageView.getContext()).load(cat.getImage_url()).into(imageView);
        }





    }
}