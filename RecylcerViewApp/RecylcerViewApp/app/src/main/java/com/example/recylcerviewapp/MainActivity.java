package com.example.recylcerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements ImageAdapter.ItemClickListener{
    Integer[] animals = {R.drawable.eagle,R.drawable.elephant,R.drawable.gorilla,
        R.drawable.panda,R.drawable.panther,R.drawable.polar};
    String[] animalNames = {"Eagle","Elephant","Gorilla","Panda","Panther","Polar"};
    ImageView img;
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgLarge);
        int numOfCol = 3;

        RecyclerView recyclerView = findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,numOfCol));
        adapter = new ImageAdapter(this,animals);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(MainActivity.this,"select animal is " +
                animalNames[position],Toast.LENGTH_LONG ).show();
        img.setImageResource(adapter.getItem(position));
    }
}