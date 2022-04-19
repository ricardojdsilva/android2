package com.finalexam.rentalcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ImageAdapter.ItemClickListener{

    Integer[] carros = {R.drawable.car1, R.drawable.car2, R.drawable.car3,
            R.drawable.car4, R.drawable.car5, R.drawable.car5 };

    String[] carNames = {"Car1","Car2","Car3","Car4","Car5","Car6"};

    ImageView img;
    ImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        img = findViewById((R.id.imgLarge));
        int numOfCol = 3;

        RecyclerView recyclerView = findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,numOfCol));
        adapter = new ImageAdapter(this,carros);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(MainActivity.this,"select car is " +
                carNames[position],Toast.LENGTH_LONG ).show();
        img.setImageResource(adapter.getItem(position));
    }

}