package com.uniquindo.edu.co.proyecto.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.vo.Participante;

/**
 *Fragmento 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class DetalleParticipanteFragment extends Fragment {

    // objeto de participante
    private Participante participante;
    // nombre del participante
    private TextView txtNombre;
    // entrenador del participante
    private TextView txtEntrenador;
    // edad del participante
    private TextView edad;
    // relacion o rol en la universidad
    private TextView relacion;
    // imagen del participante
    private ImageView imagen;
   
   /**
    *metodo constructor 
    */
    public DetalleParticipanteFragment() {
        // Required empty public constructor
    }

    /**
    *metodo que crea y retorna la jerarquia de la vista
    *asociada con el fragmento 
    *@param inflater 
    *@param container
    *@param savedInstanceState
    *@return
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_participante, container, false);
    }
    /**
    *metodo que muestra la informacion del participante
    *@param participante 
    */
    public void mostrarParticipante(Participante participante) {
        this.participante=participante;

        imagen= (ImageView) getView().findViewById(R.id.imagen_paricipante_datos);

        imagen.setImageResource(participante.getFoto());


        txtNombre = (TextView) getView().findViewById(R.id.datos_participante_nombre);

        txtNombre.setText(participante.getNombre());

        txtEntrenador= (TextView) getView().findViewById(R.id.datos_participante_nombre_entrenador);
        //txtEntrenador= (TextView) getView().findViewById(R.id.datos_entrenador_nombre);
        txtEntrenador.setText("adele");


        edad= (TextView) getView().findViewById(R.id.datos_participante_edad);
        edad.setText(String.valueOf(participante.getEdad()));

        relacion= (TextView) getView().findViewById(R.id.datos_participante_relacion);
        relacion.setText(participante.getRelacion());
        //relacion.setText("masculino");
    }
}
