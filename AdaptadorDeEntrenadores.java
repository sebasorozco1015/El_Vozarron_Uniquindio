package com.uniquindo.edu.co.proyecto.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.fragment.ListaDeEntrenadoresFragment;
import com.uniquindo.edu.co.proyecto.vo.Entrenador;

import java.util.ArrayList;

/**
 *Adaptador 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */

public class AdaptadorDeEntrenadores extends RecyclerView.Adapter<AdaptadorDeEntrenadores.EntrenadorViewHolder> {
    // ArrayList de entrenadores
    private ArrayList<Entrenador> entrenadores;
    // variable estatica de una interface
    private static OnClickAdaptadorDeEntrenador listener;

    /**
     * subClase interface
     */
    public interface OnClickAdaptadorDeEntrenador{
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
    public EntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_resumen_participantes, parent, false);
        EntrenadorViewHolder entrenadorVh =new EntrenadorViewHolder(itemView);
        return entrenadorVh;
    }
        /**
         * metodo contsructor de la clase que inicializa entrenadores y listadeentrenadoresfragment
         * @param entrenadores
         * @param listaDeEntrenadoresFragment
         */
    public AdaptadorDeEntrenadores(ArrayList<Entrenador> entrenadores, ListaDeEntrenadoresFragment listaDeEntrenadoresFragment){
        this.entrenadores=entrenadores;
        listener = (OnClickAdaptadorDeEntrenador) listaDeEntrenadoresFragment;

    }
    /**
    * metodo que permite mostra los datos en la posicion especificada
    * @param holder
    * @param position
    */
    @Override
    public void onBindViewHolder(EntrenadorViewHolder holder, int position) {
        Entrenador entrenador= entrenadores.get(position);
        holder.binEntrenador(entrenador);
    }
    /**
    * metodo que retorna el numero total de items que tiene el adaptador
    * @return tamanio de la lista de entrenadores.
    */
    @Override
    public int getItemCount() {
        return entrenadores.size();
    }

    /**
    *subclase EntrenadorViewHolder
    */
    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // imagen del entrenador
        private ImageView imagenEntrenador;
        // nombre del entrenador
        private TextView txtNombreEntrenador;
        // grupo del entrenador
        private TextView txtGrupo;
        /**
         * metodo contsructor de la subclase
         * @param itemView
         */
        public EntrenadorViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imagenEntrenador= (ImageView) itemView.findViewById(R.id.imagen_paricipante_viewcard);
            txtNombreEntrenador = (TextView)
                    itemView.findViewById(R.id.nombre_participante_viewcard);
            txtGrupo = (TextView)
                    itemView.findViewById(R.id.grupo_participante_viewcard);
        }
        /**
         *
         *metodo que asigna el nombre y la fecha capturados al textview de la actividad
         *@param entrenador
         */

        public void binEntrenador(Entrenador entrenador) {
            txtNombreEntrenador.setText(entrenador.getNombre());
            txtGrupo.setText(entrenador.getGrupo());
            imagenEntrenador.setImageResource(entrenador.getImagen());
        }


        /**
         *sirve para depurar o para verificar el funcionamiento del código
         *@param view
         */
        @Override
        public void onClick(View view) {

            listener.onClickPosition(getAdapterPosition());

            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+
                    txtNombreEntrenador.getText());
        }
    }

}
