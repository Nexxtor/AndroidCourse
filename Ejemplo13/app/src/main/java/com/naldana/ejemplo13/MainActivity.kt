package com.naldana.ejemplo13

import android.content.ContentValues
import android.os.Bundle
import android.provider.BaseColumns
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.naldana.ejemplo13.data.Database
import com.naldana.ejemplo13.data.DatabaseContract
import com.naldana.ejemplo13.data.models.Persona
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dbHelper = Database(this) // TODO (12) Se crea una instancia del SQLiteHelper definido en la clase Database.

    lateinit var mAdapter: PersonaAdapter

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = PersonaAdapter(readPersonas())

        with(rv_personas) {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this.context)
        }

        bt_save.setOnClickListener {
            val username = et_username.text.toString()
            val email = et_email.text.toString()
            val displayname = et_firstname.text.toString()


// TODO(14) Para ingresar nuevos datos, es necesario solicitar una instancia de escritura de la base de datos.
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(DatabaseContract.PersonaEntry.COLUMN_DISPLAYNAME, displayname)
                put(DatabaseContract.PersonaEntry.COLUMN_USERNAME, username)
                put(DatabaseContract.PersonaEntry.COLUMN_EMAIL, email)
            }

            val newRowId = db?.insert(DatabaseContract.PersonaEntry.TABLE_NAME, null, values)

            if (newRowId == -1L) {
                Snackbar.make(it, getString(R.string.alert_person_not_saved), Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(it, getString(R.string.alert_person_saved_success) + newRowId, Snackbar.LENGTH_SHORT)
                    .show()
                mAdapter.setPersonas(readPersonas())
            }

        }
    }

    private fun readPersonas(): List<Persona> {

// TODO(13) Para obtener los datos almacenados, es necesario solicitar una instancia de lectura de la base de datos.
        val db = dbHelper.readableDatabase

        val projection = arrayOf(
            BaseColumns._ID,
            DatabaseContract.PersonaEntry.COLUMN_USERNAME,
            DatabaseContract.PersonaEntry.COLUMN_EMAIL,
            DatabaseContract.PersonaEntry.COLUMN_DISPLAYNAME
        )

        val sortOrder = "${DatabaseContract.PersonaEntry.COLUMN_DISPLAYNAME} DESC"

        val cursor = db.query(
            DatabaseContract.PersonaEntry.TABLE_NAME, // nombre de la tabla
            projection, // columnas que se devolverán
            null, // Columns where clausule
            null, // values Where clausule
            null, // Do not group rows
            null, // do not filter by row
            sortOrder // sort order
        )

        var lista = mutableListOf<Persona>()

        with(cursor) {
            while (moveToNext()) {
                var persona = Persona(
                    getInt(getColumnIndexOrThrow(BaseColumns._ID)),
                    getString(getColumnIndexOrThrow(DatabaseContract.PersonaEntry.COLUMN_USERNAME)),
                    getString(getColumnIndexOrThrow(DatabaseContract.PersonaEntry.COLUMN_EMAIL)),
                    getString(getColumnIndexOrThrow(DatabaseContract.PersonaEntry.COLUMN_DISPLAYNAME))
                )

                lista.add(persona)
            }
        }

        return lista
    }
}
