package com.uniquindo.edu.co.proyecto.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.activity.VotacionAceptadaActivity;
import com.uniquindo.edu.co.proyecto.util.AdaptadorDeParticipante;
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
public class ListaVotacionesFragment extends Fragment implements AdaptadorDeVotaciones.OnClickVotacion, AdaptadorDeParticipante.OnClickAdaptadorDeParticipante{

    //contenedor de listadoDeParticipantes
    private RecyclerView listadoDeParticipantes;
    // lista de participantes
    private ArrayList<Participante> participantes;
    // listener
    private OnParticipanteSeleccionadoListener listener;
    // adaptador
    private AdaptadorDeVotaciones adaptador;

     /**
    *metodo constructor 
    */
    public ListaVotacionesFragment() {
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



        return inflater.inflate(R.layout.fragment_lista_votaciones, container, false);
    }
    /**
    *metodo que le dice al fragmento que su actividad ha completdo
    *su propia actividad.omCreate()
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        listadoDeParticipantes = (RecyclerView) getView().findViewById(R.id.listaVotaciones);
        adaptador = new AdaptadorDeVotaciones(participantes, this);
        listadoDeParticipantes.setAdapter(adaptador);

        listadoDeParticipantes.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                        false));
    }
/**
* llama al fragmento una vez que este es asociado
* con su contexto.
* @param context
*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            try {
                listener = (OnParticipanteSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPersonajeSeleccionadoListener");
            }

        }
    }
    /**
    * obtiene la posicion
    * @param pos
    */
    @Override
    public void onClickPosition(int posicion) {

        Intent intent= new Intent(getContext(), VotacionAceptadaActivity.class);
        startActivity(intent);


    }
    /**
     * subClase interface
     */
    public interface OnParticipanteSeleccionadoListener {
        void listaPersonajes(ArrayList<Participante> participantes);
    }
    /**
    *metodo onCreate que inicia la actividad 
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        participantes = new ArrayList();
        participantes.add(new Participante(R.drawable.adele,"Ronaldinho", "a",30,"estudiante","https://www.youtube.com/watch?v=316ZeIT-Rlk"));
        participantes.add(new Participante(R.drawable.rihanna,"Albert Einstein", "a",40,"estudiante","https://www.youtube.com/watch?v=316ZeIT-Rlk"));
        participantes.add(new Participante(R.drawable.rivera,"Leonardo da Vinci", "a",32,"profesor","https://www.youtube.com/watch?v=316ZeIT-Rlk"));
        participantes.add(new Participante(R.drawable.rivera,"Alejandro Magno", "b",18,"estudiante","https://www.youtube.com/watch?v=316ZeIT-Rlk"));
        participantes.add(new Participante(R.drawable.rivera,"Goku", "b",20,"estudiante","https://www.youtube.com/watch?v=316ZeIT-Rlk"));
        listener.listaPersonajes(participantes);


    }
    /**
     * Sets de participantes
     * @param participantes lista de entrenadores
     */
    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

}
