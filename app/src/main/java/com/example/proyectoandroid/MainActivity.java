package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button hotels = findViewById(R.id.hotels);
        hotels.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;

        if (b.getId() == R.id.hotels)
        {
            Intent hotels =new Intent(this, activity_hotels.class);

            startActivity(hotels);
        }
    }
}