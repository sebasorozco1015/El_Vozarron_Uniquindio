package com.uniquindo.edu.co.proyecto.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.vo.Entrenador;

/**
 *Fragmento  que maneja los datos de entrenador
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class DatosEntrenadorFragment extends Fragment {
    // instancia de objeto entrenador
    private Entrenador entrenador;
    // objeto de tipo imageview
    private ImageView imagen;
    // objeto de tipo TextView
    private TextView txtNombre;
    // objeto de tipo TextView
    private TextView txtGrupo;
    /**
    *metodo constructor 
    */    
    public DatosEntrenadorFragment() {
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


        return inflater.inflate(R.layout.fragment_datos_entrenador, container, false);
    }
    /**
    *metodo que le dice al fragmento que su actividad ha completdo
    *su propia actividad.omCreate()
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtNombre= (TextView) getView().findViewById(R.id.datos_entrenador_nombre);
        txtGrupo= (TextView) getView().findViewById(R.id.datos_entrenador_equipo) ;
        imagen= (ImageView) getView().findViewById(R.id.imagenEntrenador_equipos);

    }
    /**
    *metodo que inicializa el objeto entrenador y obtiene
    *y setea su imagen, nombre y grupo
    *@param entrenador
    */
    public void mostrarEntrenador(Entrenador entrenador) {
        this.entrenador= entrenador;

        imagen.setImageResource(entrenador.getImagen());
        txtNombre.setText(entrenador.getNombre());
        txtGrupo.setText(entrenador.getGrupo());

    }
}
