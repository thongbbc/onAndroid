package com.example.mac078.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mac078 on 12/20/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Person> personList;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView information;
        public View selected;

        public MyViewHolder(View view) {
            super(view);
            information = view.findViewById(R.id.txtThongtin);
            selected = view.findViewById(R.id.selected);

        }
    }


    public Adapter(Context context,List<Person> personList) {
        this.personList = personList;
        this.context = context;
    }
    private void clearSelected() {
        for(Person person:personList) {
            if (person.isSelected()) {
                person.setSelected(false);
            }
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Person person = personList.get(position);
        holder.information.setText(person.getName());

        holder.information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelected();
                personList.get(position).setSelected(true);
                for (int i =0 ;i<personList.size();i++) {
                    notifyItemChanged(i);
                }
            }
        });
        if (person.isSelected())
            holder.selected.setVisibility(View.VISIBLE);
        else
            holder.selected.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}