package com.uniquindo.edu.co.proyecto.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.fragment.ListaDeParticipantesFragment;
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

public class AdaptadorDeParticipante extends RecyclerView.Adapter<AdaptadorDeParticipante.ParticipanteViewHolder> {
    // ArrayList de entrenadores
    private ArrayList<Participante> participantes;
    // atributo estatico listener
    private static OnClickAdaptadorDeParticipante listener;

    /**
     * subClase interface
     */
    public interface OnClickAdaptadorDeParticipante{
        // obtiene la posicion
        public void onClickPosition(int pos);
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
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_resumen_participantes, parent, false);
        ParticipanteViewHolder participanteVh = new
                ParticipanteViewHolder(itemView);
        return participanteVh;
    }
    /**
    * metodo contsructor de la clase que inicializa participantes y listaDeParticipantesFragment
    * @param participantes
    * @param listaDeParticipantesFragment
    */
    public AdaptadorDeParticipante(ArrayList<Participante> participantes,
                                   ListaDeParticipantesFragment listaDeParticipantesFragment) {
        this.participantes = participantes;
        listener= (OnClickAdaptadorDeParticipante) listaDeParticipantesFragment;
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
        // nombre del participante
        private TextView txtNombreParticipante;
        // grupo del participante
        private TextView txtGrupo;
        // imagen del participante
        private ImageView imagenParticipante;
          /**
         * metodo contsructor de la subclase
         * @param itemView
         */
        public ParticipanteViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreParticipante = (TextView)
                    itemView.findViewById(R.id.nombre_participante_viewcard);
            txtGrupo = (TextView)
                    itemView.findViewById(R.id.grupo_participante_viewcard);
            imagenParticipante= (ImageView) itemView.findViewById(R.id.imagen_paricipante_viewcard);
        }
        /**
         *
         *metodo que asigna el nombre y la fecha capturados al textview de la actividad
         *@param participante
         */
        public void binParticipante(Participante participante) {
            imagenParticipante.setImageResource(participante.getFoto());
            txtNombreParticipante.setText(participante.getNombre());
            txtGrupo.setText(participante.getGrupo());
        }

        /**
         *sirve para depurar o para verificar el funcionamiento del código
         *@param view
         */
        @Override
        public void onClick(View view) {

            listener.onClickPosition(getAdapterPosition());

            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+
                    txtNombreParticipante.getText());
        }
    }

}
