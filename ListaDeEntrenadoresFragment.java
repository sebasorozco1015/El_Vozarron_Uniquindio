package com.uniquindo.edu.co.proyecto.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindo.edu.co.proyecto.R;
import com.uniquindo.edu.co.proyecto.util.AdaptadorDeEntrenadores;
import com.uniquindo.edu.co.proyecto.vo.Entrenador;

import java.util.ArrayList;

/**
 *Fragmento 
 *@author Sebastian Orozco
 *@author Braian Trejos Culma
 *@author Julian Garcia 
 * A simple {@link Fragment} subclass.
 * Created by admin on 25/10/2016.
 */
public class ListaDeEntrenadoresFragment extends Fragment implements AdaptadorDeEntrenadores.OnClickAdaptadorDeEntrenador {
  
    //contenedor de listadoDeEntrenadores
    private RecyclerView listadoDeEntrenadores;
    // adaptador
    private AdaptadorDeEntrenadores adaptador;
    // lista de entrenadores
    private static ArrayList<Entrenador> entrenadores;
    // listener
    private OnEntrenadorSeleccionadoListener listener;

    /**
    *metodo constructor 
    */
    public ListaDeEntrenadoresFragment() {
        // Required empty public constructor
    }
    /**
    * obtiene la posicion
    * @param pos
    */
    @Override
    public void onClickPosition(int pos) {
        listener.onEntrenadorSeleccionado(pos);
    }
    /**
     * subClase interface
     */
    public interface OnEntrenadorSeleccionadoListener {
        void listaEntrenadores(ArrayList<Entrenador> entrenadores);
        void onEntrenadorSeleccionado(int position);
    }
    /**
    *metodo que le dice al fragmento que su actividad ha completdo
    *su propia actividad.omCreate()
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cargarLista();

        listener.listaEntrenadores(entrenadores);

        listadoDeEntrenadores = (RecyclerView) getView().findViewById(R.id.listaEntrenadores);
        adaptador = new AdaptadorDeEntrenadores(entrenadores, this);
        listadoDeEntrenadores.setAdapter(adaptador);

        listadoDeEntrenadores.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                        false));

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
        return inflater.inflate(R.layout.fragment_lista_de_entrenadores, container, false);
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
                listener = (OnEntrenadorSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPersonajeSeleccionadoListener");
            }

        }
    }
    /**
    *metodo onCreate que inicia la actividad 
    *@param savedInstanceState de tipo Bundle
    */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
    /**
     * Sets de entrenadores
     * @param entrenadores lista de entrenadores
     */
    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    /**
     * metodo estatico que crea una instancia
     * @return lista de entrenadores
     */
    public static ListaDeEntrenadoresFragment newInstance(){
        ListaDeEntrenadoresFragment lista= new ListaDeEntrenadoresFragment();
        cargarLista();
        return lista;
    }
   /**
     * metodo estatico que carga a una lista los entrenadores
     */
    private static void cargarLista(){
        entrenadores = new ArrayList();
        entrenadores.add(new Entrenador(R.drawable.rivera, "Jhony Rivera", "a", 42, "23 febero 1974", "masculino"));
        entrenadores.add(new Entrenador(R.drawable.adele, "Adelle", "b", 28, "5 mayo 1988 ", "femenino"));
        entrenadores.add(new Entrenador(R.drawable.rihanna, "Rihana", "a", 28, "20 febero 1988", "femenino"));
    }
    /**
     * Método que devuelve los entrenadores
     * @return entrenadores
     */
    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }
}
