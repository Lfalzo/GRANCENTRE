package com.example.proyectoandroid.cartelera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectoandroid.R;

import java.util.ArrayList;
import java.util.List;

public class carteleraAdapter extends RecyclerView.Adapter<carteleraAdapter.ViewHolder>{
    private Context carteleraContext;
    private List<filmData> filmDataList;
    private carteleraAdapter.OnItemClickListener myListener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public carteleraAdapter (ArrayList<filmData> list) {
        this.filmDataList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filmscard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull carteleraAdapter.ViewHolder holder, int position) {
        filmData actual = filmDataList.get(position);
        holder.cname.setText(actual.getNombreCine());
        Glide.with(carteleraContext).load(actual.getPeli1()).into(holder.cpeli1);
        Glide.with(carteleraContext).load(actual.getPeli2()).into(holder.cpeli2);
        Glide.with(carteleraContext).load(actual.getPeli3()).into(holder.cpeli3);
        new cartelera();
    }

    @Override
    public int getItemCount() {
        return filmDataList.size();
    }

    public void setOnItemClickListener (carteleraAdapter.OnItemClickListener onItemClick){
        this.myListener = onItemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView cname;
        public ImageView cpeli1;
        public ImageView cpeli2;
        public ImageView cpeli3;


        public  ViewHolder(@NonNull View itemView) {
            super(itemView);
            carteleraContext = itemView.getContext();
            cname = itemView.findViewById(R.id.tcine);
            cpeli1 = itemView.findViewById(R.id.peli1);
            cpeli2 = itemView.findViewById(R.id.peli2);
            cpeli3 = itemView.findViewById(R.id.peli3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                    myListener.onItemClick(view,getAdapterPosition());
                }
            });
        }
    }
}
