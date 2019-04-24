package com.naldana.ejemplo13

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naldana.ejemplo13.data.models.Persona
import kotlinx.android.synthetic.main.list_item_persona.view.*

class PersonaAdapter(var items: List<Persona>) : RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_persona, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setPersonas(items: List<Persona>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(var item: View) : RecyclerView.ViewHolder(item) {
        fun bind(persona: Persona) =
                with(item) {
                    tv_username.text = persona.email
                    tv_displayname.text = persona.username
                    tv_email.text = persona.displayName
                }
    }
}