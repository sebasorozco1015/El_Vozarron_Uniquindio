package com.uniquindo.edu.co.proyecto.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.fragment.DetalleParticipanteFragment;
import com.uniquindo.edu.co.proyecto.vo.Participante;
/**
*Esta clase define la actividad que representa a los Entrenadores
*@author Sebastian Orozco
*@author Braian Trejos Culma
*@author Julian Garcia  
*
*/
public class DatosParticipanteActivity extends AppCompatActivity {
    /**
    *metodo onCreate que inicia la actividad para mostrar un video desde el fragmento deseado
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_participante);

        DetalleParticipanteFragment detalleParticipante = (DetalleParticipanteFragment)
                getSupportFragmentManager().findFragmentById(R.id.detalle_participante);

        Participante participante = (Participante) getIntent().getExtras().get("per");
        detalleParticipante.mostrarParticipante(participante);

        String frameVideo = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" src=\"https://www.google.com/\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.mWebView);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
          
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        }
        );
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");
    }
 /**
    *metodo onCreate que crea un menu en la actividad
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }
    /**
    * Este metodo pasa al MenuItem seleccionado. 
    *@param item de tipo MenuItem
    *@return id unico para el menuItem
    */  
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
