package com.uniquindo.edu.co.proyecto.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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
public class LoginAdministradorFragment extends DialogFragment {

     /**
    *metodo constructor 
    */
    public LoginAdministradorFragment() {
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
        // Inflate the layout for this fragmento
        return inflater.inflate(R.layout.fragment_login_administrador, container, false);
    }

}
