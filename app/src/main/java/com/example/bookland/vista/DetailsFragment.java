package com.example.bookland.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookland.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_AUTOR = "autor";
    public static final String ARG_TITULO = "titulo";
    public static final String ARG_PUBLICATIONYEAR = "publication_year";
    public static final String ARG_NUMRATINGS = "numratings";
    public static final String ARG_IMAGE = "image";

    // TODO: Rename and change types of parameters
    String autor;
    String titulo;
    String publicationYear;
    String numRatings;
    String image;

    TextView tituloGrande;
    TextView tituloPequeño;
    TextView autorTV;
    TextView numRatingsTV;
    TextView publicationYearTV;
    ImageView portada;
    ImageButton buttonFavourite;
    ImageButton buttonReading;
    ImageButton buttonToRead;


    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titulo = getArguments().getString(ARG_TITULO);
            autor = getArguments().getString(ARG_AUTOR);
            publicationYear = getArguments().getString(ARG_PUBLICATIONYEAR);
            image = getArguments().getString(ARG_IMAGE);
            numRatings = getArguments().getString(ARG_NUMRATINGS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        tituloGrande = v.findViewById(R.id.titutloGrande);
        tituloPequeño = v.findViewById(R.id.tituloPequeño);
        autorTV = v.findViewById(R.id.autorDetails);
        portada = v.findViewById(R.id.portadaDetails);
        numRatingsTV = v.findViewById(R.id.numRating);
        publicationYearTV = v.findViewById(R.id.publicationYear);
        buttonToRead = v.findViewById(R.id.buttonToRead);
        buttonReading = v.findViewById(R.id.buttonReading);
        buttonFavourite = v.findViewById(R.id.buttonFavourite);

        tituloPequeño.setText(titulo);
        tituloGrande.setText(titulo);
        autorTV.setText(autor);
        numRatingsTV.setText(numRatings);
        publicationYearTV.setText(publicationYear);

        Picasso.with(this.getContext())
                .load(image)
                .resize(240*3, 300*3)
                .centerCrop()
                .into(portada);
        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
}