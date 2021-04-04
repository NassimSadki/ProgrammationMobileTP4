package com.example.myapplication.ui.main;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.Locale;
import java.util.ResourceBundle;

/** une instance de SeasonFragment contient ici juste un label
 */
public class SeasonFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque SeasonFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static SeasonFragment newInstance(int position, String title) {
        SeasonFragment fragment = new SeasonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        tvLabel.setText(page + " -- " + title);

        ImageView image = (ImageView) view.findViewById(R.id.imageView1);
        switch (title) {
            case "printemps":
                image.setImageResource(R.drawable.printemps);
                break;
            case "ete":
                image.setImageResource(R.drawable.ete);
                break;
            case "automne":
                image.setImageResource(R.drawable.automne);
                break;
            case "hiver":
                image.setImageResource(R.drawable.hiver);
                break;

        }
        return view;
    }

}