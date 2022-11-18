package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView restaurantes = findViewById(R.id.crest);
        restaurantes.setOnClickListener(this);
        CardView negocios = findViewById(R.id.cfinanzas);
        negocios.setOnClickListener(this);
        CardView hoteles = findViewById(R.id.chotel);
        hoteles.setOnClickListener(this);
        CardView cartelera = findViewById(R.id.ccine);
        cartelera.setOnClickListener(this);
        CardView parking = findViewById(R.id.cparking);
        parking.setOnClickListener(this);
        CardView transporte = findViewById(R.id.ctransporte);
        transporte.setOnClickListener(this);
        CardView config = findViewById(R.id.cconfig);
        config.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        CardView c = (CardView) view;

        if (c.getId() == R.id.crest)
        {
            Intent rest =new Intent(this, activity_hotels.class);
            startActivity(rest);
        }
        else if (c.getId() == R.id.cfinanzas)
        {
            Intent negocios =new Intent(this, activity_negocios.class);
            startActivity(negocios);
        }
        else if (c.getId() == R.id.chotel)
        {
            Intent hotels =new Intent(this, activity_hotels.class);
            startActivity(hotels);
        }
        else if (c.getId() == R.id.ccine)
        {
            Intent cartelera =new Intent(this, activity_cartelera.class);
            startActivity(cartelera);
        }
        else if (c.getId() == R.id.cparking)
        {
            Intent parking =new Intent(this, activity_hotels.class);
            startActivity(parking);
        }
        else if (c.getId() == R.id.ctransporte)
        {
            Intent transporte =new Intent(this, activity_transportes.class);
            startActivity(transporte);
        }
        else if (c.getId() == R.id.cconfig)
        {
            Intent config =new Intent(this, config.class);
            startActivity(config);
        }
    }
}