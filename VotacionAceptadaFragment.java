package com.uniquindo.edu.co.proyecto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.util.AdaptadorDeVotaciones;
import com.uniquindo.edu.co.proyecto.vo.Participante;

import java.util.ArrayList;

/**
 *Fragmento 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class VotacionAceptadaFragment extends Fragment {

    // contenedor de lista de participantes
    private RecyclerView listadoDeParticipantes;
    // lista de participantes
    private ArrayList<Participante> participantes;
    // listener 
    private ListaVotacionesFragment.OnParticipanteSeleccionadoListener listener;
    // adaptador 
    private AdaptadorDeVotaciones adaptador;
    // argumento
    Bundle bundle = getArguments();
    // 
    String recuperada = bundle.getString("str");
    
    /**
    *metodo constructor 
    */
    public VotacionAceptadaFragment() {
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
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_votacion_aceptada, container, false);
    }
}
