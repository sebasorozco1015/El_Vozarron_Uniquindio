package com.uniquindo.edu.co.proyecto.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.activity.BibliografiaActivity;
import com.uniquindo.edu.co.proyecto.vo.Entrenador;

/**
 *Fragmento 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class DetalleEntrenadorFragment extends Fragment {

    // instancia de objeto entrenador
    private Entrenador entrenador;
    // objeto de tipo TextView
    private TextView txtNombre;
    // objeto de tipo TextView
    private TextView txtGrupo;
    // objeto de tipo TextView
    private TextView edad;
    // objeto de tipo TextView
    private TextView genero;
    // objeto de tipo imageView
    private ImageView imagen;
    // objeto de tipo TextView
    private TextView fecha_nacimiento;
    // objeto de tipo button
    private Button btnVerBiografia;

    /**
    *metodo constructor 
    */
    public DetalleEntrenadorFragment() {
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
        return inflater.inflate(R.layout.fragment_detalle_entrenador, container, false);
    }

    /**
    *metodo que inicializa el objeto entrenador y obtiene
    *y setea su imagen, nombre entre otros datos
    *@param entrenador
    */
    public void mostrarEntrenador (Entrenador entrenador) {
        this.entrenador = entrenador;

        imagen= (ImageView) getView().findViewById(R.id.imagenEntrenador_Datos);
     //   imagen= (ImageView) getView().findViewById(R.id.imagenEntrenador_equipos);
        imagen.setImageResource(entrenador.getImagen());


        txtNombre = (TextView) getView().findViewById(R.id.nombre_entrenador_Datos);
      //  txtNombre= (TextView) getView().findViewById(R.id.datos_entrenador_nombre);
        txtNombre.setText(entrenador.getNombre());

        txtGrupo= (TextView) getView().findViewById(R.id.grupo_entrenador_datos);
       // txtGrupo= (TextView) getView().findViewById(R.id.datos_entrenador_equipo) ;
        txtGrupo.setText(entrenador.getGrupo());

        edad= (TextView) getView().findViewById(R.id.edad_entrenador);
        edad.setText(String.valueOf(entrenador.getEdad()));

        genero= (TextView) getView().findViewById(R.id.genero_entrenador);
        genero.setText(entrenador.getGenero());

        fecha_nacimiento= (TextView) getView().findViewById(R.id.fecha_nacimiento_entrenador);
        fecha_nacimiento.setText(entrenador.getFecha_nacimiento());

         btnVerBiografia= (Button)
                getView().findViewById(R.id.button_ver_biografia);
        btnVerBiografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), BibliografiaActivity.class);
                startActivity(intent);
            }
        });
    }

}
