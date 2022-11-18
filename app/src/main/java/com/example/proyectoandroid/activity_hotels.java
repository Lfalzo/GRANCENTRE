package com.example.proyectoandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.proyectoandroid.hotels.cincEstrelles;
import com.example.proyectoandroid.hotels.duesEstrelles;
import com.example.proyectoandroid.hotels.quatreEstrelles;
import com.example.proyectoandroid.hotels.tresEstrelles;
import com.example.proyectoandroid.hotels.unaEstrella;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class activity_hotels extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    ViewPagerAdapter adapter;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        viewPager2 = findViewById(R.id.viewPager2);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        ImageButton backbt = findViewById(R.id.back);
        backbt.setOnClickListener(this);

        //Afegir fragments
        adapter.addFragment(new unaEstrella());
        adapter.addFragment(new duesEstrelles());
        adapter.addFragment(new tresEstrelles());
        adapter.addFragment(new quatreEstrelles());
        adapter.addFragment(new cincEstrelles());

        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("*");
                        break;
                    case 1:
                        tab.setText("**");
                        break;
                    case 2:
                        tab.setText("***");
                        break;
                    case 3:
                        tab.setText("****");
                        break;
                    case 4:
                        tab.setText("*****");
                        break;
                }
            }
        }).attach();

        // creem el spinner
        Spinner spinner = (Spinner) findViewById((R.id.spinner));
        ArrayAdapter<CharSequence> spinneradapter = ArrayAdapter.createFromResource(this, R.array.gcmenuoptions, android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinneradapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    final Intent intent;
        switch(i) {
            case 1: {
                intent = new Intent(activity_hotels.this, activity_cartelera.class);
            }
            break;
            case 2: {
                intent = new Intent(activity_hotels.this, activity_cartelera.class);
            }
            break;
            case 3: {
                intent = new Intent(activity_hotels.this, activity_hotels.class);
            }
            break;
            case 4: {
                intent = new Intent(activity_hotels.this, activity_cartelera.class);
            }
            break;
            case 5: {
                intent = new Intent(activity_hotels.this, activity_cartelera.class);
            }
            break;
            case 6: {
                intent = new Intent(activity_hotels.this, activity_cartelera.class);
            }
            break;
            case 7: {
                intent = new Intent(activity_hotels.this, activity_cartelera.class);
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

        if (bt.getId() == R.id.back)
        {
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        }
    }
}