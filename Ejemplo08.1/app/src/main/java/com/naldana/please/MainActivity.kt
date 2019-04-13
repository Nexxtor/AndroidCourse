package com.naldana.please

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lista: MutableList<Persona> = MutableList(10) { index ->
            Persona("Nombre " + index, "Apellido " + index)
        }

        var vadapter = PersonaAdapter(lista) {
            Toast.makeText(this, it.nombre, Toast.LENGTH_LONG).show()
        }

        var manager = LinearLayoutManager(this)

        with(rv_persona) {
            adapter = vadapter
            layoutManager = manager
        }


    }


}
