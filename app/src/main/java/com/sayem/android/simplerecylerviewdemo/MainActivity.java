package com.sayem.android.simplerecylerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter();
        adapter.setItemModels(getData());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }

    private List<ItemModel> getData() {
        List<ItemModel> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setTitle("Title " + i);
            itemModel.setDescription("Description " + i);

            list.add(itemModel);
        }
         return list;
    }
}
