package com.uniquindo.edu.co.proyecto.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uniquindo.edu.co.proyecto.R;
/**
*Esta clase define la actividad que representa a la bibliografia 
*@author Sebastian Orozco
*@author Braian Trejos Culma
*@author Julian Garcia	
*
*/
public class BibliografiaActivity extends AppCompatActivity {
	/**
	*metodo onCreate que inicia la actividad 
	*@param savedInstanceState de tipo Bundle
	*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // metodo que define la UI
        setContentView(R.layout.activity_bibliografia);
    }
}
