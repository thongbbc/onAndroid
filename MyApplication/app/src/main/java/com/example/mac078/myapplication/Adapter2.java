package com.example.mac078.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mac078 on 12/20/17.
 */

public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyViewHolder> {

    private List<NameNumber> personList;
    private Context context;
    private ClickListener clickListener;

    public void updateItem(NameNumber objectDownloading) {
        int index = personList.indexOf(objectDownloading);
        personList.remove(index);
        personList.add(index, objectDownloading);
        notifyItemChanged(index);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtNumber;

        public MyViewHolder(View view) {
            super(view);
            txtName = view.findViewById(R.id.txtName);
            txtNumber = view.findViewById(R.id.txtNumber);

        }
    }


    public Adapter2(Context context,List<NameNumber> personList) {
        this.personList = personList;
        this.context = context;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public Adapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item2, parent, false);
        return new Adapter2.MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final NameNumber person = personList.get(position);
        holder.txtName.setText(person.getName());
        holder.txtNumber.setText(position+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onClick(person);
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return personList.size();
    }

    public interface ClickListener {
        void onClick(NameNumber object);
    }

}