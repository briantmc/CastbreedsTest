package com.eiscolombia.testcatbreeds.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eiscolombia.testcatbreeds.R;
import com.eiscolombia.testcatbreeds.classcat.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CatAdapter extends RecyclerView.Adapter<CatHolder>
                        implements View.OnClickListener {

    ArrayList<Cat> listitem = new ArrayList<Cat>();

    ArrayList<Cat> originallistitem = new ArrayList<Cat>();
    private View.OnClickListener listener;

    public CatAdapter(ArrayList<Cat> listitem){
        this.listitem = listitem;
        this.originallistitem.addAll(listitem);
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //Asignación de view
        View view = layoutInflater.inflate(R.layout.item_listcat, parent, false);
        //Evento de selección
        view.setOnClickListener(this);
        return new CatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        Cat cat = (Cat) listitem.get(position);
        holder.render(cat);
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }



    @Override
    public void onClick(View view) {

        if(listener!=null){
            listener.onClick(view);
        }
    }

    public void filter(String stringSearch){
        int _lenght = stringSearch.length();

        if(_lenght==0){
            //Si no se ha escrito nada siempre estará la original
            listitem.clear();
            listitem.addAll(originallistitem);

        }else{
            //Filtración de la lista, se comparan en minusculas.
            List<Cat> list = listitem.stream()
                    .filter( i -> i.getNamerace().toLowerCase().contains(stringSearch.toLowerCase()))
                    .collect(Collectors.toList());
            listitem.clear();
            listitem.addAll(list);

        }
        notifyDataSetChanged();
    }

}
