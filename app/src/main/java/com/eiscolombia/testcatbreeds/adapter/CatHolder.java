package com.eiscolombia.testcatbreeds.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eiscolombia.testcatbreeds.DetailCat;
import com.eiscolombia.testcatbreeds.MainActivity;
import com.eiscolombia.testcatbreeds.Principal;
import com.eiscolombia.testcatbreeds.R;
import com.eiscolombia.testcatbreeds.classcat.Cat;


public class CatHolder extends RecyclerView.ViewHolder {

    TextView textViewNameRace;
    TextView textViewCountry;
    TextView textViewIntelligence;
    ImageView imageView;

    public CatHolder(@NonNull View itemView) {
        super(itemView);
        textViewNameRace = itemView.findViewById(R.id.name_race);
        textViewCountry = itemView.findViewById(R.id.country);
        textViewIntelligence = itemView.findViewById(R.id.intelligence);
        imageView = itemView.findViewById(R.id.image_cat);

    }

    public void render (Cat cat){
        textViewNameRace.setText(cat.getNamerace());
        textViewCountry.setText("País de origen: " +cat.getOrigin());
        textViewIntelligence.setText("Inteligencia: " + cat.getIntelligence());
        if(cat.getImage_url()!=null) {
            Glide.with(imageView.getContext()).load(cat.getImage_url()).into(imageView);
        }

        //Se asigna el evento al click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(textViewNameRace.getContext(), DetailCat.class);
                intent.putExtra("CAT", cat);
                textViewNameRace.getContext().startActivity(intent);

                Toast.makeText(textViewNameRace.getContext(),
                        cat.getNamerace(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
