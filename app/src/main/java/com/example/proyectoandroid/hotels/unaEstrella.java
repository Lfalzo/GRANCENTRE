package com.example.proyectoandroid.hotels;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyectoandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link unaEstrella#newInstance} factory method to
 * create an instance of this fragment.
 */
public class unaEstrella extends Fragment implements View.OnClickListener{
    private RecyclerView hlista;
    private cardadapter adapter;
    private List<hotelData> dataHotels = new ArrayList<hotelData>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public unaEstrella() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment unaEstrella.
     */
    // TODO: Rename and change types and number of parameters
    public static unaEstrella newInstance(String param1, String param2) {
        unaEstrella fragment = new unaEstrella();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void readJSON(){
        String jsonString = loadJSONFromAsset();

        try {
            JSONArray data = new JSONArray(jsonString);
            String result = "";
            for (int i=0;i< data.length(); i++)
            {
                JSONObject h = data.getJSONObject(i);
                if (h.getInt("estrellas")==1) {
                    hotelData hotel = new hotelData(
                    h.getString("nombre"),
                    h.getInt("estrellas"),
                    h.getString("descripcion"),
                    h.getString("imatge"),
                    h.getString("imatge2"),
                    h.getString("direccion"),
                    h.getString("telefono"),
                    h.getString("email"),
                    h.getInt("valoracion"),
                    h.getString("website"));

                    //make an array with the classes hotelData
                    dataHotels.add(hotel);
                };
            };
            } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("hotels.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_una_estrella, container, false);

        readJSON();

        hlista = view.findViewById(R.id.hotelsList1);

        initValues();

        //Button detalls = view.findViewById(R.id.hoteldetails);
        //detalls.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Button bt = (Button) view;

        if (bt.getId() == R.id.hoteldetails){
            //s'hauran de passar els parametres del JSON
            Intent popup =new Intent(getActivity().getApplicationContext(), popup_hotel.class);

            //afegir les dades del Json //popup.putExtra(Bundle);

            startActivity(popup);
        }
    }

    private void initViews (){

    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext());
        hlista.setLayoutManager(manager);

        adapter = new cardadapter((ArrayList<hotelData>) dataHotels);
    }
}