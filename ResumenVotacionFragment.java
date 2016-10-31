package com.uniquindo.edu.co.proyecto.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindo.edu.co.proyecto.R;

/**
 *Fragmento 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class ResumenVotacionFragment extends Fragment {
    /**
    *metodo constructor 
    */
    public ResumenVotacionFragment() {
        // Required empty public constructor
    }

    /**
    *metodo que crea y retorna la jerarquia de la vista
    *asociada con el fragmento 
    *@param savedInstanceState de tipo Bundle
    *@return  
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_resumen_votacion, container, false);
        return view;
    }

}
