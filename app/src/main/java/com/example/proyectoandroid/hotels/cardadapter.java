package com.example.proyectoandroid.hotels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoandroid.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class cardadapter extends RecyclerView.Adapter<cardadapter.ViewHolder> {
    private Context hotelContext;
    private List<hotelData> hotelDataList;

    public cardadapter (ArrayList<hotelData> list) {
        this.hotelDataList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotelcard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        hotelData actual = hotelDataList.get(position);
        holder.hname.setText(actual.getNombre());
        //holder.himage.setImageResource();
        holder.hdescription.setText(actual.getDescripcion());
        holder.hrating.setRating(actual.getValoracion());
        //falta el click del details
        new unaEstrella();
    }

    @Override
    public int getItemCount() {
        return hotelDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView himage;
        public TextView hname;
        public TextView hdescription;
        public RatingBar hrating;
        public Button hdetails;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            himage = itemView.findViewById(R.id.img1);
            hname = itemView.findViewById(R.id.hotelname);
            hdescription = itemView.findViewById(R.id.hoteldescription);
            hrating = itemView.findViewById(R.id.hotelrating);
            hdetails = itemView.findViewById(R.id.hoteldetails);
        }
    }
}
