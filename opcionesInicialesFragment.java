package com.uniquindo.edu.co.proyecto.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.activity.EntrenadoresActivity;
import com.uniquindo.edu.co.proyecto.activity.EquiposActivity;
import com.uniquindo.edu.co.proyecto.activity.IngresarParticipanteActivity;
import com.uniquindo.edu.co.proyecto.activity.ParticipantesActivity;
import com.uniquindo.edu.co.proyecto.activity.VotacionesActivity;

/**
 *Fragmento 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class opcionesInicialesFragment extends Fragment{

    // boton de participantes
    private Button btnParticipantes;
    // boton de agregar participantes
    private Button btnAgregarParticipante;
    // boton de Entrenadores
    private Button btnEntrenadores;
    // boton de Votacion
    private Button btnVotacion;
    // boton de Equipos
    private Button btnEquipos;

    /**
    *metodo constructor 
    */
    public opcionesInicialesFragment() {
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

        View view= inflater.inflate(R.layout.fragment_opciones_iniciales, container, false);

        btnParticipantes= (Button) view.findViewById(R.id.btn_ir_a_participantes);
        btnParticipantes.setOnClickListener(new View.OnClickListener() {
            // metodo que inicia la actividad
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), ParticipantesActivity.class);
                startActivity(intent);
            }
        });

        btnAgregarParticipante= (Button) view.findViewById(R.id.btn_ir_a_agregar_articipante);
        btnAgregarParticipante.setOnClickListener(new View.OnClickListener() {
            // metodo que inicia la actividad
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), IngresarParticipanteActivity.class);
                startActivity(intent);
            }
        });

        btnEntrenadores= (Button) view.findViewById(R.id.btn_ir_a_entrenadores);
        btnEntrenadores.setOnClickListener(new View.OnClickListener() {
            // metodo que inicia la actividad
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), EntrenadoresActivity.class);
                startActivity(intent);
            }
        });

        btnVotacion= (Button) view.findViewById(R.id.btn_ir_a_votacion);
        btnVotacion.setOnClickListener(new View.OnClickListener() {
            // metodo que inicia la actividad
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), VotacionesActivity.class);
                startActivity(intent);
            }
        });

        btnEquipos= (Button) view.findViewById(R.id.btn_ir_a_equipos);
        btnEquipos.setOnClickListener(new View.OnClickListener() {
            // metodo que inicia la actividad
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), EquiposActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
