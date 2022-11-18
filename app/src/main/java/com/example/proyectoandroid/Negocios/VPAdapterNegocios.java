package com.example.proyectoandroid.Negocios;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapterNegocios extends FragmentStateAdapter {

    public VPAdapterNegocios(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new fragment_tiendas();
            case 1:
                return new fragment_automovil();
            default:
                return new fragment_supermercados();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
