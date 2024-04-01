package rodrigo.kevin.aplicacion.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import rodrigo.kevin.R

class InicioSesionActivity : AppCompatActivity() {

    lateinit var btnIngresar: Button
    lateinit var tvRegistrarse: TextView
    lateinit var tvRecuperarContra: TextView
    lateinit var txtCorreo: EditText
    lateinit var txtContra: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        this.btnIngresar = findViewById(R.id.btnIngresar)
        this.tvRegistrarse = findViewById(R.id.lblRegistrarse)
        this.tvRecuperarContra = findViewById(R.id.lblOlvidoContra)
        this.txtCorreo = findViewById(R.id.txtCorreo)
        this.txtContra = findViewById(R.id.txtContra)

    }

}