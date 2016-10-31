package com.uniquindo.edu.co.proyecto.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.fragment.DetalleEntrenadorFragment;
import com.uniquindo.edu.co.proyecto.vo.Entrenador;
/**
*Esta clase define la actividad que representa a los  Datos de Entrenador
*@author Sebastian Orozco
*@author Braian Trejos Culma
*@author Julian Garcia	
*
*/
public class DatosEntrenadorActivity extends AppCompatActivity {
	/**
	*metodo onCreate que inicia la actividad 
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // metodo que define la UI    
        setContentView(R.layout.activity_datos_entrenador);
		// asigna a detallePersonaje el Return the FragmentManager para 
        //interactuar con fragmentos asosciados con esta acividad del fragmento
        DetalleEntrenadorFragment detallePersonaje = (DetalleEntrenadorFragment)
                getSupportFragmentManager().findFragmentById(R.id.detalle_entrenador);
        // asigna a entrenador los datos de la intencion, en este caso busca per         
        Entrenador entrenador = (Entrenador) getIntent().getExtras().get("per");
        detallePersonaje.mostrarEntrenador(entrenador);
    }
}
