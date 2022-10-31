package com.example.proyectoandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.proyectoandroid.hotels.cincEstrelles;
import com.example.proyectoandroid.hotels.duesEstrelles;
import com.example.proyectoandroid.hotels.quatreEstrelles;
import com.example.proyectoandroid.hotels.tresEstrelles;
import com.example.proyectoandroid.hotels.unaEstrella;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class activity_hotels extends AppCompatActivity {

    ViewPagerAdapter adapter;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        viewPager2 = findViewById(R.id.viewPager2);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());

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
                switch (position)
                {
                    case 0: tab.setText("*");break;
                    case 1: tab.setText("**");break;
                    case 2: tab.setText("***");break;
                    case 3: tab.setText("****");break;
                    case 4: tab.setText("*****");break;
                }
            }
        }).attach();
    }
}