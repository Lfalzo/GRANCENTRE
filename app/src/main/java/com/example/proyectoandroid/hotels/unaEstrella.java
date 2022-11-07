package com.example.proyectoandroid.hotels;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.proyectoandroid.R;
import com.example.proyectoandroid.activity_hotels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link unaEstrella#newInstance} factory method to
 * create an instance of this fragment.
 */
public class unaEstrella extends Fragment implements View.OnClickListener{

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
        //Button detalls = (R.id.detalls1);
        //detalls.setOnClickListener(this);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        JSONObject jsonObject = null;
        /*try {
            jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("hotels");
            for (int i = 0; i < jsonArray.length(); i++) {
            //parsejar a objecte
                name
                descripction
                img1
                img2
                direction
                tel
                email
                url
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        // cridar el json i agafar nomes les dades dels X estrelles al array
        // utilitzar aquest array per mostrar un cardview per cada un dels hotels
        // crear links
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //ImageView imageView = (ImageView) getView().findViewById(R.id.hotels_view);
        return inflater.inflate(R.layout.fragment_una_estrella, container, false);
    }

    @Override
    public void onClick(View view) {
        Button bt = (Button) view;

        if (bt.getId() == R.id.detalls1){
            //s'hauran de passar els parametres del JSON
            Intent popup =new Intent(getActivity().getApplicationContext(), popup_hotel.class);

            //afegir les dades del Json //popup.putExtra(Bundle);

            startActivity(popup);
        }
    }
}