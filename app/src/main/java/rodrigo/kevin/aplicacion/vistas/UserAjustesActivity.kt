package rodrigo.kevin.aplicacion.vistas

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import rodrigo.kevin.R
import java.util.Locale

class UserAjustesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_ajustes)

        // Configurar el botón de cerrar sesión
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener {
            // Lógica para cerrar sesión
            // Por ejemplo, guardar en las shared preferences que el usuario ha cerrado sesión
            val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("isLoggedIn", false)
                apply()
            }
            // Y luego cerrar la actividad actual
            finish()
        }

        // Configurar el switch de notificaciones
        val swNotificaciones = findViewById<Switch>(R.id.swNotificaciones)
        swNotificaciones.setOnCheckedChangeListener { _, isChecked ->
            // Lógica para activar/desactivar notificaciones
            // Por ejemplo, guardar en las shared preferences el estado del switch
            val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("notificationsEnabled", isChecked)
                apply()
            }
        }

        // Configurar el spinner de idioma
        val spIdioma = findViewById<Spinner>(R.id.spIdioma)
        val idiomas = arrayOf("Español", "Inglés", "Francés")
        val adapterIdioma =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idiomas)
        adapterIdioma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spIdioma.adapter = adapterIdioma
        // Obtener el idioma actual de las shared preferences
        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val idiomaActual = sharedPref.getString("idioma", "Español")
        // Y seleccionar el idioma actual en el spinner
        val position = idiomas.indexOf(idiomaActual)
        if (position != -1) {
            spIdioma.setSelection(position)
        }
        // Y configurar el listener para cuando se seleccione un idioma
        spIdioma.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // Lógica para cuando se selecciona un idioma
                // Por ejemplo, guardar en las shared preferences el idioma seleccionado
                val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("idioma", idiomas[position])
                    apply()
                }
                // Y cambiar el idioma de la aplicación
                // Por ejemplo, usando la biblioteca de internacionalización de Android
                val locale = Locale(idiomas[position])
                Locale.setDefault(locale)
                val config = resources.configuration
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
    }
}