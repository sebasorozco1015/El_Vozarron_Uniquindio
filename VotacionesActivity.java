package com.uniquindo.edu.co.proyecto.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.fragment.ListaVotacionesFragment;
import com.uniquindo.edu.co.proyecto.vo.Entrenador;
import com.uniquindo.edu.co.proyecto.vo.Participante;

import java.util.ArrayList;
/**
 *Esta clase 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * Created by admin on 25/10/2016.
 */
public class VotacionesActivity extends AppCompatActivity implements ListaVotacionesFragment.OnParticipanteSeleccionadoListener{
    //  contenedor listadoDeParticipantes
    private RecyclerView listadoDeParticipantes;
    //  arrayList de participante
    private ArrayList<Participante> participantes;
    //  arrayList de entrenadores
   private ArrayList<Entrenador> entrenadores;
   //Variable constante PER
   private static String PER = "per";

    /**
    *metodo onCreate que inicia la actividad 
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votaciones);
    }
    /**
    *metodo inicializa el arraylist de participantes
    *@param participantes atributo de tipo arraylist que sera inicializado
    */
    @Override
    public void listaPersonajes(ArrayList<Participante> participantes) {
        this.participantes=participantes;
    }
}
