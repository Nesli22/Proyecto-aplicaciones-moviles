package rodrigo.kevin.aplicacion.vistas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import rodrigo.kevin.R

class AjustesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)
        val swNotificaciones = findViewById<Switch>(R.id.swNotificaciones)
        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        swNotificaciones.isChecked = sharedPref.getBoolean("notificationsEnabled", false)

        configurarBotonCerrarSesion()
        configurarSwitchNotificaciones()
        configurarSpinnerIdioma()
    }

    private fun configurarBotonCerrarSesion() {
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener {
            val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("isLoggedIn", false)
                apply()
            }
            val intent = Intent(this, InicioSesionActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun configurarSwitchNotificaciones() {
        val swNotificaciones = findViewById<Switch>(R.id.swNotificaciones)
        swNotificaciones.setOnCheckedChangeListener { _, isChecked ->
            val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("notificationsEnabled", isChecked)
                apply()
            }
        }
    }

    private fun configurarSpinnerIdioma() {
        val spIdioma = findViewById<Spinner>(R.id.spIdioma)
        val idiomas = arrayOf("Español", "Inglés", "Francés")
        val adapterIdioma =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idiomas)
        adapterIdioma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spIdioma.adapter = adapterIdioma

        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val idiomaActual = sharedPref.getString("idioma", "Español")
        val position = idiomas.indexOf(idiomaActual)
        if (position != -1) {
            spIdioma.setSelection(position)
        }

        spIdioma.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val idiomaSeleccionado = parent.getItemAtPosition(position).toString()
                with(sharedPref.edit()) {
                    putString("idioma", idiomaSeleccionado)
                    apply()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No se seleccionó nada
            }
        }
    }
}