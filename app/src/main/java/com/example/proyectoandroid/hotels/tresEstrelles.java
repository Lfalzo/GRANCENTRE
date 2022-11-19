package com.example.proyectoandroid.hotels;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tresEstrelles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tresEstrelles extends Fragment implements View.OnClickListener,cardadapter.OnItemClickListener{
    private RecyclerView hlista;
    private cardadapter adapter;
    private ArrayList<hotelData> dataHotels = new ArrayList<hotelData>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tresEstrelles() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tresEstrelles.
     */
    // TODO: Rename and change types and number of parameters
    public static tresEstrelles newInstance(String param1, String param2) {
        tresEstrelles fragment = new tresEstrelles();
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
        dataHotels = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(jsonString);
            String result = "";
            for (int i=0;i< data.length(); i++)
            {
                JSONObject h = data.getJSONObject(i);
                if (h.getInt("estrellas")==3) {
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
        View view = inflater.inflate(R.layout.fragment_tres_estrelles, container, false);

        readJSON();

        hlista = view.findViewById(R.id.hotelsList1);

        initValues();

        return view;
    }

    @Override
    public void onClick(View view) {
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext());
        hlista.setLayoutManager(manager);

        adapter = new cardadapter((ArrayList<hotelData>) dataHotels);
        adapter.setOnItemClickListener(this);
        hlista.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View v, int position) {
        Intent popup =new Intent(getActivity().getApplicationContext(), popup_hotel.class);

        String nom = dataHotels.get(position).getNombre();
        String email = dataHotels.get(position).getEmail();
        String telefon = dataHotels.get(position).getTelefono();
        String website = dataHotels.get(position).getWebsite();
        String imatge2 = dataHotels.get(position).getImatge2();
        String direccio = dataHotels.get(position).getDireccion();


        Bundle extras = new Bundle();
        extras.putString("nomHotel",nom);
        extras.putString("email",email);
        extras.putString("telefon",telefon);
        extras.putString("website",website);
        extras.putString("imatge",imatge2);
        extras.putString("direccio",direccio);

        popup.putExtras(extras);
        startActivity(popup);
    }
}
