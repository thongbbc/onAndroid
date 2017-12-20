package com.example.mac078.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter2.ClickListener {
    private List<Person> personList = new ArrayList<>();
    private List<NameNumber> personList2 = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;

    private Adapter mAdapter;
    private Adapter2 mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        for (int i =0 ;i< 30 ;i++) {
            if (i == 0) {
                personList.add(new Person(i+"",Integer.toString(i),true));
            } else
            personList.add(new Person(i+"",Integer.toString(i)));
        }
        mAdapter = new Adapter(this,personList);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                RecyclerView.LayoutManager mLayoutManager = layoutManager;
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
        for (int i =0 ;i< 30 ;i++) {
            if (i == 0) {
                personList2.add(new NameNumber("Thong"));
            } else
                personList2.add(new NameNumber("Thong"));
        }
        mAdapter2 = new Adapter2(this,personList2);
        mAdapter2.setClickListener(this);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(mAdapter2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recyclerView2.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {

                }
            });
        }

    }

    NameNumber objectDownloading;

    @Override
    public void onClick(NameNumber object) {
        if (isDowloading) {
            // Add to queue
        } else {
            // Start download this object
        }
    }

    void onPercentUpdate(int percent) {
        if (objectDownloading != null) {
            objectDownloading.progress = percent;
            mAdapter2.updateItem(objectDownloading);
        }
    }
}
