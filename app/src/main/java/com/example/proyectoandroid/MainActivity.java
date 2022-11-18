package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.proyectoandroid.cartelera.cartelera;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardhotel = findViewById(R.id.chotel);
        cardhotel.setOnClickListener(this);

        ImageButton restaurantes = findViewById(R.id.gcrest);
        restaurantes.setOnClickListener(this);
        ImageButton finanzas = findViewById(R.id.gcfinanzas);
        finanzas.setOnClickListener(this);
        //ImageButton hoteles = findViewById(R.id.gchotel);
        //hoteles.setOnClickListener(this);
        ImageButton cartelera = findViewById(R.id.gccine);
        cartelera.setOnClickListener(this);
        ImageButton parking = findViewById(R.id.gcparking);
        parking.setOnClickListener(this);
        ImageButton transporte = findViewById(R.id.gctransporte);
        transporte.setOnClickListener(this);
        ImageButton config = findViewById(R.id.gcconfig);
        config.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ImageButton b = (ImageButton) view;
        CardView c = (CardView) view;

        if (b.getId() == R.id.gcrest)
        {
            Intent rest =new Intent(this, activity_hotels.class);
            startActivity(rest);
        }
        else if (b.getId() == R.id.gcfinanzas)
        {
            Intent finanzas =new Intent(this, activity_hotels.class);
            startActivity(finanzas);
        }
        else if (c.getId() == R.id.chotel)
        {
            Intent hotels =new Intent(this, activity_hotels.class);
            startActivity(hotels);
        }
        else if (b.getId() == R.id.gccine)
        {
            Intent cartelera =new Intent(this, com.example.proyectoandroid.cartelera.cartelera.class);
            startActivity(cartelera);
        }
        else if (b.getId() == R.id.gcparking)
        {
            Intent parking =new Intent(this, activity_hotels.class);
            startActivity(parking);
        }
        else if (b.getId() == R.id.gctransporte)
        {
            Intent transporte =new Intent(this, activity_hotels.class);
            startActivity(transporte);
        }
        else if (b.getId() == R.id.gcconfig)
        {
            Intent config =new Intent(this, activity_hotels.class);
            startActivity(config);
        }
    }
}