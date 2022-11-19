package com.example.proyectoandroid.cartelera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoandroid.R;

public class popup_cartelera extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_cartelera);
        Bundle extras = getIntent().getExtras();

        TextView nom = findViewById(R.id.nomCine);
        nom.setText(extras.getString("nomCine"));

        TextView direction = findViewById(R.id.directionCine);
        direction.setText(extras.getString("direccio"));

        ImageButton website = findViewById(R.id.websiteCine);
        website.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ImageButton ib = (ImageButton) view;
        Bundle extras = getIntent().getExtras();

        if (ib.getId() == R.id.websiteCine) {
            Intent websiteIntent = new Intent("android.intent.action.VIEW", Uri.parse(extras.getString("website"))); //posar variable amb la web
            startActivity(websiteIntent);
        }

    }
}