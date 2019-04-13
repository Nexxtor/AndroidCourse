package com.naldana.please

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.person_from_list.view.*

class PersonaAdapter(var lista: List<Persona>, val listener: (Persona) -> Unit) :
        RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        var v: View = LayoutInflater.from(parent.context).inflate(R.layout.person_from_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(lista[position], listener)

    }

    class ViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        /* fun bind(persona: Persona, listener: Unit) {
             v.tv_nombre.text=persona.nombre
             v.tv_apellido.text=persona.apellido
             v.setOnClickListener {
                 listener(persona)
             }
         }*/

        fun bind(persona: Persona, listener: (Persona) -> Unit) = with(v) {
            tv_nombre.text = persona.nombre
            tv_apellido.text = persona.apellido
            setOnClickListener {
                listener(persona)
            }
        }
    }
}