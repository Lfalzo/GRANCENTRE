package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView hotels = findViewById(R.id.gchotel);
        hotels.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ImageView b = (ImageView) view;

        if (b.getId() == R.id.gchotel)
        {
            Intent hotels =new Intent(this, activity_hotels.class);

            startActivity(hotels);
        }
    }
}