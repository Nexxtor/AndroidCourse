package com.naldana.ejemplo03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var nameButton: Button
    lateinit var nameDisplayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        addEventsListener()

    }

    fun bindView() {
        nameEditText = findViewById(R.id.et_name)
        nameButton = findViewById(R.id.bt_send_name)
        nameDisplayTextView = findViewById(R.id.tv_display_name)
    }

    fun addEventsListener() {
        nameButton.setOnClickListener {
            val name = nameEditText.text

            if (name.isEmpty()) {
                nameDisplayTextView.text = getString(R.string.notification_nombre)
                Toast.makeText(
                    applicationContext,
                    getString(R.string.notification_nombre),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                nameDisplayTextView.text = name
                Toast.makeText(
                    applicationContext,
                    "Se guardao correctamente " + name,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
