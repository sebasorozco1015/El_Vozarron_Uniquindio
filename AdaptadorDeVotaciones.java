package com.uniquindo.edu.co.proyecto.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.fragment.ListaVotacionesFragment;
import com.uniquindo.edu.co.proyecto.vo.Participante;

import java.util.ArrayList;

/**
 *Adaptador 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class AdaptadorDeVotaciones extends RecyclerView.Adapter<AdaptadorDeVotaciones.ParticipanteViewHolder> {
    // ArrayList de participantes
    private ArrayList<Participante> participantes;
    // atributo estatico listener
    private static OnClickVotacion listener;

    /**
    * metodo contsructor de la clase que inicializa participantes y listaVotacionesFragment
    * @param participantes
    * @param listaVotacionesFragment
    */
    public AdaptadorDeVotaciones(ArrayList<Participante> participantes,
                                 ListaVotacionesFragment listaVotacionesFragment) {
        this.participantes = participantes;
        listener= (OnClickVotacion) listaVotacionesFragment;
    }
    /**
     * subClase interface
     */
    public interface OnClickVotacion{
        // obtiene la posicion
        public void onClickPosition(int posicion);

    }

  /**
    *metodo que va a mostrar los items del adaptador
    *@param parent El ViewGroup  en el cual el nuevo View sera agregado despues de que
    *a su adaptador de posicion.
    *@param viewType el tipo de View de la nueva View.
    *@return un nuevo viewHolder que contiente una view del tipo de view dado
    */
    @Override
    public ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_resumen_votacion, parent, false);
        ParticipanteViewHolder participanteVh = new ParticipanteViewHolder(itemView);
        return participanteVh;
    }
    /**
    * metodo que permite mostra los datos en la posicion especificada
    * @param holder
    * @param position
    */
    @Override
    public void onBindViewHolder(ParticipanteViewHolder holder, int position) {

        Participante participante = participantes.get(position);
        holder.binParticipante(participante);
    }
    /**
    * metodo que retorna el numero total de items que tiene el adaptador
    * @return tamanio de la lista de participantes.
    */
    @Override
    public int getItemCount() {
        return participantes.size();
    }

    /**
    *subclase ParticipanteViewHolder
    */
    public static class ParticipanteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // imagen del participante
        private ImageView imageParticipante;
        // nombre del participante
        private TextView txtNombreParticipante;
        // fecha de nacimiento del participante
        private TextView txtFechaNacimiento;
        // nombre del entrenadr
        private TextView txtNombreEntrenador;
        // cuenta 
        private EditText editTextCuenta;
        // boton para la votacion del participante
        private Button btnVotarM;
          /**
         * metodo contsructor de la subclase
         * @param itemView
         */
        public ParticipanteViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            imageParticipante= (ImageView) itemView.findViewById(R.id.imagen_paricipante);
            txtNombreParticipante = (TextView)
                    itemView.findViewById(R.id.nombre_participante);
            txtNombreEntrenador= (TextView) itemView.findViewById(R.id.nombre_entrenador_votacion);
            editTextCuenta= (EditText) itemView.findViewById(R.id.numero_votaciones_edit);
            btnVotarM= (Button) itemView.findViewById(R.id.button_votar);
            btnVotarM.setOnClickListener(this);
        }

        /**
         *metodo que asigna el nombre y la fecha capturados al textview de la actividad
         *@param participante
         */
        public void binParticipante(Participante participante) {
            txtNombreParticipante.setText(participante.getNombre());
            imageParticipante.setImageResource(participante.getFoto());
            txtNombreEntrenador.setText("adelle");
            editTextCuenta.setText("0");


        }

        /**
         *sirve para depurar o para verificar el funcionamiento del código
         *@param view
         */
        @Override
        public void onClick(View view) {
            listener.onClickPosition(getAdapterPosition());
          // Intent intent= new Intent();
           //view.startActionMode(intent);


            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+
                    txtNombreParticipante.getText());
        }
    }
}
