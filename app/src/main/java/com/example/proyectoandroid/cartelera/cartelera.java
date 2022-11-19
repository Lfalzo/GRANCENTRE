package com.example.proyectoandroid.cartelera;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoandroid.R;
import com.example.proyectoandroid.hotels.cardadapter;
import com.example.proyectoandroid.hotels.hotelData;
import com.example.proyectoandroid.hotels.popup_hotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cartelera#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cartelera extends Fragment implements View.OnClickListener, carteleraAdapter.OnItemClickListener{
    private RecyclerView clista;
    private carteleraAdapter adapter;
    private ArrayList<filmData> dataCinemas = new ArrayList<filmData>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cartelera() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cartelera.
     */
    // TODO: Rename and change types and number of parameters
    public static cartelera newInstance(String param1, String param2) {
        cartelera fragment = new cartelera();
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
        dataCinemas = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(jsonString);
            String result = "";
            for (int i=0;i< data.length(); i++)
            {
                JSONObject c = data.getJSONObject(i);
                    filmData cinema = new filmData(
                            c.getString("nombreCine"),
                            c.getString("peli1"),
                            c.getString("peli2"),
                            c.getString("peli3"),
                            c.getString("direccion"),
                            c.getString("website"));
                    //make an array with the classes hotelData
                    dataCinemas.add(cinema);
                };
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("pelis.json");
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
        View view = inflater.inflate(R.layout.fragment_cartelera, container, false);

        readJSON();

        clista = view.findViewById(R.id.filmsList);

        initValues();

        return view;
    }

    @Override
    public void onClick(View view) {
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext());
        clista.setLayoutManager(manager);

        adapter = new carteleraAdapter((ArrayList<filmData>) dataCinemas);
        adapter.setOnItemClickListener(this);
        clista.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View v, int position) {
        Intent popup =new Intent(getActivity().getApplicationContext(), popup_cartelera.class);

        String nom = dataCinemas.get(position).getNombreCine();
        String website = dataCinemas.get(position).getWebsite();
        String direccio = dataCinemas.get(position).getDireccion();


        Bundle extras = new Bundle();
        extras.putString("nomCine",nom);
        extras.putString("website",website);
        extras.putString("direccio",direccio);

        popup.putExtras(extras);
        startActivity(popup);
    }
}