package com.example.proyectoandroid.hotels;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.proyectoandroid.R;

public class popup_hotel extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_hotel);
        Bundle extras = getIntent().getExtras();

        ImageView image = findViewById(R.id.img2);
        Glide.with(this).load(extras.getString("imatge")).into(image);

        TextView nom = findViewById(R.id.nomHotel);
        nom.setText(extras.getString("nomHotel"));

        TextView direction = findViewById(R.id.direction);
        direction.setText(extras.getString("direccio"));

        ImageButton call= findViewById(R.id.call);
        call.setOnClickListener(this);

        ImageButton email = findViewById(R.id.email);
        email.setOnClickListener(this);

        ImageButton website = findViewById(R.id.website);
        website.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ImageButton ib = (ImageButton) view;
        Bundle extras = getIntent().getExtras();

        if (ib.getId() == R.id.call) {
            Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+extras.getString("telefon")));
            startActivity(callIntent);
        } else if (ib.getId() == R.id.email) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, extras.getString("email"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ask for information");
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            } else {
                Toast.makeText(this, "No hay ninguna aplicacion para mandar el email", Toast.LENGTH_SHORT).show();
            }
        } else if (ib.getId() == R.id.website) {
            Intent websiteIntent = new Intent("android.intent.action.VIEW", Uri.parse(extras.getString("website")));
            startActivity(websiteIntent);
        }

    }
}