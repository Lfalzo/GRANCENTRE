package com.example.proyectoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.proyectoandroid.cartelera.cartelera;

public class activity_cartelera extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener  {

    ViewPagerAdapter adapter;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartelera);

        viewPager2 = findViewById(R.id.viewPager2cartelera);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        ImageButton backbt = findViewById(R.id.backCartelera);
        backbt.setOnClickListener(this);

        adapter.addFragment(new cartelera());

        viewPager2.setAdapter(adapter);

        Spinner spinner = (Spinner) findViewById((R.id.spinnerCartelera));
        ArrayAdapter<CharSequence> spinneradapter = ArrayAdapter.createFromResource(this, R.array.gcmenuoptions, android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinneradapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        final Intent intent;
        switch (i) {
            case 1: {
                intent = new Intent(activity_cartelera.this, activity_cartelera.class);
            }
            break;
            case 2: {
                intent = new Intent(activity_cartelera.this, activity_cartelera.class);
            }
            break;
            case 3: {
                intent = new Intent(activity_cartelera.this, activity_hotels.class);
            }
            break;
            case 4: {
                intent = new Intent(activity_cartelera.this, activity_cartelera.class);
            }
            break;
            case 5: {
                intent = new Intent(activity_cartelera.this, activity_cartelera.class);
            }
            break;
            case 6: {
                intent = new Intent(activity_cartelera.this, activity_cartelera.class);
            }
            break;
            case 7: {
                intent = new Intent(activity_cartelera.this, activity_cartelera.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public void onClick(View view) {
        ImageButton bt = (ImageButton) view;

        if (bt.getId() == R.id.backCartelera)
        {
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        }
    }
}